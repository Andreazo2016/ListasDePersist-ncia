package HibernatePostgres;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Parameter;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import DAO.IDependenteDAO;
import Util.JPAUtil;
import model.Dependente;
import model.Funcionario;

public class DependenteH implements IDependenteDAO {

	public void save(Dependente d) {
		EntityManager entity = JPAUtil.getEntityManagerByBDName("dev");
		EntityTransaction entityTransation = entity.getTransaction();
		try{
			entityTransation.begin();
			entity.persist(d);
			entityTransation.commit();
			System.out.println("Adicionado com sucesso!!");
		}catch(Exception e){
			entityTransation.rollback();
			e.printStackTrace();
			
		}finally {
			JPAUtil.CloseEntity();
			
		}
		
	}

	public Integer getIDFuncionario(int cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	

	public List<Dependente> getDependenteByNameCriteria(String name) {
		EntityManager em =  JPAUtil.getEntityManagerByBDName("dev");
		CriteriaBuilder cb  = em.getCriteriaBuilder();
		CriteriaQuery<Dependente> cf = cb.createQuery(Dependente.class);
		Root<Dependente> r = cf.from(Dependente.class);
		Predicate predicate =  cb.and();
		predicate = cb.and(predicate,cb.like(r.<String>get("nome"), name+"%"));	
		TypedQuery<Dependente> tp = em.createQuery(cf.select(r).where(predicate));
		List<Dependente> dep = tp.getResultList();
		JPAUtil.CloseEntity();
		return dep ;
	}

	public List<Dependente> getDependenteByNameJPQL(String name) {
		EntityManager em  =  JPAUtil.getEntityManagerByBDName("dev");
		List<Dependente> l = em.createQuery("from Dependente where nome like :nome",Dependente.class)
				.setParameter("nome", name + "%")
				.getResultList();
		JPAUtil.CloseEntity();
		return l;
	}

	public List<Dependente> getDependenteByNameNamed(String name) {
		EntityManager em  =  JPAUtil.getEntityManagerByBDName("dev");
		List<Dependente> l = em.createQuery("from Dependente where nome like :nome",Dependente.class)
				.setParameter("nome", name + "%")
				.getResultList();
		JPAUtil.CloseEntity();
		return l;
		
		
	}

	public List<Dependente> getDependenteByNameNativa(String name) {
		EntityManager em =  JPAUtil.getEntityManagerByBDName("dev");
		String sql = "select * from Dependente where nome like ?";
		Query query = em.createNativeQuery(sql, Dependente.class);
		query.setParameter(1, name+"%");
		List<Dependente> f = query.getResultList();
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
