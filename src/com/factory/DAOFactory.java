package com.factory;

import com.dao.IGoodsDAO;
import com.dao.IOrderDAO;
import com.dao.proxy.GoodsDAOProxy;
import com.dao.proxy.OrderInDAOProxy;

public class DAOFactory {
	public static IGoodsDAO getGoodsDAOInstance() throws Exception {
		return new GoodsDAOProxy();
	}
	public static IOrderDAO getOrderInDAOInstance() throws Exception {
		return new OrderInDAOProxy();
	}
}
