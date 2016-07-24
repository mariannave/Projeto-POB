package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Funcionario extends Pessoa{
	
	private String funcao;
	
	@OneToMany(mappedBy="funcionario", cascade=CascadeType.ALL)
	private List<Pagamento> pagamentos = new ArrayList<Pagamento>(); 
	
	public Funcionario() {
		super();
	}
	
	public Funcionario(String nome, String funcao){
		super(nome);
		this.funcao = funcao;
	}
	
	
	public void setFuncao(String funcao){
		this.funcao = funcao;
	}
	
	public String getFuncao(){
		return funcao;
	}
	
	public void addPagamento(Pagamento pag){
		pagamentos.add(pag);
	}

	
	@Override
	public String toString() {
		return super.toString() + " ---- Funcao = "+ funcao;
	}
}
