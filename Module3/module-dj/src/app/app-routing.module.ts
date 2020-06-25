import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ImageGalleryComponent} from "./image-gallery/image-gallery.component";
import {ImgSliderComponent} from "./img-slider/img-slider.component";


const routes: Routes = [{path: 'baithuchanh', component: ImageGalleryComponent},
  {path: 'baitap', component: ImgSliderComponent},];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
