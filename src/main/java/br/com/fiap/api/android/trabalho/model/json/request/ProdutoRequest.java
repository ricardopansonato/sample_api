package br.com.fiap.api.android.trabalho.model.json.request;

import java.io.Serializable;

public class ProdutoRequest implements Serializable {

	private static final long serialVersionUID = 777978643489103764L;
	
	private String id;
	private String nome;
	private String descricao;
	private Double valor;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
