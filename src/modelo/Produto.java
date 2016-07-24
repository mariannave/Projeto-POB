package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	private String nome;
	private int qtde;
	
	@ManyToMany(mappedBy="produtos", cascade=CascadeType.ALL)
	private List<Servico> servicos = new ArrayList<Servico>(); 
	
	public Produto(){}
	
	public Produto(String nome, int qtde){
		this.nome = nome;
		this.qtde = qtde;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setQtde(int qtde){
		this.qtde = qtde;
	}
	
	public int getQtde(){
		return qtde;
	}
	
	//Servico
	public List<Servico> getServicos(){
		return servicos;
	}
	
	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}
	
	public void addServico(Servico servico) {
		servicos.add(servico);
	}

	@Override
	public String toString() {
		return "Id = " + id + " --- Nome = " + nome + " --- Quantidade =" + qtde;
	}
	
}
