package it.contrader.view.operator;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class OperatorDeleteView extends AbstractView{
	
	private Request request;

	private int id;
	private final String mode = "DELETE";

	public OperatorDeleteView() {
	}


	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Operator", null);
		}
	}


	@Override
	public void showOptions() {
			System.out.println("Inserisci id dell'operatore:");
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
