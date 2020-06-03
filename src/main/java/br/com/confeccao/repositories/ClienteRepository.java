package br.com.confeccao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.confeccao.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
