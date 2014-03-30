package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.dao.IGoodsDAO;
import com.model.Goods;

public class IGoodsDAOImpl implements IGoodsDAO{
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public IGoodsDAOImpl(Connection  conn) {
		this.conn = conn;
	}

	@Override
	public boolean doCreate(Goods goods) throws Exception {
		boolean result = false;
		String sql = "insert into goods (name, manuFacturer, sn, size)"
				+ "values (?, ?, ?, ?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, goods.getName());
		this.pstmt.setString(2, goods.getManuFacturer());
		this.pstmt.setString(3, goods.getSn());
		this.pstmt.setString(4, goods.getSize());
		if(this.pstmt.executeUpdate() > 0)
			result = true;
		this.pstmt.close();
		return result;
	}

	@Override
	public List<Goods> findAll(String keyWord) throws Exception {
		List<Goods> all = new LinkedList<Goods>();
		String sql = "select id, name, manuFacturer, sn, size from goods"
				+ "where name like ? or manuFacturer like ? or sn like ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setString(2, "%" + keyWord + "%");
		this.pstmt.setString(3, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		Goods goods = null;
		while(rs.next()) {
			goods = new Goods();
			goods.setId(rs.getInt(1));
			goods.setName(rs.getString(2));
			goods.setManuFacturer(rs.getString(3));
			goods.setSn(rs.getString(4));
			goods.setSize(rs.getString(5));
			all.add(goods);
		}
		this.pstmt.close();
		return all;
	}

	@Override
	public Goods findById(int id) throws Exception {
		Goods goods = new Goods();
		String sql = "select id, name, manuFacturer, sn, size from goods"
				+ "where id like ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + id + "%");
		ResultSet rs = this.pstmt.executeQuery();
		while(rs.next()) {
			goods.setId(rs.getInt(1));
			goods.setName(rs.getString(2));
			goods.setManuFacturer(rs.getString(3));
			goods.setSn(rs.getString(4));
			goods.setSize(rs.getString(5));
		}
		this.pstmt.close();
		return goods;
	}

	@Override
	public List<Goods> getAll() throws Exception {
		List<Goods> all = new LinkedList<Goods>();
		String sql = "select id, name, manuFacturer, sn, size from goods";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		Goods goods = null;
		while(rs.next()) {
			goods = new Goods();
			goods.setId(rs.getInt(1));
			goods.setName(rs.getString(2));
			goods.setManuFacturer(rs.getString(3));
			goods.setSn(rs.getString(4));
			goods.setSize(rs.getString(5));
			all.add(goods);
		}
		this.pstmt.close();
		return all;
	}
	
}
