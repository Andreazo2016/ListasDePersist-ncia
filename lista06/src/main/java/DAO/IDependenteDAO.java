package DAO;

import java.util.List;

import model.Dependente;

public interface IDependenteDAO {
	public void save(Dependente d);
	public Integer getIDFuncionario(int cpf);
	public List<Dependente>getDependenteByNameCriteria(String name);
	public List<Dependente>getDependenteByNameJPQL(String name);
	public List<Dependente>getDependenteByNameNamed(String name);
	public List<Dependente>getDependenteByNameNativa(String name);
	public void BeginTransaction();
	public void Commit();
	public void rollback();
}
