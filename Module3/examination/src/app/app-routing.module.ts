import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {EntityComponent} from './entity/entity.component';
import {EntityRoutingModule} from './entity/entity-routing.module';

const routes: Routes = [
  {path: 'entity', component: EntityComponent},
  {path: '**', component: EntityComponent},
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
    EntityRoutingModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
