package com.laptrinhtichhop.moigioinhatro.resources;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.laptrinhtichhop.moigioinhatro.entities.Phong;
import com.laptrinhtichhop.moigioinhatro.util.HibernateUtil;

@Path("phong")
public class PhongResource {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("getallphong")
	public List<Phong> getAllPhong() {
		System.out.println("getAllPhong called");

		List<Phong> phongs = null;
		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			org.hibernate.query.Query<Phong> query = session.createQuery("from Phong");
			phongs = query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			phongs = null;
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			//session.close();
		}

		return phongs;
	}
	
	// insert a new Phong
	@POST
	@Path("insertPhong")
	@Produces(MediaType.APPLICATION_XML)
	public Phong insertPhong(Phong phong) {
		System.out.println("insertPhong called");
		
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			session.save(phong);
			transaction.commit();
		}catch (Exception e) {
			// TODO: handle exception
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return null;
		}
		
		return phong;
	}
}
