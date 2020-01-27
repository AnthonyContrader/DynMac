package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ReportDTO {

	private long id;
	
	private long production;
	private long totalProduction;
	private long difference;
	// Netto e spreco
	private long net;
	private long waste;
	private long cost;
	
	private MachineDTO machineDTO;
	
	private OperatorDTO operatorDTO;
	
}
