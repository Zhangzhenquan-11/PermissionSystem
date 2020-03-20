package com.jxau.ssm.dao;

import com.jxau.ssm.model.Orders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class TestDao {
    @Autowired
    OrdersDao ordersDao;

    @Test
    public void findAll() throws Exception {
        List<Orders> list = ordersDao.findAll();
        for (Orders order: list) {
            System.out.println(order.toString());
        }
    }
    @Test
    public void findById() throws Exception {
        Orders orders = ordersDao.findById(1);
        System.out.println(orders);
    }
}
