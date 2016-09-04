package daodb4o;


import java.util.List;
import com.db4o.query.Query;
import modelo.Produto;
public class DAOProduto  extends DAO<Produto>{
	public DAOProduto(){
		super();
	}

	@Override
	public Produto localizar (Object chave){
		try{
			int id =  (Integer) chave;
			Query q = manager.query();
			q.constrain(Produto.class);
			q.descend("id").constrain(id);
			List<Produto> resultados = q.execute();
			if (resultados.size()>0)
				return resultados.get(0);
			else
				return null;
		}
		catch(ClassCastException e){
			throw new RuntimeException("campo de busca invalido");
		}
	}

	public Produto localizarPeloNome (String nome){
		try{
			Query q = manager.query();
			q.constrain(Produto.class);
			q.descend("nome").constrain(nome);
			List<Produto> resultados = q.execute();
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

	public int consultarTotalProdutos() {
		Query q = manager.query();
		q.constrain(Produto.class);
		int total = q.execute().size(); 
		return total;
	}


}
