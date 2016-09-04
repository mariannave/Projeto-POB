package daojpa;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Servico;

public class DAOServico extends DAO<Servico>{
	public DAOServico(){
		super();
	}
	
	public Servico localizarPeloNome (String n){
		try{
			Query q = manager.createQuery("select s from Servico s where s.descricao= '" + n +"'");
			return (Servico) q.getSingleResult();

		}catch(NoResultException e){			
			return null;
		}
	}
}
