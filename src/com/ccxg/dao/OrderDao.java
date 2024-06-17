package com.ccxg.dao;

import com.ccxg.bean.Order;

import java.util.List;

/**
 * @author ccxg
 * @create 2024-08-28 10:57
 */
public interface OrderDao {

    public int saveOrder(Order order);

    public List<Order> queryAllOrders();

    public void updateOrderStatus(int i, String orderId);

    public List<Order> queryMyOrders(int userId);

}
