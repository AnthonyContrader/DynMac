package it.contrader.view.machine;

import it.contrader.controller.Request;

import it.contrader.dto.MachineDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class MachineReadView extends AbstractView {
	
	private int id;
	private Request request;
	private final String mode = "READ";

	public MachineReadView() {
	}

	@Override
	public void showResults(Request request) {
		if (request != null) {
			MachineDTO machine = (MachineDTO) request.get("machine");
			System.out.println(machine);
			MainDispatcher.getInstance().callView("Machine", null);
		}
	}


	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID della macchina:");
		id = Integer.parseInt(getInput());
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Machine", "doControl", request);
	}


}
