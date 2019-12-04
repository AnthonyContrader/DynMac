package it.contrader.view.department;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class DepartmentUpdateView extends AbstractView{
	
	private Request request;

	private int id;

	private String name;
	private int number_operators;
	
	private final String mode = "UPDATE";

	public DepartmentUpdateView() {
	}


	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Department", null);
		}
	}


	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id dell'utente:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci nome dell'operatore:");
			name = getInput();
			System.out.println("Inserisci il numero di operatori:");
			number_operators = Integer.parseInt(getInput());
		} catch (Exception e) {

		}
	}

	
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("name", name);
		request.put("number_operators", number_operators);

		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Department", "doControl", request);
	}

}
