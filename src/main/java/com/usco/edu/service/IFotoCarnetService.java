package com.usco.edu.service;

import java.io.ByteArrayInputStream;

import javax.servlet.http.HttpServletResponse;

import com.usco.edu.dto.FotoAntigua;

public interface IFotoCarnetService {

	ByteArrayInputStream mirarFoto(String codigo, HttpServletResponse response);

	FotoAntigua mirarFotoAntigua(String codigo);

}
