package aplicacao;

import fachada.Sistema;
import modelo.Produto;
import modelo.Servico;


public class Cadastro {
	
	public Cadastro() {
		Sistema.inicializar();
		
		try {
			
////			//CADASTRANDO CLIENTE;
//			Cliente cliente;
//			cliente = Sistema.cadastroCliente("Maria Silva", "(83) 9 9999-0000", "Rua das Trincheiras, 110. Joao Pessoa");
//			cliente = Sistema.cadastroCliente("Ana Clara", "(83) 9 9999-1111", "Rua Anna Rossmark, 1380. Joao Pessoa");
//			cliente = Sistema.cadastroCliente("Tereza Soares", "(83) 9 9999-2222", "Rua Francisco Paulo Simao, 1485. Joao Pessoa");
//			cliente = Sistema.cadastroCliente("Lucia Moraes", "(83) 9 9999-3333", "Rua Angelo Minosi, 568. Joao Pessoa");
//			System.out.println("Cliente cadastrado");
//			
//			//CADASTRANDO FUNCIONARIO;
//			
//			Funcionario funcionario;
//			funcionario = Sistema.cadastroFuncionario("Laura Rocha Oliveira", "Manicure");
//			funcionario = Sistema.cadastroFuncionario("Ana Ferreira Souza", "Cabelereira");
//			funcionario = Sistema.cadastroFuncionario("Leila Sousa Azevedo", "Colorista");
//			funcionario = Sistema.cadastroFuncionario("Raissa Costa Rodrigues", "Esteticista");
//			System.out.println("Funcionario cadastrado");
//
//			
////			CADASTRANDO PRODUTO;
//			Produto produto;
//			produto = Sistema.cadastrarProduto("Shampoo", 10);
//			produto = Sistema.cadastrarProduto("Condicionador", 10);
//			produto = Sistema.cadastrarProduto("Tinta", 20);
//			produto = Sistema.cadastrarProduto("Esmalte", 100);
//			System.out.println("Produto cadastrado");
//			
//////			CADASTRANDO SERVICO
//			Servico servico;
//			servico = Sistema.cadastrarServico("Escova de cabelo", 30.00);
//			servico = Sistema.cadastrarServico("Manicure", 20.00);
//			servico = Sistema.cadastrarServico("Pedicure", 20.00);
//			servico = Sistema.cadastrarServico("Selagem", 100.00);
//			System.out.println("Servico cadastrado");
			
			
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
