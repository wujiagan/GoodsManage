package com.factory;

import com.dao.IGoodsDAO;
import com.dao.proxy.GoodsDAOProxy;

public class DAOFactory {
	public static IGoodsDAO getGoodsDAOInstance() throws Exception {
		return new GoodsDAOProxy();
	}
}
