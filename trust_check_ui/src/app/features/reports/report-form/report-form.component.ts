import {Component, OnInit} from '@angular/core';
import {FormArray, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators} from '@angular/forms';
import {dateTimestampProvider} from 'rxjs/internal/scheduler/dateTimestampProvider';

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

  reportForm: FormGroup = new FormGroup({
    scammer_details:new FormGroup({
      scammer_alias: new FormControl(null, [Validators.required]),
      full_name:new FormControl(null, [Validators.required]),
      phone_number: new FormControl(null, [Validators.required]),
      email_address : new FormControl(null,[Validators.email]),
    }),
    scame_case_information:new FormGroup({
      scame_category: new FormControl(null, [Validators.required]),
      case_type: new FormControl(null, [Validators.required]),
      date_of_incident:new FormControl(new Date(), [Validators.required]),
      short_story:new FormControl(new Date(), [Validators.required]),
      modality:new FormControl(new Date(), [Validators.required]),
      long_story: new FormControl(null),
    }),
    payment_information: new FormGroup({
      total_amount_lost:new FormControl(null),
      currency:new FormControl(null, [Validators.required]),
      transactions:new FormArray([])
    }),
    case_evidence:new FormGroup({
      links:new FormControl(null, [Validators.required]),
      attachments:new FormControl(null, [Validators.required]),
    }),
    social_media_handles: new FormGroup({
      platform: new FormControl(null),
      profile_url:new FormControl('')
    }),
    location:new FormGroup({
      country_name:new FormControl(null, [Validators.required]),
      country_code:new FormControl(null, [Validators.required]),
      city_name:new FormControl(null, [Validators.required]),
    }),

    reporter:new FormGroup({
      name:new  FormControl(),
      contact_mail:new FormControl(null, [Validators.required]),
      contact_phone:new FormControl(null, [Validators.required]),
    })

  });
  ngOnInit(): void {

  }

  onAddTransactions(){
    const transactionForm =new FormGroup({
      payment_method:new FormControl(null, [Validators.required]),
      account_holder_name: new FormControl(null, [Validators.required]),
      bank_account_name: new FormControl(null, [Validators.required]),
      bank_name: new FormControl(null, [Validators.required]),
      amount:new FormControl(null, [Validators.required]),
    });
    (<FormArray>this.reportForm.get("payment_information.transactions")).push(transactionForm);
  }

  onFileSelected (event: Event) {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files.length > 0) {
        const file = input.files[0];
        // this.fileName = file.name;
      console.log('selected file:' + file)
    }
  }

  onSubmit(){
    if(this.reportForm.valid){
      console.log(this.reportForm);
    }
  }

  protected readonly dateTimestampProvider = dateTimestampProvider;
}
