package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import dao.CidadeDAO;
import dao.ClienteDAO;
import model.Categoria;
import model.Cidade;
import model.Cliente;
import model.Pedido;
import model.Produto;

public class TelaMain {

	public static void main(String[] args) {
		//List<Cidade> cidades = new ArrayList<Cidade>();
		List<Cidade> cidades = CidadeDAO.getCidades();

		//List<Cliente> clientes = new ArrayList<Cliente>();
		List<Cliente> clientes = ClienteDAO.getClientes();
		
		List<Categoria> categorias = new ArrayList<Categoria>();
		List<Produto> produtos = new ArrayList<Produto>();
		List<Pedido> pedidos = new ArrayList<Pedido>();

		int opcao;
		do{
			opcao = mostrarMenu();
			switch ( opcao ) {
				case 0: 
					break;
				case 1:
					//cidades.add( cadastrarCidade() );
					cadastrarCidade();
					break;
				case 2:
					cidades = CidadeDAO.getCidades();
					if( cidades.size() == 0 ){
						JOptionPane.showMessageDialog(null, "É necessário cadastrar cidade primeiro!");
						cadastrarCidade();
						cidades = CidadeDAO.getCidades();
						cadastrarCliente(cidades);
					}else{
						//clientes.add( cadastrarCliente( cidades ) );
						cadastrarCliente( cidades );
					}
					break;
				case 3:
					categorias.add( cadastrarCategoria() );
					break;
				case 4:
					if( categorias.size() == 0 ){
						JOptionPane.showMessageDialog(null, "É necessário cadastrar categoria primeiro!");
						break;
					}else{
						produtos.add( cadastrarProduto( categorias ) );
						break;
					}
				case 5:
					cidades = CidadeDAO.getCidades();
					listarCidades( cidades );
					break;
				case 6:
					clientes = ClienteDAO.getClientes();
					listarClientes( clientes );
					break;
				case 7:
					listarCategorias(categorias);
					break;
				case 8:
					listarProdutos(produtos);
					break;
				case 9:
					pedidos.add( cadastrarPedido(pedidos, clientes) );
					break;
				case 10:
					listarPedidos(pedidos);
					if( pedidos.size() > 0 ){
						if( produtos.size() == 0){
							JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado!" );
							break;
						}else{ 
							String idPedDigitado = JOptionPane.showInputDialog("Digite o ID do Pedido:");
							if( idPedDigitado.isEmpty() ){ 
								break;
							}else{
								try {
									int idPed = Integer.valueOf( idPedDigitado  );
									Pedido pedSelected = null;
									for (Pedido pedido : pedidos) {
										if( pedido.id == idPed ){
											pedSelected = pedido;
										}
									}
									addProdutoAoPedido(produtos, pedSelected );
									break;
								} catch (Exception e) {
									JOptionPane.showMessageDialog(null, e.toString() );
									break;
								}
							}
						}
					}else{
						break;
					}
				case 11:
					listarPedidos( pedidos );
					break;
				case 12:
					vizualizarPedido(pedidos);
					break;
				case 13:
					excluirCidade();
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opção inválida");
					break;
			}

		}while( opcao != 0 );
	}

	public static void listarCidades( List<Cidade> cidades ){
		String texto = "Cidades cadastradas:";
		if( cidades.size() == 0 ){
			texto += "\n\nNenhuma cidade cadastrada";
		}
		for (Cidade cid : cidades) {
			texto += "\n " + cid.id +  " - " + cid.nome + 
				 "\n-------------------------";
		}
		JOptionPane.showMessageDialog(null, texto);
	}

	public static void listarCategorias( List<Categoria> categorias){
		String texto = "Categorias cadastradas:";
		if( categorias.size() == 0 ){
			texto += "\n\nNenhuma categoria cadastrada";
		}
		for (Categoria cat : categorias) {
			texto += "\n " + cat.id +  " - " + cat.nome + 
				 "\n-------------------------";
		}
		JOptionPane.showMessageDialog(null, texto);
	}

	public static void listarClientes( List<Cliente> clientes){
		String texto = "Clientes cadastrados:";
		if( clientes.size() == 0 ){
			texto += "\n\nNenhum cliente cadastrado";
		}
		for ( Cliente cli : clientes) {
			texto += "\n " + cli.id +  " - " + cli.nome + 
				 "\nEnd: " + cli.endereco +
				 "\nCidade: " + cli.cidade.nome + 
				 "\n-------------------------";
		}
		JOptionPane.showMessageDialog(null, texto);
	}

	public static void listarProdutos( List<Produto> produtos){
		String texto = "Produtos cadastrados:";
		if( produtos.size() == 0 ){
			texto += "\n\nNenhum produto cadastrado";
		}
		for ( Produto prod: produtos ) {
			texto += "\n " + prod.id +  " - " + prod.nome + 
				 "\nPreço: " + prod.preco +
				 "\nQuantidade: " + prod.quantidade +
				 "\nCategoria: " + prod.categoria.nome + 
				 "\n-------------------------";
		}
		JOptionPane.showMessageDialog(null, texto);
	}

