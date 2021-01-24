import { Component, OnInit } from '@angular/core';

import { ReportService } from 'src/app/services/report.service';

import { Report4 } from './../../../models/Report4.model';

@Component({
  selector: 'app-report4',
  templateUrl: './report4.component.html',
  styleUrls: ['./report4.component.scss'],
})
export class Report4Component implements OnInit {
  public reportData: Report4;
  public months: string[];

  constructor(private reportService: ReportService) {}

  ngOnInit(): void {
    this.reportService.getReport4().subscribe((data) => {
      this.reportData = data;
      this.months = Object.keys(data).sort();
    });
  }
}
