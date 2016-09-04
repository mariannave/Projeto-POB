package aplicacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fachada.Sistema;
import modelo.Funcionario;
import modelo.Pagamento;
import modelo.Servico;

public class Consulta {
	
	private static EntityManager manager;
	
	public static void main(String args[]) {
	
		manager = Sistema.inicializar();
		
		// Listando os servicos e seus valores
		Query query1 = manager.createQuery("SELECT s FROM Servico s");
		List<Servico> result = query1.getResultList();

		System.out.println("Serviços e Valores ");
		for (Servico s : result) {
			System.out.println("Servico = "+s.getDescricao()+" ---- Valor = "  + s.getValor());
		}
		
		//Listando os funcionários e suas funções
		Query query2 = manager.createQuery("SELECT f FROM Funcionario f");
		List<Funcionario> resultado = query2.getResultList();
		
		System.out.println("Funcionarios e Funções ");
		for (Funcionario f : resultado) {
			System.out.println("Funcionario = "+f.getNome()+" ---- Função = "  + f.getFuncao());
		}

		
		// Nome dos funcionarios que possuem algum pagamento
		Query query3 = manager.createQuery("SELECT f FROM Pagamento p JOIN p.funcionario f");
		List<Funcionario> f = query3.getResultList();
		
		System.out.println("Funcionarios que possuem pagamentos");
		for(Funcionario func : f){
			System.out.println(func.getNome());
		}
		
		// Todos os pagamentos que um funcionario de id = 5 participou
		Query query4 = manager.createQuery("SELECT pag FROM Funcionario f JOIN Pagamento pag WHERE f.id = 5");
		List<Pagamento> pagamentos = query4.getResultList();
		
		System.out.println("Pagamentos do funcionario de Id 5 : ");
		for(Pagamento pag : pagamentos){
			System.out.println(pag);
		}
		
		//Todos os servicos que usam o produto Esmalte
		Query query5 = manager.createQuery("SELECT s FROM Servico s JOIN Produto p WHERE p.id = 4");
		List<Servico> servicos = query5.getResultList();
		
		System.out.println("Servicos que utilizam o produto - Esmalte");
		for(Servico s: servicos){
			System.out.println(s.getDescricao());
		}

	}	
		
}
