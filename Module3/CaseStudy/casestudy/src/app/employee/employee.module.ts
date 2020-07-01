import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {CreateEmployeeComponent} from './create-employee/create-employee.component';
import {EditEmployeeComponent} from './edit-employee/edit-employee.component';
import {ListEmployeeComponent} from './list-employee/list-employee.component';
import {EmployeeComponent} from './employee.component';
import {RouterModule} from '@angular/router';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgxPaginationModule} from 'ngx-pagination';
import {Ng2SearchPipeModule} from 'ng2-search-filter';
import {EmployeeRoutingModule} from './employee-routing.module';

@NgModule({
  declarations: [EmployeeComponent, CreateEmployeeComponent, EditEmployeeComponent, ListEmployeeComponent],
  exports: [
    EmployeeComponent,
    CreateEmployeeComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    EmployeeRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    NgxPaginationModule,
    Ng2SearchPipeModule,
  ]
})
export class EmployeeModule {
}
