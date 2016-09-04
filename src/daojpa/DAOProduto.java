/**IFPB - Curso SI - Disciplina de POB
 * @author Prof Fausto Ayres
 */
package daojpa;


import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Produto;

public class DAOProduto  extends DAO<Produto>{
	public DAOProduto(){
		super();
	}

	public Produto localizarPeloNome (String n){
		try{
			Query q = manager.createQuery("select p from Produto p where p.nome= '" + n +"'");
			return (Produto) q.getSingleResult();

		}catch(NoResultException e){			
			return null;
		}
	}



	public long consultarTotalProdutos() {
		Query q = manager.createQuery(
				"select count(p) from Produto p");
		return (Long) q.getSingleResult();
	}

}
