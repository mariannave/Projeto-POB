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
	
	@ManyToMany(mappedBy="pagamentos", cascade=CascadeType.ALL)
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
		String saida = "";
		if (servicos.isEmpty()) {
			saida += "Nenhum servi�o\n";
		} else {
			for (Servico s : servicos) {
				saida += s.getDescricao() + "\n";
			}
		}
		return "Cliente\n"+cliente+"\n[Servicos]: \n" + saida + "\nFuncionario\n" + funcionario;
	}

}