import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormControl, ReactiveFormsModule} from '@angular/forms';
import {NgIf} from '@angular/common';
import {debounceTime, distinctUntilChanged, map, of, Subject, switchMap, takeUntil} from 'rxjs';
import {ReportService} from '../report.service';
import {SearchResultSummary} from '../scamReport';


@Component({
  selector: 'app-search-report',
  imports: [
    NgIf,
    ReactiveFormsModule
  ],
  templateUrl: './search-report.component.html',
  styleUrl: './search-report.component.css',
  styles: [
    `
      .input-radius{
        border-bottom-left-radius: 16px;
      }

    `
  ]
})
export class SearchReportComponent implements OnInit ,OnDestroy {


  queryControl = new FormControl<string>('');
  lastResult: SearchResultSummary | null = null;

  loading = false;
  searched = false;
  private destroy$: Subject<void> = new Subject<void>();

  constructor(private reportService:ReportService) {
  }
  ngOnInit(): void {
    this.queryControl.valueChanges.pipe(
      debounceTime(300),
      distinctUntilChanged(),
      switchMap(q=> this.performSearch(q ?? '')),
      takeUntil(this.destroy$))
      .subscribe(res=>{
        this.lastResult = res;
        this.loading = false;
        this.searched = true;
      })
  }

  performSearch(q:string) {
    this.loading = true;
    if(!q|| q.trim().length == 0){
      this.lastResult = null;
      this.searched = false;
      return of(null);
    }
    this.loading = true;
    return this.reportService.search(q).pipe(map(data => data));
  }
  onManualSearch(){
    const q = this.queryControl.value || '';
    this.performSearch(q).subscribe(
      r =>{
        this.lastResult = r;
        this.loading = false;
        this.searched = true;
      }
    )
  }

  openReport(){
    alert('Open report flow (demo)')
  }

  viewDetails(){
    alert('View details page (demo)');
  }


  ngOnDestroy(): void {
    this.destroy$.next();
    this.destroy$.complete();
  }
}
