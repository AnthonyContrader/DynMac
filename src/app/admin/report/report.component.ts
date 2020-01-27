import { Component, OnInit } from '@angular/core';
import { OperatorDTO } from 'src/dto/operatordto';
import { MachineDTO } from 'src/dto/machinedto';
import { ReportDTO } from 'src/dto/reportdto';
import { ReportService } from 'src/service/reportService';
import { MachineService } from 'src/service/machineService';
import { OperatorService } from 'src/service/operatorService';

  @Component({
    selector: 'app-report',
    templateUrl: './report.component.html',
    styleUrls: ['./report.component.css']
  })

  export class ReportComponent implements OnInit {

    reports: ReportDTO[];
    operators: OperatorDTO[];
    machines: MachineDTO[];
    reporttoinsert: ReportDTO = new ReportDTO();

    
    constructor(private service: ReportService, private machineService: MachineService, private operatorService: OperatorService) { }
  
    ngOnInit() {
      this.getReports();
      this.getMachines();
      this.getOperators();
    }

    getReports() {
      this.service.getAll().subscribe(reports => {
         this.reports = reports
         console.log(this.reports);
      });
    }

    getMachines() {
      this.machineService.getAll().subscribe(machines => this.machines = machines);
    }
  
    getOperators() {
      this.operatorService.getAll().subscribe(operators => this.operators = operators);
    }

    delete(report: ReportDTO) {
      this.service.delete(report.id).subscribe(() => this.getReports());
    }
  
    update(report: ReportDTO) {
      this.service.update(report).subscribe(() => this.getReports());
    }
  
    insert(report: ReportDTO) {
      this.service.insert(report).subscribe(() => this.getReports());
    }
  
    clear(){
      this.reporttoinsert = new ReportDTO();
    }

}

