import { Component, OnInit } from '@angular/core';
import { MachineService } from 'src/service/machineService';
import { MachineDTO } from 'src/dto/machinedto';
import { StoreDTO } from 'src/dto/storedto';
import { StoreService } from 'src/service/storeService';
import { SensorDTO } from 'src/dto/sensordto';
import { SensorService } from 'src/service/sensorService';

  @Component({
    selector: 'app-sensor',
    templateUrl: './sensor.component.html',
    styleUrls: ['./sensor.component.css']
  })

  export class SensorComponent implements OnInit {

    sensors: SensorDTO[];
    machines: MachineDTO[];
    stores: StoreDTO[];
    sensortoinsert: SensorDTO = new SensorDTO();
    
    constructor(private service: SensorService, private machineService: MachineService, private storeService: StoreService) { }
  
    ngOnInit() {
      this.getSensors();
      this.getMachines();
      this.getStores();
    }

    getSensors() {
      this.service.getAll().subscribe(sensors => {
         this.sensors = sensors
         console.log(this.sensors);
      });
    }
    
    getMachines() {
      this.machineService.getAll().subscribe(machines => this.machines = machines);
    }

    getStores() {
      this.storeService.getAll().subscribe(stores => this.stores = stores);
    }
  
    delete(sensor: SensorDTO) {
      this.service.delete(sensor.id).subscribe(() => this.getSensors());
    }
  
    update(sensor: SensorDTO) {
      this.service.update(sensor).subscribe(() => this.getSensors());
    }
  
    insert(sensor: SensorDTO) {
      this.service.insert(sensor).subscribe(() => this.getSensors());
    }
  
    clear(){
      this.sensortoinsert = new SensorDTO();
    }

}

