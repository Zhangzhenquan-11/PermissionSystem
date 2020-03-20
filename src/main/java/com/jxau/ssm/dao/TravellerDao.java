package com.jxau.ssm.dao;

import com.jxau.ssm.model.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TravellerDao {

    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId})")
    List<Traveller> findByOrdersId(Integer ordersId) throws Exception;
}
