package com.atguigu.product.service.impl;


import com.atgui.product.bean.Product;
import com.atguigu.product.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @PackageName: com.atguigu.product.service.impl
 * @ClaseName: ProductServiceImpl
 * @Description: ProductServiceImpl
 * @Author: zhaoyg
 * @Date: 2025/3/10 11:02
 * @params *@params $
 */

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Product getProductById(Long productId) {
        Product product = new Product();
        product.setId(productId);
        product.setPrice(new BigDecimal(100));
        product.setProductName("苹果");
        product.setNum(2);
        return product;
    }


    private void test111(){
        System.out.println("111");
    }


    private void test222(){
        System.out.println("222");
    }

    private void test333(){
        System.out.println("333");
    }

    private void test333(){
        System.out.println("333");
    }
}
