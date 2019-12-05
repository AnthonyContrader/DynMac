package it.contrader.model;

public class Machine {

	private int id;
	private String name;
	private int number_sensors; 
	
	public Machine(int id, String name, int number_sensors) {
		this.id = id;
		this.name = name;
		this.number_sensors = number_sensors;
	}
	
	public Machine(String name, int number_sensors) {
		this.name = name;
		this.number_sensors = number_sensors;
	}
	// COSTRUTTORE VUOTO
	
	public Machine() { }

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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Machine other = (Machine) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number_sensors != other.number_sensors)
			return false;
		return true;
	}
	
}
