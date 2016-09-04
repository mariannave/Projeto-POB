package fachada;

import java.util.List;

import daojpa.DAO;
import daojpa.DAOCliente;
import daojpa.DAOFuncionario;
import daojpa.DAOPagamento;
import daojpa.DAOProduto;
import daojpa.DAOServico;
import modelo.Cliente;
import modelo.Funcionario;
import modelo.Pagamento;
import modelo.Produto;
import modelo.Servico;

public class Sistema {
	
	private static DAOProduto daoProduto = new DAOProduto();
	private static DAOCliente daoCliente = new DAOCliente();
	private static DAOFuncionario daoFuncionario = new DAOFuncionario();
	private static DAOServico daoServico = new DAOServico();
	private static DAOPagamento daoPagamento = new DAOPagamento();


	
	public static void inicializar(){
		DAO.abrir();
	}
	
	public static void finalizar(){
		DAO.fechar();
	}
		
	// ---------- CLIENTE -----
	
	// CADASTRANDO CLIENTE
	public static Cliente cadastroCliente(String nome, String telefone, String endereco) 
			throws  Exception{
	
		DAO.begin();
		
		Cliente cliente = daoCliente.localizarPeloNome(nome); 
		
		if(cliente != null){
			throw new Exception("Cliente ja cadastrado:" + nome);
		}
	
		cliente = new Cliente(nome,telefone,endereco);
		daoCliente.persistir(cliente);
		daoCliente.commit();
		
		return cliente;
	}
	
	//	FUNCIONARIO
	// CADASTRANDO FUNCIONARIO
		public static Funcionario cadastroFuncionario(String nome, String funcao) 
				throws  Exception{
			
			DAO.begin();
			
			Funcionario funcionario = daoFuncionario.localizarPeloNome(nome);
			
			if(funcionario != null){
				throw new Exception("Funcionario ja cadastrado:" + nome);
			}
			
			funcionario = new Funcionario(nome, funcao);
			daoFuncionario.persistir(funcionario);
			daoFuncionario.commit();
			
			return funcionario;					
			
		}
		
		//PRODUTO
		//CADASTRANDO PRODUTO
		public static Produto cadastrarProduto(String nome, int qtde) 
				throws  Exception{
			DAO.begin();	
			Produto produto = daoProduto.localizarPeloNome(nome);
			if(produto != null){
				throw new Exception("Produto ja cadastrado:" + nome);
			}

			produto = new Produto(nome,qtde);
			daoProduto.persistir(produto);
			DAO.commit();

			return produto;
		}
		
		//SERVICO
		//CADASTRANDO SERVICO
		public static Servico cadastrarServico(String descricao, double valor) 
						throws  Exception{
			DAO.begin();
			Servico servico = daoServico.localizarPeloNome(descricao);
			if(servico != null){
				throw new Exception("Servico ja cadastrado:" + descricao);
			}
			
			servico = new Servico(descricao,valor);
			daoServico.persistir(servico);
			DAO.commit();
			
			return servico;
		}
				
		//CADASTRANDO PRODUTO AO SERVICO
		public static void addProdutoServico(String servico, String produto)  throws Exception {
			DAO.begin();
			
			Servico s = daoServico.localizarPeloNome(servico);
			if(s == null){
				throw new Exception("Servico não cadastrado:" + servico);
			}
			
			Produto p = daoProduto.localizarPeloNome(produto);
			if(p == null){
				throw new Exception("Produto não cadastrado:" + produto);
			}
			
			

			s.addProduto(p);
			p.addServico(s);
			daoServico.atualizar(s);
			daoProduto.atualizar(p);
			DAO.commit();
		}
		
		//PAGAMENTO
		//CADASTRANDO PAGAMENTO
		public static void addPagamento(String cliente, String servico, String funcionario) throws Exception{
			DAO.begin();
			
			Cliente c = daoCliente.localizarPeloNome(cliente);
			if(c == null){
				throw new Exception("Cliente não cadastrado:" + cliente);
			}
			
			Servico s = daoServico.localizarPeloNome(servico);
			if(s == null){
				throw new Exception("Servico não cadastrado:" + servico);
			}
			
			Funcionario f = daoFuncionario.localizarPeloNome(funcionario);
			if(f == null){
				throw new Exception("Funcionário não cadastrado:" + funcionario);
			}
			
			Pagamento pag = new Pagamento();
			pag.addCliente(c);
			c.addPagamento(pag);
			pag.addServico(s);
			s.addPagamento(pag);
			pag.addFuncionario(f);
			f.addPagamento(pag);
			daoPagamento.atualizar(pag);
			DAO.commit();			
		}
			
		//LISTAR CLIENTES
		public static String listarCliente() {
			List<Cliente> aux = daoCliente.listar();
			
			String texto = "Listagem de clientes: \n";
			
			if (aux.isEmpty())
				texto += "Não existe clientes cadastrado";
			else {	
				for(Cliente c: aux) {
					texto += "\n" + c; 
				}
			}
			return texto;	
		}
		
		//LISTAR FUNCIONARIOS
		public static String listarFuncionario() {
			List<Funcionario> aux = daoFuncionario.listar();
			
			String texto = "\nListagem de Funcionarios: \n";

			if (aux.isEmpty())
				texto += "Não exite funcionarios cadastrados";
			else {	
				for(Funcionario f: aux) {
					texto += "\n" + f; 
				}
			}
			return texto;
		}
		
		//LISTAR SERVICOS
		public static String listarServicos() {
			List<Servico> aux = daoServico.listar();

			String texto = "\nListagem de Servicos: \n";

			if (aux.isEmpty())
				texto += "Não possui servicos cadastrados";
			else {	
				for(Servico s: aux) {
					texto += "\n" + s; 
				}
			}
			return texto;
		}
		
		//LISTAR PRODUTOS
		public static String listarProdutos() {
			List<Produto> aux = daoProduto.listar();

			String texto = "\nListagem de Produtos: \n";

			if (aux.isEmpty())
				texto += "Não possui produtos cadastrados";
			else {	
				for(Produto p: aux) {
					texto += "\n" + p; 
				}
			}
			return texto;
		}
		
		public static void removerProduto(String nome) 	throws  Exception{
			DAO.begin();
			
			Produto prod = daoProduto.localizarPeloNome(nome);
			if(prod == null){ 
				throw new Exception("Produto nao cadastrado:" + nome);
			}

			daoProduto.apagar(prod);
			DAO.commit();
		}

		public static void removerCliente(String nome) 	throws  Exception{
			DAO.begin();
			Cliente cli = daoCliente.localizarPeloNome(nome);
			if(cli == null){ 
				throw new Exception("Cliente nao cadastrado: " + nome);
			}
			
			daoCliente.apagar(cli);
			DAO.commit();
		}
		
		public static void removerFuncionario(String nome) throws Exception{
			DAO.begin();
			
			Funcionario func = daoFuncionario.localizarPeloNome(nome);
			if(func == null){
				throw new Exception("Funcionário nao cadastrado: " + nome);
			}
			
			daoFuncionario.apagar(func);
			DAO.commit();
		}
}