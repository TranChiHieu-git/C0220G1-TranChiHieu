import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {CreateCustomerComponent} from './create-customer/create-customer.component';
import {EditCustomerComponent} from './edit-customer/edit-customer.component';
import {ListCustomerComponent} from './list-customer/list-customer.component';
import {RouterModule} from '@angular/router';
import {CustomerRoutingModule} from './customer-routing.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgxPaginationModule} from 'ngx-pagination';
import {Ng2SearchPipeModule} from 'ng2-search-filter';
import {EmployeeComponent} from '../employee/employee.component';
import {CreateEmployeeComponent} from '../employee/create-employee/create-employee.component';
import {CustomerComponent} from './customer.component';


@NgModule({
  declarations: [CustomerComponent, CreateCustomerComponent, EditCustomerComponent, ListCustomerComponent],
  imports: [
    CommonModule,
    RouterModule,
    CustomerRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    NgxPaginationModule,
    Ng2SearchPipeModule,
  ]
})
export class CustomerModule {
}
