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

import it.contrader.dto.MachineDTO;
import it.contrader.dto.PurchaseOrderDTO;
import it.contrader.dto.StoreDTO;
import it.contrader.model.PurchaseOrder;
import it.contrader.service.StoreService;

@RestController
@RequestMapping("/purchaseorder")
@CrossOrigin(origins = "http://localhost:4200")
public class PurchaseOrderController extends AbstractController<PurchaseOrderDTO>{

	
}