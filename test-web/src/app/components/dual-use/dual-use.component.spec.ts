import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DualUseComponent } from './dual-use.component';

describe('DualUseComponent', () => {
  let component: DualUseComponent;
  let fixture: ComponentFixture<DualUseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DualUseComponent],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DualUseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
