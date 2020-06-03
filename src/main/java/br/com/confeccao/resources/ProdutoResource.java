package br.com.confeccao.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.confeccao.entities.Produto;
import br.com.confeccao.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAll(){
		List<Produto> list = produtoService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = ("/{id}"))
	public ResponseEntity<Produto> findById(@PathVariable Long id){
		Produto obj = produtoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
