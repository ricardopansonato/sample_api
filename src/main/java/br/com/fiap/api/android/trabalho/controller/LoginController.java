package br.com.fiap.api.android.trabalho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.api.android.trabalho.model.json.request.LoginRequest;
import br.com.fiap.api.android.trabalho.model.json.response.LoginResponse;
import br.com.fiap.api.android.trabalho.security.TokenUtils;

@RestController
@RequestMapping("auth")
public class LoginController {

	@Value("${api.token.header}")
	private String tokenHeader;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenUtils tokenUtils;

	@Autowired
	private UserDetailsService userDetailsService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> authenticationRequest(@RequestBody LoginRequest authenticationRequest,
			Device device) throws AuthenticationException {

		Authentication authentication = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				authenticationRequest.getUsuario(), authenticationRequest.getSenha()));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		UserDetails userDetails = this.userDetailsService.loadUserByUsername(authenticationRequest.getUsuario());
		String token = this.tokenUtils.generateToken(userDetails, device);

		return ResponseEntity.ok(new LoginResponse(token));
	}
}