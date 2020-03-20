package com.jxau.ssm.service;

import com.jxau.ssm.model.Orders;

import java.util.List;

public interface OrdersService {

    List<Orders> findAll(int page, int size) throws Exception;

    Orders findById(Integer ordersId) throws Exception;

}
