package it.contrader.model;

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

public class Report {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private long production;
	private long totalProduction;
	private long difference = totalProduction - production;
	// Netto e spreco
	private long waste;
	private long net = difference - waste;
	private int cost;
	
		
	@ManyToOne
	@JoinColumn(name="id_machine", referencedColumnName="id")
	private Machine machine;
	
	@ManyToOne
	@JoinColumn(name="id_operator", referencedColumnName="id")
	private Operator operator;

	
}
