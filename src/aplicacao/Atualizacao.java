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
				
				Sistema.addPagamento(1,1,2);
				System.out.println("FUNFA");
				
				
				
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

				Sistema.finalizar();
				System.out.println("Atualizado com sucesso");
		}
			
		public static void main(String[] args) {
			new Atualizacao();

		}

}

