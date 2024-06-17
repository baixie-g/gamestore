package com.ccxg.test;

import com.ccxg.bean.Cart;
import com.ccxg.bean.CartItem;
import com.ccxg.service.OrderService;
import com.ccxg.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author ccxg
 * @create 2024-08-28 14:14
 */
public class OrderServiceTest {
    private OrderService orderService = new OrderServiceImpl();
    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"lkjs",1,new BigDecimal(5),new BigDecimal(66)));
        cart.addItem(new CartItem(1,"lkjs",1,new BigDecimal(5),new BigDecimal(66)));
        cart.addItem(new CartItem(2,"你妹的",1,new BigDecimal(5),new BigDecimal(66)));

        System.out.println(orderService.createOrder(cart,1));
    }

    @Test
    public void queryAllOrders() {
        System.out.println(orderService.queryAllOrders());
    }

    @Test
    public void queryMyOrders() {
        System.out.println(orderService.queryMyOrders(5));
    }

    @Test
    public void receivedOrder() {
    }
}
