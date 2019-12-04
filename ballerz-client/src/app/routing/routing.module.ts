import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { EventListComponent } from "../event-list/event-list.component";
import { EventFormComponent } from '../event-form/event-form.component';
import { EventDetailComponent } from '../event-detail/event-detail.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: '/events',
    pathMatch: 'full'
  },
  {
    path: 'events',
    component: EventListComponent
  },
  {
    path: 'events/new',
    component: EventFormComponent
  },
  {
    path: 'events/:id',
    component: EventDetailComponent
  },
];

@NgModule({
  imports: [ RouterModule.forRoot(routes)  ],
  exports: [ RouterModule ],
  declarations: []
})
export class RoutingModule { }