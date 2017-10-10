package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
@NamedQuery(name = "Funcionario.find",query = " from Funcionario ")
@Entity
public class Funcionario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private int cpf;
	private int matricula;
	private String nome;
	private String email;
	private String telefone;
	@OneToMany(mappedBy = "funcionario",cascade = CascadeType.ALL)
	private List<Dependente> dependente;
	
	public Funcionario() {
		// TODO Auto-generated constructor stub
	}
	public Funcionario(int cpf,int matricula,String nome,String email,String telefone){
		this.cpf = cpf;
		this.matricula = matricula;
		this.nome = nome;
		this.telefone =telefone;
		this.email = email;
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
	public List<Dependente> getDependente() {
		return dependente;
	}
	public void setDependente(List<Dependente> dependente) {
		this.dependente = dependente;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	

}
