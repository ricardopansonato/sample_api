package br.com.fiap.api.android.trabalho.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.api.android.trabalho.model.Produto;
import br.com.fiap.api.android.trabalho.model.json.request.ProdutoRequest;
import br.com.fiap.api.android.trabalho.model.json.response.ProdutoResponse;
import br.com.fiap.api.android.trabalho.model.json.response.ProdutosResponse;
import br.com.fiap.api.android.trabalho.repository.ProdutoRepository;

@RestController
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;

	@RequestMapping(value = "produtos", method = RequestMethod.GET)
	@PreAuthorize("@securityService.hasProtectedAccess()")
	public ResponseEntity<?> all(@RequestParam(name = "nome", required = false) String nome, HttpServletRequest request) {
		List<ProdutoResponse> produtos = null;
		if (StringUtils.isEmpty(nome)) {
			produtos = repository.findAll()
									.stream()
									.map(p -> new ProdutoResponse(p.getId(), p.getNome(), p.getDescricao(), p.getValor()))
									.collect(Collectors.toList());
		} else {
			produtos = repository.findByNome(nome)
										.stream()
										.map(p -> new ProdutoResponse(p.getId(), p.getNome(), p.getDescricao(), p.getValor()))
										.collect(Collectors.toList());
		}
		
		return ResponseEntity.ok(new ProdutosResponse(produtos));
	}
	
	@RequestMapping(value = "produto/{id}", method = RequestMethod.GET)
	@PreAuthorize("@securityService.hasProtectedAccess()")
	public ResponseEntity<?> get(@PathVariable(name = "id") String id, HttpServletRequest request) {
		Produto produto = repository.findOne(id);
		if (produto == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(new ProdutoResponse(produto));
	}
	
	@RequestMapping(value = "produto/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("@securityService.hasProtectedAccess()")
	public ResponseEntity<?> delete(@PathVariable(name = "id") String id, HttpServletRequest request) {
		Produto produto = repository.findOne(id);
		if (produto == null) {
			return ResponseEntity.notFound().build();
		}
		repository.delete(id);
		return ResponseEntity.accepted().build();
	}
	
	@RequestMapping(value = "produto", method = RequestMethod.POST)
	@PreAuthorize("@securityService.hasProtectedAccess()")
	public ResponseEntity<?> create(@RequestBody ProdutoRequest produtoRequest, HttpServletRequest request) {
		Produto produto = new Produto();
		BeanUtils.copyProperties(produtoRequest, produto);
		repository.save(produto);
		return ResponseEntity.accepted().build();
	}
}
