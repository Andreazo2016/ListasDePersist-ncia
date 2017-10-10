package HibernatePostgres;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.ExcludeSuperclassListeners;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import DAO.IFuncionarioDAO;
import Util.JPAUtil;
import model.Funcionario;


public class FuncionarioHP implements IFuncionarioDAO {
	
	public void save(Funcionario f) {
		EntityManager entity = JPAUtil.getEntityManagerByBDName("dev");
		EntityTransaction entityTransation = entity.getTransaction();
		try{
			entityTransation.begin();
			entity.persist(f);
			entityTransation.commit();
			System.out.println("Adicionado com sucesso!!");
		}catch(Exception e){
			entityTransation.rollback();
			e.printStackTrace();
			
		}finally {
			JPAUtil.CloseEntity();
			
		}
		
	}

	public List<Funcionario> getAllFuncionarioNamedQuery() {
		EntityManager em =  JPAUtil.getEntityManagerByBDName("dev");
		List<Funcionario> f = em.createNamedQuery("Funcionario.find",Funcionario.class).getResultList();
		JPAUtil.CloseEntity();
		return f;
	}

	public List<Funcionario> getAllFuncionarioJPQL() {
		EntityManager em =  JPAUtil.getEntityManagerByBDName("dev");
		List<Funcionario> f = em.createQuery("from Funcionario",Funcionario.class).getResultList();
		JPAUtil.CloseEntity();
		return f;
	}

	public List<Funcionario> getAllFuncionarioCriteria() {
		EntityManager em =  JPAUtil.getEntityManagerByBDName("dev");
		CriteriaBuilder cb  = em.getCriteriaBuilder();
		CriteriaQuery<Funcionario> cf = cb.createQuery(Funcionario.class);
		cf.from(Funcionario.class);
		List<Funcionario> f = em.createQuery(cf).getResultList();
		JPAUtil.CloseEntity();
		// TODO Auto-generated method stub
		return f;
	}

	public List<Funcionario> getAllFuncionarioNativa() {
		EntityManager em =  JPAUtil.getEntityManagerByBDName("dev");
		String sql = "select * from Funcionario";
		Query query = em.createNativeQuery(sql, Funcionario.class);
		List<Funcionario> f = query.getResultList();
		JPAUtil.CloseEntity();
		
		return f;
	}

	public void BeginTransaction() {
		JPAUtil.BeginTransaction();
		
	}

	public void Commit() {
		JPAUtil.commit();
		
	}

	public void rollback() {
		JPAUtil.rollback();
		
	}
	
}
