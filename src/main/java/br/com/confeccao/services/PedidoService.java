package br.com.confeccao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.confeccao.entities.Pedido;
import br.com.confeccao.repositories.PedidoRepository;

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

}
