import { Component, OnInit } from '@angular/core';

import { CsvTypes } from 'src/app/enums/CsvTypes.enum';

import { UploadService } from './../../services/upload.service';

@Component({
  selector: 'app-data-insertion',
  templateUrl: './data-insertion.component.html',
  styleUrls: ['./data-insertion.component.scss'],
})
export class DataInsertionComponent implements OnInit {
  public CsvTypes: typeof CsvTypes = CsvTypes;

  constructor(private uploadService: UploadService) {}

  ngOnInit(): void {}

  upload(csv: File, type: CsvTypes): void {
    this.uploadService.upload(csv, type).subscribe(
      () => alert('Successfully uploaded.'),
      (error) => alert('Upload Failed -> ' + error.error.message)
    );
  }
}
