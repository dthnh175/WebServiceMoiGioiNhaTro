package com.laptrinhtichhop.moigioinhatro.resources;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.laptrinhtichhop.moigioinhatro.entities.ChuPhong;
import com.laptrinhtichhop.moigioinhatro.util.HibernateUtil;

@Path("chuphong")
public class ChuPhongResource {
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@GET
	@Path("getchuphong/{tenDangNhap}")
	@Produces(MediaType.APPLICATION_XML)
	public List<ChuPhong> getChuPhong(@PathParam("tenDangNhap") String tenDangNhap) {
		Session session = null;
		Transaction transaction = null;
		List<ChuPhong> chuPhongs = null;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			Query<ChuPhong> query = session
					.createQuery("from ChuPhong cp where cp.tenDangNhap=:username")
					.setParameter("username", tenDangNhap);
			
			System.out.println("yo: " + query);

			chuPhongs = query.getResultList();

		} catch (Exception e) {
			// TODO: handle exception
			chuPhongs = null;
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			
		}
		
		return chuPhongs;
	}
}
