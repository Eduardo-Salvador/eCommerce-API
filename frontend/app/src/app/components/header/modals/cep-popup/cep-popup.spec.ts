import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CepPopup } from './cep-popup';

describe('CepPopup', () => {
  let component: CepPopup;
  let fixture: ComponentFixture<CepPopup>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CepPopup],
    }).compileComponents();

    fixture = TestBed.createComponent(CepPopup);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
