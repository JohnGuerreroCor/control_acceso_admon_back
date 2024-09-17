package com.usco.edu.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.usco.edu.entities.Usuario;
import com.usco.edu.service.serviceImpl.UsuarioService;

@Component
public class InfoAdicionalToken implements TokenEnhancer{
	
	@Autowired
	private UsuarioService usuarioService;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		Usuario usuario = usuarioService.findByUsername(authentication.getName());
		Map<String, Object> info = new HashMap<>();
		 info.put("Informacion Token Inicio Sesion", "Campos Necesarios ".concat(authentication.getName()));
        info.put("personaCodigo", usuario.getPersona().getCodigo());
        info.put("uaaCodigo", usuario.getUaa().getCodigo());
        info.put("uaaNombre", usuario.getUaa().getNombreCorto());
        info.put("personaNombre", usuario.getPersona().getNombre());
        info.put("personaApellido", usuario.getPersona().getApellido());
        info.put("horaInicioSesion", usuario.getHoraInicioSesion());
		
		
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		
		return accessToken;
	}

}
