import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginBox } from './login-box';

describe('LoginBox', () => {
  let component: LoginBox;
  let fixture: ComponentFixture<LoginBox>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LoginBox],
    }).compileComponents();

    fixture = TestBed.createComponent(LoginBox);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
