package daojpa;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Funcionario;

public class DAOFuncionario extends DAO<Funcionario>{
	public DAOFuncionario(){
		super();
	}
	
	public Funcionario localizarPeloNome(String n){
		try{
			Query q = manager.createQuery("select f from Funcionario f where f.nome= '" + n +"'");
			return (Funcionario) q.getSingleResult();

		}catch(NoResultException e){			
			return null;
		}
	}
	
	
}
