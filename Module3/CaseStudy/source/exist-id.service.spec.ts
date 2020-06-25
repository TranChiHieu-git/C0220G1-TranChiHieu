import { TestBed } from '@angular/core/testing';

import { ExistIdService } from './exist-id.service';

describe('ExistIdService', () => {
  let service: ExistIdService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExistIdService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
