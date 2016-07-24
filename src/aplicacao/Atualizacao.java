package aplicacao;

import fachada.Sistema;

public class Atualizacao {

	
		public Atualizacao() {
			Sistema.inicializar();
			
			try {
				
//				RELACIONAMENTOS
				
//				CADASTRANDO PRODUTO EM UM SERVICO
//				Sistema.addProdutoServico(1,1);
//				Sistema.addProdutoServico(1,2);
//				Sistema.addProdutoServico(2,4);
//				Sistema.addProdutoServico(3,4);
//				System.out.println("Produto vinculado a servico.");
//				
//				Sistema.addPagamento(1,1,"Laura Rocha Oliveira");
//				Sistema.addPagamento(2,3,"Ana Ferreira Souza");
//				Sistema.addPagamento(3,4,"Raissa Costa Rodrigues");
//				System.out.println("Pagamentos efetuados");
				
				
				//LISTANDO 
				System.out.println(Sistema.listarCliente());
//				System.out.println(Sistema.listarFuncionario());
//				System.out.println(Sistema.listarServicos());
//				System.out.println(Sistema.listarProdutos());
//				
				// REMOVENDO PRODUTO
//				Sistema.removerProduto(1);
//				Sistema.removerProduto(3);
				
				// REMOVENDO CLIENTE
//				Sistema.removerCliente(2);
//				Sistema.removerCliente(4);
				
				
				
				
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

