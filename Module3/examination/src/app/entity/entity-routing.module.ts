import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ShowEntityComponent} from './show-entity/show-entity.component';
import {EditEntityComponent} from './edit-entity/edit-entity.component';
import {RouterModule} from '@angular/router';

const routers = [
  {path: 'entity/show', component: ShowEntityComponent},
  {path: 'entity/update/:id', component: EditEntityComponent},
  {path: '**', component: ShowEntityComponent}
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routers)
  ]
})
export class EntityRoutingModule {
}
