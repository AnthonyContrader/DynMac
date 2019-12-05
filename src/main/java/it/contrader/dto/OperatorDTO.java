package it.contrader.dto;

public class OperatorDTO {


	private int id;
	private String name;
	private String type;

	public OperatorDTO() {
	}

	public OperatorDTO(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public OperatorDTO(int id, String name, String type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return  id + " \t " + name + " \t" + type ;
	}

}
