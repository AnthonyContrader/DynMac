import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { DepartmentDTO } from 'src/dto/departmentdto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

/**
 * I service sono decorati da @Injectable. 
 * Qui trovate, oltre ai metodi ereditati dall'Abstract,
 *  il metodo per il login (in mirror con il backend).
 * 
 * @author Vittorio Valent
 * 
 * @see AbstractService
 */
@Injectable({
  providedIn: 'root'
})
export class DepartmentService extends AbstractService<DepartmentDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'department';
  }

}