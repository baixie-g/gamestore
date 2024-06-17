package com.ccxg.service.impl;

import com.ccxg.bean.*;
import com.ccxg.dao.GameDao;
import com.ccxg.dao.OrderDao;
import com.ccxg.dao.OrderItemDao;
import com.ccxg.dao.impl.GameDaoImpl;
import com.ccxg.dao.impl.OrderDaoImpl;
import com.ccxg.dao.impl.OrderItemDaoImpl;
import com.ccxg.service.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author ccxg
 * @create 2024-08-28 14:01
 */
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private GameDao gameDao = new GameDaoImpl();
    @Override
    public String createOrder(Cart cart, Integer userId) {
        //订单号唯一
        String orderId = System.currentTimeMillis() + "" + userId;
        //创建一个订单对象
        Order order = new Order(orderId,new Date(),cart.getTotalPrice(),0,userId);
        orderDao.saveOrder(order);
        for(Map.Entry<Integer, CartItem>entry : cart.getItems().entrySet()) {
            //获取每个购物车中的商品项转换为每一个订单项
            CartItem cartItem = entry.getValue();
            OrderItem orderItem = new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(),orderId);
            //保存订单到数据库
            orderItemDao.saveOrderItem(orderItem);
            Game game = gameDao.queryGameById(cartItem.getId());
            game.setSales(game.getSales() + cartItem.getCount());
            game.setStock(game.getStock() - cartItem.getCount());
            gameDao.updateGame(game);

        }
        cart.clear();
        return orderId;
    }

    @Override
    public List<Order> queryAllOrders() {
        // 查询所有订单
        return orderDao.queryAllOrders();
    }

    @Override
    public void sendOrder(String orderId) {
        // 修改订单状态为已发货
        orderDao.updateOrderStatus(1, orderId);
    }

    @Override
    public List<Order> queryMyOrders(Integer id) {
        return orderDao.queryMyOrders(id);
    }


    @Override
    public void receivedOrder(String orderId) {
        // 修改订单状态为已收货
        orderDao.updateOrderStatus(2, orderId);
    }

    @Override
    public List<OrderItem> showOrderItem(String orderId) {
        List<OrderItem> orderItems = orderItemDao.showOrderItem(orderId);
        return orderItems;
    }
}
