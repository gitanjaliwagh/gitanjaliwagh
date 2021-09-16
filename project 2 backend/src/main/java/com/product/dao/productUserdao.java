package com.product.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.product.entity.productUser;
@Repository
public class productUserdao  implements productUserdaoInterface  {
	@Autowired
	private SessionFactory sf;
	
	@Autowired
	private EntityManagerFactory emf;

	
	@Transactional

	public int addproductListDAO(productUser pu) {
		int i=0;
		//Session s=sf.openSession();
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(pu);
		et.commit();
		//s.save(fu);
		i=1;
		return i;
	}

   
	@Override
	public int deleteproductListDAO(String pu) {
		EntityManager em=emf.createEntityManager();
		Query q=em.createQuery("delete from com.product.entity.productUser p where p.name=:pname");
		q.setParameter("pname", pu);
		
		EntityTransaction et=em.getTransaction();
		et.begin();
		int i=q.executeUpdate();
		et.commit();
		return i;
	}


	@Override
	public int editproductListDAO(String pu) {
		EntityManager em=emf.createEntityManager();
		Query q=em.createQuery("update from com.product.entity.productUser p set p.name=:pname");
		q.setParameter("pname", pu);
		EntityTransaction et=em.getTransaction();
		et.begin();
		int i=q.executeUpdate();
		et.commit();
		return i;
	}


	@Override
	public productUser viewproductListDAO(String pu) {
		EntityManager em=emf.createEntityManager();
		Query q=em.createQuery("from com.product.entity.productUser p where p.name=:pname");
		q.setParameter("pname", pu);
		return (productUser)q.getSingleResult();

	}
	

}
