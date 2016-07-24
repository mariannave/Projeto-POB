package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Servico {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String descricao;
	private double valor;
	
	@ManyToMany
	private List<Produto> produtos = new ArrayList<Produto>();
	
	
	public Servico(){ }
	
	public Servico(String descricao, double valor){
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public int getId(){
		return id;
	}
	
	public String getDescricao(){
		return descricao;
	}
	public void setDescricao(String descricao){
		this.descricao = descricao;
	}
	
	public double getValor(){
		return valor;
	}
	
	public void setValor(Double valor){
		this.valor = valor;
	}
	
	// Produto
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	

	@Override
	public String toString() {
		return "Id = " + id + " --- Descricao = " + descricao + " --- Valor = " + valor + " --- Produtos = " + produtos;
	}
	
	
}
