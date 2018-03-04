package br.com.fiap.api.android.trabalho.model.json.response;

import java.io.Serializable;
import java.util.List;

public class ProdutosResponse implements Serializable {

	private static final long serialVersionUID = -8442350959585540237L;

	private List<ProdutoResponse> items;

	public ProdutosResponse() {
		super();
	}

	public ProdutosResponse(List<ProdutoResponse> items) {
		super();
		this.items = items;
	}

	public List<ProdutoResponse> getItems() {
		return items;
	}

}
