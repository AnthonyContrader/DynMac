package it.contrader.dto;

public class DepartmentDTO {
	
	private int id;
	private String name;
	private int number_operators;

	public DepartmentDTO() {
	}

	public DepartmentDTO(String name, int number_operators) {
		this.name = name;
		this.number_operators = number_operators;
	}

	public DepartmentDTO(int id, String name, int number_operators) {
		this.id = id;
		this.name = name;
		this.number_operators = number_operators;
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

	public int getNumber_operators() {
		return number_operators;
	}

	public void setNumber_operators(int number_operators) {
		this.number_operators = number_operators;
	}

	@Override
	public String toString() {
		return  id + " \t "+ name + "\t" +  number_operators;
	}


}
