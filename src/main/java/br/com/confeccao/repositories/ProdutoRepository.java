package br.com.confeccao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.confeccao.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
