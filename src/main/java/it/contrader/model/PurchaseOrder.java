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

public class PurchaseOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true)
	private String name_spareparts;
	
	private String description;
	
	private int number_PiecesToOrder;
	
	// MOLTI ORDINI D'ACQUISTO STANNO IN MAGAZZINO
	@ManyToOne
	@JoinColumn(name="id_store", referencedColumnName="id")
	private Store store;
	
	
}
