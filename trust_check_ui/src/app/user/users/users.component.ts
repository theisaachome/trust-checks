import {AfterViewInit, Component, ViewChild} from '@angular/core';
import {FormsModule, NgForm, ReactiveFormsModule} from "@angular/forms";
import {NgForOf, NgIf} from '@angular/common';

declare var $: any;
@Component({
  selector: 'app-users',
  imports: [
    FormsModule,
    ReactiveFormsModule,
    NgIf,
    NgForOf
  ],
  templateUrl: './users.component.html',
  styleUrl: './users.component.css'
})
export class UsersComponent implements AfterViewInit{
  ngAfterViewInit(): void {
    $('.ui.radio.checkbox').checkbox();
    $('.selection.dropdown')
      .dropdown()
    ;
  }

  @ViewChild("myForm") myForm?: NgForm;

  defaultQuestion="default"
  answer = '';

  genders = ['male', 'female ', 'other','abc'];

  suggestUserName(){
    const suggestedName =" super user"

  }

  // onSubmit(f:NgForm){
  //   console.log(f);
  // }

  onSubmit(){
    console.log(this.myForm);
  }
}
