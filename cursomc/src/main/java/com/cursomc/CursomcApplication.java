package com.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cursomc.domain.Categoria;
import com.cursomc.domain.Cidade;
import com.cursomc.domain.Cliente;
import com.cursomc.domain.Endereco;
import com.cursomc.domain.Estado;
import com.cursomc.domain.ItemPedido;
import com.cursomc.domain.Pagamento;
import com.cursomc.domain.PagamentoComBoleto;
import com.cursomc.domain.PagamentoComCartao;
import com.cursomc.domain.Pedido;
import com.cursomc.domain.Produto;
import com.cursomc.domain.enums.EstadoPagamento;
import com.cursomc.domain.enums.TipoCliente;
import com.cursomc.repositories.CategoriaRepository;
import com.cursomc.repositories.CidadeRepository;
import com.cursomc.repositories.ClienteRepository;
import com.cursomc.repositories.EnderecoRepository;
import com.cursomc.repositories.EstadoRepository;
import com.cursomc.repositories.ItemPedidoRepository;
import com.cursomc.repositories.PagamentoRepository;
import com.cursomc.repositories.PedidoRepository;
import com.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired						// CRIANDO AS DEPENDÊNCIAS DOS REPOSITORIES
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
		
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática"); 		//Instanciando categorias
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Cama mesa e Banho");
		Categoria cat4 = new Categoria(null, "Eletrônicos");		
		Categoria cat5 = new Categoria(null, "Jargdinagem");
		Categoria cat6 = new Categoria(null, "Decoração");
		Categoria cat7 = new Categoria(null, "Perfumaria");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);		//Instanciando produtos
		Produto p2 = new Produto(null, "Impressora", 800.000);
		Produto p3 = new Produto(null, "Mouse" , 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));		//Instanciando lista de produtos
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1 , cat2));		//Instanciando lista de categorias
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));//Instanciando salva a lista de categorias
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));		//Instanciando salva a lista de produtos
		
		Estado est1 = new Estado(null, "Minas Gerais");				//Instanciando os estados
		Estado est2 = new Estado(null, "São Paulo");
		
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);			//Instanciando cidades
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));				//Instanciando lista de cidades
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));		//Instanciando salva a lista de estados
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));		//Instanciando salva a lista de cidades
		
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);  //Instanciando cliente
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);		//Instanciando endereco
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "sala 800", "Centro", "38777012", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));		//Instanciando lista de endereco
		
		clienteRepository.saveAll(Arrays.asList(cli1));			//Instanciando salva lista de cliente
		enderecoRepository.saveAll(Arrays.asList(e1, e2));		//Instanciando salva lista de enderecos
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm"); 	//Instanciando formato SimpleDateFormat
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);	//Instanciando pedido
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);		//Instanciando pagamento
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));		//Instanciando lista de pedidos
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));		//Instanciando salva lista de pedidos
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2)); //Instanciando salva lista de pagamentos
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);	//Instanciando  Itens Pedido
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));		//Instanciando cada pedido com os itens do pedido
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip3));			//Instaciando cada produto com os itens do pedido
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3)); //Instanciando salva itens do pedido
	}

}
