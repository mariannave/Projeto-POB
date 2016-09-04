package daodb4o;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.constraints.UniqueFieldValueConstraintViolationException;
import com.sun.org.apache.xml.internal.security.signature.ObjectContainer;

import modelo.Cliente;
import modelo.Funcionario;
import modelo.Pagamento;
import modelo.Produto;
import modelo.Servico;


public abstract class DAO<T> implements DAOInterface<T> {
	protected static ObjectContainer manager;

	public static void abrir(){
		if(manager==null){			
			
//			Backup.criar("banco.db4o");	//opcional
//			System.out.println("backup realizado com sucesso !");
//			new File("banco.db4o").delete();   // apagar o arquivo do banco
	
			
			/******************************************
			 * 
			 *  CONFIGURACAO PARA USO LOCAL
			 *  
			 ******************************************/
			EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
			config.common().messageLevel(0);   //0,1,2,3,4
			config.common().objectClass(Produto.class).cascadeOnUpdate(true);
			config.common().objectClass(Produto.class).cascadeOnDelete(true);
			config.common().objectClass(Produto.class).cascadeOnActivate(true);
			config.common().objectClass(Servico.class).cascadeOnUpdate(true);
			config.common().objectClass(Servico.class).cascadeOnDelete(true);
			config.common().objectClass(Servico.class).cascadeOnActivate(true);
			config.common().objectClass(Cliente.class).cascadeOnUpdate(true);
			config.common().objectClass(Cliente.class).cascadeOnDelete(true);
			config.common().objectClass(Cliente.class).cascadeOnActivate(true);
			config.common().objectClass(Funcionario.class).cascadeOnUpdate(true);
			config.common().objectClass(Funcionario.class).cascadeOnDelete(true);
			config.common().objectClass(Funcionario.class).cascadeOnActivate(true);
			config.common().objectClass(Pagamento.class).cascadeOnUpdate(true);
			config.common().objectClass(Pagamento.class).cascadeOnDelete(true);
			config.common().objectClass(Pagamento.class).cascadeOnActivate(true);
			
 			//indexacao de atributos para agilizar a busca
			config.common().objectClass(Produto.class).objectField("id").indexed(true);
			config.common().objectClass(Servico.class).objectField("id").indexed(true);
			config.common().objectClass(Cliente.class).objectField("id").indexed(true);
			config.common().objectClass(Funcionario.class).objectField("id").indexed(true);
			config.common().objectClass(Pagamento.class).objectField("id").indexed(true);

			manager = Db4oEmbedded.openFile(config,"banco.db4o");
			
		
			//--------------Inicializar o gerente de id-----------------
			//Apos a criação do banco
			AutoGenerateIDManager.inicializar(manager);
			//----------------------------------------------------------
		}
	}

	public static void fechar(){
		if(manager!=null) {
			manager.close();
			manager=null;
		}
	}

	@Override
	public void persistir(T obj){
		manager.store( obj );
	}
	
	@Override
	public T localizar(Object chave){
		return null;
	};  //implementado nos dao especificos
	
	@Override
	public T atualizar(T obj){
		manager.store(obj);
		return obj;
	}
	@Override
	public void apagar(T obj) {
		manager.delete(obj);
	}
	@Override
	public void reler(T obj){
		manager.ext().refresh(obj, Integer.MAX_VALUE);
	}
	
	//--------transação---------------
	public static void begin(){	}		// tem que ser vazio!
	
	public static void commit(){
		try {
			manager.commit();
		} 
		// Evitar de gravar objetos duplicados
		catch (UniqueFieldValueConstraintViolationException e) {
			throw new RuntimeException ("atributo duplicado  " + e.getMessage());
		}
	}
	public static void flush(){	//commit intermediario
		commit();
	}
	public static void rollback(){
		manager.rollback();
	}
	@SuppressWarnings("unchecked")
	public List<T> listar(){
		Class<T> type = (Class<T>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
		return (List<T>) manager.query(type);
	}

	
}

