package ui;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import DAO.IDependenteDAO;
import DAO.IFuncionarioDAO;
import HibernatePostgres.DependenteH;
import HibernatePostgres.FuncionarioHP;
import JDBC.ConectionFactory;
import JDBC.FuncionarioJDBC;
import model.Dependente;
import model.Funcionario;

public class principal {

	public static void main(String[] args) {
		/*
		IFuncionarioDAO func =  new FuncionarioJDBC();
		Funcionario fun = new Funcionario(93,123,"ThaisGalvão","Thais@gmail.com","123");
		Dependente d = new Dependente("Mel",123);
		d.setFuncionario(fun);
		List<Dependente> dep =  new ArrayList<Dependente>();
		dep.add(d);
		fun.setDependente(dep);
		func.save(fun);
		
		*/

		/*
		IDependenteDAO d = new DependenteH();
		List<Dependente> l = d.getDependenteByNameCriteria("A");
		for(Dependente de : l){
			System.out.println("Dependente: " + de.getNome());
			System.out.println("Funcionario: " + de.getFuncionario().getNome());
			
		}
	
		
		IFuncionarioDAO f  = new FuncionarioHP();
		List<Funcionario> fu = f.getAllFuncionarioNativa();
		for(Funcionario  fe : fu){
			System.out.println("Nome: "+fe.getNome());
			System.out.println("CPF: "+fe.getCpf());
			System.out.println("Email: "+fe.getEmail());
		}
		
		*/
		
		
		IFuncionarioDAO func =  new FuncionarioHP();
		IDependenteDAO dep = new DependenteH();
		Funcionario fun = new Funcionario(93,123,"Julio","JUJU@gmail.com","123");
		Funcionario josafa = new Funcionario(93,123,"Josafa","JUJU@gmail.com","123");
	
		Dependente d = new Dependente("Mel1",123);
		Dependente d1 = new Dependente("Mel1",123);
		Dependente d2 = new Dependente("Mel1",123);
		
		List<Dependente> deps =  new ArrayList<Dependente>();
		
		
		//Adicionado Dependente sem Funcionario - erro
		d2.setFuncionario(fun);
		dep.save(d2);
		
		
		//adicionando funcionario
		func.save(josafa);
		
		//Adicionar Funcionarios com seus dependentes
		d.setFuncionario(josafa);
		deps.add(d);
		d1.setFuncionario(josafa);
		deps.add(d1);
		d2.setFuncionario(josafa);
		deps.add(d2);
		josafa.setDependente(deps);
		func.save(josafa);
		
		
		
		
		
		
		
		
	}

}
