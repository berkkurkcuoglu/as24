import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { environment } from './../../environments/environment';

import { Report1 } from '../models/Report1.model';
import { Report2 } from '../models/Report2.model';
import { Report4 } from '../models/Report4.model';

@Injectable({
  providedIn: 'root',
})
export class ReportService {
  constructor(private httpClient: HttpClient) {}

  public getReport1(): Observable<Report1> {
    return this.httpClient.get<Report1>(
      `${environment.beUrl}rest/report/report1`
    );
  }
  public getReport2(): Observable<Report2> {
    return this.httpClient.get<Report2>(
      `${environment.beUrl}rest/report/report2`
    );
  }
  public getReport3(): Observable<number> {
    return this.httpClient.get<number>(
      `${environment.beUrl}rest/report/report3`
    );
  }
  public getReport4(): Observable<Report4> {
    return this.httpClient.get<Report4>(
      `${environment.beUrl}rest/report/report4`
    );
  }
}
