package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OperatorDTO {


	private long id;
	
	private String name;
	
	private String type;
	
	private DepartmentDTO departmentDTO;
	
	private MachineDTO machineDTO;
	
	private ReportDTO reportDTO;

}
