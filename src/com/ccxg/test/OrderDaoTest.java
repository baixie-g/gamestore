package com.ccxg.test;

import com.ccxg.dao.OrderDao;
import com.ccxg.dao.impl.OrderDaoImpl;
import org.junit.Test;

/**
 * @author ccxg
 * @create 2024-08-29 21:39
 */
public class OrderDaoTest {

    private OrderDao orderDao = new OrderDaoImpl();
    @Test
    public void saveOrder() {
    }

    @Test
    public void queryAllOrders() {
        System.out.println(orderDao.queryAllOrders());
    }

    @Test
    public void updateOrderStatus() {
        orderDao.updateOrderStatus(1,"15987004865195");
    }

    @Test
    public void queryMyOrders() {
        System.out.println(orderDao.queryMyOrders(1));
    }


}
