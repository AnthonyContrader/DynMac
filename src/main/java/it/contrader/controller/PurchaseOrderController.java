package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.PurchaseOrderDTO;
import it.contrader.dto.StoreDTO;
import it.contrader.service.PurchaseOrderService;
import it.contrader.service.StoreService;

@Controller
@RequestMapping("/purchaseorder")
public class PurchaseOrderController {

	@Autowired
	private PurchaseOrderService service;
	@Autowired
	private StoreService storeService;

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "purchaseorder";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "purchaseorder";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatepurchaseorder";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") int id,
			@RequestParam("name_spareparts") String name_spareparts,
			@RequestParam("description") String description,
			@RequestParam("number_PiecesToOrder") int number_PiecesToOrder,
			@RequestParam("idStore") Long idStore) {

		PurchaseOrderDTO dto = new PurchaseOrderDTO();
		StoreDTO s = storeService.read(idStore);
		dto.setId(id);
		dto.setName_spareparts(name_spareparts);
		dto.setDescription(description);
		dto.setNumber_PiecesToOrder(number_PiecesToOrder);
		dto.setStoreDTO(s);
		service.update(dto);
		setAll(request);
		return "purchaseorder";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, 
			@RequestParam("name_spareparts") String name_spareparts,
			@RequestParam("description") String description,
			@RequestParam("number_PiecesToOrder") int number_PiecesToOrder,
			@RequestParam("idStore") long i) {
		
		PurchaseOrderDTO dto = new PurchaseOrderDTO();
		StoreDTO s = storeService.read(i);
		dto.setName_spareparts(name_spareparts);
		dto.setDescription(description);
		dto.setNumber_PiecesToOrder(number_PiecesToOrder);
		dto.setStoreDTO(s);
		
		service.insert(dto);
		setAll(request);
		
		
		/*
		if (storeService.getNumberSensor(storeService.getNumberSensor(number_spareparts)) < 10) {
			
			
		}*/
		
		return "purchaseorder";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readpurchaseorder";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
		request.getSession().setAttribute("storelist", storeService.getAll());
	}

}
