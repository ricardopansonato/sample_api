package br.com.fiap.api.android.trabalho.model.json.response;

import java.io.Serializable;

import br.com.fiap.api.android.trabalho.model.Produto;

public class ProdutoResponse implements Serializable {

	private static final long serialVersionUID = 4711934627126886877L;
	
	private String id;
	private String nome;
	private String descricao;
	private Double valor;
	
	public ProdutoResponse() {
		super();
	}
	
	public ProdutoResponse(final Produto produto) {
		super();
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.valor = produto.getValor();
	}

	public ProdutoResponse(String id, String nome, String descricao, Double valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public Double getValor() {
		return valor;
	}
}
