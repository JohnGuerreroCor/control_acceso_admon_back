package com.usco.edu.entities;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Vigilante implements Serializable {
	
	private int codigo;
	private TipoDocumento documento;
	private String identificacion;
	private String nombre;
	private String apellido;
	private String correo;
	private String empresa;
	private Date fechaCreacion;
	private Date fechaRetiro;
	private int estado;

	private static final long serialVersionUID = 1L;

}
