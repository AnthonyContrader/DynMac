package it.contrader.controller;

import java.util.List;

import it.contrader.dto.OperatorDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.OperatorService;

public class OperatorController implements Controller {
	
	private static String sub_package = "operator.";
	private OperatorService operatorService;

	public OperatorController() {
		this.operatorService = new OperatorService();
	}
	
	
	@Override
	public void doControl(Request request) {
		
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");

		int id;
		String name;
		String type;


		switch (mode) {
		
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			OperatorDTO operatorDTO = operatorService.read(id);
			request.put("operator", operatorDTO);
			MainDispatcher.getInstance().callView(sub_package + "OperatorRead", request);
			break;
		
		case "INSERT":
			name = request.get("name").toString();
			type = request.get("type").toString();
			
			OperatorDTO operatorToInsert = new OperatorDTO(name, type);
			operatorService.insert(operatorToInsert);
			request = new Request();
			request.put("mode", "mode");

			MainDispatcher.getInstance().callView(sub_package + "OperatorInsert", request);
			break;
		
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			operatorService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "OperatorDelete", request);
			break;
		
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			name = request.get("name").toString();
			type = request.get("type").toString();
			
			OperatorDTO operatorToUpdate = new OperatorDTO(name, type);
			operatorToUpdate.setId(id);
			operatorService.update(operatorToUpdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "OperatorUpdate", request);
			break;
			
		case "OPERATORSLIST":
			List<OperatorDTO> operatorsDTO = operatorService.getAll();
			request.put("operators", operatorsDTO);
			MainDispatcher.getInstance().callView("Operator", request);
			break;
			
	
		case "GETCHOICE":
					
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "OperatorRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "OperatorInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "OperatorUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "OperatorDelete", null);
				break;
				
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}

}
