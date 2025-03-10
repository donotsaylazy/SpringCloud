package com.atguigu.product.controller;


import com.atgui.product.bean.Product;
import com.atguigu.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * @PackageName: com.atguigu.product.controller
 * @ClaseName: ProductController
 * @Description: ProductController
 * @Author: zhaoyg
 * @Date: 2025/3/10 10:33
 * @params *@params $
 */

@RestController
public class ProductController {


    @Autowired
    private ProductService productService;




    //查询商品
    @GetMapping("/product/{id}" )
    public Product getProduct(@PathVariable("id") Long productId){
        Product product = productService.getProductById(productId);
        return product;
    }


}
