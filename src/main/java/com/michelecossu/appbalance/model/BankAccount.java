package com.michelecossu.appbalance.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "conto")
public class Conto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "saldo")
	private double saldo;
	
	@OneToMany(mappedBy = "conto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Operazione> operazioni = new ArrayList<>();

}
