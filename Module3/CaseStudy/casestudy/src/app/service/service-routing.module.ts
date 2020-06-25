import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from '@angular/router';
import {ListServiceComponent} from './list-service/list-service.component';
import {CreateServiceComponent} from './create-service/create-service.component';

const routers = [
  {path: 'service/list', component: ListServiceComponent},
  {path: 'service/create', component: CreateServiceComponent},
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routers)
  ]
})

export class ServiceRoutingModule {
}
