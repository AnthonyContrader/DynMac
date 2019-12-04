package it.contrader.controller;

import java.util.List;

import it.contrader.dto.DepartmentDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.DepartmentService;

public class DepartmentController implements Controller {
	
	private static String sub_package = "department.";
	private DepartmentService departmentService;

	public DepartmentController() {
		this.departmentService = new DepartmentService();
	}
	
	
	@Override
	public void doControl(Request request) {
		
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");

		int id;
		String name;
		int number_operators;


		switch (mode) {
		
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			DepartmentDTO departmentDTO = departmentService.read(id);
			request.put("department", departmentDTO);
			MainDispatcher.getInstance().callView(sub_package + "DepartmentRead", request);
			break;
		
		case "INSERT":
			name = request.get("name").toString();
			number_operators = Integer.parseInt(request.get("number_operators").toString());
			
			DepartmentDTO departmentToInsert = new DepartmentDTO(name, number_operators);
			departmentService.insert(departmentToInsert);
			request = new Request();
			request.put("mode", "mode");

			MainDispatcher.getInstance().callView(sub_package + "DepartmentInsert", request);
			break;
		
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			departmentService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "DepartmentDelete", request);
			break;
		
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			name = request.get("name").toString();
			number_operators = Integer.parseInt(request.get("number_operators").toString());
			
			DepartmentDTO departmentToUpdate = new DepartmentDTO(name, number_operators);
			departmentToUpdate.setId(id);
			departmentService.update(departmentToUpdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "DepartmentUpdate", request);
			break;
			
		case "DEPARTMENTSLIST":
			List<DepartmentDTO> departmentsDTO = departmentService.getAll();
			request.put("departments", departmentsDTO);
			MainDispatcher.getInstance().callView("Department", request);
			break;
			
	
		case "GETCHOICE":
					
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "DepartmentRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "DepartmentInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "DepartmentUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "DepartmentDelete", null);
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
