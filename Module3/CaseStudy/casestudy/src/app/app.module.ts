import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import {ServiceModule} from './service/service.module';
import {HttpClientModule} from '@angular/common/http';
import {RouterModule} from '@angular/router';
import {NgxPaginationModule} from 'ngx-pagination';
import {Ng2SearchPipeModule} from 'ng2-search-filter';
import {EmployeeModule} from './employee/employee.module';
import {CustomerModule} from './customer/customer.module';
import {ContractComponent} from './contract/contract.component';
import {IndexComponent} from './index/index.component';
import {IndexModule} from './index/index.module';
import {ContractModule} from './contract/contract.module';

@NgModule({
  declarations: [
    AppComponent,
    ContractComponent,
    IndexComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    ServiceModule,
    EmployeeModule,
    CustomerModule,
    ContractModule,
    IndexModule,
    HttpClientModule,
    RouterModule,
    NgxPaginationModule,
    Ng2SearchPipeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
