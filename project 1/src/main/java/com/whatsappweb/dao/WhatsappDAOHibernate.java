package com.whatsappweb.dao;


import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.whatsappweb.entity.WhatsappUser;

public class WhatsappDAOHibernate implements WhatsappDAOInterface{
	
	private SessionFactory sf;
	
	public WhatsappDAOHibernate() {
		sf=new Configuration().configure().buildSessionFactory();
	}
	public int createProfileDAO(WhatsappUser wu) {
		int i=0;
		Session s=sf.openSession();
		s.save(wu);//this will create a table and save data but permanently it will not appear in table so for that we use transaction
		
		Transaction t=s.beginTransaction();
		t.commit();
		i=1;
		return i;
	}
	
	public boolean loginProfileDAO(WhatsappUser wu) {
			boolean b=false;
			Session s=sf.openSession();
			Query q=s.createQuery("from WhatsappUser wu where wu.username='"+wu.getUsername()+"' and wu.password='"+wu.getPassword()+"'");
			List<WhatsappUser> ff=q.getResultList();
			if(ff.size()>0) {
				b=true;
			}
			return b;
		
	}
	public WhatsappUser viewProfileDAO(WhatsappUser wu) {
		System.out.println(wu.getUsername());
		Session s=sf.openSession();
		Query q=s.createQuery("from WhatsappUser wu where wu.username='"+wu.getUsername()+"'");
		WhatsappUser ww=(WhatsappUser)q.getSingleResult();
		
		return ww;
	}
	
	
	
	
	
	
	public int deleteProfile(WhatsappUser wu) {
		int i=0;
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		//s.delete(wu);
		Query q=s.createQuery("delete from WhatsappUser wu where wu.username='"+wu.getUsername()+"' and wu.password='"+wu.getPassword()+"'"); //no 2 and used in real
		i=q.executeUpdate();
		t.commit();
		//i=1;
		return i;
	}
	
	
	public int editProfileDAO(WhatsappUser wu) {
		int i=0;
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
	    s.update(wu);  //no 1 but not used in real
		//Query q=s.createQuery("update WhatsappUser wu set wu.name="+wu.getName()+",wu.phone="+wu.getPhone()+",wu.age="+wu.getAge()+",wu.email="+wu.getEmail()+",wu.password="+wu.getPassword()+"where wu.username="+wu.getUsername());
		//i=q.executeUpdate();
		t.commit();
		i=1;
		return i;
	}
	
	
	
	
	

		
	
	

}
