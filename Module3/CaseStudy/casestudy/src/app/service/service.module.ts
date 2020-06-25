import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from '@angular/router';
import {ServiceRoutingModule} from './service-routing.module';
import {ServiceComponent} from './service.component';
import {CreateServiceComponent} from './create-service/create-service.component';
import {DeleteServiceComponent} from './delete-service/delete-service.component';
import {EditServiceComponent} from './edit-service/edit-service.component';
import {ListServiceComponent} from './list-service/list-service.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

@NgModule({
  declarations: [ServiceComponent, CreateServiceComponent, DeleteServiceComponent, EditServiceComponent, ListServiceComponent],
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

  ]
})
export class ServiceModule {
}
