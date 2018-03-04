package br.com.fiap.api.android.trabalho.loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.fiap.api.android.trabalho.model.Produto;
import br.com.fiap.api.android.trabalho.model.Usuario;
import br.com.fiap.api.android.trabalho.repository.ProdutoRepository;
import br.com.fiap.api.android.trabalho.repository.UsuarioRepository;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private ProdutoRepository produtoRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		usuarioRepository.deleteAll();
		usuarioRepository.save(new Usuario("usuario", bCryptPasswordEncoder.encode("usuario"), "ADMIN"));
		produtoRepository.deleteAll();
		produtoRepository.save(new Produto("Banana", "Fruta", 12d));
		produtoRepository.save(new Produto("Pera", "Fruta", 10d));
	}

}