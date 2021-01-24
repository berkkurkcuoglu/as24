import { Component, OnInit } from '@angular/core';

import { ReportService } from 'src/app/services/report.service';

@Component({
  selector: 'app-report3',
  templateUrl: './report3.component.html',
  styleUrls: ['./report3.component.scss'],
})
export class Report3Component implements OnInit {
  public averagePrice: number;

  constructor(private reportService: ReportService) {}

  ngOnInit(): void {
    this.reportService.getReport3().subscribe((data) => {
      this.averagePrice = data;
    });
  }
}
