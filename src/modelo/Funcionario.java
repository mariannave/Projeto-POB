package modelo;

import javax.persistence.*;

@Entity
public class Funcionario extends Pessoa{
	
	private String funcao;
	
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

	@Override
	public String toString() {
		return super.toString() + " ---- Funcao = "+ funcao;
	}
}
