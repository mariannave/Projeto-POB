package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
public class Cliente extends Pessoa{
	private String telefone;
	private String endereco;
	
	@OneToMany(mappedBy="cliente", cascade=CascadeType.ALL)
	private List<Pagamento> pagamentos = new ArrayList<Pagamento>(); 
	
	public Cliente(){
		super();
	}
	
	public Cliente(String nome, String telefone, String endereco){
		super(nome);
		this.telefone = telefone;
		this.endereco = endereco;
	}
	
	public void setTelefone(String telefone){
		this.telefone = telefone;
	}
	
	public String getTelefone(){
		return telefone;
	}
	
	public void setEndereco(String endereco){
		this.endereco = endereco;
	}
	
	public String getEndereco(){
		return endereco;
	}
	
	public void addPagamento(Pagamento pag){
		pagamentos.add(pag);
	}
	
	@Override
	public String toString() {
		return super.toString() + " ---- Telefone = "+ telefone + " ---- Endereco = " + endereco ;
	}
}
