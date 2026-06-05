import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OfferCard } from './offer-card';

describe('OfferCard', () => {
  let component: OfferCard;
  let fixture: ComponentFixture<OfferCard>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OfferCard],
    }).compileComponents();

    fixture = TestBed.createComponent(OfferCard);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
