import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from '@angular/router';
import {ServiceComponent} from './service/service.component';
import {ServiceRoutingModule} from './service/service-routing.module';
import {NgxPaginationModule} from 'ngx-pagination';
import {EmployeeComponent} from './employee/employee.component';
import {EmployeeRoutingModule} from './employee/employee-routing.module';
import {CustomerComponent} from './customer/customer.component';
import {CustomerRoutingModule} from './customer/customer-routing.module';
import {ContractRoutingModule} from './contract/contract-routing.module';
import {ContractComponent} from './contract/contract.component';
import {IndexComponent} from './index/index.component';

const routers = [
  {path: 'service', component: ServiceComponent},
  {path: 'employee', component: EmployeeComponent},
  {path: 'customer', component: CustomerComponent},
  {path: 'contract', component: ContractComponent},
  {path: '**', component: IndexComponent},
];


@NgModule({
  declarations: [ServiceComponent, EmployeeComponent, CustomerComponent],
  imports: [
    CommonModule,
    RouterModule.forRoot(routers),
    ServiceRoutingModule,
    EmployeeRoutingModule,
    CustomerRoutingModule,
    ContractRoutingModule,
    NgxPaginationModule,
  ]
})
export class AppRoutingModule {
}
