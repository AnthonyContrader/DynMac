import { DepartmentDTO } from './departmentdto';
export class MachineDTO {

	id: number;
	
	name: string;
	
	number_sensor: Int16Array; 

	department : DepartmentDTO;

}