import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FighterListComponent } from './components/fighter-list/fighter-list.component';
import {HttpClientModule} from '@angular/common/http';
import { FighterService } from './services/fighter.service';

@NgModule({
  declarations: [
    AppComponent,
    FighterListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule
  ],
  providers: [
    FighterService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
