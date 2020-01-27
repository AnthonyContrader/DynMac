import { Component, OnInit } from '@angular/core';
import { DepartmentDTO } from 'src/dto/departmentdto';
import { DepartmentService } from 'src/service/departmentService';

  @Component({
    selector: 'app-department',
    templateUrl: './department.component.html',
    styleUrls: ['./department.component.css']
  })

  export class DepartmentComponent implements OnInit {

    departments: DepartmentDTO[];
    departmenttoinsert: DepartmentDTO = new DepartmentDTO();
    
    constructor(private service: DepartmentService) { }
  
    ngOnInit() {
      this.getDepartments();
    }

    getDepartments() {
      this.service.getAll().subscribe(departments => this.departments = departments);
    }
  
    delete(department: DepartmentDTO) {
      this.service.delete(department.id).subscribe(() => this.getDepartments());
    }
  
    update(department: DepartmentDTO) {
      this.service.update(department).subscribe(() => this.getDepartments());
    }
  
    insert(department: DepartmentDTO) {
      this.service.insert(department).subscribe(() => this.getDepartments());
    }
  
    clear(){
      this.departmenttoinsert = new DepartmentDTO();
    }

}