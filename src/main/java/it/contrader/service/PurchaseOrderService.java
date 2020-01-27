package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.PurchaseOrderConverter;
import it.contrader.dao.PurchaseOrderRepository;
import it.contrader.dto.PurchaseOrderDTO;
import it.contrader.model.PurchaseOrder;

@Service
public class PurchaseOrderService extends AbstractService<PurchaseOrder, PurchaseOrderDTO> {

	@Autowired
	private PurchaseOrderConverter converter;
	@Autowired
	private PurchaseOrderRepository repository;

}
