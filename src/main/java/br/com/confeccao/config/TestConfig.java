package br.com.confeccao.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.confeccao.entities.Cliente;
import br.com.confeccao.entities.Despesa;
import br.com.confeccao.entities.ItemPedido;
import br.com.confeccao.entities.Pedido;
import br.com.confeccao.entities.Produto;
import br.com.confeccao.enums.TipoDespesa;
import br.com.confeccao.repositories.ClienteRepository;
import br.com.confeccao.repositories.DespesaRepository;
import br.com.confeccao.repositories.ItemPedidoRepository;
import br.com.confeccao.repositories.PedidoRepository;
import br.com.confeccao.repositories.ProdutoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private DespesaRepository despesaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Produto prod1 = new Produto(null, "Blusa Moletom", 40.00);
		Produto prod2 = new Produto(null, "Body Infantil", 8.00);
		
		produtoRepository.saveAll(Arrays.asList(prod1, prod2));
		
		Cliente c1 =  new Cliente(null, "Hellen");
		Cliente c2 = new Cliente(null, "Cris");
		
		Pedido p1 = new Pedido(null, LocalDate.now(), 0.0, "Pijamas Coloridos", c1);
		Pedido p2 = new Pedido(null, LocalDate.now(), 11.50, "Blusas Moletom", c2);
		Pedido p3 = new Pedido(null, LocalDate.now(), 0.0, null, c1);
		
		clienteRepository.saveAll(Arrays.asList(c1,c2));
		pedidoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		ItemPedido ip1 = new ItemPedido(p1, prod1, 5, prod1.getPreco());
		ItemPedido ip2 = new ItemPedido(p2, prod2, 2, prod2.getPreco());
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2));
		
		Despesa d1 = new Despesa(null, LocalDate.now(), TipoDespesa.MATERIAL, "5 peças moletom", 2000.00);
		Despesa d2 = new Despesa(null, LocalDate.now(), TipoDespesa.MÂO_DE_OBRA, "Alessandra: 2 dias", 300.00);
		
		despesaRepository.saveAll(Arrays.asList(d1, d2));
		
		
		
		
		
		
	}

}
