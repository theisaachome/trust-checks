import { Component } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {JsonPipe, NgIf} from '@angular/common';
import {InputComponent} from '../../shared/components/input/input.component';

@Component({
  selector: 'app-profiles',
  imports: [
    JsonPipe,
    ReactiveFormsModule,
    InputComponent
  ],
  templateUrl: './profiles.component.html',
  styleUrl: './profiles.component.css'
})
export class ProfilesComponent {

  profileForm =new FormGroup({
     full_name_on_card:new FormControl(null,[Validators.required,Validators.minLength(3)]),
     card_number: new FormControl(null,[Validators.required,Validators.minLength(16),Validators.maxLength(16)]),
     expiration: new FormControl(null,[Validators.required,
     Validators.pattern(/^(0[1-9]|1[0-2])\/\d{2}$/)]),
     security_code: new FormControl(null,[Validators.required,Validators.minLength(3),Validators.maxLength(3)]),
  });


  constructor() {
  }

  onSubmit(){
    console.log(this.profileForm.value);
  }
}
