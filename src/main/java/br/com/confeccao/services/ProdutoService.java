package br.com.confeccao.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.confeccao.entities.Produto;
import br.com.confeccao.repositories.ProdutoRepository;
import br.com.confeccao.services.exceptions.DatabaseException;
import br.com.confeccao.services.exceptions.ResourceNotFoundException;

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
	
	public Produto insert(Produto obj) {
		return produtoRepository.save(obj);
	}
	
	public void delete(Long id) {
		try {
		produtoRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Produto update(Long id, Produto obj) {
		try {
			Produto entity = produtoRepository.getOne(id);
			updateData(entity, obj);
			return produtoRepository.save(entity);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Produto entity, Produto obj) {
		entity.setNome(obj.getNome());
		entity.setPreco(obj.getPreco());
		
	}

}
