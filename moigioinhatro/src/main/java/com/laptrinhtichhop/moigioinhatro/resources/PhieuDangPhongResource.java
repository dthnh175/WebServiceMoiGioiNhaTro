package com.laptrinhtichhop.moigioinhatro.resources;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.laptrinhtichhop.moigioinhatro.entities.PhieuDangPhong;
import com.laptrinhtichhop.moigioinhatro.util.HibernateUtil;

@Path("phieudangphong")
public class PhieuDangPhongResource {

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@GET
	@Path("getallphieudangphong")
	@Produces(MediaType.APPLICATION_XML)
	public List<PhieuDangPhong> getAllPhieuDangPhong() {
		System.out.println("getAllPhong called");

		List<PhieuDangPhong> phieuDangPhongs = null;
		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			org.hibernate.query.Query<PhieuDangPhong> query = session.createQuery("from PhieuDangPhong");
			phieuDangPhongs = query.getResultList();
			
			// get all pictures from the phieuDangPhong
		} catch (Exception e) {
			phieuDangPhongs = null;
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			// session.close();
		}

		return phieuDangPhongs;
	}
	
	// get a PhieuDangPhon with the specific id
	@GET
	@Path("getphieudangphong/{maPhieuDang}")
	@Produces(MediaType.APPLICATION_XML)
	public List<PhieuDangPhong> getPhieuDangPhong(@PathParam("maPhieuDang") int maPhieuDang) {
		System.out.println("getPhieuDangPhong called");

		List<PhieuDangPhong> phieuDangPhongs = null;
		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			org.hibernate.query.Query<PhieuDangPhong> query = session.createQuery("from PhieuDangPhong pdp where pdp.maPhieuDang=:maPhieuDang").setParameter("maPhieuDang", maPhieuDang);
			phieuDangPhongs = query.getResultList();
			
			// get all pictures from the phieuDangPhong
		} catch (Exception e) {
			phieuDangPhongs = null;
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			// session.close();
		}

		return phieuDangPhongs;
	}

}
