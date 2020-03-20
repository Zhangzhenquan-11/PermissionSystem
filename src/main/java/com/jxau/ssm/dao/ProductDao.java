package com.jxau.ssm.dao;

import com.jxau.ssm.model.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductDao {

    //根据id查询产品信息
    @Select("select * from product where id=#{id}")
    Product findById(Integer id) throws Exception;

    //查询所有产品
    @Select("select * from product")
    List<Product> findAll() throws Exception;

    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) " +
            " value(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);
}
