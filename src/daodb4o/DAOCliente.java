package daodb4o;


import java.util.List;

import com.*;


import modelo.Cliente;


public class DAOCliente extends DAO<Cliente>{
	public DAOCliente(){
		super();
	}
	
	@Override
	public Cliente localizar (Object chave){
		try{
			int id =  (Integer) chave;
			Query q = manager.query();
			q.constrain(Cliente.class);
			q.descend("id").constrain(id);
			List<Cliente> resultados = q.execute();
			if (resultados.size()>0)
				return resultados.get(0);
			else
				return null;
		}
		catch(ClassCastException e){
			throw new RuntimeException("campo de busca invalido");
		}
	}
	
	
	public Cliente localizarPeloNome (String nome){
		try{
			Query q = manager.query();
			q.constrain(Cliente.class);
			q.descend("nome").constrain(nome);
			List<Cliente> resultados = q.execute();
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
