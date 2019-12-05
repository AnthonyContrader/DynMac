package it.contrader.view.machine;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class MachineUpdateView extends AbstractView {
	
	private Request request;

	private int id;
	private String name_machine;
	private int number_sensor;
	private final String mode = "UPDATE";

	public MachineUpdateView() {
	}

	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Machine", null);
		}
	}

	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id della macchina:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci nome della macchina:");
			name_machine = getInput();
			System.out.println("Inserisci numero sensori:");
			number_sensor = Integer.parseInt(getInput());
		} catch (Exception e) {

		}
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("name", name_machine);
		request.put("number_sensor", number_sensor);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Machine", "doControl", request);
	}
}
