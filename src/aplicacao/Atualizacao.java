package aplicacao;

import fachada.Sistema;

public class Atualizacao {

		public Atualizacao() {
			Sistema.inicializar();
			
			try {
				
//				RELACIONAMENTOS
				
//				CADASTRANDO PRODUTO EM UM SERVICO
//				Sistema.addProdutoServico("Escova de cabelo", "Shampoo");
//				Sistema.addProdutoServico("Manicure","Esmalte");
//				Sistema.addProdutoServico("Selagem","Shampoo");
//				Sistema.addProdutoServico("Escova de cabelo","Condicionador");
//				System.out.println("Produto vinculado a servico.");

//				CADASTRANDO PAGAMENTOS 	
//				Sistema.addPagamento("Maria Silva","Escova de cabelo","Ana Ferreira");
//				Sistema.addPagamento("Ana Clara","Escova de cabelo","Leila Sousa");
//				Sistema.addPagamento("Tereza Soares","Selagem","Ana Ferreira Souza");
//				System.out.println("Pagamentos efetuados");
//				
//				
//				LISTANDO 
//				System.out.println(Sistema.listarCliente());
//				System.out.println(Sistema.listarFuncionario());
//				System.out.println(Sistema.listarServicos());
//				System.out.println(Sistema.listarProdutos());
				System.out.println(Sistema.listarPagCliente("Ana Clara"));
//				System.out.println(Sistema.listarPagFuncionario("Ana Ferreira"));
//				System.out.println(Sistema.listarPagServico("Escova de cabelo"));
								


				
//				REMOVENDO PRODUTO
//				Sistema.removerProduto("Condicionador");
//				Sistema.removerProduto("Shampoo");
//				
//				REMOVENDO CLIENTE
//				Sistema.removerCliente("Maria Silva");
//				Sistema.removerCliente("Ana Clara");
//				Sistema.removerCliente("Ana Silva");
//				Sistema.removerCliente("Lucia Moraes");
//				
//				REMOVENDO FUNCIONÁRIO				
//				Sistema.removerFuncionario("Laura Rocha Oliveira");
//				Sistema.removerFuncionario("Leila Sousa Azevedo");
				
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

				Sistema.finalizar();
				System.out.println("Programa finalizado");
		}
			
		public static void main(String[] args) {
			new Atualizacao();

		}

}

