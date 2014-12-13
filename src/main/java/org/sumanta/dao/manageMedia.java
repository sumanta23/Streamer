package org.sumanta.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.AnnotationConfiguration;

import org.sumanta.bean.Media;

public class manageMedia {
	private static SessionFactory factory=
			new Configuration().configure().buildSessionFactory(); 
	
	
	public void addMedia(Media media)
	{
		System.out.println("hello");
		Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         session.save(media); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   
	  } //end of addMedia
	
	
	public void removeMedia(Media media) {
		Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         session.delete(media); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   
	}

	
	public void updateMedia(Media media,int id) {
		Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Media temp = (Media)session.get(Media.class, id); 
	         temp.setId(media.getId());
	         temp.setPath(media.getPath());
			 session.update(temp);
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	}
	
	public List viewMedia() {
		Session session = factory.openSession();
	      Transaction tx = null;
	      List result=new ArrayList<Media>();
	      try{
	         tx = session.beginTransaction();
	        // Query query = session.createSQLQuery("select ID,FirstName,LastName,Marks from Media_details");
	        // System.out.println(Media.class.getSimpleName());
	         Query query =session.createQuery("from org.sumanta.bean.Media");
	         result = query.list();
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      
	      return result;
		
	}
	
	
	public Media singleMediaDetails(String id) {
		Session session = factory.openSession();
	      Transaction tx = null;
	      Media st=new Media();
	      try{
	         tx = session.beginTransaction();
	         Media temp = (Media)session.get(Media.class, Integer.parseInt(id)); 
	         st=temp;
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return st;
		
	}
	
}
