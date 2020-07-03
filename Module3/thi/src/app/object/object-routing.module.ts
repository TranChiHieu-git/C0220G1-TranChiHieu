import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ListObjectComponent} from './list-object/list-object.component';
import {CreateObjectComponent} from './create-object/create-object.component';
import {EditObjectComponent} from './edit-object/edit-object.component';
import {RouterModule} from '@angular/router';
import {NgxPaginationModule} from 'ngx-pagination';

const routers = [
  {path: 'object/list', component: ListObjectComponent},
  {path: 'object/create', component: CreateObjectComponent},
  {path: 'object/update/:id', component: EditObjectComponent},
  {path: '**', component: ListObjectComponent}
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routers),
    NgxPaginationModule
  ]
})
export class ObjectRoutingModule {
}
