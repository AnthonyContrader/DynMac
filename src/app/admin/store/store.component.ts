import { Component, OnInit } from '@angular/core';
import { StoreDTO } from 'src/dto/storedto';
import { StoreService } from 'src/service/storeService';
import { OrderDTO } from 'src/dto/orderdto';
import { OrderService } from 'src/service/orderService';

  @Component({
    selector: 'app-store',
    templateUrl: './store.component.html',
    styleUrls: ['./store.component.css']
  })

  export class StoreComponent implements OnInit {

    stores: StoreDTO[];
    storetoinsert: StoreDTO = new StoreDTO();
    order : OrderDTO;

    
    constructor(private service: StoreService, private orderService: OrderService) { }
  
    ngOnInit() {
      this.getStores();
    }

    getStores() {
      this.service.getAll().subscribe(stores => this.stores = stores);
    }
  
    delete(store: StoreDTO) {
      this.service.delete(store.id).subscribe(() => this.getStores());
    }
  
    update(store: StoreDTO) {
      this.service.update(store).subscribe(() => this.getStores());
    }
  
    insert(store: StoreDTO) {
      this.service.insert(store).subscribe(() => this.getStores());
    }

    NewOrder(store: StoreDTO) {
      if(store.number_spareparts < 10){
        this.orderService.insertOrder;
        
      }      
    }

    clear(){
      this.storetoinsert = new StoreDTO();
    }

}