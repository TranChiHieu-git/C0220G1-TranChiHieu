import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ObjectComponent} from './object/object.component';
import {CommonModule} from '@angular/common';
import {ObjectRoutingModule} from './object/object-routing.module';
import {NgxPaginationModule} from 'ngx-pagination';


const routes: Routes = [
  {path: 'object', component: ObjectComponent},
  {path: '**', component: ObjectComponent},
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
    CommonModule,
    ObjectRoutingModule,
    NgxPaginationModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
