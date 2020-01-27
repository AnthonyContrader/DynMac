import { Component, OnInit } from '@angular/core';
import { MachineService } from 'src/service/machineService';
import { MachineDTO } from 'src/dto/machinedto';
import { DepartmentDTO } from 'src/dto/departmentdto';
import { DepartmentService } from 'src/service/departmentService';

  @Component({
    selector: 'app-machine',
    templateUrl: './machine.component.html',
    styleUrls: ['./machine.component.css']
  })

  export class MachineComponent implements OnInit {

    machines: MachineDTO[];
    departments: DepartmentDTO[];
    machinetoinsert: MachineDTO = new MachineDTO();
    
    constructor(private service: MachineService, private departmentService: DepartmentService) { }
  
    ngOnInit() {
      this.getMachines();
      this.getDepartments();  
    }

    getMachines() {
      this.service.getAll().subscribe(machines => {
         this.machines = machines
         console.log(this.machines);
      });
    }

    getDepartments() {
      this.departmentService.getAll().subscribe(departments => this.departments = departments);
    }

    delete(machine: MachineDTO) {
      this.service.delete(machine.id).subscribe(() => this.getMachines());
    }
  
    update(machine: MachineDTO) {
      this.service.update(machine).subscribe(() => this.getMachines());
    }
  
    insert(machine: MachineDTO) {
      this.service.insert(machine).subscribe(() => this.getMachines());    
    }
  
    clear(){
      this.machinetoinsert = new MachineDTO();
    }

}
