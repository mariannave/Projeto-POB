package aplicacao;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Persistencia de Objetos
 * Prof. Fausto Maranhão Ayres
 **********************************/


import java.util.Scanner;

import fachada.Sistema;
import modelo.Prateleira;
import modelo.Produto;

public class AplicacaoConsole {
	private Scanner teclado = new Scanner(System.in);

	public AplicacaoConsole() {
		Sistema.inicializar();		
		processarMenu();
		Sistema.finalizar();
	}

	public  void processarMenu() {
		String entrada;
		int opcao;
		System.out.println("\n\n <-- Bem vindo à loja BoaMais" + " --> ");
		do {
			exibirMenu();
			try{
				entrada = teclado.nextLine();
				opcao = Integer.parseInt(entrada);
				switch (opcao) {
				case 0:	break;
				case 1:	tarefa_cadastrarProduto();				break;
				case 2:	tarefa_cadastrarPrateleira();			break;
				case 3:	tarefa_inserirProdutoPrateleira();					break;
				case 4: tarefa_listarProdutos();				break;
				case 5: tarefa_listarPrateleiras();				break;
				case 6:	tarefa_retirarProdutoPrateleira();		break;
				case 7: tarefa_apagarProduto(); 				break;
				case 8: tarefa_consultar_prateleiras_vazias();  break;
				case 9 : tarefa_consultar_vizinhos_arroz(); break;
				default: System.out.println("Opção Invalida !! \n");
				}
			}
			catch(NumberFormatException e)	{
				System.out.println("Digite somente número! \n");
				opcao=-1;
			}
			catch(Exception e)	{
				System.out.println("erro:" + e.getMessage());
				//e.printStackTrace();
				opcao=-1;
			}
		}while (opcao != 0);
		System.out.println("\n <-- Até Breve -->");
	}


