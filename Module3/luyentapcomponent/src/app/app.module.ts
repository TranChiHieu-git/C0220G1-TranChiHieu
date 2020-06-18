import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {CalculatorComponent} from './calculator/calculator.component';
import {FormsModule} from '@angular/forms';
import {ProcessComponent} from './process/process.component';
import {RatingBarComponent} from './rating-bar/rating-bar.component';
import {CountdownComponent} from './countdown/countdown.component';
import {RouterModule} from '@angular/router';

@NgModule({
  declarations: [
    AppComponent,
    CalculatorComponent,
    ProcessComponent,
    RatingBarComponent,
    CountdownComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
