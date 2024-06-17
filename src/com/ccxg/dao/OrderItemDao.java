package com.ccxg.dao;

import com.ccxg.bean.OrderItem;

import java.util.List;

/**
 * @author ccxg
 * @create 2024-08-28 11:03
 */
public interface OrderItemDao {
    public int saveOrderItem(OrderItem orderItem);

    public List<OrderItem> showOrderItem(String orderId);
}
