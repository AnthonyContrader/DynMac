import { StoreDTO } from './storedto';
import { MachineDTO } from './machinedto';
export class SensorDTO {

	id: number;
	
	name : string;

	lifetime: Int16Array;

	machine : MachineDTO;

	store : StoreDTO;
	
}