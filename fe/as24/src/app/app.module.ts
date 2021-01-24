import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { DataInsertionComponent } from './components/data-insertion/data-insertion.component';
import { TabsComponent } from './components/tabs/tabs.component';
import { Report1Component } from './components/dashboard/report1/report1.component';
import { Report2Component } from './components/dashboard/report2/report2.component';
import { Report3Component } from './components/dashboard/report3/report3.component';
import { Report4Component } from './components/dashboard/report4/report4.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    DataInsertionComponent,
    TabsComponent,
    Report1Component,
    Report2Component,
    Report3Component,
    Report4Component,
  ],
  imports: [BrowserModule, HttpClientModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
