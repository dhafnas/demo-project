import { TestBed } from '@angular/core/testing';

import { FeatureRequestsService } from './feature-requests.service';

describe('FeatureRequestsService', () => {
  let service: FeatureRequestsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FeatureRequestsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
