import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from '@angular/router';
import {ServiceRoutingModule} from './service-routing.module';
import {ServiceComponent} from './service.component';
import {CreateServiceComponent} from './create-service/create-service.component';
import {EditServiceComponent} from './edit-service/edit-service.component';
import {ListServiceComponent} from './list-service/list-service.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgxPaginationModule} from 'ngx-pagination';
import {Ng2SearchPipeModule} from 'ng2-search-filter';

@NgModule({
  declarations: [ServiceComponent, CreateServiceComponent, EditServiceComponent, ListServiceComponent],
  exports: [
    ServiceComponent,
    CreateServiceComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    ServiceRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    NgxPaginationModule,
    Ng2SearchPipeModule
  ]
})
export class ServiceModule {
}