	public static void listarPedidos(List<Pedido> pedidos ){
		String texto = "Pedidos cadastrados:";
		if( pedidos.size() == 0 ){
			texto += "\n\nNenhum pedido cadastrado";
		}else{
			for (Pedido ped : pedidos) {
				texto += "\n-----------------------\n";
				texto += "Id do Pedido: " + ped.id;
				texto += "\nPedido no end: " + ped.endereco ;
				texto += "\nNome do Cliente: " + ped.cliente.nome;
				texto += "\nNome da cidade do Cliente: " + ped.cliente.cidade.nome;
				texto += "\nTotal do Pedido: R$ " + 
			 		String.format("%.2f",  ped.getTotalPedido() );
			}
		}
		JOptionPane.showMessageDialog(null, texto);
	}

	public static int mostrarMenu(){
		String texto =  "----Lojinha---- \n\n" +
				"1 - Cadastrar Cidade \n" +
				"2 - Cadastrar Cliente \n" +
				"3 - Cadastrar Categoria \n" +
				"4 - Cadastrar Produto \n" +
				"5 - Listar Cidades \n" +
				"6 - Listar Clientes \n" +
				"7 - Listar Categorias \n" +
				"8 - Listar Produtos \n"+ 
				"9 - Cadastrar Pedido \n"+ 
				"10 - Adicionar Produtos ao Pedido \n"+ 
				"11 - Listar Pedidos \n"+ 
				"12 - Visualizar Pedido \n"+ 
				"13 - Excluir cidade\n"+
				"0 - Sair \n " +
				"\nDigite a opção desejada: ";
		int opcao = -1;
		String opcaoDigitada = JOptionPane.showInputDialog(texto);
		if( !opcaoDigitada.isEmpty() ){
			opcao = Integer.valueOf( opcaoDigitada );
		}
		return opcao;
	}

/*
	public static Cidade cadastrarCidade(){
		String idDigitado = JOptionPane.showInputDialog("Digite o ID da Cidade");
		int id = 0;
		if( ! idDigitado.isEmpty() ){
			id = Integer.valueOf( idDigitado );
		}
		String nome = JOptionPane.showInputDialog("Digite o nome da Cidade");
		Cidade novaCidade = new Cidade(id, nome);
		return novaCidade;
	}
*/
	public static void cadastrarCidade(){
		String nome = JOptionPane.showInputDialog("Digite o nome da Cidade");
		if( !nome.isEmpty() )
			CidadeDAO.cadastrar(nome);
	}

	public static Categoria cadastrarCategoria(){
		String idDigitado = JOptionPane.showInputDialog("Digite o ID da Categoria");
		int id = 0;
		if( ! idDigitado.isEmpty() ){
			id = Integer.valueOf( idDigitado );
		}
		String nome = JOptionPane.showInputDialog("Digite o nome da Categoria");
		Categoria novaCategoria = new Categoria(id, nome);
		return novaCategoria;
	}

	public static void cadastrarCliente(List<Cidade> municipios){
		
		String nome = JOptionPane.showInputDialog("Digite o nome da Cliente: ");
		String end = JOptionPane.showInputDialog("Digite o endereço: ");
		
		String texto = "Cidades cadastradas:";
		for (Cidade cidade : municipios) {
			texto += "\n " + cidade.id +  " - " + cidade.nome;
		}

		texto += "\n  Digite o id da cidade deste cliente: ";
		int idCidade = Integer.valueOf(  JOptionPane.showInputDialog(texto) );
		Cidade cidSelecionada = null;
		for (Cidade cidade : municipios) {
			if( cidade.id == idCidade ){
				cidSelecionada = cidade;
			}
		}
		Cliente novoCliente = new Cliente(0 , nome, end, cidSelecionada);
		ClienteDAO.cadastrar(novoCliente);
	}

