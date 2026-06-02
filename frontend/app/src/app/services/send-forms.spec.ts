import { TestBed } from '@angular/core/testing';

import { SendForms } from './send-forms';

describe('SendForms', () => {
  let service: SendForms;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SendForms);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
