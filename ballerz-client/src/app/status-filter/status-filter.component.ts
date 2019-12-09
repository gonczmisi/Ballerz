import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'status-filter',
  templateUrl: './status-filter.component.html',
  styleUrls: [ './status-filter.component.css' ]
})
export class StatusFilterComponent  {

  @Input('type') selectedType: string = '';
  public types: string[] = [ 'SINGLE_MATCH', 'TOURNAMENT' ];
  @Output() onChange = new EventEmitter<string>();

  constructor() { }

  onFilterChange(type: string): void {
    this.selectedType = type;
    this.onChange.emit(type);
  }

}