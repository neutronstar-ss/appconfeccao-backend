package br.com.confeccao.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.confeccao.entities.Pedido;
import br.com.confeccao.repositories.PedidoRepository;
import br.com.confeccao.services.exceptions.DatabaseException;
import br.com.confeccao.services.exceptions.ResourceNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public List<Pedido> findAll(){
		return pedidoRepository.findAll();
	}
	
	public Pedido findById(Long Id) {
		Optional<Pedido> obj =  pedidoRepository.findById(Id);
		return obj.get();
	}
	
	public Pedido insert(Pedido obj) {
		return pedidoRepository.save(obj);
	}
	
	public void delete(Long id) {
		try {
		pedidoRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Pedido update(Long id, Pedido obj) {
		try {
			Pedido entity = pedidoRepository.getOne(id);
			updateData(entity, obj);
			return pedidoRepository.save(entity);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Pedido entity, Pedido obj) {
		entity.setData(obj.getData());
		entity.setDesconto(obj.getDesconto());
		entity.setObservacoes(obj.getObservacoes());
		
	}

}
