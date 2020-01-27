package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MachineDTO {

	private long id;
	
	private String name;
	
	private int number_sensor; 
	

	private DepartmentDTO departmentDTO;
	
	private ReportDTO reportDTO;
	
}