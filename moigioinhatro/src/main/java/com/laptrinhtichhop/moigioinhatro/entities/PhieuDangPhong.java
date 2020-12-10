package com.laptrinhtichhop.moigioinhatro.entities;
// Generated Dec 9, 2020, 8:44:57 PM by Hibernate Tools 5.4.21.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * PhieuDangPhong generated by hbm2java
 */
@Entity
@Table(name="PHIEU_DANG_PHONG")
@XmlRootElement
public class PhieuDangPhong implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ma_phieu_dang")
	private Integer maPhieuDang;

	@JoinColumn(name = "ma_chu_phong")
	@ManyToOne
	private ChuPhong chuPhong;

	@JoinColumn(name = "ma_phong")
	@ManyToOne
	private Phong phong;

	@JoinColumn(name = "ma_tien_ich")
	@ManyToOne
	private TienIch tienIch;

	@Column(name = "tien_giu_cho")
	private int tienGiuCho;

	@Column(name = "tien_dat_coc")
	private int tienDatCoc;

	@Column(name = "tien_thue")
	private int tienThue;

	@Column(name = "tien_dien")
	private int tienDien;

	@Column(name = "tien_nuoc")
	private int tienNuoc;

	@Column(name = "ngay_dang")
	private Date ngayDang;

	@Column(name = "trang_thai")
	private Boolean trangThai;

	@Transient
	@OneToMany(mappedBy="maAnh")
	private Set<Anh> anhs = new HashSet<Anh>(0);

	public PhieuDangPhong() {
	}

	public PhieuDangPhong(int tienGiuCho, int tienDatCoc, int tienThue, int tienDien, int tienNuoc) {
		this.tienGiuCho = tienGiuCho;
		this.tienDatCoc = tienDatCoc;
		this.tienThue = tienThue;
		this.tienDien = tienDien;
		this.tienNuoc = tienNuoc;
	}

	public PhieuDangPhong(ChuPhong chuPhong, Phong phong, TienIch tienIch, int tienGiuCho, int tienDatCoc, int tienThue,
			int tienDien, int tienNuoc, Date ngayDang, Boolean trangThai, Set<Anh> anhs) {
		this.chuPhong = chuPhong;
		this.phong = phong;
		this.tienIch = tienIch;
		this.tienGiuCho = tienGiuCho;
		this.tienDatCoc = tienDatCoc;
		this.tienThue = tienThue;
		this.tienDien = tienDien;
		this.tienNuoc = tienNuoc;
		this.ngayDang = ngayDang;
		this.trangThai = trangThai;
		this.anhs = anhs;
	}

	public Integer getMaPhieuDang() {
		return this.maPhieuDang;
	}

	public void setMaPhieuDang(Integer maPhieuDang) {
		this.maPhieuDang = maPhieuDang;
	}

	public ChuPhong getChuPhong() {
		return this.chuPhong;
	}

	public void setChuPhong(ChuPhong chuPhong) {
		this.chuPhong = chuPhong;
	}

	public Phong getPhong() {
		return this.phong;
	}

	public void setPhong(Phong phong) {
		this.phong = phong;
	}

	public TienIch getTienIch() {
		return this.tienIch;
	}

	public void setTienIch(TienIch tienIch) {
		this.tienIch = tienIch;
	}

	public int getTienGiuCho() {
		return this.tienGiuCho;
	}

	public void setTienGiuCho(int tienGiuCho) {
		this.tienGiuCho = tienGiuCho;
	}

	public int getTienDatCoc() {
		return this.tienDatCoc;
	}

	public void setTienDatCoc(int tienDatCoc) {
		this.tienDatCoc = tienDatCoc;
	}

	public int getTienThue() {
		return this.tienThue;
	}

	public void setTienThue(int tienThue) {
		this.tienThue = tienThue;
	}

	public int getTienDien() {
		return this.tienDien;
	}

	public void setTienDien(int tienDien) {
		this.tienDien = tienDien;
	}

	public int getTienNuoc() {
		return this.tienNuoc;
	}

	public void setTienNuoc(int tienNuoc) {
		this.tienNuoc = tienNuoc;
	}

	public Date getNgayDang() {
		return this.ngayDang;
	}

	public void setNgayDang(Date ngayDang) {
		this.ngayDang = ngayDang;
	}

	public Boolean getTrangThai() {
		return this.trangThai;
	}

	public void setTrangThai(Boolean trangThai) {
		this.trangThai = trangThai;
	}

	public Set<Anh> getAnhs() {
		return this.anhs;
	}

	public void setAnhs(Set<Anh> anhs) {
		this.anhs = anhs;
	}

}
