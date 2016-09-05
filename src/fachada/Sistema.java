package fachada;

import java.util.List;

//import daojpa.*;
import daodb4o.DAO;
import daodb4o.DAOCliente;
import daodb4o.DAOFuncionario;
import daodb4o.DAOPagamento;
import daodb4o.DAOProduto;
import daodb4o.DAOServico;
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
				throw new Exception("Servico n�o cadastrado:" + servico);
			}
			
			Produto p = daoProduto.localizarPeloNome(produto);
			if(p == null){
				throw new Exception("Produto n�o cadastrado:" + produto);
			}
			
			

			s.addProduto(p);
			p.addServico(s);
			daoServico.atualizar(s);
			daoProduto.atualizar(p);
			DAO.commit();
		}
		
		//PAGAMENTO
		//CADASTRANDO PAGAMENTO
		public static Pagamento addPagamento(String cliente, String servico, String funcionario) throws Exception{
			DAO.begin();
			
			Cliente c = daoCliente.localizarPeloNome(cliente);
			if(c == null){
				throw new Exception("Cliente n�o cadastrado:" + cliente);
			}
			
			Servico s = daoServico.localizarPeloNome(servico);
			if(s == null){
				throw new Exception("Servico n�o cadastrado:" + servico);
			}
			
			Funcionario f = daoFuncionario.localizarPeloNome(funcionario);
			if(f == null){
				throw new Exception("Funcion�rio n�o cadastrado:" + funcionario);
			}
			
			Pagamento pag = new Pagamento();
			pag.addCliente(c);
			pag.addServico(s);
			pag.addFuncionario(f);
			daoPagamento.atualizar(pag);
			DAO.commit();
			
			return pag;
		}
			
		//LISTAR CLIENTES
		public static String listarClientes() {
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
				texto += "N�o exite funcionarios cadastrados";
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
				texto += "N�o possui servicos cadastrados";
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
				texto += "N�o possui produtos cadastrados";
			else {	
				for(Produto p: aux) {
					texto += "\n" + p; 
				}
			}
			return texto;
		}
		
		//LISTAR PAGAMENTOS
		public static String listarPagamentos(){
			List<Pagamento> aux = daoPagamento.listar();

			String texto = "\nListagem de Pagamentos: \n";

			if (aux.isEmpty())
				texto += "N�o existe pagamentos cadastrados";
			else {	
				for(Pagamento p: aux) {
					texto += "\n" + p; 
				}
			}
			return texto;
		}
		
		public static String listarPagCliente(String nome){
			List<Pagamento> aux = daoPagamento.localizarPorCliente(nome);
			String texto = "Pagamentos de cliente: "+ nome +"\n" ;
			
			if (aux.isEmpty()){
				texto += "N�o existem pagamentos para esse cliente";
			}else {	
				for(Pagamento p: aux) {
					texto += "\n" + p +"\n"; 
				}
			}
			return texto;			
		}
		
		public static String listarPagFuncionario(String nome){
			List<Pagamento> aux = daoPagamento.localizarPorFuncionario(nome);
			String texto = "Pagamentos do funcionario: "+ nome +"\n" ;
			
			if (aux.isEmpty()){
				texto += "N�o existe pagamentos para esse funcionario";
			}else {	
				for(Pagamento p: aux) {
					texto += "\n" + p; 
				}
			}
			return texto;			
		}
		
		
//		REMOÇÃO DE PRODUTO
		
		public static void removerProduto(String nome) 	throws  Exception{
			DAO.begin();
			
			Produto prod = daoProduto.localizarPeloNome(nome);
			if(prod == null){ 
				throw new Exception("Produto nao cadastrado:" + nome);
			}
			daoProduto.apagar(prod);
			
			DAO.commit();
		}

//		REMOÇÃO SERVICO
		public static void removerServico(String nome) throws Exception{
			DAO.begin();
			Servico serv = daoServico.localizarPeloNome(nome);
			if(serv == null){
				throw new Exception("Servico nao cadastrado:" + nome);
			}
			
			daoServico.apagar(serv);
			DAO.commit();			
		}
		
//		REMOÇÃO DE CLIENTE
		public static void removerCliente(String nome) 	throws  Exception{
			DAO.begin();
			Cliente cli = daoCliente.localizarPeloNome(nome);
			if(cli == null){ 
				throw new Exception("Cliente nao cadastrado: " + nome);
			}
			
			daoCliente.apagar(cli);
			DAO.commit();
		}
		
//		REMOÇÃO DE FUNCIONÁRIO
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