package com.dao.proxy;

import java.util.List;

import com.dao.IGoodsDAO;
import com.dao.impl.IGoodsDAOImpl;
import com.dbc.DatabaseConnection;
import com.model.Goods;

public class GoodsDAOProxy implements IGoodsDAO{
	private DatabaseConnection dbc = null;
	private IGoodsDAO dao = null;
	public GoodsDAOProxy() throws Exception {
		this.dbc = new DatabaseConnection();
		this.dao = new IGoodsDAOImpl(this.dbc.getConnection());
	}
	@Override
	public boolean doCreate(Goods goods) throws Exception {
		try {
			this.dao.doCreate(goods);
		} catch (Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		return false;
	}
	@Override
	public List<Goods> findAll(String keyWord) throws Exception {
		List<Goods> all = null;
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
	public Goods findById(int id) throws Exception {
		Goods goods = null;
		try{
			goods = this.dao.findById(id);
		}catch(Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
		return goods;
	}
}
