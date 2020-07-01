import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {IndexComponent} from './index.component';
import {RouterModule} from '@angular/router';
import {NgxPaginationModule} from 'ngx-pagination';


const routers = [
  {path: '**', component: IndexComponent},
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routers),
    NgxPaginationModule
  ]
})
export class IndexRoutingModule {
}
