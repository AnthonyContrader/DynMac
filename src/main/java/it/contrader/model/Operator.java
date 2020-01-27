package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor; 

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Operator {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true)
	private String name;
	
	private String type;
	
	// MOLTI OPERATORI STANNO IN UN REPARTO
	@ManyToOne
	@JoinColumn(name="id_department", referencedColumnName="id")
	private Department department;
	
	@ManyToOne
	@JoinColumn(name="id_machine", referencedColumnName="id")
	private Machine machine;

	
}
