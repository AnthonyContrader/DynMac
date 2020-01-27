package it.contrader.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.converter.StoreConverter;
import it.contrader.dao.StoreRepository;
import it.contrader.dto.StoreDTO;
import it.contrader.model.PurchaseOrder;
import it.contrader.model.Store;
import it.contrader.service.PurchaseOrderService;
import it.contrader.service.StoreService;


@RestController
@RequestMapping("/store")
@CrossOrigin(origins = "http://localhost:4200")
public class StoreController extends AbstractController<StoreDTO>{
	
/*
	@Autowired
	private StoreService service;
	@Autowired
	private PurchaseOrderService purchaseService;
	
	@PostMapping("/purchaseorder")
	public int getNumberSpareparts(int number_spareparts, HttpServletRequest request) {
		
		List<StoreDTO> list = new ArrayList<StoreDTO>();
		list = (List<StoreDTO>) service.getAll();
		int index = list.size()-1;	
		for (StoreDTO a : list ) {
			if (a.getNumber_spareparts() < 10) {			
				//purchaseService.insert(request,((List<StoreDTO>) service.getAll()).get(index).getName() , " nessuna descrizione", 1000, ((List<StoreDTO>) service.getAll()).get(index).getId() );
				System.out.println("Pezzi minori di 10");
			System.out.println(a.getNumber_spareparts());
			}
		}
		 
	return  number_spareparts;
}	
*/
	
	
}