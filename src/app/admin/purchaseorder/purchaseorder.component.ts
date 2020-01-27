import { Component, OnInit } from '@angular/core';
import { OrderService } from 'src/service/orderService';
import { OrderDTO } from 'src/dto/orderdto';
import { StoreDTO } from 'src/dto/storedto';
import { StoreService } from 'src/service/storeService';

  @Component({
    selector: 'app-purchaseorder',
    templateUrl: './purchaseorder.component.html',
    styleUrls: ['./purchaseorder.component.css']
  })

  export class PurchaseorderComponent implements OnInit {

    orders: OrderDTO[];
    stores: StoreDTO[];
    ordertoinsert: OrderDTO = new OrderDTO();
    
    constructor(private service: OrderService, private storeService: StoreService) { }
  
    ngOnInit() {
      this.getOrders();
      this.getStores();
    }

    getOrders() {
      this.service.getAll().subscribe(orders => {
         this.orders = orders
         console.log(this.orders);
      });
    }

    getStores() {
      this.storeService.getAll().subscribe(stores => this.stores = stores);
    }
  
    delete(order: OrderDTO) {
      this.service.delete(order.id).subscribe(() => this.getOrders());
    }
  
    update(order: OrderDTO) {
      this.service.update(order).subscribe(() => this.getOrders());
    }
  
    insert(order: OrderDTO) {
      this.service.insert(order).subscribe(() => this.getOrders());
    }
  
    clear(){
      this.ordertoinsert = new OrderDTO();
    }

}