	public static Produto cadastrarProduto(List<Categoria> categorias){
		String idDigitado = JOptionPane.showInputDialog("Digite o ID da Produto: ");
		int id = 0;
		if( ! idDigitado.isEmpty() ){
			id = Integer.valueOf( idDigitado );
		}

		String nome = JOptionPane.showInputDialog("Digite o nome da Produto: ");

		String precoDigitado = JOptionPane.showInputDialog("Digite o preço: ");
		precoDigitado = precoDigitado.replace("," , "." );
		double preco = 0;
		if( ! precoDigitado.isEmpty() ){
			preco = Double.valueOf( precoDigitado );
		}

		String qtdDigitada = JOptionPane.showInputDialog("Digite a quantidade: ");
		qtdDigitada = qtdDigitada.replace("," , "." );
		double qtd = 0;
		if( ! qtdDigitada.isEmpty() ){
			qtd = Double.valueOf( qtdDigitada );
		}
		

		String texto = "Categorias cadastradas:";
		for (Categoria cat : categorias) {
			texto += "\n " + cat.id +  " - " + cat.nome;
		}
		texto += "\n  Digite o id da categoria deste produto: ";

		int idCategoria = Integer.valueOf(  JOptionPane.showInputDialog(texto) );
		Categoria catSelecionada = null;
		for (Categoria cat : categorias) {
			if( cat.id == idCategoria ){
				catSelecionada = cat;
			}
		}
		Produto novoProduto = new Produto(nome, preco, qtd, catSelecionada);
		novoProduto.id = id;
		return novoProduto;
	}

	public static Pedido cadastrarPedido(List<Pedido> pedidos, List<Cliente> clientes){
		String idDigitado = JOptionPane.showInputDialog("Digite o ID da Pedido: ");
		int id = 0;
		if( ! idDigitado.isEmpty() ){
			id = Integer.valueOf( idDigitado );
		}
		String end = JOptionPane.showInputDialog("Digite o endereço de entrega: ");
		String texto = "Clientes cadastrados:";
		for (Cliente cli : clientes) {
			texto += "\n " + cli.id +  " - " + cli.nome;
		}
		texto += "\n  Digite o id do cliente deste Pedido: ";
		int idCliente = Integer.valueOf(  JOptionPane.showInputDialog(texto) );
		Cliente cliSelecionado = null;
		for (Cliente cli : clientes) {
			if( cli.id == idCliente ){
				cliSelecionado = cli;
			}
		}
		Pedido novoPedido = new Pedido();
		novoPedido.id = id;
		novoPedido.endereco = end;
		novoPedido.cliente = cliSelecionado;
		return novoPedido;
	}

	public static void addProdutoAoPedido(List<Produto> produtos, Pedido pedido){
		String texto = "Produtos cadastrados:";
		if( produtos.size() == 0 ){
			texto += "\n\nNenhum produto cadastrado";
		}
		for ( Produto prod: produtos ) {
			texto += "\n " + prod.id +  " - " + prod.nome + 
				 "\nPreço: " + prod.preco +
				 "\nQuantidade: " + prod.quantidade +
				 "\nCategoria: " + prod.categoria.nome + 
				 "\n-------------------------" ;
		}
		texto += "\n\nDigite o id do Produto";
		String idDigitado = JOptionPane.showInputDialog(null, texto);
		int idProduto = 0;
		if( !idDigitado.isEmpty() ){
			idProduto = Integer.valueOf( idDigitado ) ;
		}

		Produto prodSelecionado = null;
		for (Produto produto : produtos) {
			if( produto.id == idProduto){
				prodSelecionado = produto;
			}
		}
		pedido.addProduto( prodSelecionado );

		
	} 

	public static void vizualizarPedido(List<Pedido> pedidos){
		int idPedido = Integer.valueOf( JOptionPane.showInputDialog("Id do Pedido:") );
		Pedido pedSelecionado = null;
		for (Pedido pedido : pedidos) {
			if( pedido.id == idPedido){
				pedSelecionado = pedido;
			}
		}
		String texto = "";
		texto += "Id do Pedido: " + pedSelecionado.id;
		texto += "\nPedido no end: " + pedSelecionado.endereco ;
		texto += "\nNome do Cliente: " + pedSelecionado.cliente.nome;
		texto += "\nNome da cidade do Cliente: " + pedSelecionado.cliente.cidade.nome;
		texto += "\nTotal do Pedido: R$ " + 
			 String.format("%.2f",  pedSelecionado.getTotalPedido() );
		if( pedSelecionado.produtos.size() == 0 ){
			texto += "\nPedido Vazio";
		}else{
			texto += "\nProdutos do Pedido:";
			for (Produto prod : pedSelecionado.produtos ) {
				texto += "\n" + prod.nome + " - " + prod.preco + " - " + prod.categoria.nome;
			}
		}
		JOptionPane.showMessageDialog(null, texto);
	}

	public static void excluirCidade(){
		List<Cidade> cidades = CidadeDAO.getCidades();
		String texto = "Cidades cadastradas:";
		for (Cidade cidade : cidades) {
			texto += "\n " + cidade.id +  " - " + cidade.nome;
		}

		texto += "\n  Digite o id da cidade que deseja excluir: ";
		String idDiditado = JOptionPane.showInputDialog(texto) ;
		if( idDiditado.isEmpty() ){
			JOptionPane.showMessageDialog(null, "Um id válido deve ser preenchido");
		}else{
			int idCidade = Integer.valueOf( idDiditado );
			CidadeDAO.excluir(idCidade);
		}
		
	}

}
