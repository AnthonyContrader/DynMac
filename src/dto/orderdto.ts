import { StoreDTO } from './storedto';

export class OrderDTO {

	id: number;
	
	name_spareparts : string;

	description : string;
	
	number_PiecesToOrder : string;

	store : StoreDTO;

}