import {NgModule} from '@angular/core';
import {Routes, RouterModule, PreloadAllModules} from '@angular/router';
import {TimeliveComponent} from "./timelive/timelive.component";
import {PlaymusicComponent} from "./playmusic/playmusic.component";
import {DictionaryComponent} from "./dictionary/dictionary.component";
import {PlaylistComponent} from "./playlist/playlist.component";


const routes: Routes = [{path: 'timelive', component: TimeliveComponent},
  {
    path: 'playmusic', component: PlaylistComponent, children: [{
      path: ':id',
      component: PlaymusicComponent
    }]
  },
  {
    path: 'dictionary', component: DictionaryComponent,
  }];

@NgModule({
  imports: [RouterModule.forRoot(routes, {
    preloadingStrategy: PreloadAllModules
  })],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
