package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.DepartmentDTO;
import it.contrader.main.MainDispatcher;

public class DepartmentView extends AbstractView {
	
	private Request request;
	private String choice;

	public DepartmentView() {
		
	}


	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione department ----------------\n");
			System.out.println("ID\tName\tNumber_Operators");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<DepartmentDTO> departments = (List<DepartmentDTO>) request.get("departments");
			for (DepartmentDTO d: departments)
				System.out.println(d);
			System.out.println();
		}
	}


	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();

		
	}
	

	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Department", "doControl", this.request);
	}

}
