import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {ReportListComponent} from './features/reports/report-list/report-list.component';
import {ReportFormComponent} from './features/reports/report-form/report-form.component';
import {FormsModule, NgForm} from '@angular/forms';
import {UsersComponent} from './features/user/users/users.component';
import {FooterComponent} from './core/footer/footer.component';
import {SearchReportComponent} from './features/reports/search-report/search-report.component';
import {ReportComponent} from './features/reports/report/report.component';
import {HeaderComponent} from './core/header/header.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, ReportListComponent, ReportFormComponent, FormsModule, UsersComponent, FooterComponent, SearchReportComponent, ReportComponent, HeaderComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
}
