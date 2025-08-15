import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule} from '@angular/forms';

@Component({
  selector: 'app-report-form',
  imports: [
    FormsModule,
    ReactiveFormsModule
  ],
  templateUrl: './report-form.component.html',
  styleUrl: './report-form.component.css'
})
export class ReportFormComponent  implements  OnInit{

  reportForm: FormGroup = new FormGroup({});
  ngOnInit(): void {
    this.reportForm = new FormGroup({
       scammerAlias:new FormControl(),
       fullName: new FormControl(),
       phoneNumber: new FormControl(),
    })
  }

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
