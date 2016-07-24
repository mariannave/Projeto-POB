package modelo;

import javax.persistence.Entity;


@Entity
public class Cliente extends Pessoa{
	private String telefone;
	private String endereco;
	
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
	
	@Override
	public String toString() {
		return super.toString() + " ---- Telefone = "+ telefone + " ---- Endereco = " + "endereco" ;
	}
}
