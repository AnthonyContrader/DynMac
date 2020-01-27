package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.PurchaseOrderDTO;
import it.contrader.model.PurchaseOrder;
	@Component
	public class PurchaseOrderConverter extends AbstractConverter<PurchaseOrder, PurchaseOrderDTO> {
		@Autowired
		private StoreConverter storeConverter;
		
		@Override
		public PurchaseOrder toEntity(PurchaseOrderDTO orderDTO) {
			PurchaseOrder order = null;
			order = new PurchaseOrder();
			order.setId(orderDTO.getId());
			if (orderDTO.getName_spareparts() != null) {
				order.setName_spareparts(orderDTO.getName_spareparts());
			}
			if (orderDTO.getDescription() != null) {
				order.setDescription(orderDTO.getDescription());
			}
			if (orderDTO.getNumber_PiecesToOrder() != 0) {
				order.setNumber_PiecesToOrder(orderDTO.getNumber_PiecesToOrder());
			}
			if (orderDTO.getStoreDTO() != null) {
				  order.setStore(storeConverter.toEntity(orderDTO.getStoreDTO()));
			}
			return order;
		}

		@Override
		public PurchaseOrderDTO toDTO(PurchaseOrder order) {
			PurchaseOrderDTO orderDTO = null;
			orderDTO = new PurchaseOrderDTO();
			orderDTO.setId(order.getId());
			if (order.getName_spareparts() != null) {
				orderDTO.setName_spareparts(order.getName_spareparts());
			}
			if (order.getDescription() != null) {
				orderDTO.setDescription(order.getDescription());
			}
			if (order.getNumber_PiecesToOrder() != 0) {
				orderDTO.setNumber_PiecesToOrder(order.getNumber_PiecesToOrder());
			}
			if (order.getStore() != null) {
				  orderDTO.setStoreDTO(storeConverter.toDTO(order.getStore()));
			}
			return orderDTO;
		}
	}
