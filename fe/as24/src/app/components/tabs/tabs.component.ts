import { Component, EventEmitter, OnInit, Output } from '@angular/core';

import { Tabs } from 'src/app/enums/Tabs.enum';

@Component({
  selector: 'app-tabs',
  templateUrl: './tabs.component.html',
  styleUrls: ['./tabs.component.scss'],
})
export class TabsComponent implements OnInit {
  @Output() tabSelected = new EventEmitter<Tabs>();

  public Tabs: typeof Tabs = Tabs;
  public selectedTab: Tabs;

  constructor() {}

  ngOnInit(): void {
    this.selectTab(Tabs.DASHBOARD);
  }

  selectTab(tab: Tabs): void {
    this.selectedTab = tab;
    this.tabSelected.emit(tab);
  }
}
