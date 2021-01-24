import { Component, OnInit } from '@angular/core';
import { ReportService } from './../../../services/report.service';
import { Report1 } from './../../../models/Report1.model';

@Component({
  selector: 'app-report1',
  templateUrl: './report1.component.html',
  styleUrls: ['./report1.component.scss'],
})
export class Report1Component implements OnInit {
  public reportData: Report1;
  public sellers: string[];

  constructor(private reportService: ReportService) {}

  ngOnInit(): void {
    this.reportService.getReport1().subscribe((data) => {
      this.reportData = data;
      this.sellers = Object.keys(data);
    });
  }
}
