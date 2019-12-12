package it.contrader.model;

public class Department {

	private int id;
	private String name;
	private int number_operators;

	public Department() {
	}

	public Department(String name, int number_operators) {
		this.name = name;
		this.number_operators = number_operators;
	}

	public Department(int id, String name, int number_operators) {
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
		return "Department [id=" + id + ", name=" + name + ", number_operators=" + number_operators + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number_operators != other.number_operators)
			return false;
		return true;
	}

}
