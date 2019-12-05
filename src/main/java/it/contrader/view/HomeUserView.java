package it.contrader.view;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeUserView extends AbstractView{

	private Request request;
	private String choice;
	private Request requestUser;

	@Override
	public void showResults(Request request) {
		this.requestUser = request;
    	if(request!=null) {
    	System.out.println("\n\nBenvenuto in DYNMAC ( "+request.get("username").toString().toUpperCase() +" )" + "\n");
    	}
	}

	@Override
	public void showOptions() {
		 System.out.println("--------------------------------- .:MENU:. ----------------------------------------\n");
	     System.out.println("Seleziona cosa vuoi gestire:");
	     System.out.println("[M]odifica [E]sci");
	     	     
	     //Il metodo che salva l'input nella stringa choice.
	     choice = this.getInput();
	}

	@Override
	public void submit() {
		
		request = new Request();

		switch (choice) {
			case "m":
	        	this.requestUser.put("mode", "MACHINESLIST");
	        	MainDispatcher.getInstance().callAction("Machine", "doControl", requestUser);
	        	break;
	
			default:
				MainDispatcher.getInstance().callAction("HomeUser", "doControl", null);
		}
				
	}

}