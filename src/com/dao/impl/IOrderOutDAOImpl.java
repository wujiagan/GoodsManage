package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.dao.IOrderDAO;
import com.model.Order;

public class IOrderOutDAOImpl implements IOrderDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public IOrderOutDAOImpl(Connection  conn) {
		this.conn = conn;
	}

	@Override
	public boolean doCreate(Order order) throws Exception {
		boolean result = false;
		String sql = "insert into order_out (goods_id, amount, in_date, operateman)"
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
		String sql = "select order_out.id, goods.name, goods_id, amount, in_date, operateman " 
				+ "from order_out, goods "
				+ "where order_out.goods_id = goods.id "
				+ "and goods.name like ? "
				+ "order by in_date";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		Order order = null;
		while(rs.next()) {
			order = new Order();
			order.setId(rs.getInt(1));
			order.setGoods_name(rs.getString(2));
			order.setGoods_id(rs.getInt(3));
			order.setAmount(rs.getInt(4));
			order.setDate(rs.getDate(5));
			order.setOperateMan(rs.getString(6));
			all.add(order);
		}
		this.pstmt.close();
		return all;
	}

	@Override
	public Order findById(int id) throws Exception {
		Order order = null;
		String sql = "select id, goods_id, amount, in_date, operateman from order_out"
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
		String sql = "select id, goods_id, name,  amount, in_date, operateman from "
				+ "order_out_view "
				+ "order by in_date";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		Order order = null;
		while(rs.next()) {
			order = new Order();
			order.setId(rs.getInt(1));
			order.setGoods_id(rs.getInt(2));
			order.setGoods_name(rs.getString(3));
			order.setAmount(rs.getInt(4));
			order.setDate(rs.getDate(5));
			order.setOperateMan(rs.getString(6));
			all.add(order);
		}
		this.pstmt.close();
		return all;
	}

	@Override
	public boolean deleteById(int id) throws Exception {
		boolean result = false;
		String sql = "delete from order_out where id = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, id);
		if(this.pstmt.executeUpdate() > 0)
			result = true;
		this.pstmt.close();
		return result;
	}

	@Override
	public List<Order> findAll(Date start_date, Date end_date) throws Exception {
		List<Order> all = new LinkedList<Order>();
		String sql = "select order_out.id, goods.name, goods_id, amount, in_date, operateman " 
				+ "from order_out, goods "
				+ "where order_out.goods_id = goods.id "
				+ "and in_date > ? and in_date < ? "
				+ "order by in_date";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setDate(1, new java.sql.Date(start_date.getTime()));
		this.pstmt.setDate(2, new java.sql.Date(end_date.getTime()));
		ResultSet rs = this.pstmt.executeQuery();
		Order order = null;
		while(rs.next()) {
			order = new Order();
			order.setId(rs.getInt(1));
			order.setGoods_name(rs.getString(2));
			order.setGoods_id(rs.getInt(3));
			order.setAmount(rs.getInt(4));
			order.setDate(rs.getDate(5));
			order.setOperateMan(rs.getString(6));
			all.add(order);
		}
		this.pstmt.close();
		return all;
	}
}
