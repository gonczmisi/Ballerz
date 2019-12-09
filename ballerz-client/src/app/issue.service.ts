import { Injectable } from '@angular/core';
import { Issue } from "./issue";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthService, httpOptions } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class IssueService {
  
  private issueUrl: string = 'http://localhost:8080/events';

  constructor(
    private http: HttpClient,
    private authService: AuthService 
  ) { }

  getIssues(): Promise<Issue[]> {
    console.log(":(")
    return this.http.get<Issue[]>(`${this.issueUrl}`, httpOptions).toPromise();
  }

  getIssue(id: number): Promise<Issue> {
    return this.http.get<Issue>(`${this.issueUrl}/${id}`, httpOptions).toPromise();
  }

  createIssue(issue: Issue): Promise<Issue> {
    return this.http.post<Issue>(`${this.issueUrl}`, issue, httpOptions).toPromise();
  }

  updateIssue(issue: Issue): Promise<Issue> {
    return this.http.put<Issue>(`${this.issueUrl}/${issue.id}`, issue, httpOptions).toPromise();
  }

  deleteIssue(id): Promise<Issue> {
    return this.http.delete<Issue>(`${this.issueUrl}/${id}`, httpOptions).toPromise();
  }
}