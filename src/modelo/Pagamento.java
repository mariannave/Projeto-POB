package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Pagamento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Cliente cliente;
	
	@ManyToOne
	private Funcionario funcionario;
	
	@ManyToMany
	private List<Servico> servicos = new ArrayList<Servico>();
	
	
	public Pagamento(){}
	
	public int getId(){
		return id;
	}
	
	public void addServico(Servico servico) {
		servicos.add(servico);
	}
	
	public void addCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void addFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public List<Servico> getServicos() {
		return this.servicos;
	}
	
	@Override
	public String toString() {
		return "Id = " + id + " \n ---  \nCliente = " + cliente + " \n--- \n Funcionario = " + funcionario ;
	}

}