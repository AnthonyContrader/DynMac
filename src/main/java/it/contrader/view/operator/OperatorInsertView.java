package it.contrader.view.operator;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class OperatorInsertView extends AbstractView {
	
	private Request request;

	private String name;
	private String type;

	private final String mode = "INSERT";

	public OperatorInsertView() {
	}
	

	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Operator", null);
		}
	}


	@Override
	public void showOptions() {
			System.out.println("Inserisci nome dell'operatore:");
			name = getInput();
			System.out.println("Inserisci tipo dell'operatore:");
			type = getInput();

	}


	@Override
	public void submit() {
		request = new Request();
		request.put("name", name);
		request.put("type", type);

		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Operator", "doControl", request);
	}


}
