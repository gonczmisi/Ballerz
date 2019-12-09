import { Component, OnInit } from '@angular/core';
import { Issue } from "../issue";
import { IssueService } from '../issue.service';
import { AuthService } from '../auth.service';
import { User } from '../user';

@Component({
  selector: 'app-issue-list',
  templateUrl: './issue-list.component.html',
  styleUrls: ['./issue-list.component.css']
})
export class IssueListComponent implements OnInit {
  public filteredIssues: Issue[];
  public selectedType: string;
  public selectedIssue: Issue;

  private b : Boolean = false;
  private joinedIssues: Issue[] = [];
  private issues: Issue[] = [];

  constructor(
    private issueService: IssueService,
    private authService: AuthService,
  ) { 
  }

  async ngOnInit(): Promise<void> {
    this.selectedType = '';
    this.issues = await this.issueService.getIssues();
    this.authService = this.issueService.getAuthService();
    this.filter();
  }

  onFilterChange(type: string): void {
    this.selectedType = type;
    this.filter();
  }

  onSelectIssue(issue: Issue): void {
    this.selectedIssue = issue;
  }

  async onFormSubmit(issue: Issue): Promise<void> {
    if (issue.id > 0) {
      await this.issueService.updateIssue(issue)
      this.selectedIssue.venue = issue.venue;
      this.selectedIssue.name = issue.name;
      this.selectedIssue.organizer = issue.organizer;
      this.selectedIssue.type = issue.type;
      this.selectedIssue.current_players = issue.current_players;
      
    } else {
      this.selectedIssue.id = Math.floor(Math.random()*1000000);
      this.selectedIssue.venue = issue.venue;
      this.selectedIssue.name = issue.name;
      this.selectedIssue.organizer = issue.organizer;
      this.selectedIssue.type = issue.type;
      this.selectedIssue.current_players = 0;
      this.issueService.createIssue(this.selectedIssue)
                        .then(createdIssue => {
                          this.issues.push(createdIssue);
                        });
    }
    this.selectedIssue = null;
  }
  
  onNewClick(): void {
    this.selectedIssue = new Issue();
  }
  
  onJoinClick() : void{
    for(let is of this.joinedIssues)
      this.b = (this.selectedIssue == is);

    if(!this.b){
      this.selectedIssue.current_players++;
      this.joinedIssues.push(this.selectedIssue);
      this.b = false;
    }
  }

  onDeleteClick(id: number) {
    this.issueService.deleteIssue(id)
    .then(async () => {
      this.selectedIssue = null;
      this.issues = await this.issueService.getIssues();
      this.filter();
    })
  }

  private filter(): void {
    this.filteredIssues = this.selectedType === ''
    ? this.issues
    : this.issues.filter(issue => issue.type === this.selectedType);
  }
}
