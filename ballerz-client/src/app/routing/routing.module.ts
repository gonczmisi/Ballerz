import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { EventListComponent } from "../event-list/event-list.component";
import { EventFormComponent } from '../event-form/event-form.component';
import { EventDetailComponent } from '../event-detail/event-detail.component';
import { LoginFormComponent } from '../login-form/login-form.component';
import { AuthGuard } from '../auth.guard';

const routes: Routes = [
  {
    path: '',
    redirectTo: '/events',
    pathMatch: 'full'
  },
  {
    path: 'events',
    component: EventListComponent,
    canActivate: [ AuthGuard ]
  },
  {
    path: 'events/new',
    component: EventFormComponent, 
    canActivate: [ AuthGuard ],
    data: {
     roles: ['ROLE_ADMIN']
    }
  },
  {
    path: 'events/:id',
    component: EventDetailComponent
  },
  {
    path: 'login',
    component: LoginFormComponent
  },
];

@NgModule({
  imports: [ RouterModule.forRoot(routes)  ],
  exports: [ RouterModule ],
  declarations: []
})
export class RoutingModule { }