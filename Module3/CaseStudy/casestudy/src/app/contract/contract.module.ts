import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {CreateContractComponent} from './create-contract/create-contract.component';
import {EditContractComponent} from './edit-contract/edit-contract.component';
import {ListContractComponent} from './list-contract/list-contract.component';
import {CreateContractdetailsComponent} from './create-contractdetails/create-contractdetails.component';
import {EditContractdetailsComponent} from './edit-contractdetails/edit-contractdetails.component';
import {RouterModule} from '@angular/router';
import {CustomerRoutingModule} from '../customer/customer-routing.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgxPaginationModule} from 'ngx-pagination';
import {Ng2SearchPipeModule} from 'ng2-search-filter';
import {ContractRoutingModule} from './contract-routing.module';


@NgModule({
  declarations: [CreateContractComponent, EditContractComponent, ListContractComponent,
    CreateContractdetailsComponent, EditContractdetailsComponent],
  imports: [
    CommonModule,
    RouterModule,
    ContractRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    NgxPaginationModule,
    Ng2SearchPipeModule,
  ]
})
export class ContractModule {
}
