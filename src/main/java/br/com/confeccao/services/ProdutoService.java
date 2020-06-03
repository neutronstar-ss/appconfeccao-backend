package br.com.confeccao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.confeccao.entities.Produto;
import br.com.confeccao.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> findAll(){
		return produtoRepository.findAll();
	}
	
	public Produto findById(Long Id) {
		Optional<Produto> obj =  produtoRepository.findById(Id);
		return obj.get();
	}

}
