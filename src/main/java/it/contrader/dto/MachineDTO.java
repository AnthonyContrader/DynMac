package it.contrader.dto;

public class MachineDTO {

	private int id;
	private String name;
	private int number_sensors; 
	
	public MachineDTO(int id, String name, int number_sensors) {
		this.id = id;
		this.name = name;
		this.number_sensors = number_sensors;
	}
	
	public MachineDTO(String name, int number_sensors) {
		this.name = name;
		this.number_sensors = number_sensors;
	}
	// COSTRUTTORE VUOTO
	
	public MachineDTO() { }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber_sensors() {
		return number_sensors;
	}

	public void setNumber_sensors(int number_sensors) {
		this.number_sensors = number_sensors;
	}

	//To String
	@Override
	public String toString() {
		return id + " \t" + name + "\t" + number_sensors;
	}
}