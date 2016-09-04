package daodb4o;

import java.util.List;

import com.db4o.query.Query;

import modelo.Cliente;
import modelo.Funcionario;
import modelo.Pagamento;


public class DAOPagamento extends DAO<Pagamento>{
	public DAOPagamento(){
		super();
	}
	
	@Override
	public Pagamento localizar (Object chave){
		try{
			int id =  (Integer) chave;
			Query q = manager.query();
			q.constrain(Pagamento.class);
			q.descend("id").constrain(id);
			List<Pagamento> resultados = q.execute();
			if (resultados.size()>0)
				return resultados.get(0);
			else
				return null;
		}
		catch(ClassCastException e){
			throw new RuntimeException("campo de busca invalido");
		}
	}
	
	public List<Pagamento> localizarPorCliente(String nome){
		try{
			Query q = manager.query();
			q.constrain(Cliente.class);
			q.descend("nome").constrain(nome);
			List<Cliente> resultados = q.execute();
			Cliente c = null;
			if (resultados.size()>0){
				c = resultados.get(0);
			}
			
			Query p = manager.query();
			p.constrain(Pagamento.class);
			p.descend("cliente").constrain(c);
			List<Pagamento> resultadosPagamentos = p.execute();
			
			if (resultadosPagamentos.size()>0){
				return resultadosPagamentos;
			}else{
				return null;
			}

		}catch(ClassCastException e){
			throw new RuntimeException("campo de busca invalido");
		}
	}
	
	public List<Pagamento> localizarPorFuncionario(String nome){
		try{
			Query q = manager.query();
			q.constrain(Funcionario.class);
			q.descend("nome").constrain(nome);
			List<Funcionario> resultados = q.execute();
			Funcionario f = null;
			if (resultados.size()>0){
				f = resultados.get(0);
			}
			
			Query p = manager.query();
			p.constrain(Pagamento.class);
			p.descend("funcionario").constrain(f);
			List<Pagamento> resultadosPagamentos = p.execute();
			
			if (resultadosPagamentos.size()>0){
				return resultadosPagamentos;
			}else{
				return null;
			}

		}catch(ClassCastException e){
			throw new RuntimeException("campo de busca invalido");
		}
	}
	
//	public List<Pagamento> localizarPorServico(String descricao){
//		try{
//			Query q = manager.query();
//			q.constrain(Servico.class);
//			q.descend("descricao").constrain(descricao);
//			List<Servico> resultados = q.execute();
//			Servico s = null;
//			if (resultados.size()>0){
//				s = resultados.get(0);
//			}
//			
//			Query p = manager.query();
//			p.constrain(Pagamento.class);
//			p.descend("servico").constrain(s);
//			List<Pagamento> resultadosPagamentos = p.execute();
//			
//			if (resultadosPagamentos.size()>0){
//				return resultadosPagamentos;
//			}else{
//				return null;
//			}
//
//		}catch(ClassCastException e){
//			throw new RuntimeException("campo de busca invalido");
//		}
//	}
}
