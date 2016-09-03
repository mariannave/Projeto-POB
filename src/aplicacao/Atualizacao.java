package aplicacao;

import fachada.Sistema;

public class Atualizacao {

	
		public Atualizacao() {
			Sistema.inicializar();
			
			try {
				
//				RELACIONAMENTOS
				
//				CADASTRANDO PRODUTO EM UM SERVICO
				Sistema.addProdutoServico("Escova de cabelo", "Shampoo");
				Sistema.addProdutoServico("Manicure","Esmalte");
				Sistema.addProdutoServico("Selagem","Shampoo");
				Sistema.addProdutoServico("Escova de cabelo","Condicionador");
				System.out.println("Produto vinculado a servico.");

//				CADASTRANDO PAGAMENTOS 	
				Sistema.addPagamento("Maria Silva","Escova de cabelo","Ana Ferreira Souza");
				Sistema.addPagamento("Ana Clara","Escova","Ana Ferreira Souza");
				Sistema.addPagamento("Tereza Soares","Selagem","Ana Ferreira Souza");
				System.out.println("Pagamentos efetuados");
				
				
				//LISTANDO 
				System.out.println(Sistema.listarCliente());
				System.out.println(Sistema.listarFuncionario());
				System.out.println(Sistema.listarServicos());
				System.out.println(Sistema.listarProdutos());
//				
				// REMOVENDO PRODUTO
				Sistema.removerProduto(1);
				Sistema.removerProduto(3);
				
				// REMOVENDO CLIENTE
				Sistema.removerCliente(2);
				Sistema.removerCliente(4);
				
				
				
				
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

