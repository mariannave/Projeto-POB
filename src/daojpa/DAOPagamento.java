package daojpa;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Cliente;
import modelo.Funcionario;
import modelo.Pagamento;
import modelo.Servico;

public class DAOPagamento extends DAO<Pagamento>{
	public DAOPagamento(){
		super();
	}
	
	public List<Pagamento> localizarPorCliente(String nome){
		try{
			Query q = manager.createQuery("select c from Cliente c where c.nome= '" + nome +"'");
			List<Cliente> clientes = q.getResultList();
			
			 if (clientes.isEmpty()) {
		            return null;
		        }
		 
			Cliente cliente = clientes.get(0);
			
			Query p = manager.createQuery("Select p from Pagamento p where p.cliente.id= "+ cliente.getId());
			List<Pagamento> pagamentos = p.getResultList();
			
			if(pagamentos.size() > 0){
				return pagamentos;
			}else{
				return null;
			}
			
		}catch(NoResultException e){			
			return null;
		}
	}
	
	public List<Pagamento> localizarPorFuncionario(String nome){
	    try{
	        Query q = manager.createQuery("select f from Funcionario f where f.nome= '"+nome+"'");
	        List<Funcionario> funcionarios = q.getResultList();
	 
	        if (funcionarios.isEmpty()) {
	            return null;
	        }
	 
	        Funcionario funcionario = funcionarios.get(0);
	       
	       
	        Query p = manager.createQuery("Select p from Pagamento p where p.funcionario.id= "+ funcionario.getId());
	        List<Pagamento> pagamentos = p.getResultList();
	       
	        if(pagamentos.size() > 0){
	            return pagamentos;
	        }else{
	            return null;
	        }      
	       
	    }catch(NoResultException e){          
	        return null;
	    }
	}

	public List<Pagamento> localizarPorServico(String descricao) {
		if (descricao.length() == 0) {
			return null;
		}
		
		Query q = manager.createQuery("SELECT p FROM Pagamento p JOIN p.servicos s WHERE s.descricao LIKE '"+ descricao+"'");
		List<Pagamento> pagamentos = q.getResultList();
		
		if (pagamentos.isEmpty()) {
			return null;
		}
		
		return pagamentos;
	}
	
	
}
