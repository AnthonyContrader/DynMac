package it.contrader.view.department;

import it.contrader.controller.Request;
import it.contrader.dto.DepartmentDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class DepartmentReadView extends AbstractView{

	private int id;
	private Request request;
	private final String mode = "READ";
	
	@Override
	public void showResults(Request request) {
		if (request != null) {
			DepartmentDTO departmentDTO = (DepartmentDTO) request.get("department");
			System.out.println(departmentDTO);
			MainDispatcher.getInstance().callView("Department", null);
		}
	}

	
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'id del reparto:");
		id = Integer.parseInt(getInput());
	}


	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Department", "doControl", request);
	}
}
