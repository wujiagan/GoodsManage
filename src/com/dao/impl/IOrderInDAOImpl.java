package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.dao.IOrderDAO;
import com.model.Order;

public class IOrderInDAOImpl implements IOrderDAO{
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public IOrderInDAOImpl(Connection  conn) {
		this.conn = conn;
	}

	@Override
	public boolean doCreate(Order order) throws Exception {
		boolean result = false;
		String sql = "insert into order_in (goods_id, amount, in_date, deliveryman)"
				+ "values (?, ?, ?, ?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, order.getGoods_id());
		this.pstmt.setInt(2, order.getAmount());
		this.pstmt.setDate(3, new java.sql.Date(order.getDate().getTime()));
		this.pstmt.setString(4, order.getOperateMan());
		if(this.pstmt.executeUpdate() > 0)
			result = true;
		this.pstmt.close();
		return result;
	}

	@Override
	public List<Order> findAll(String keyWord) throws Exception {
		List<Order> all = new LinkedList<Order>();
		String sql = "select id, goods_id, amount, in_date, deliveryman from order_in";
		this.pstmt = this.conn.prepareStatement(sql);
		//this.pstmt.setString(1, "%" + keyWord + "%");
		//this.pstmt.setString(2, "%" + keyWord + "%");
		//this.pstmt.setString(3, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		Order order = null;
		while(rs.next()) {
			order = new Order();
			order.setId(rs.getInt(1));
			order.setGoods_id(rs.getInt(2));
			order.setAmount(rs.getInt(3));
			order.setDate(rs.getDate(4));
			order.setOperateMan(rs.getString(5));
			all.add(order);
		}
		this.pstmt.close();
		return all;
	}

	@Override
	public Order findById(int id) throws Exception {
		Order order = null;
		String sql = "select id, goods_id, amount, in_date, deliveryman from order_in"
				+ "where id like ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + id + "%");
		ResultSet rs = this.pstmt.executeQuery();
		while(rs.next()) {
			order = new Order();
			order.setId(rs.getInt(1));
			order.setGoods_id(rs.getInt(2));
			order.setAmount(rs.getInt(3));
			order.setDate(rs.getDate(4));
			order.setOperateMan(rs.getString(5));
		}
		this.pstmt.close();
		return order;
	}

	@Override
	public List<Order> getAll() throws Exception {
		List<Order> all = new LinkedList<Order>();
		String sql = "select id, goods_id, amount, in_date, deliveryman from "
				+ "order_in";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		Order order = null;
		while(rs.next()) {
			order = new Order();
			order.setId(rs.getInt(1));
			order.setGoods_id(rs.getInt(2));
			order.setAmount(rs.getInt(3));
			order.setDate(rs.getDate(4));
			order.setOperateMan(rs.getString(5));
			all.add(order);
		}
		this.pstmt.close();
		return all;
	}
	
}
