package it.contrader.controller;

import java.util.List;

import it.contrader.dto.MachineDTO;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.MachineService;

public class MachineController implements Controller {

	private static String sub_package = "machine.";
	private MachineService machineService;
	
	public MachineController() {
		this.machineService = new MachineService();
	}
	
	@Override
	public void doControl(Request request) {
		
		//Estrae dalla request mode e choice
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");

		//Definisce i campi della classe (serviranno sempre, tanto vale definirli una sola volta)
		int id;
		String name;
		int number_sensors;
		
		switch (mode) {
		
		// Arriva qui dalla UserReadView. Invoca il Service con il parametro id e invia alla UserReadView uno user da mostrare 
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			MachineDTO machineDTO = machineService.read(id);
			request.put("machine", machineDTO);
			MainDispatcher.getInstance().callView(sub_package + "MachineRead", request);
			break;
		
		// Arriva qui dalla UserInsertView. Estrae i parametri da inserire e chiama il service per inserire uno user con questi parametri
		case "INSERT":
			name = request.get("name").toString();
			number_sensors = Integer.parseInt(request.get("number_sensor").toString());
			
			//costruisce l'oggetto user da inserire
			MachineDTO machinetoinsert = new MachineDTO(name, number_sensors);
			//invoca il service
			machineService.insert(machinetoinsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "MachineInsert", request);
			break;
		
		// Arriva qui dalla UserDeleteView. Estrae l'id dell'utente da cancellare e lo passa al Service
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			//Qui chiama il service
			machineService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "MachineDelete", request);
			break;
		
		// Arriva qui dalla UserUpdateView
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			name = request.get("name").toString();
			number_sensors = Integer.parseInt(request.get("number_sensor").toString());
			MachineDTO machinetoupdate = new MachineDTO(name, number_sensors);
			machinetoupdate.setId(id);
			machineService.update(machinetoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "MachineUpdate", request);
			break;
			
		//Arriva qui dalla UserView Invoca il Service e invia alla UserView il risultato da mostrare 
		case "MACHINESLIST":
			List<MachineDTO> machinesDTO = machineService.getAll();
			//Impacchetta la request con la lista degli user
			request.put("machines", machinesDTO);
			MainDispatcher.getInstance().callView("Machine", request);
			break;
		
			//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
			//con REQUEST NULL (vedi una View specifica)
				case "GETCHOICE":
				//toUpperCase() mette in maiuscolo la scelta
				switch (choice.toUpperCase()) {
				
				case "L":
					MainDispatcher.getInstance().callView(sub_package + "MachineRead", null);
					break;
					
				case "I":
					MainDispatcher.getInstance().callView(sub_package + "MachineInsert", null);
					break;
					
				case "M":
					MainDispatcher.getInstance().callView(sub_package + "MachineUpdate", null);
					break;
					
				case "C":
					MainDispatcher.getInstance().callView(sub_package + "MachineDelete", null);
					break;
					
				case "E":
					MainDispatcher.getInstance().callView("Login", null);
					break;
				
				case "B":
					MainDispatcher.getInstance().callView("HomeAdmin", null);
					break;
					
				default:
					MainDispatcher.getInstance().callView("Login", null);
				}
				
				default:
				MainDispatcher.getInstance().callView("Login", null);}
			
		}
}
