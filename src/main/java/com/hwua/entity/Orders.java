package com.hwua.entity;

import java.util.Date;

/**
 * 订单表
 * 
 * @author oracleOAEC
 *
 */
public class Orders {
	private Integer id;//订单编号

	private String number;

	private Date createtime;

	private String note;

	private Users user;//用户编号

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number == null ? null : number.trim();
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note == null ? null : note.trim();
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Orders(Integer id, String number, Date createtime, String note, Users user) {
		super();
		this.id = id;
		;
		this.number = number;
		this.createtime = createtime;
		this.note = note;
		this.user = user;
	}

	public Orders() {
		super();
	}
	

	public Orders(String number, Date createtime, String note, Users user) {
		super();
		this.number = number;
		this.createtime = createtime;
		this.note = note;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", number=" + number + ", createtime=" + createtime + ", note=" + note + ", user="
				+ user + "]";
	}

}