package com.michelecossu.appbalance.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "operazione")
public class Operazione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "descrizione")
	private String descrizione;
	
	@Column(name = "data")
	private Date data;
	
	@Column(name = "tipo_operazione")
	private String tipoOperazione;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conto_id")
	private Conto conto;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
	private Categoria categoria;

}
