import { Component } from '@angular/core';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-contact',
  imports: [
    FormsModule
  ],
  templateUrl: './contact.component.html',
  styleUrl: './contact.component.css'
})
export class ContactComponent {

  contactMail="support@scamcheck.com";

  contact = {
    name:'',
    email:'',
    subject:'',
    message:'',
  }

  submitContact(){
    console.log("Contact Form Submitted");
    alert('Thank you for contacting us! We will get back to you soon.');
    this.contact = { name: '', email: '', subject: '', message: '' };
  }

}
