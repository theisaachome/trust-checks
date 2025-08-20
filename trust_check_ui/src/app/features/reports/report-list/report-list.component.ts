import {Component, OnInit} from '@angular/core';
import {ScameReportService} from '../scame-report.service';
import {ScamReport} from '../scamReport';
import {DatePipe, NgIf} from '@angular/common';

@Component({
  selector: 'app-report-list',
  imports: [
    NgIf,
    DatePipe
  ],
  templateUrl: './report-list.component.html',
  styleUrl: './report-list.component.css'
})
export class ReportListComponent  implements OnInit{
  data:ScamReport[]=[];
  constructor(private reportService : ScameReportService) {

  }
  ngOnInit() {
    this.data = this.reportService.getReports()
    console.log(this.data)
  }


  trackById(index:string, item:any):number{
     return item.id;
  }
}
