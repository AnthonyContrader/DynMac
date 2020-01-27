	package it.contrader.converter;

	import org.springframework.stereotype.Component;

	import it.contrader.dto.StoreDTO;

	import it.contrader.model.Store;

	@Component
	public class StoreConverter extends AbstractConverter<Store, StoreDTO> {

		@Override
		public Store toEntity(StoreDTO storeDTO) {
			Store store = null;
			if (storeDTO != null) {
				store = new Store(storeDTO.getId(), storeDTO.getNumber_spareparts(), storeDTO.getName(), storeDTO.getCost(), storeDTO.getTotCost());
			}
			return store;
		}

		@Override
		public StoreDTO toDTO(Store store) {
			StoreDTO storeDTO = null;
			if (store != null) {
				storeDTO = new StoreDTO(store.getId(), store.getNumber_spareparts(), store.getName(), store.getCost(), store.getTotCost());
			}
			return storeDTO;
		}
	}
