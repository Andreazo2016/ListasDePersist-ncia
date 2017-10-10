package DAO;

import java.util.List;

import model.Funcionario;

public interface IFuncionarioDAO {
	public void save(Funcionario f);
	public List<Funcionario> getAllFuncionarioNamedQuery();
	public List<Funcionario> getAllFuncionarioJPQL();
	public List<Funcionario> getAllFuncionarioCriteria();
	public List<Funcionario> getAllFuncionarioNativa();
	public void BeginTransaction();
	public void Commit();
	public void rollback();
	
	
	

}
