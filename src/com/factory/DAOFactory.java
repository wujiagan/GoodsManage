package com.factory;

import com.dao.IGoodsDAO;
import com.dao.IOrderDAO;
import com.dao.proxy.GoodsDAOProxy;
import com.dao.proxy.OrderInDAOProxy;
import com.dao.proxy.OrderOutDAOProxy;

public class DAOFactory {
	public static IGoodsDAO getGoodsDAOInstance() throws Exception {
		return new GoodsDAOProxy();
	}
	public static IOrderDAO getOrderInDAOInstance() throws Exception {
		return new OrderInDAOProxy();
	}
	public static IOrderDAO getOrderOutDAOInstance() throws Exception {
		return new OrderOutDAOProxy();
	}
}
