package br.com.confeccao.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.confeccao.entities.Despesa;
import br.com.confeccao.services.DespesaService;

@RestController
@RequestMapping(value = "/despesas")
public class DespesaResource {
	
	@Autowired
	private DespesaService despesaService;
	
	@GetMapping
	public ResponseEntity<List<Despesa>> findAll(){
		List<Despesa> list = despesaService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = ("/{id}"))
	public ResponseEntity<Despesa> findById(@PathVariable Long id){
		Despesa obj = despesaService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Despesa> insert(@RequestBody Despesa obj){
		obj = despesaService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = ("/{id}"))
	public ResponseEntity<Void> delete (@PathVariable Long id){
		despesaService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = ("/{id}"))
	public ResponseEntity<Despesa> update(@PathVariable Long id, @RequestBody Despesa obj ){
		obj = despesaService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
