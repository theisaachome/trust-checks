import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {ReportListComponent} from './reports/report-list/report-list.component';
import {ReportFormComponent} from './reports/report-form/report-form.component';
import {FormsModule, NgForm} from '@angular/forms';
import {UsersComponent} from './user/users/users.component';
import {FooterComponent} from './common/footer/footer.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, ReportListComponent, ReportFormComponent, FormsModule, UsersComponent, FooterComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Scam Reports';
}
