package com.usco.edu.service.serviceImpl;

import java.io.ByteArrayInputStream;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.edu.dao.IFotoCarnetDao;
import com.usco.edu.dto.FotoAntigua;
import com.usco.edu.dto.RespuestaVerFoto;
import com.usco.edu.feing.EnviarFotoClient;
import com.usco.edu.service.IFotoCarnetService;


@Service
public class FotoCarnetServiceImpl implements IFotoCarnetService  {
	
	@Autowired
	private EnviarFotoClient enviarFotoClient;
	
	@Autowired
	private IFotoCarnetDao fotoCarnetDao;

	public boolean isValido(String nombre) {
		String expresion = "^([[a-zA-Z][0-9]_]{2,150})$";
		try {
			Pattern p = Pattern.compile(expresion);
			Matcher matcher = p.matcher(nombre);
			return matcher.matches();
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}

	}
	
	@Override
	public ByteArrayInputStream mirarFoto(String perCodigo, HttpServletResponse response) {
		
		byte[] array = {1, 2, 3, 4};

		String Key = fotoCarnetDao.obtenerTokenFoto(perCodigo);

		RespuestaVerFoto respuesta = new RespuestaVerFoto();

		try {
			respuesta = enviarFotoClient.mostrarFoto(perCodigo, Key);

			byte[] fotoBytes = Base64.getDecoder().decode(respuesta.getBase64().split(",")[1]);
			return new ByteArrayInputStream(fotoBytes);

		} catch (Exception e) {
			System.out.println(e);
		}

		return new ByteArrayInputStream(array);
	}
	
	@Override
	public FotoAntigua mirarFotoAntigua(String perCodigo) {
		String aux = "";
		String Key = fotoCarnetDao.obtenerTokenFoto(perCodigo);
		aux = enviarFotoClient.mostrarFotoAntigua(perCodigo, Key).toString();
		FotoAntigua foto = new FotoAntigua();
		foto.setUrl(aux);
		return foto;
	}

}
