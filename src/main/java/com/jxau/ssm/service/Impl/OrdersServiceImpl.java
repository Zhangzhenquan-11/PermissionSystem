package com.jxau.ssm.service.Impl;

import com.github.pagehelper.PageHelper;
import com.jxau.ssm.dao.OrdersDao;
import com.jxau.ssm.model.Orders;
import com.jxau.ssm.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;

    @Override
    public List<Orders> findAll(int page,int size) throws Exception {
        //分页显示
        PageHelper.startPage(page,size);
        return ordersDao.findAll();
    }

    @Override
    public Orders findById(Integer ordersId) throws Exception {
        return ordersDao.findById(ordersId);
    }
}
