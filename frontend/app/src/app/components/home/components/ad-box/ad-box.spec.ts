import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdBox } from './ad-box';

describe('AdBox', () => {
  let component: AdBox;
  let fixture: ComponentFixture<AdBox>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AdBox],
    }).compileComponents();

    fixture = TestBed.createComponent(AdBox);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
