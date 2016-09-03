package fachada;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.Cliente;
import modelo.Funcionario;
import modelo.Pagamento;
import modelo.Produto;
import modelo.Servico;

public class Sistema {
	
	private static EntityManager manager;

	// INICIALIZANDO O BANCO
	public static EntityManager inicializar(){
		EntityManagerFactory factory =	
				Persistence.createEntityManagerFactory("salao");
		manager = factory.createEntityManager();
		return manager;
	}	
	
	// ENCERRANDO O BANCO
	public static void finalizar(){
		manager.close();
	}
	
	// ---------- CLIENTE -----
	
	// CADASTRANDO CLIENTE
	public static Cliente cadastroCliente(String nome, String telefone, String endereco) 
			throws  Exception{
		
		Query query;
		query = manager.createQuery("select c from Cliente c where c.nome='" +nome+ "'");
		List<Cliente> lista = (List<Cliente>)query.getResultList();
		Cliente cliente;
		
		if (lista.isEmpty()){
			cliente = null;
		} else {
			cliente = lista.get(0);
		}
		
		if(cliente != null){
			throw new Exception("Cliente ja cadastrado:" + nome);
		}
		
		manager.getTransaction().begin();
		cliente = new Cliente(nome,telefone,endereco);
		manager.persist(cliente);
		manager.getTransaction().commit();

		return cliente;					
		
	}
	
	//	FUNCIONARIO
	// CADASTRANDO FUNCIONARIO
		public static Funcionario cadastroFuncionario(String nome, String funcao) 
				throws  Exception{
			
			Query query;
			query = manager.createQuery("select f from Funcionario f where f.nome='" +nome+ "'");
			List<Funcionario> lista = (List<Funcionario>)query.getResultList();
			Funcionario funcionario;
			
			if (lista.isEmpty()){
				funcionario = null;
			} else {
				funcionario = lista.get(0);
			}
			
			if(funcionario != null){
				throw new Exception("Funcionario ja cadastrado:" + nome);
			}
			
			manager.getTransaction().begin();
			funcionario = new Funcionario(nome,funcao);
			manager.persist(funcionario);
			manager.getTransaction().commit();

			return funcionario;					
			
		}
		
		//PRODUTO
		//CADASTRANDO PRODUTO
		public static Produto cadastrarProduto(String nome, int qtde) 
				throws  Exception{

		
			Query q = manager.createQuery("select p from Produto p where p.nome='" +nome+ "'");		
			List<Produto> lista = q.getResultList();
			Produto p;

			if (lista.isEmpty()){
				p = null;
			}else{
				p = lista.get(0);
			}
				


			if(p != null){
				throw new Exception("produto ja cadastrado:" + nome);
			}
			

			manager.getTransaction().begin();
			p = new Produto(nome,qtde);
			manager.persist(p);
			manager.getTransaction().commit();

			return p;
		}
		
		//SERVICO
		//CADASTRANDO SERVICO
		public static Servico cadastrarServico(String descricao, double valor) 
						throws  Exception{

				
			Query q = manager.createQuery("select s from Servico s where s.descricao='" +descricao+ "'");		
			List<Servico> lista = (List<Servico>)q.getResultList();
			Servico s;

			if (lista.isEmpty()){
			s = null;
			}else{
				s = lista.get(0);
			}
						


			if(s != null){
				throw new Exception("Servico ja cadastrado:" + descricao);
			}					

			manager.getTransaction().begin();
			s = new Servico(descricao,valor);
			manager.persist(s);
			manager.getTransaction().commit();
				return s;
		}
				
		//CADASTRANDO PRODUTO AO SERVICO
		public static void addProdutoServico(String servico, String produto)  throws Exception {
			Query s = manager.createQuery("select s FROM Servico s WHERE s.descricao = '"+servico+"'");
			List<Servico>listaServico = s.getResultList() ;
			Servico servic ;
			
			
			if(listaServico.isEmpty()){
				servic = null;
			}else{
				servic = listaServico.get(0);
			}
			
			System.out.println(servic);

			
			Query p = manager.createQuery("select p FROM Produto p WHERE p.nome = '"+produto+"'");
			List<Produto> listaProduto = p.getResultList();
			Produto produt;
			
			if(listaProduto.isEmpty()){
				produt = null;
			}else{
				produt = listaProduto.get(0);
			}
					
			System.out.println(produt);

			manager.getTransaction().begin();
			servic.addProduto(produt);
			manager.merge(produt);
			manager.getTransaction().commit();	
		}
		
		//CADASTRANDO PAGAMENTO
		public static void addPagamento(String cliente, String servico, String funcionario){
			Query c = manager.createQuery("select c FROM Cliente c WHERE c.nome = '"+cliente+"'");		
			List<Cliente> listaCliente = c.getResultList();
			Cliente client;
			
			if (listaCliente.isEmpty()){
				client = null;
			}else{
				client = listaCliente.get(0);
			}
			
			Query se = manager.createQuery("Select s FROM Servico s WHERE s.descricao= '"+servico+"'");
			List<Servico> listaServico = se.getResultList();
			Servico servic;
			
			if (listaServico.isEmpty()){
				servic = null;
			}else{
				servic = listaServico.get(0);
			}
			
			
			Query f = manager.createQuery("select f FROM Funcionario f WHERE f.nome = '"+funcionario+"'");		
			List<Funcionario> listaFuncionario = f.getResultList();
			Funcionario func;
			
			if (listaFuncionario.isEmpty()){
				func = null;
			}else{
				func = listaFuncionario.get(0);
			}


			manager.getTransaction().begin();
			
			Pagamento pag = new Pagamento();
			pag.addCliente(client);
			pag.addServico(servic);
			pag.addFuncionario(func);
			
			manager.merge(pag);
			manager.getTransaction().commit();
			
		}
			
		
		public static String listarCliente() {
			Query q = manager.createQuery("SELECT c FROM Cliente c");		
			List<Cliente> aux = (List<Cliente>)q.getResultList();

			String texto = "\nListagem de Clientes: \n";

			if (aux.isEmpty())
				texto += "Não possui clientes cadastrados";
			else {	
				for(Cliente c: aux) {
					texto += "\n" + c; 
				}
			}
			return texto;
		}
		
		public static String listarFuncionario() {
			Query q = manager.createQuery("SELECT f FROM Funcionario f");		
			List<Funcionario> aux = (List<Funcionario>)q.getResultList();

			String texto = "\nListagem de Funcionarios: \n";

			if (aux.isEmpty())
				texto += "Não possui funcionarios cadastrados";
			else {	
				for(Funcionario f: aux) {
					texto += "\n" + f; 
				}
			}
			return texto;
		}
		
		public static String listarServicos() {
			Query q = manager.createQuery("SELECT s FROM Servico s");		
			List<Servico> aux = (List<Servico>)q.getResultList();

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
		
		public static String listarProdutos() {
			Query q = manager.createQuery("SELECT p FROM Produto p");		
			List<Produto> aux = (List<Produto>)q.getResultList();

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
		
		public static void removerProduto(int id) 	throws  Exception{

			Produto prod = manager.find(Produto.class, id);
			if(prod == null){ 
				throw new Exception("Produto nao cadastrada:" + id);
			}
			manager.getTransaction().begin();
			manager.remove(prod);
			manager.getTransaction().commit();
		}

		public static void removerCliente(int id) 	throws  Exception{

			Cliente cli = manager.find(Cliente.class, id);
			if(cli == null){ 
				throw new Exception("Cliente nao cadastrado:" + id);
			}
			manager.getTransaction().begin();
			manager.remove(cli);
			manager.getTransaction().commit();
		}
		
		
}
