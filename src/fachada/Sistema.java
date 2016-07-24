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
	public static void inicializar(){
		EntityManagerFactory factory =	
				Persistence.createEntityManagerFactory("salao");
		manager = factory.createEntityManager();
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
		public static void addProdutoServico(int idServico, int idProduto)  throws Exception {
					
			Servico servico = manager.find(Servico.class, idServico);
			
			Produto produto = manager.find(Produto.class, idProduto);
					
			manager.getTransaction().begin();
			servico.addProduto(produto);
			//manager.merge(produto);
			manager.getTransaction().commit();	
		}
		
		//CADASTRANDO PAGAMENTO
		public static void addPagamento(int cliente, int servico, int funcionario){
			Cliente client = manager.find(Cliente.class, cliente);
			Servico servic = manager.find(Servico.class, servico);
			Funcionario func =  manager.find(Funcionario.class, funcionario);

			manager.getTransaction().begin();
			Pagamento pag = new Pagamento();
			pag.addCliente(client);
			pag.addServico(servic);
			pag.addFuncionario(func);
			manager.merge(pag);
			manager.getTransaction().commit();
			
		}
			
}
