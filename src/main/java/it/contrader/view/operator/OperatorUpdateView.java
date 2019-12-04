package it.contrader.view.operator;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class OperatorUpdateView extends AbstractView{
	
	private Request request;

	private int id;
	private String name;
	private String type;
	
	private final String mode = "UPDATE";

	public OperatorUpdateView() {
	}


	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Operator", null);
		}
	}


	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id dell'utente:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci nome dell'operatore:");
			name = getInput();
			System.out.println("Inserisci tipo dell'operatore:");
			type = getInput();
		} catch (Exception e) {

		}
	}



	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("name", name);
		request.put("type", type);
		
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Operator", "doControl", request);
	}

}
