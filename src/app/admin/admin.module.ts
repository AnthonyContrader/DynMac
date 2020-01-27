import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AdminRoutingModule } from './admin-routing.module';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UsersComponent } from './users/users.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
import { MachineComponent } from './machine/machine.component';
import { DepartmentComponent } from './department/department.component';
import { OperatorComponent } from './operator/operator.component';
import { SensorComponent } from './sensor/sensor.component';
import { StoreComponent } from './store/store.component';
import { PurchaseorderComponent } from './purchaseorder/purchaseorder.component';
import { ReportComponent } from './report/report.component';

/**
 * Modulo dell'admin, qui vengono dichiarate le component che utilizza 
 * l'admin. Questo modulo importa AdminRoutingModule.
 * 
 * @author Vittorio Valent
 * 
 * @see AdminRoutingModule
 */
@NgModule({
  declarations: [AdminDashboardComponent, UsersComponent, WorkInProgressComponent, MachineComponent, DepartmentComponent, OperatorComponent, SensorComponent, StoreComponent, PurchaseorderComponent, ReportComponent],
  imports: [
    CommonModule,
    AdminRoutingModule,
    FormsModule
  ]
})
export class AdminModule { }
