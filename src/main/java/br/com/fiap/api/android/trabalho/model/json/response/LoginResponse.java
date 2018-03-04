package br.com.fiap.api.android.trabalho.model.json.response;

import java.io.Serializable;

public class LoginResponse implements Serializable {

	private static final long serialVersionUID = 3509306501734872132L;
	
	private String token;

	public LoginResponse() {
		super();
	}

	public LoginResponse(String token) {
		this.setToken(token);
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
