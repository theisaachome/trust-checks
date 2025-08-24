import {Component, Input} from '@angular/core';
import { NgClass, NgIf} from '@angular/common';
import {FormControl, ReactiveFormsModule} from '@angular/forms';

@Component({
  selector: 'app-input',
  imports: [
    NgIf,
    ReactiveFormsModule,
    NgClass
  ],
  template: `
     <div class="field" [ngClass]="{'fieldClass':showError()}" style="margin-bottom: 12px;">
      <label>{{label}}</label>
      <input  [formControl]="control" [type]="type">

      <ng-container *ngIf="control.dirty &&
            control.touched
         && control.errors">
        <div class="ui error message">
          <p *ngIf="control.errors['required']">Value is required</p>
          <p *ngIf="control.errors['minlength']">
            The value you entered is
            {{control.errors['minlength'].actualLength}} characters long,
            But it must be at least
            {{ control.errors['minlength'].requiredLength}} characters,
          </p>


          <p *ngIf="control.errors['maxlength']">
            The value you entered is
            {{control.errors['maxlength'].actualLength}} characters long,
            But it can not be longer than
            {{ control.errors['maxlength'].requiredLength}} characters,
          </p>


          <p *ngIf="control.errors['pattern']">
            Invalid format!!
          </p>

        </div>
      </ng-container>
    </div>

  `,
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
