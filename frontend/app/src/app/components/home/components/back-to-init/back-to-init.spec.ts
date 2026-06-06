import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BackToInit } from './back-to-init';

describe('BackToInit', () => {
  let component: BackToInit;
  let fixture: ComponentFixture<BackToInit>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BackToInit],
    }).compileComponents();

    fixture = TestBed.createComponent(BackToInit);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
