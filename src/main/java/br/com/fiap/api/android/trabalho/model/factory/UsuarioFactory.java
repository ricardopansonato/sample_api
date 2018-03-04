package br.com.fiap.api.android.trabalho.model.factory;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import br.com.fiap.api.android.trabalho.model.Usuario;
import br.com.fiap.api.android.trabalho.model.security.UsuarioLogado;

public class UsuarioFactory {

	public static UsuarioLogado create(Usuario usuario) {
		Collection<? extends GrantedAuthority> authorities;
		try {
			authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(usuario.getRole());
		} catch (Exception e) {
			authorities = null;
		}
		return new UsuarioLogado(usuario.getId(), usuario.getUsuario(), usuario.getSenha(), authorities);
	}
}
