package br.com.confeccao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.confeccao.entities.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {

}
