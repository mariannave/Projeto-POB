package daodb4o;

import java.util.List;

import com.db4o.query.Query;

import modelo.Funcionario;

public class DAOFuncionario extends DAO<Funcionario>{
	public DAOFuncionario(){
		super();
	}
	
	@Override
	public Funcionario localizar (Object chave){
		try{
			int id =  (Integer) chave;
			Query q = manager.query();
			q.constrain(Funcionario.class);
			q.descend("id").constrain(id);
			List<Funcionario> resultados = q.execute();
			if (resultados.size()>0)
				return resultados.get(0);
			else
				return null;
		}
		catch(ClassCastException e){
			throw new RuntimeException("campo de busca invalido");
		}
	}
	
	public Funcionario localizarPeloNome (String nome){
		try{
			Query q = manager.query();
			q.constrain(Funcionario.class);
			q.descend("nome").constrain(nome);
			List<Funcionario> resultados = q.execute();
			if (resultados.size()>0)
				return resultados.get(0);
			else
				return null;
		}
		catch(ClassCastException e){
			throw new RuntimeException("campo de busca invalido");
		}
	}
}
