package aplicacao;

import fachada.Sistema;


public class Cadastro {
	
	public Cadastro() {
		Sistema.inicializar();
		
		try {
			
			//CADASTRANDO CLIENTE;			
			Sistema.cadastroCliente("Maria Silva", "(83) 9 9999-0000", "Rua das Trincheiras, 110. Joao Pessoa");
			Sistema.cadastroCliente("Ana Clara", "(83) 9 9999-1111", "Rua Anna Rossmark, 1380. Joao Pessoa");
			Sistema.cadastroCliente("Tereza Soares", "(83) 9 9999-2222", "Rua Francisco Paulo Simao, 1485. Joao Pessoa");
			Sistema.cadastroCliente("Lucia Moraes", "(83) 9 9999-3333", "Rua Angelo Minosi, 568. Joao Pessoa");
			System.out.println("Cliente cadastrado");
			
			//CADASTRANDO FUNCIONARIO;
			
			
			Sistema.cadastroFuncionario("Laura Rocha", "Manicure");
			Sistema.cadastroFuncionario("Ana Ferreira", "Cabelereira");
			Sistema.cadastroFuncionario("Leila Sousa", "Colorista");
			Sistema.cadastroFuncionario("Raissa Costa", "Esteticista");
			System.out.println("Funcionario cadastrado");

			
////			CADASTRANDO PRODUTO;
			Sistema.cadastrarProduto("Shampoo", 10);
			Sistema.cadastrarProduto("Condicionador", 10);
			Sistema.cadastrarProduto("Tinta", 20);
			Sistema.cadastrarProduto("Esmalte", 100);
			System.out.println("Produto cadastrado");
			
//////			CADASTRANDO SERVICO
			Sistema.cadastrarServico("Escova de cabelo", 30.00);
			Sistema.cadastrarServico("Manicure", 20.00);
			Sistema.cadastrarServico("Pedicure", 20.00);
			Sistema.cadastrarServico("Selagem", 100.00);
			System.out.println("Servico cadastrado");
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

			Sistema.finalizar();
			System.out.println("Adicionado com sucesso");
	}
		
	public static void main(String[] args) {
		new Cadastro();

	}

}
