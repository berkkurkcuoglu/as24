import { Component } from '@angular/core';

import { Tabs } from './enums/Tabs.enum';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  public Tabs: typeof Tabs = Tabs;
  public selectedTab: Tabs;

  public setSelectedTab(tab: Tabs): void {
    this.selectedTab = tab;
  }
}
