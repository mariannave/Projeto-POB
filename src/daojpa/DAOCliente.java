package daojpa;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Cliente;
import modelo.Produto;


public class DAOCliente extends DAO<Cliente>{
	public DAOCliente(){
		super();
	}
	
	public Cliente localizarPeloNome (String n){
		try{
			Query q = manager.createQuery("select c from Cliente c where c.nome= '" + n +"'");
			return (Cliente) q.getSingleResult();

		}catch(NoResultException e){			
			return null;
		}
	}
}
