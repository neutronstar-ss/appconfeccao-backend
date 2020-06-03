package br.com.confeccao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.confeccao.entities.Despesa;
import br.com.confeccao.repositories.DespesaRepository;

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

}
