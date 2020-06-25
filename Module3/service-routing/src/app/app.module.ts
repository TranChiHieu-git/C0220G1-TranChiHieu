import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TimeliveComponent } from './timelive/timelive.component';
import { PlaymusicComponent } from './playmusic/playmusic.component';
import { DictionaryComponent } from './dictionary/dictionary.component';
import { PlaylistComponent } from './playlist/playlist.component';
import {DictionaryService} from "./dictionary.service";

@NgModule({
  declarations: [
    AppComponent,
    TimeliveComponent,
    PlaymusicComponent,
    DictionaryComponent,
    PlaylistComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [DictionaryService],
  bootstrap: [AppComponent]
})
export class AppModule { }
