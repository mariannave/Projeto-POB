package daodb4o;


import java.util.List;

import com.db4o.query.Query;

import modelo.Servico;

public class DAOServico extends DAO<Servico>{
	public DAOServico(){
		super();
	}
	
	@Override
	public Servico localizar (Object chave){
		try{
			int id =  (Integer) chave;
			Query q = manager.query();
			q.constrain(Servico.class);
			q.descend("id").constrain(id);
			List<Servico> resultados = q.execute();
			if (resultados.size()>0){
				return resultados.get(0);
			}else{
				return null;
			}
		}
		catch(ClassCastException e){
			throw new RuntimeException("campo de busca invalido");
		}
	}
	
	public Servico localizarPeloNome (String descricao){
		try{
			Query q = manager.query();
			q.constrain(Servico.class);
			q.descend("descricao").constrain(descricao);
			List<Servico> resultados = q.execute();
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
