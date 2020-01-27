import { MachineDTO } from './machinedto';
import { OperatorDTO } from './operatordto';

export class ReportDTO {

	id: number;
	
	production : number;

	totalProduction : number;

	difference : number;

	net : number;

	waste : number;

	cost : number;

	machine : MachineDTO;

	operator : OperatorDTO;



	
}