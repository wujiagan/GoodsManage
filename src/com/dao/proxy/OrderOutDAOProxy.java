package com.dao.proxy;

import java.util.Date;
import java.util.List;

import com.dao.IOrderDAO;
import com.dao.impl.IOrderOutDAOImpl;
import com.dbc.DatabaseConnection;
import com.model.Order;

public class OrderOutDAOProxy implements IOrderDAO {
	private DatabaseConnection dbc = null;
	private IOrderDAO dao = null;
	public OrderOutDAOProxy() throws Exception {
		this.dbc = new DatabaseConnection();
		this.dao = new IOrderOutDAOImpl(this.dbc.getConnection());
	}
	@Override
	public boolean doCreate(Order order) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.doCreate(order);
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}
	@Override
	public List<Order> findAll(String keyWord) throws Exception {
		List<Order> all = null;
		try{
			 all = this.dao.findAll(keyWord);
		}catch(Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		return all;
	}
	@Override
	public Order findById(int id) throws Exception {
		Order order = null;
		try{
			order = this.dao.findById(id);
		}catch(Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		return order;
	}
	@Override
	public List<Order> getAll() throws Exception {
		List<Order> all = null;
		try{
			 all = this.dao.getAll();
		}catch(Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		return all;
	}
	@Override
	public boolean deleteById(int id) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.deleteById(id);
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}
	@Override
	public List<Order> findAll(Date start_date, Date end_date) throws Exception {
		List<Order> all = null;
		try{
			 all = this.dao.findAll(start_date, end_date);
		}catch(Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		return all;
	}
}
