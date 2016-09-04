package daojpa;

import java.util.List;

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
			List<Funcionario> funcionarios = q.getResultList();
			
			if (funcionarios.isEmpty()) {
				return null;
			}
			
			return funcionarios.get(0);

		}catch(NoResultException e){			
			return null;
		}
	}
	
	
}
