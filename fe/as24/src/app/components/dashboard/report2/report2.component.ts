import { Component, OnInit } from '@angular/core';

import { Report2 } from 'src/app/models/Report2.model';

import { ReportService } from 'src/app/services/report.service';

@Component({
  selector: 'app-report2',
  templateUrl: './report2.component.html',
  styleUrls: ['./report2.component.scss'],
})
export class Report2Component implements OnInit {
  public reportData: Report2;
  public makes: string[];

  constructor(private reportService: ReportService) {}

  ngOnInit(): void {
    this.reportService.getReport2().subscribe((data) => {
      this.reportData = data;
      this.makes = Object.keys(data);
    });
  }
}
