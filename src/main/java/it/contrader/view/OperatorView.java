package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.OperatorDTO;
import it.contrader.main.MainDispatcher;

public class OperatorView extends AbstractView {
	
	private Request request;
	private String choice;

	public OperatorView() {
		
	}


	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione operator ----------------\n");
			System.out.println("ID\tName\tType");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<OperatorDTO> operators = (List<OperatorDTO>) request.get("operators");
			for (OperatorDTO o: operators)
				System.out.println(o);
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
		MainDispatcher.getInstance().callAction("Operator", "doControl", this.request);
	}

}
