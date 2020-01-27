import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { StoreDTO } from 'src/dto/storedto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { OrderDTO } from 'src/dto/orderdto';

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
export class StoreService extends AbstractService<StoreDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'store';
  }


}