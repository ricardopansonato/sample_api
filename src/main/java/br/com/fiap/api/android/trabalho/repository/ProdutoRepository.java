package br.com.fiap.api.android.trabalho.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.fiap.api.android.trabalho.model.Produto;

public interface ProdutoRepository extends MongoRepository<Produto, String> {
	List<Produto> findByNome(final String nome);
}
