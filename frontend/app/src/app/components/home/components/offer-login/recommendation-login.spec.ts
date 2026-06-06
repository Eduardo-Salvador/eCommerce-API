import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecommendationLogin } from './recommendation-login';

describe('RecommendationLogin', () => {
  let component: RecommendationLogin;
  let fixture: ComponentFixture<RecommendationLogin>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RecommendationLogin],
    }).compileComponents();

    fixture = TestBed.createComponent(RecommendationLogin);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
