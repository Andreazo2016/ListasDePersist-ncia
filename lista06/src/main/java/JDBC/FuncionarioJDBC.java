package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import DAO.IFuncionarioDAO;
import model.Dependente;
import model.Funcionario;

public class FuncionarioJDBC implements IFuncionarioDAO{
	
	private Connection con;
	public FuncionarioJDBC() {
		con = new ConectionFactory().getConnection();
	}
	public void save(Funcionario f)  {
		String sql = "insert into Funcionario (cpf, matricula, nome, email, telefone) values(?,?,?,?,?)";
		PreparedStatement pre;
		List<Dependente> listaDependente;
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, f.getCpf());
			pre.setInt(2, f.getMatricula());
			pre.setString(3, f.getNome());
			pre.setString(4, f.getEmail());
			pre.setString(5, f.getTelefone());
			listaDependente = f.getDependente();
			pre.executeUpdate();
			if(!listaDependente.isEmpty()){
				for(Dependente de:listaDependente){
					de.getFuncionario().setId(new DependenteJDBC().getIDFuncionario(f.getCpf()));
					new DependenteJDBC().save(de);
				}
			}
			System.out.println("Funcionario Adicionado com Sucesso!!!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	public List<Funcionario> getAllFuncionarioNamedQuery() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Funcionario> getAllFuncionarioJPQL() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Funcionario> getAllFuncionarioCriteria() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Funcionario> getAllFuncionarioNativa() {
		// TODO Auto-generated method stub
		return null;
	}
	public void BeginTransaction()  {
		try {
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void Commit() {
		try {
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void rollback() {
		if(con != null){
			try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	

}
