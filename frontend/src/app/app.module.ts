import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { CarsComponent } from './cars/cars.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import { GoodsComponent } from './goods/goods.component';
import { MastersComponent } from './masters/masters.component';
import { OrdersComponent } from './orders/orders.component';
import { OwnersComponent } from './owners/owners.component';
import { ServicesComponent } from './services/services.component';

@NgModule({
  declarations: [
    AppComponent,
    CarsComponent,
    GoodsComponent,
    MastersComponent,
    OrdersComponent,
    OwnersComponent,
    ServicesComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
