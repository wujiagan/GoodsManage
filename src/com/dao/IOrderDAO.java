package com.dao;

import java.util.Date;
import java.util.List;

import com.model.Order;

public interface IOrderDAO {
	public boolean doCreate(Order order) throws Exception;
	public List<Order> findAll(String keyWord) throws Exception;
	public List<Order> getAll() throws Exception;
	public Order findById(int id) throws Exception;
	public boolean deleteById(int id) throws Exception;
	public List<Order> findAll(Date start_date, Date end_date) throws Exception;
}