	public void exibirMenu() {
		System.out.println("\n\n| - - - - - - - - -  Menu  - - - - - - - - - - - |");
		System.out.println("|  [0]- Sair                                     |");
		System.out.println("|  [1]- Cadastrar produto                        |");
		System.out.println("|  [2]- Cadastrar prateleira                     |");
		System.out.println("|  [3]- Inserir produto na prateleira            |");
		System.out.println("|  [4]- Listar produtos                          |");
		System.out.println("|  [5]- Listar prateleiras                       |");
		System.out.println("|  [6]- Remover produto da prateleira            |");
		System.out.println("|  [7]- Apagar produto                           |");
		System.out.println("|  [8]- Consultar prateleiras vazias             |");
		System.out.println("|  [9]- Consultar vizinhos do arroz              |");
		System.out.println("| - - - - - - - - - - - - - - - - - - - - - - - -|");
		System.out.print("  Opção :");
	}


//	---------------------------------------
	public void tarefa_cadastrarProduto(){
//	---------------------------------------
		Produto p;
		String nome;
		String preco;
		String estoque;
		String peso;
		System.out.println("\n---CADASTRO DE PRODUTO---");
		System.out.print("Nome do Produto(ou ENTER para voltar):");
		nome = teclado.nextLine();
		while (!nome.equals("")) {
			try{
				System.out.print("preco:");
				preco = teclado.nextLine();
				System.out.print("estoque:");
				estoque = teclado.nextLine();
				System.out.print("peso:");
				peso = teclado.nextLine();

				p = Sistema.cadastrarProduto(nome,
						Double.parseDouble(preco),
						Integer.parseInt(estoque),
						Double.parseDouble(peso)) ;
				System.out.println("--> cadastrado com sucesso ! --> " + p.getNome() +"\n");
			}
			catch(NumberFormatException e){
				System.out.println("--> numero incorreto");
			}
			catch(Exception e){
				System.out.println("-->" + e.getMessage());
			}

			System.out.print("Nome do Produto(ou ENTER para voltar):");
			nome = teclado.nextLine();
		}
	}

//	---------------------------------------
	public void tarefa_apagarProduto(){
//	---------------------------------------
		Produto p;
		String nome;
		System.out.println("\n---CADASTRO DE PRODUTO---");
		System.out.print("Nome do Produto(ou ENTER para voltar):");
		nome = teclado.nextLine();
		while (!nome.equals("")) {
			try{

				Sistema.apagarProduto(nome) ;
				System.out.println("--> apagou com sucesso ! --> " +"\n");
			}
			catch(Exception e){
				System.out.println("-->" + e.getMessage());
			}

			System.out.print("Nome do Produto(ou ENTER para voltar):");
			nome = teclado.nextLine();
		}
	}



//	---------------------------------------
	public void tarefa_cadastrarPrateleira(){
//	---------------------------------------
		System.out.println("\n---CADASTRO DE PRATELEIRA---");
		Prateleira pt;
	//	String id;
		String peso;
		System.out.print("peso maximo da prateleira(ou ENTER para voltar):");
		peso = teclado.nextLine();
		while (!peso.equals("")) {
			try{
				pt = Sistema.cadastrarPrateleira(Double.parseDouble(peso)) ;
				System.out.println("--> cadastrado com sucesso ! --> " + pt.getId() +"\n");
			}
			catch(NumberFormatException e){
				System.out.println("--> numero incorreto");
			}
			catch(Exception e){
				System.out.println("-->" + e.getMessage());
			}
			System.out.print("peso maximo da prateleira(ou ENTER para voltar):");
			peso = teclado.nextLine();
		}
	}

//	---------------------------------------
	public void tarefa_inserirProdutoPrateleira(){
//	---------------------------------------
		System.out.println("\n---ALOCAÇÃO DE PRODUTO NA PRATELEIRA---");
		String nome,idprat;
		System.out.print("Nome do Produto:");
		nome = teclado.nextLine();
		System.out.print("Id da prateleira:");
		idprat = teclado.nextLine();
		try{
			Sistema.inserirProdutoPrateleira(Integer.parseInt(idprat), nome) ;
			System.out.println("--> alocado com sucesso !   \n");
		}
		catch(NumberFormatException e){
			System.out.println("--> numero incorreto");
		}
		catch(Exception e){
			System.out.println("-->" + e.getMessage());
		}
	}

//	---------------------------------------
	public void tarefa_retirarProdutoPrateleira(){
//	---------------------------------------
		System.out.println("\n---REMOVER DE PRODUTO NA PRATELEIRA---");
		String nome;
		System.out.print("nome do produto:");
		nome = teclado.nextLine();
		try{
			Sistema.retirarProdutoPrateleira(nome) ;
			System.out.println("--> removido com sucesso !   \n");
		}
		catch(Exception e){
			System.out.println("-->" + e.getMessage());
		}
	}


//	---------------------------------------
	public void tarefa_listarProdutos()
//	---------------------------------------
	{
		System.out.println("\n---------inicio--------");
		System.out.println(Sistema.listarProdutos());
		System.out.println("-----------fim-----------");
	}

//	---------------------------------------
	public void tarefa_listarPrateleiras()
//	---------------------------------------
	{
		System.out.println("\n---------inicio--------");
		System.out.println(Sistema.listarPrateleiras());
		System.out.println("-----------fim-----------");
	}


//	---------------------------------------
	public void tarefa_consultar_prateleiras_vazias()
//	---------------------------------------
	{
		System.out.println("\n---------inicio--------");
//		System.out.println(Sistema.consultarPrateleirasVazias());
		System.out.println("-----------fim-----------");
	}

//	---------------------------------------
	public void tarefa_consultar_vizinhos_arroz()
//	---------------------------------------
	{
		System.out.println("\n---------inicio--------");
//		System.out.println(Sistema.consultarVizinhosArroz());
		System.out.println("-----------fim-----------");
	}


//  ***********************************************
	public static void main (String[] args)
//  ***********************************************
	{
		AplicacaoConsole ap1 = new AplicacaoConsole();
	}

}
