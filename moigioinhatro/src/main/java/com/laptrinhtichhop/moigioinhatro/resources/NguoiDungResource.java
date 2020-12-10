package com.laptrinhtichhop.moigioinhatro.resources;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.laptrinhtichhop.moigioinhatro.entities.NguoiDung;
import com.laptrinhtichhop.moigioinhatro.util.BooleanWrapper;
import com.laptrinhtichhop.moigioinhatro.util.HibernateUtil;

@Path("nguoidung")
public class NguoiDungResource {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@POST
	@Path("xacthuc")
	@Produces(MediaType.APPLICATION_XML)
	public BooleanWrapper authenticateNguoiDung(NguoiDung nguoiDung) {
		Session session = null;
		Transaction transaction = null;
		BooleanWrapper bw = new BooleanWrapper();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			Query<NguoiDung> query = session.createQuery("from NguoiDung nd where nd.tenDangNhap=:username and nd.matKhau=:password")
					.setParameter("username", nguoiDung.getTenDangNhap())
					.setParameter("password", nguoiDung.getMatKhau());
			
			List<NguoiDung> nguoiDungs = query.getResultList();
			
			if (nguoiDungs.size() > 0) {				
				bw.setResult(true);
			}
			else {
				bw.setResult(false);
			}
			
			return bw;
		} catch (Exception e) {
			// TODO: handle exception
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return null;
		}		
	}
	
	@POST
	@Path("taonguoidung")
	@Produces(MediaType.APPLICATION_XML)
	public BooleanWrapper insertNguoiDung(NguoiDung nguoiDung) {
		Session session = null;
		Transaction transaction = null;
		BooleanWrapper bw = new BooleanWrapper();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			session.save(nguoiDung);
			
			transaction.commit();
			
			bw.setResult(true);
			return bw;
		} catch (Exception e) {
			// TODO: handle exception
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return null;
		}		
	}
}
