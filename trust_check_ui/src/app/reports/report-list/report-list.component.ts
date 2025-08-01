import {Component, OnInit} from '@angular/core';
import {ReportService} from '../report.service';
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
  constructor(private reportService : ReportService) {

  }
  ngOnInit() {
    this.data = this.reportService.getReports()
  }


}
