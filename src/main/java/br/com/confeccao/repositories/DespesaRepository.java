package br.com.confeccao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.confeccao.entities.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {

}
