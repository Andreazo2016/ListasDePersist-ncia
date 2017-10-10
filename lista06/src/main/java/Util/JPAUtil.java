package Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAUtil {
	private static  EntityManagerFactory emf;
	private static ThreadLocal<EntityManager> ems = new ThreadLocal<EntityManager>();
	private static String name;
	
	public static EntityManager getEntityManagerByBDName(String dbName){
		name = dbName;
		EntityManager em = ems.get();
		if(em == null){
			emf = Persistence.createEntityManagerFactory(dbName);
			em = emf.createEntityManager();
			ems.set(em);
		}
		return em;
	}
	public static void CloseEntity(){
		EntityManager em = ems.get();
		if(em != null){
			EntityTransaction tns = em.getTransaction();
			if(tns.isActive()){
				tns.commit();
			}
			em.close();
			ems.set(null);
		}
	}
	public static void BeginTransaction(){
		EntityManager em  = ems.get();
		if(em != null){
			EntityTransaction t = em.getTransaction();
			t.begin();
		}
		em.close();
		ems.set(null);
	}
	public static void commit(){
		EntityManager em  = ems.get();
		if(em != null){
			EntityTransaction t = em.getTransaction();
			t.commit();
		}
		em.close();
		ems.set(null);
	}
	public static void rollback(){
		EntityManager em  = ems.get();
		if(em != null){
			EntityTransaction t = em.getTransaction();
			t.rollback();
		}
		em.close();
		ems.set(null);
	}
}
