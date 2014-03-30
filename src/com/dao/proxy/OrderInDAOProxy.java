package com.dao.proxy;

import java.util.List;

import com.dao.IOrderDAO;
import com.dao.impl.IOrderInDAOImpl;
import com.dbc.DatabaseConnection;
import com.model.Order;

public class OrderInDAOProxy implements IOrderDAO{
	private DatabaseConnection dbc = null;
	private IOrderDAO dao = null;
	public OrderInDAOProxy() throws Exception {
		this.dbc = new DatabaseConnection();
		this.dao = new IOrderInDAOImpl(this.dbc.getConnection());
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
}
