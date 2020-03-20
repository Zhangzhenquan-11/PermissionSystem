package com.jxau.ssm.service.Impl;

import com.github.pagehelper.PageHelper;
import com.jxau.ssm.dao.ProductDao;
import com.jxau.ssm.model.Product;
import com.jxau.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findAll(int page,int size) throws Exception {

        PageHelper.startPage(page,size);
        return productDao.findAll();
    }

    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }
}
