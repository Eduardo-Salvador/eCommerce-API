import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardBestRatedProducts } from './card-best-rated-products';

describe('CardBestRatedProducts', () => {
  let component: CardBestRatedProducts;
  let fixture: ComponentFixture<CardBestRatedProducts>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CardBestRatedProducts],
    }).compileComponents();

    fixture = TestBed.createComponent(CardBestRatedProducts);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
