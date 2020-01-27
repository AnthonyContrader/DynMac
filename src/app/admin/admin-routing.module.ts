import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminLayoutComponent } from '../layout/admin-layout/admin-layout.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UsersComponent } from './users/users.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
import { MachineComponent } from './machine/machine.component';
import { DepartmentComponent } from './department/department.component';
import { OperatorComponent } from './operator/operator.component';
import { PurchaseorderComponent } from './purchaseorder/purchaseorder.component';
import { SensorComponent } from './sensor/sensor.component';
import { StoreComponent } from './store/store.component';
import { ReportComponent } from './report/report.component';

/**
 * Modulo di routing dell'admin. Qui ci sono i percorsi che un admin può seguire:
 * appena fa il login viene caricato nel <router-outlet> di app-component il layout e nel 
 * <router-outlet> del layout (come percorsi "children") vengono visualizzati gli altri 
 * (qui sotto sono indentati).
 * 
 * @author Vittorio Valent
 * 
 * @see AdminLayoutComponent
 * 
 * @see layout
 */
const routes: Routes = [
  { path: 'admin-dashboard', component: AdminLayoutComponent, children:[
    { path: '', component: AdminDashboardComponent},
    { path: 'users', component: UsersComponent},
    { path: 'work-in-progress', component: WorkInProgressComponent},
    { path: 'machines', component: MachineComponent},
    { path: 'departments', component: DepartmentComponent},
    { path: 'operators', component: OperatorComponent},
    { path: 'purchaseorders', component: PurchaseorderComponent},
    { path: 'sensors', component: SensorComponent},
    { path: 'stores', component: StoreComponent},
    { path: 'reports', component: ReportComponent}

  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }