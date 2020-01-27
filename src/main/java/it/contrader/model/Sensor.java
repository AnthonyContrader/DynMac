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

public class Sensor {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@Column(unique = true)
		private String name;
		
		private int lifetime;
		
		// MOLTI SENSORI STANNO IN MAGAZZINO
		@ManyToOne
		@JoinColumn(name="id_store", referencedColumnName="id")
		private Store store;
		
		@ManyToOne
		@JoinColumn(name="id_machine", referencedColumnName="id")
		private Machine machine;

	}
