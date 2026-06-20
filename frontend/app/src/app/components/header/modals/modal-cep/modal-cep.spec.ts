import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalCep } from './modal-cep';

describe('ModalCep', () => {
  let component: ModalCep;
  let fixture: ComponentFixture<ModalCep>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ModalCep],
    }).compileComponents();

    fixture = TestBed.createComponent(ModalCep);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
