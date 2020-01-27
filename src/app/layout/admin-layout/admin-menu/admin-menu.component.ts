import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-menu',
  templateUrl: './admin-menu.component.html',
  styleUrls: ['./admin-menu.component.css']
})
export class AdminMenuComponent implements OnInit {

  isUserCollapsed = false;
  isClientCollapsed = false;
  isAccountCollapsed = false;

  isMachineCollapsed = false;
  isDepartmentCollapsed = false;
  isOperatorCollapsed = false;
  isPurchaseorderCollapsed = false;
  isReportCollapsed = false;
  isSensorCollapsed = false;
  isStoreCollapsed = false;


  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('');
  }

  userscollapse() {
    if (this.isUserCollapsed === false) {
      this.isUserCollapsed = true;
    } else { this.isUserCollapsed = false; }
  }

  accountcollapse() {
    if (this.isAccountCollapsed === false) {
      this.isAccountCollapsed = true;
    } else { this.isAccountCollapsed = false; }
  }

  machinescollapse() {
    if (this.isMachineCollapsed === false) {
      this.isMachineCollapsed = true;
    } else { this.isMachineCollapsed = false; }
  }

  departmentscollapse() {
    if (this.isDepartmentCollapsed === false) {
      this.isDepartmentCollapsed = true;
    } else { this.isDepartmentCollapsed = false; }
  }

  operatorscollapse() {
    if (this.isOperatorCollapsed === false) {
      this.isOperatorCollapsed = true;
    } else { this.isOperatorCollapsed = false; }
  }

  purchaseorderscollapse() {
    if (this.isPurchaseorderCollapsed === false) {
      this.isPurchaseorderCollapsed = true;
    } else { this.isPurchaseorderCollapsed = false; }
  }

  reportscollapse() {
    if (this.isReportCollapsed === false) {
      this.isReportCollapsed = true;
    } else { this.isReportCollapsed = false; }
  }

  sensorscollapse() {
    if (this.isSensorCollapsed === false) {
      this.isSensorCollapsed = true;
    } else { this.isSensorCollapsed = false; }
  }

  storescollapse() {
    if (this.isStoreCollapsed === false) {
      this.isStoreCollapsed = true;
    } else { this.isStoreCollapsed = false; }
  }

}
