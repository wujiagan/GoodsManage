package com.model;

import java.util.Date;

public class Order {
	private int id;
	private int goods_id;
	private int amount;
	private Date date;
	private String operateMan;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getOperateMan() {
		return operateMan;
	}
	public void setOperateMan(String operateMan) {
		this.operateMan = operateMan;
	}
	
}
