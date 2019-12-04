package it.contrader.view.department;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class DepartmentInsertView extends AbstractView {
	
	private Request request;

	private String name;
	private int number_operators;

	private final String mode = "INSERT";

	public DepartmentInsertView() {
	}
	

	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Department", null);
		}
	}


	@Override
	public void showOptions() {
			System.out.println("Inserisci nome dell'operatore:");
			name = getInput();
			System.out.println("Inserisci il numero di operatori:");
			number_operators = Integer.parseInt(getInput());

	}


	@Override
	public void submit() {
		request = new Request();
		request.put("name", name);
		request.put("number_operators", number_operators);

		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Department", "doControl", request);
	}

}
