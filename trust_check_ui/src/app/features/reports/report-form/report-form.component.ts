import { Component } from '@angular/core';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-report-form',
  imports: [
    FormsModule
  ],
  templateUrl: './report-form.component.html',
  styleUrl: './report-form.component.css'
})
export class ReportFormComponent {

  fileName: string ='';

  onFileSelected (event: Event) {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files.length > 0) {
        const file = input.files[0];
        this.fileName = file.name;
      console.log('selected file:' + file)
    }
  }
}
