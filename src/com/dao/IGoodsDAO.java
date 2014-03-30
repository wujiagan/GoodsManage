package com.dao;

import java.util.List;

import com.model.Goods;



public interface IGoodsDAO{
	public boolean doCreate(Goods goods) throws Exception;
	public List<Goods> findAll(String keyWord) throws Exception;
	public List<Goods> getAll() throws Exception;
	public Goods findById(int id) throws Exception;
	
}
