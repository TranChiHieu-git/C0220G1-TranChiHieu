import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {CreateObjectComponent} from './create-object/create-object.component';
import {EditObjectComponent} from './edit-object/edit-object.component';
import {ListObjectComponent} from './list-object/list-object.component';
import {RouterModule} from '@angular/router';
import {ObjectRoutingModule} from './object-routing.module';
import {NgxPaginationModule} from 'ngx-pagination';
import {HttpClientModule} from '@angular/common/http';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';


@NgModule({
  declarations: [CreateObjectComponent, EditObjectComponent, ListObjectComponent],
  imports: [
    CommonModule,
    BrowserModule,
    RouterModule,
    ObjectRoutingModule,
    NgxPaginationModule,
    HttpClientModule,
    FormsModule,
  ]
})
export class ObjectModule {
}
