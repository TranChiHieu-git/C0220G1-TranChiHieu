import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ListContractComponent} from './list-contract/list-contract.component';
import {CreateContractComponent} from './create-contract/create-contract.component';
import {EditContractComponent} from './edit-contract/edit-contract.component';
import {CreateContractdetailsComponent} from './create-contractdetails/create-contractdetails.component';
import {EditContractdetailsComponent} from './edit-contractdetails/edit-contractdetails.component';
import {RouterModule} from '@angular/router';
import {NgxPaginationModule} from 'ngx-pagination';

const routers = [
  {path: 'contract/list', component: ListContractComponent},
  {path: 'contract/create', component: CreateContractComponent},
  {path: 'contract/update/:id', component: EditContractComponent},
  {path: 'contract/contractdetails/create/:id', component: CreateContractdetailsComponent},
  {path: 'contract/contractdetails/update/:id', component: EditContractdetailsComponent},
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routers),
    NgxPaginationModule
  ]
})
export class ContractRoutingModule {
}
