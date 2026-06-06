import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubFooter } from './sub-footer';

describe('SubFooter', () => {
  let component: SubFooter;
  let fixture: ComponentFixture<SubFooter>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SubFooter],
    }).compileComponents();

    fixture = TestBed.createComponent(SubFooter);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
