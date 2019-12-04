package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.OperatorDTO;
import it.contrader.model.Operator;

public class OperatorConverter {
	
	public OperatorDTO toDTO(Operator operator) {
		OperatorDTO operatorDTO = new OperatorDTO(operator.getId(), operator.getName(), operator.getType());
		return operatorDTO;
	}

	
	public Operator toEntity(OperatorDTO operatorDTO) {
		Operator operator = new Operator(operatorDTO.getId(), operatorDTO.getName(), operatorDTO.getType());
		return operator;
	}
	
	
	public List<OperatorDTO> toDTOList(List<Operator> operatorList) {

		List<OperatorDTO> operatorDTOList = new ArrayList<OperatorDTO>();
		
		for(Operator operator : operatorList) {

			operatorDTOList.add(toDTO(operator));
		}
		return operatorDTOList;
	}

}
