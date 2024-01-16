package com.usco.edu.entities;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AsignacionPuesto implements Serializable {
	
	private int codigo;
	private PuestoVigilancia puesto;
	private Vigilante vigilante;
	private String observacion;
	private Date fechaCreacion;
	private Date fechaRetiro;
	private int estado;

	private static final long serialVersionUID = 1L;

}