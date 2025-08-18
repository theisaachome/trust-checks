import {AfterViewInit, Component, EventEmitter, Input, OnDestroy, OnInit, Output} from '@angular/core';


declare var $: any;

@Component({
  selector: 'report-datepicker',
  template:`
    <div class="ui calendar" [id]="calendarId">
      <div class="ui input left icon">
        <input type="text" placeholder="Date">
        <i class="calendar icon"></i>
      </div>
    </div>
  `,
  styles:[
    `
    `
  ]
})
export class ReportDatepickerComponent implements AfterViewInit, OnDestroy {

    @Input() value?:string; // initial-date
    @Output() valueChange = new EventEmitter<string>();

  calendarId = 'date_calendar_' + Math.random().toString(36).substring(2); // unique id
  private initialized = false;



    ngAfterViewInit(){
      const self = this;
      $('#'+this.calendarId)
        .calendar({
          type: 'date',
          initialDate: this.value ? new Date(this.value) : undefined,
          onChange(date:Date,text:string){
            self.valueChange.emit(text)
          }
        });
      this.initialized = true;
    }
    ngOnDestroy() {
      if (this.initialized) {
        $('#' + this.calendarId).calendar('destroy');
      }
    }
}
