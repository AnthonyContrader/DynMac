package it.contrader.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.StoreDTO;
import it.contrader.service.StoreService;

@Controller
@RequestMapping("/store")
public class StoreController {

	@Autowired
	private StoreService service;
	@Autowired
	private PurchaseOrderController purchaseService;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "store";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, 
			@RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "store";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, 
			@RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatestore";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, 
			@RequestParam("id") long id,
			@RequestParam("number_spareparts") int number_spareparts) {

		StoreDTO dto = new StoreDTO();
		dto.setId(id);
		dto.setNumber_spareparts(number_spareparts);
		service.update(dto);
		setAll(request);
		return "store";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request,
			@RequestParam("name") String name,
			@RequestParam("number_spareparts") int number_spareparts,
			@RequestParam("cost") int cost,
			@RequestParam("totCost") int totCost) {
		StoreDTO dto = new StoreDTO();
		dto.setName(name);
		dto.setNumber_spareparts(number_spareparts);
		dto.setCost(cost);
		dto.setTotCost(totCost);
		
		service.insert(dto);
		getNumberSpareparts(number_spareparts,request);
		setAll(request);
			
		return "store";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		
		return "readstore";
	}

	// FUNZIONE NUOVO ORDINE D'ACQUISTO SE PEZZI DI RICAMBIO < 10 IN STORE
	public int getNumberSpareparts(int number_spareparts, HttpServletRequest request) {

		List<StoreDTO> list = new ArrayList<StoreDTO>();
		list = service.getAll();
		int index = list.size()-1;	
		for (StoreDTO a : list ) {
			if (a.getNumber_spareparts() < 10) {
				purchaseService.insert(request,service.getAll().get(index).getName() , " nessuna descrizione", 1000, service.getAll().get(index).getId() );
			}
		}

	return  number_spareparts;
}

	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
}
