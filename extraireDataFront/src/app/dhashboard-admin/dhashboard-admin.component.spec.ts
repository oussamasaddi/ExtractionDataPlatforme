import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DhashboardAdminComponent } from './dhashboard-admin.component';

describe('DhashboardAdminComponent', () => {
  let component: DhashboardAdminComponent;
  let fixture: ComponentFixture<DhashboardAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DhashboardAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DhashboardAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
