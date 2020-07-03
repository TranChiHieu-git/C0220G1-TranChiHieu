import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {EntityRoutingModule} from './entity-routing.module';
import {HttpClientModule} from '@angular/common/http';
import {NgxPaginationModule} from 'ngx-pagination';
import {FormsModule} from '@angular/forms';


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    EntityRoutingModule,
    HttpClientModule,
    NgxPaginationModule,
    FormsModule
  ]
})
export class EntityModule {
}
