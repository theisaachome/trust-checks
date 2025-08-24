import {Component, Input} from '@angular/core';
import {JsonPipe, NgClass, NgIf} from '@angular/common';
import {FormControl, ReactiveFormsModule} from '@angular/forms';

@Component({
  selector: 'app-input',
  imports: [
    JsonPipe,
    NgIf,
    ReactiveFormsModule,
    NgClass
  ],
  templateUrl: './input.component.html',
  styleUrl: './input.component.css'
})
export class InputComponent {


   @Input({required:true}) label!: string;
   @Input({required:true}) control: FormControl = new FormControl();
   @Input() fieldClass:string='';
   @Input() type:'text' | 'email' | 'number' = 'text';


  constructor() {
  }

   showError(){
     const {dirty,touched,errors} = this.control;
     return dirty && touched && errors
   }
}
