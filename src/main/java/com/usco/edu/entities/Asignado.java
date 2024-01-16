package com.usco.edu.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Asignado implements Serializable {
	
	private int codigo;
	private String sede;
	private int sedeCodigo;
	private String subsede;
	private int subsedeCodigo;
	private String bloque;
	private int bloqueCodigo;
	private String nombrePuesto;
	private String tipoPuesto;
	private int tipoPuestoCodigo;
	private int cupoVigilante;
	private int asignados;
	private int estado;

	private static final long serialVersionUID = 1L;

}
