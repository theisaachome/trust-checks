import {AfterViewInit, Component, OnInit} from '@angular/core';
import {FormArray, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators} from '@angular/forms';
import {NgForOf} from '@angular/common';
import {Country, City, ICountry, ICity} from 'country-state-city';


declare var $: any; // for jQuery

@Component({
  selector: 'app-report-form',
  imports: [
    FormsModule,
    ReactiveFormsModule,
    NgForOf
  ],
  templateUrl: './report-form.component.html',
  styleUrl: './report-form.component.css'
})
export class ReportFormComponent  implements  OnInit,AfterViewInit{
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

  counties: ICountry[]=[];
  cities: ICity[]|undefined=[] ;

  ngOnInit(): void {
     this.counties = Country.getAllCountries();
  }

  onCountryChange(event:any){
    console.log(event);
    const selectedCountry = this.counties.find((c)=>c.isoCode===event.target.value);
    this.cities=[];
    if(selectedCountry){
      this.cities = City.getCitiesOfCountry(selectedCountry.isoCode) ;
      console.log(this.cities);
    }
  }

  get transactions(): FormArray{
   return  this.reportForm.get("payment_information.transactions") as FormArray;
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
  onRemoveTransactions(i:number){
    this.transactions.removeAt(i);
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

  ngAfterViewInit(): void {
    ($('.ui.dropdown') as any).dropdown({
      onChange: (value: string, text: string) => {
        // ✅ Sync with Angular form
        this.reportForm.get('location.country_code')?.setValue(value);
        this.reportForm.get('location.country_name')?.setValue(text);
      }
    });
  }

}
