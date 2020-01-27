import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { OrderDTO } from 'src/dto/orderdto';
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
export class OrderService extends AbstractService<OrderDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'purchaseorder';
  }

  insertOrder(order: OrderDTO) {
    return this.http.post('http://localhost:' + this.port + '/' + this.type + '/insert', order.number_PiecesToOrder='1000' );
  }

}
