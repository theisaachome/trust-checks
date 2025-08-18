import {AfterViewInit, Component, OnInit} from '@angular/core';
import {FormArray, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators} from '@angular/forms';
import {NgForOf} from '@angular/common';
import {Country, City, ICountry, ICity} from 'country-state-city';
import {CASE_TYPES, CaseType, SCAM_CATEGORIES, ScamCategory} from '../scamReport';
import {ReportDatepickerComponent} from '../../common/report-datepicker.component';


declare var $: any; // for jQuery

@Component({
  selector: 'app-report-form',
  imports: [
    FormsModule,
    ReactiveFormsModule,
    NgForOf,
    ReportDatepickerComponent
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
      short_story:new FormControl('', [Validators.required]),
      modality:new FormControl(new Date(), [Validators.required]),
      long_story: new FormControl(''),
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
      city_name:new FormControl({value:null,disabled:true}),
    }),

    reporter:new FormGroup({
      name:new  FormControl(),
      contact_mail:new FormControl(null, [Validators.required]),
      contact_phone:new FormControl(null, [Validators.required]),
    })

  });

  counties: ICountry[]=[];
  cities: ICity[]|undefined=[] ;

  scameCategories: ScamCategory []=[];
  caseTypes: CaseType[]=[];

  ngOnInit(): void {
     this.counties = Country.getAllCountries();
     this.scameCategories = SCAM_CATEGORIES;
     this.caseTypes = CASE_TYPES;
  }

  onDateOfIncidentPick(selectedDate:string){
    this.reportForm.get("scame_case_information.date_of_incident")?.patchValue(new Date(selectedDate));
  }

  onScameCategoryChange(event:any){
    const selectedCategory = event.target.value;
    const selectedCaseType = this.caseTypes.find(c => c.categoryId === selectedCategory);
    if(selectedCategory){
      this.reportForm.get("scame_case_information.case_type")?.patchValue(selectedCaseType?.name)
      this.reportForm.get("scame_case_information.short_story")?.patchValue(selectedCaseType?.story)
    }
  }

  onCountryChange(event:any){
    const selectedCountry = this.counties.find((c)=>c.isoCode===event.target.value);
    this.cities=[];

    if(selectedCountry){
      const countryCities = City.getCitiesOfCountry(selectedCountry.isoCode) ?? [];
      this.cities = countryCities;
      const cityControl = this.reportForm.get("location.city_name");

      if (cityControl) {
        cityControl.reset(); // clear previous value
        // cityControl.disable(); // keep disabled until check
      }


      if (cityControl) {
        if (this.cities.length > 0) {
          console.log("got cities in this country")
          cityControl.enable();
        }
      }
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
