package br.com.fiap.api.android.trabalho.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.fiap.api.android.trabalho.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
	Usuario findByUsuario(String usuario);
}
