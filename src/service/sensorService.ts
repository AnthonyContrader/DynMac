import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { SensorDTO } from 'src/dto/sensordto';
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
export class SensorService extends AbstractService<SensorDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'sensor';
  }

}