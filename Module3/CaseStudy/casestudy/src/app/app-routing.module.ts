import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from '@angular/router';
import {ServiceComponent} from './service/service.component';
import {ServiceRoutingModule} from './service/service-routing.module';

const routers = [
  {path: 'service', component: ServiceComponent},
];


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routers),
    ServiceRoutingModule
  ]
})
export class AppRoutingModule {
}
