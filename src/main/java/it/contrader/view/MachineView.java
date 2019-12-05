package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.MachineDTO;
import it.contrader.main.MainDispatcher; 

public class MachineView extends AbstractView {
	private Request request;
	private String choice;

	public MachineView() {
		
	}

	/**
	 * Mostra la lista macchina
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione Macchina ----------------\n");
			System.out.println("ID\tNome Macchina\tNumero Sensori\\");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<MachineDTO> machines = (List<MachineDTO>) request.get("machines");
			for (MachineDTO m: machines)
				System.out.println(m);
			System.out.println();
		}
	}

	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();

		
	}
	
	/**
	 * Impacchetta la request e la manda allo UserController.
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Machine", "doControl", this.request);
	}

}
