package it.contrader.view.machine;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class MachineInsertView extends AbstractView {
	
	private Request request;

	private String name;
	private int number_sensors;
	private final String mode = "INSERT";

	public MachineInsertView() {
	}
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Machine", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da inserire
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci nome macchina:");
			name = getInput();
			System.out.println("Inserisci numero sensori:");
			number_sensors = Integer.parseInt(getInput());
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("name", name);
		request.put("number_sensors", number_sensors);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Machine", "doControl", request);
	}

}
