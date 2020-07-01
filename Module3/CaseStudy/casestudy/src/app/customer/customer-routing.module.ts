import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ListCustomerComponent} from './list-customer/list-customer.component';
import {CreateCustomerComponent} from './create-customer/create-customer.component';
import {EditCustomerComponent} from './edit-customer/edit-customer.component';
import {RouterModule} from '@angular/router';
import {NgxPaginationModule} from 'ngx-pagination';


const routers = [
  {path: 'customer/list', component: ListCustomerComponent},
  {path: 'customer/create', component: CreateCustomerComponent},
  {path: 'customer/update/:id', component: EditCustomerComponent},
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routers),
    NgxPaginationModule
  ]
})
export class CustomerRoutingModule {
}
