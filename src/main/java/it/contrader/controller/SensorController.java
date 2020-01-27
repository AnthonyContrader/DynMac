package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.MachineDTO;
import it.contrader.dto.SensorDTO;
import it.contrader.dto.StoreDTO;
import it.contrader.service.MachineService;
import it.contrader.service.SensorService;
import it.contrader.service.StoreService;

@Controller
@RequestMapping("/sensor")
public class SensorController {

	@Autowired
	private SensorService service;
	@Autowired
	private StoreService storeService;
	@Autowired
	private MachineService machineService;
	
	

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "sensor";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "sensor";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatesensor";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request,
			@RequestParam("id") Long id, 
			@RequestParam("name") String name,
			@RequestParam("lifetime") int lifetime,
			@RequestParam("idStore") Long idStore,
			@RequestParam("idMachine") Long idMachine) {

		SensorDTO dto = new SensorDTO();
		StoreDTO s = storeService.read(idStore);
		MachineDTO m = machineService.read(idMachine);
		dto.setId(id);
		dto.setName(name);
		dto.setLifetime(lifetime);
		dto.setStoreDTO(s);
		dto.setMachineDTO(m);
		service.update(dto);
		setAll(request);
		return "sensor";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request,
			@RequestParam("name") String name,
			@RequestParam("lifetime") int lifetime,
			@RequestParam("idStore") Long idStore,
			@RequestParam("idMachine") Long idMachine) {
		SensorDTO dto = new SensorDTO();
		StoreDTO s = storeService.read(idStore);
		MachineDTO m = machineService.read(idMachine);
		dto.setName(name);
		dto.setLifetime(lifetime);
		dto.setStoreDTO(s);
		dto.setMachineDTO(m);
		service.insert(dto);
		setAll(request);
		return "sensor";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readsensor";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
		request.getSession().setAttribute("storelist", storeService.getAll());
		request.getSession().setAttribute("machinelist", machineService.getAll());
	}
}
