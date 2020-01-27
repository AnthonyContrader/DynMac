package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PurchaseOrderDTO {
	private long id;
	
	private String name_spareparts;
	
	private String description;
	
	private int number_PiecesToOrder;
	
	private StoreDTO storeDTO;
	
}
