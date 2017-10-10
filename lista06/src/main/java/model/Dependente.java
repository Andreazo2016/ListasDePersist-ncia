package model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.NamedQuery;
@NamedQuery(name = "Dependente.findAll",query = "from Dependente where nome like :name")
@Entity
public class Dependente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int cpf;
	private String nome;
	@ManyToOne
	private Funcionario funcionario;
	
	public Dependente(String nome,int cpf) {
		this.cpf = cpf;
		this.nome = nome;
	}
	public Dependente() {
		// TODO Auto-generated constructor stub
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	

}
