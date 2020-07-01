import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from '@angular/router';
import {ListServiceComponent} from './list-service/list-service.component';
import {CreateServiceComponent} from './create-service/create-service.component';
import {EditServiceComponent} from './edit-service/edit-service.component';
import {NgxPaginationModule} from 'ngx-pagination';

const routers = [
  {path: 'service/list', component: ListServiceComponent},
  {path: 'service/create', component: CreateServiceComponent},
  {path: 'service/update/:id', component: EditServiceComponent},
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routers),
    NgxPaginationModule
  ]
})

export class ServiceRoutingModule {
}
