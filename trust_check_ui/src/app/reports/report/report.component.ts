import {Component, Input} from '@angular/core';
import {ScamReport} from '../scamReport';
import {DatePipe, DecimalPipe, NgClass, NgIf, NgOptimizedImage} from '@angular/common';

@Component({
  selector: 'app-report',
  imports: [
    NgClass,
    DatePipe,
    NgIf,
    DecimalPipe,
    NgOptimizedImage
  ],
  templateUrl: './report.component.html',
  styleUrl: './report.component.css'
})
export class ReportComponent {

  @Input()report?: ScamReport;

  shareReport(){}
  goBack(){}
  disputeReport(){}
}
