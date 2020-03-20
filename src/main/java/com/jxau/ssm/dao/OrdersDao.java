package com.jxau.ssm.dao;

import com.jxau.ssm.model.Orders;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrdersDao {

    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "productId", column = "productId"),
            @Result(property = "memberId", column = "memberId"),
            @Result(property = "product", column = "productId",one = @One(select = "com.jxau.ssm.dao.ProductDao.findById")),

    })
    public List<Orders> findAll() throws Exception;

    //多表操作
    @Select("select * from orders where id=#{ordersId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "productId", column = "productId"),
            @Result(property = "memberId", column = "memberId"),
            @Result(property = "product", column = "productId",one = @One(select = "com.jxau.ssm.dao.ProductDao.findById")),
            @Result(property = "travellers",column = "id",many = @Many(select = "com.jxau.ssm.dao.TravellerDao.findByOrdersId")),
            @Result(property = "member", column = "memberId",one = @One(select = "com.jxau.ssm.dao.MemberDao.findById"))
    })
    public Orders findById(Integer ordersId) throws Exception;
}
