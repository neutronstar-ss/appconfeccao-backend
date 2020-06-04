package br.com.confeccao.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.confeccao.entities.Despesa;
import br.com.confeccao.repositories.DespesaRepository;
import br.com.confeccao.services.exceptions.DatabaseException;
import br.com.confeccao.services.exceptions.ResourceNotFoundException;

@Service
public class DespesaService {
	
	@Autowired
	private DespesaRepository despesaRepository;
	
	public List<Despesa> findAll(){
		return despesaRepository.findAll();
	}
	
	public Despesa findById(Long Id) {
		Optional<Despesa> obj =  despesaRepository.findById(Id);
		return obj.get();
	}
	
	public Despesa insert(Despesa obj) {
		return despesaRepository.save(obj);
	}
	
	public void delete(Long id) {
		try {
		despesaRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Despesa update(Long id, Despesa obj) {
		try {
			Despesa entity = despesaRepository.getOne(id);
			updateData(entity, obj);
			return despesaRepository.save(entity);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Despesa entity, Despesa obj) {
		entity.setData(obj.getData());
		entity.setTipoDespesa(obj.getTipo());
		entity.setDescricao(obj.getDescricao());
		entity.setValor(obj.getValor());
		
	}

}
