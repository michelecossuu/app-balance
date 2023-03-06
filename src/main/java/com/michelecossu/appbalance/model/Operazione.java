package com.michelecossu.appbalance.model;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Operazione {
	
	private long id;
	private String descrizione;
	private Date data;
	private String tipoOperazione;
	private Conto conto;
	private Categoria categoria;

}
