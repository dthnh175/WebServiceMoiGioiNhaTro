package com.laptrinhtichhop.moigioinhatro.resources;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.laptrinhtichhop.moigioinhatro.entities.Phong;
import com.laptrinhtichhop.moigioinhatro.util.HibernateUtil;

//import jakarta.ws.rs.GET;
//import jakarta.ws.rs.Path;
//import jakarta.ws.rs.Produces;
//import jakarta.ws.rs.core.MediaType;

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
}
