import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {ReportListComponent} from './reports/report-list/report-list.component';
import {ReportFormComponent} from './reports/report-form/report-form.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, ReportListComponent, ReportFormComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Scam Reports';
}
