package br.com.confeccao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.confeccao.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
