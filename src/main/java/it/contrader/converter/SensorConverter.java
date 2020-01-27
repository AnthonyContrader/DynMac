	package it.contrader.converter;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Component;

	import it.contrader.dto.SensorDTO;
	import it.contrader.model.Sensor;

	@Component
	public class SensorConverter extends AbstractConverter<Sensor, SensorDTO> {
		@Autowired
		private StoreConverter storeConverter;
		@Autowired
		private MachineConverter machineConverter;

		@Override
		public Sensor toEntity(SensorDTO sensorDTO) {
			Sensor sensor = null;
			sensor = new Sensor();
			sensor.setId(sensorDTO.getId());
			if (sensorDTO.getName() != null) {
				sensor.setName(sensorDTO.getName());
			}
			if (sensorDTO.getLifetime() != 0) {
				sensor.setLifetime(sensorDTO.getLifetime());
			}
			if (sensorDTO.getStoreDTO() != null) {
				  sensor.setStore(storeConverter.toEntity(sensorDTO.getStoreDTO()));
			}
			if (sensorDTO.getMachineDTO() != null) {
				  sensor.setMachine(machineConverter.toEntity(sensorDTO.getMachineDTO()));
			}
			return sensor;
		}

		@Override
		public SensorDTO toDTO(Sensor sensor) {
			SensorDTO sensorDTO = null;
			sensorDTO = new SensorDTO();
			sensorDTO.setId(sensor.getId());
			if (sensor.getName() != null) {
				sensorDTO.setName(sensor.getName());
			}
			if (sensor.getLifetime() != 0) {
				sensorDTO.setLifetime(sensor.getLifetime());
			}
			if (sensor.getStore() != null) {
				  sensorDTO.setStoreDTO(storeConverter.toDTO(sensor.getStore()));
			}
			if (sensor.getMachine() != null) {
				  sensorDTO.setMachineDTO(machineConverter.toDTO(sensor.getMachine()));
			}
			
			return sensorDTO;
		}
		
	}
