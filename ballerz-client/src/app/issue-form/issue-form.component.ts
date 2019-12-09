import { Component, OnChanges, Input, Output, EventEmitter  } from '@angular/core'; 
import { Issue } from '../Issue';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'issue-form',
  templateUrl: './issue-form.component.html',
  styleUrls: ['./issue-form.component.css']
})
export class IssueFormComponent implements OnChanges {

  @Input() issue: Issue
  public model: Issue
  @Output() onSubmit = new EventEmitter<Issue>();

  constructor() { }

  ngOnChanges(): void {
    this.model = Object.assign({}, this.issue);
  }
  
  submit(form: NgForm): void {
    if (!form.valid) {
      return;
    }
    this.onSubmit.emit(this.model);
  }

}
