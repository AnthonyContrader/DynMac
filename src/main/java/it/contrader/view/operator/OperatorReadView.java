package it.contrader.view.operator;

import it.contrader.controller.Request;
import it.contrader.dto.OperatorDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class OperatorReadView extends AbstractView{
	
	private int id;
	private Request request;
	
	private final String mode = "READ";

	public OperatorReadView() {
	}


	@Override
	public void showResults(Request request) {
		if (request != null) {
			OperatorDTO operatorDTO = (OperatorDTO) request.get("operator");
			System.out.println(operatorDTO);
			MainDispatcher.getInstance().callView("Operator", null);
		}
	}

	
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'id dell'operatore:");
		id = Integer.parseInt(getInput());
	}


	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Operator", "doControl", request);
	}


}
