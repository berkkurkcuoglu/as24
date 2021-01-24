import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { CsvTypes } from '../enums/CsvTypes.enum';
import { environment } from './../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class UploadService {
  constructor(private httpClient: HttpClient) {}

  public upload(file: File, type: CsvTypes): Observable<void> {
    const endpoint = this.getUploadEndpoint(type);
    const formData = new FormData();
    formData.append('file', file);

    return this.httpClient.post<void>(
      `${environment.beUrl}${endpoint}`,
      formData
    );
  }

  private getUploadEndpoint(type: CsvTypes): string {
    if (type === CsvTypes.LISTINGS) {
      return 'rest/listings';
    }
    if (type === CsvTypes.CONTACTS) {
      return 'rest/listings/contacts';
    }
  }
}
