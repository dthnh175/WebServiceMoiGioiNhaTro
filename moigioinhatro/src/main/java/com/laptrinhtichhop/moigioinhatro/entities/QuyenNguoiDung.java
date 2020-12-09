package com.laptrinhtichhop.moigioinhatro.entities;

import javax.persistence.*;

// Generated Dec 9, 2020, 8:44:57 PM by Hibernate Tools 5.4.21.Final

/**
 * QuyenNguoiDung generated by hbm2java
 */
@Entity
@Table(name = "QUYEN_NGUOI_DUNG")
public class QuyenNguoiDung implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ma_quyen_nguoi_dung")
	private Integer maQuyenNguoiDung;
	
	@JoinColumn(name = "ma_nguoi_dung")
	@ManyToOne
	private NguoiDung nguoiDung;
	
	@JoinColumn(name = "nhom_nguoi_dung")
	@ManyToOne
	private NhomNguoiDung nhomNguoiDung;

	public QuyenNguoiDung() {
	}

	public QuyenNguoiDung(NguoiDung nguoiDung, NhomNguoiDung nhomNguoiDung) {
		this.nguoiDung = nguoiDung;
		this.nhomNguoiDung = nhomNguoiDung;
	}

	public Integer getMaQuyenNguoiDung() {
		return this.maQuyenNguoiDung;
	}

	public void setMaQuyenNguoiDung(Integer maQuyenNguoiDung) {
		this.maQuyenNguoiDung = maQuyenNguoiDung;
	}

	public NguoiDung getNguoiDung() {
		return this.nguoiDung;
	}

	public void setNguoiDung(NguoiDung nguoiDung) {
		this.nguoiDung = nguoiDung;
	}

	public NhomNguoiDung getNhomNguoiDung() {
		return this.nhomNguoiDung;
	}

	public void setNhomNguoiDung(NhomNguoiDung nhomNguoiDung) {
		this.nhomNguoiDung = nhomNguoiDung;
	}

}
