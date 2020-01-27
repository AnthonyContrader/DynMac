import { Component, OnInit } from '@angular/core';
import { MachineService } from 'src/service/machineService';
import { MachineDTO } from 'src/dto/machinedto';
import { DepartmentDTO } from 'src/dto/departmentdto';
import { DepartmentService } from 'src/service/departmentService';
import {OperatorDTO } from 'src/dto/operatordto';
import { OperatorService } from 'src/service/operatorService';

  @Component({
    selector: 'app-operator',
    templateUrl: './operator.component.html',
    styleUrls: ['./operator.component.css']
  })

  export class OperatorComponent implements OnInit {

    operators: OperatorDTO[];
    machines: MachineDTO[];
    departments: DepartmentDTO[];
    operatortoinsert: OperatorDTO = new OperatorDTO();
    
    constructor(private service: OperatorService, private machineService: MachineService, private departmentService: DepartmentService) { }
  
    ngOnInit() {
      this.getOperators();
      this.getMachines();
      this.getDepartments();
    }

    getOperators() {
      this.service.getAll().subscribe(operators => {
         this.operators = operators
         console.log(this.operators);
      });
    }

    getMachines() {
      this.machineService.getAll().subscribe(machines => this.machines = machines);
    }

    getDepartments() {
      this.departmentService.getAll().subscribe(departments => this.departments = departments);
    }
  
    delete(operator: OperatorDTO) {
      this.service.delete(operator.id).subscribe(() => this.getOperators());
    }
  
    update(operator: OperatorDTO) {
      this.service.update(operator).subscribe(() => this.getOperators());
    }
  
    insert(operator: OperatorDTO) {
      this.service.insert(operator).subscribe(() => this.getOperators());
    }
  
    clear(){
      this.operatortoinsert = new OperatorDTO();
    }

}

