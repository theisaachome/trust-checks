import {AfterViewInit, Component, OnInit} from '@angular/core';
import {
  AbstractControl,
  FormArray,
  FormControl,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators, ɵFormGroupRawValue, ɵGetProperty, ɵTypedOrUntyped
} from '@angular/forms';
import {JsonPipe, NgForOf, NgIf, NgTemplateOutlet} from '@angular/common';
import {Country, City, ICountry, ICity} from 'country-state-city';
import {CASE_TYPES, CaseType, SCAM_CATEGORIES, ScamCategory} from '../scamReport';
import {ReportDatepickerComponent} from '../../common/report-datepicker.component';
import {InputComponent} from '../../../shared/components/input/input.component';


declare var $: any; // for jQuery

@Component({
  selector: 'app-report-form',
  imports: [
    FormsModule,
    ReactiveFormsModule,
    NgForOf,
    ReportDatepickerComponent,
    JsonPipe,
    InputComponent,
    NgIf,
    NgTemplateOutlet
  ],
  templateUrl: './report-form.component.html',
  styleUrl: './report-form.component.css'
})
export class ReportFormComponent  implements  OnInit,AfterViewInit{
  reportForm = new FormGroup({
    scammer_details:new FormGroup({
      scammer_alias: new FormControl("", [Validators.required,Validators.minLength(3)]),
      full_name:new FormControl(null, [Validators.required,Validators.minLength(5)]),
      phone_number: new FormControl(null, [Validators.required]),
      email_address : new FormControl(null,[Validators.email]),
    }),
    scame_case_information:new FormGroup({
      scame_category: new FormControl('', [Validators.required]),
      case_type: new FormControl('', [Validators.required]),
      date_of_incident:new FormControl(new Date(), [Validators.required]),
      short_story:new FormControl('', [Validators.required]),
      long_story: new FormControl(''),
    }),
    payment_information: new FormGroup({
      total_amount_lost:new FormControl(null),
      currency:new FormControl(null),
      transactions:new FormArray([])
    }),
    case_evidence:new FormGroup({
      links:new FormControl(null),
      attachments:new FormControl(null),
    }),
    social_media_handles:new FormArray([]),
    location:new FormGroup({
      country_name:new FormControl('', [Validators.required]),
      country_code:new FormControl('', [Validators.required]),
      city_name:new FormControl(null),
    }),
    reporter:new FormGroup({
      nick_name:new  FormControl(null,[Validators.required,Validators.minLength(3)]),
      contact_mail:new FormControl(null),
      contact_phone:new FormControl(null),
    }),
    modality:new FormControl(null),
    notes:new FormControl(null),
    declarationConsent:new FormControl(null,[Validators.required])
  });

   transactionForm:FormGroup =new FormGroup({
     payment_method:new FormControl(null, [Validators.required]),
     bank_name: new FormControl(null, [Validators.required]),
     bank_account_number: new FormControl(null, [Validators.required]),
     account_holder_name: new FormControl(null, [Validators.required]),
     amount:new FormControl(null, [Validators.required]),
     transaction_date:new FormControl(null, [Validators.required]),
  });

  counties: ICountry[]=[];
  cities: ICity[]|undefined=[] ;
  currencies: any[]=[];

  scameCategories: ScamCategory []=[];
  caseTypes: CaseType[]=[];

  ngOnInit(): void {
     this.counties = Country.getAllCountries();
     this.scameCategories = SCAM_CATEGORIES;
     this.caseTypes = CASE_TYPES;
  }


  get scammerDetails():FormGroup {
    return this.reportForm.get('scammer_details') as FormGroup;
  }
  get scammer_full_name():FormControl {
    return  this.reportForm.get('scammer_details.full_name') as FormControl;
  }
  onDateOfIncidentPick(selectedDate:string){
    this.reportForm.get("scame_case_information.date_of_incident")?.patchValue(new Date(selectedDate));
  }

  onScameCategoryChange(event:any){
    const selectedCategory = event.target.value || null;
    const selectedCaseType = this.caseTypes.find(c => c.categoryId === selectedCategory);
    if(selectedCategory){
      this.reportForm.get("scame_case_information.case_type")?.patchValue(selectedCaseType?.name??null);
      this.reportForm.get("scame_case_information.short_story")?.patchValue(selectedCaseType?.story??null);
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
  get socialMediaHandles():FormArray{
     return  this.reportForm.get("social_media_handles") as FormArray;
  }
  onAddSocialMediaHandles(){
   const socialMediaForm = new FormGroup({
      platform: new FormControl(null),
      profile_url:new FormControl('')
    });
    (<FormArray> this.reportForm.get("social_media_handles")).push(socialMediaForm);
  }
  onRemoveSocialMediaHandles(i:number){
    this.socialMediaHandles.removeAt(i);
  }
  get transactions(): FormArray{
   return  this.reportForm.get("payment_information.transactions") as FormArray;
  }
  onAddTransactions(){
    (<FormArray>this.reportForm.get("payment_information.transactions")).push(this.transactionForm);
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

  showErrorMessage(inputControl: AbstractControl | null){
      if (!inputControl) return false; // null check
        const {dirty,touched,errors} = inputControl;
        return dirty && touched && errors;
    }

  onSubmit(){
    // this.reportForm.get("payment_information.currency")?.setValue("S$");
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
    $('.ui.checkbox').checkbox();
  }

  private buildPayload(){
  }
}
