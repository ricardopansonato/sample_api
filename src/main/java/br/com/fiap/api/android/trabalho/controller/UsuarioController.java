package br.com.fiap.api.android.trabalho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.api.android.trabalho.model.Usuario;
import br.com.fiap.api.android.trabalho.model.json.request.LoginRequest;
import br.com.fiap.api.android.trabalho.repository.UsuarioRepository;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> authenticationRequest(@RequestBody LoginRequest authenticationRequest,
			Device device) throws AuthenticationException {
		final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		Usuario usuario = new Usuario(authenticationRequest.getUsuario(), bCryptPasswordEncoder.encode(authenticationRequest.getSenha()), "ADMIN");
		repository.save(usuario);
		return ResponseEntity.ok(usuario);
	}
}
