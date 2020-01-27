import { DepartmentDTO } from './departmentdto';
import { MachineDTO } from './machinedto';

export class OperatorDTO {

	id: number;
	
	name : string;

	type : string;

	Department : DepartmentDTO;

	Machine: MachineDTO;
	
}