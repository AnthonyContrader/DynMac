package it.contrader.view.machine;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class MachineDeleteView extends AbstractView {
	
	private Request request;

	private int id;
	private final String mode = "DELETE";

	public MachineDeleteView() {
	}

	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Machine", null);
		}
	}

	/**
	 * Chiede all'utente di inserire l'id dell'utente da cancellare
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci id della macchina:");
			id = Integer.parseInt(getInput());

	}

	/**
	 * impacchetta la request con l'id dell'utente da cancellare
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Machine", "doControl", request);
	}


}
