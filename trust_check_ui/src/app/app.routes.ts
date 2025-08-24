import { Routes } from '@angular/router';
import {SearchReportComponent} from './features/reports/search-report/search-report.component';
import {UsersComponent} from './features/user/users/users.component';
import {ReportListComponent} from './features/reports/report-list/report-list.component';
import {AboutUsComponent} from './pages/about-us/about-us.component';
import {ContactComponent} from './pages/contact/contact.component';
import {ReportFormComponent} from './features/reports/report-form/report-form.component';
import {ProfilesComponent} from './features/profiles/profiles.component';

export const routes: Routes = [
  {
    path: '',
    component:SearchReportComponent
  },
  {
    path:'profiles',
    component:ProfilesComponent,
  },
  {
    path:'report-now',
    component:ReportFormComponent,
  },
  {
    path:'users',
    component:UsersComponent
  },
  {
    path:'lists',
    component:ReportListComponent
  },
  {
    path:'about-us',
    component:AboutUsComponent
  },
  {
    path:'contact',
    component:ContactComponent
  }
];
