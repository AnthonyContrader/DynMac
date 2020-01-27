package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class StoreDTO {

		private long id;
		
		private int number_spareparts;
		
		private String name;
		
		private int cost;
		
		private int totCost;
	
}
