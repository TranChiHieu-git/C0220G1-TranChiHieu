import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ListEmployeeComponent} from './list-employee/list-employee.component';
import {CreateEmployeeComponent} from './create-employee/create-employee.component';
import {EditEmployeeComponent} from './edit-employee/edit-employee.component';
import {RouterModule} from '@angular/router';
import {NgxPaginationModule} from 'ngx-pagination';


const routers = [
  {path: 'employee/list', component: ListEmployeeComponent},
  {path: 'employee/create', component: CreateEmployeeComponent},
  {path: 'employee/update/:id', component: EditEmployeeComponent},
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routers),
    NgxPaginationModule
  ]
})
export class EmployeeRoutingModule {
}
