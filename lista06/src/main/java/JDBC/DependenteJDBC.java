package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import DAO.IDependenteDAO;
import model.Dependente;

public class DependenteJDBC implements IDependenteDAO{

	private Connection con;
	public DependenteJDBC() {
		con = new ConectionFactory().getConnection();
	}
	public void save(Dependente d) {
		String sql = "INSERT INTO Dependente(nome,cpf,funcionario_id) values(?,?,?)";
		PreparedStatement stm;
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, d.getNome());
			stm.setInt(2, d.getCpf());
			stm.setLong(3, d.getFuncionario().getId());
			
			stm.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}
	public Integer getIDFuncionario(int cpf) {
		String sql = "select id from funcionario where cpf = ?";
		PreparedStatement pre;
		int id = 0;
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, cpf);
			ResultSet set = pre.executeQuery();
			
			while(set.next()){
				id = set.getInt("id");
			}
			pre.close();
			con.close();
			return id;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	public List<Dependente> getDependenteByNameCriteria(String name) {
	
		return null;
	}
	public List<Dependente> getDependenteByNameJPQL(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Dependente> getDependenteByNameNamed(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Dependente> getDependenteByNameNativa(String name) {
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
