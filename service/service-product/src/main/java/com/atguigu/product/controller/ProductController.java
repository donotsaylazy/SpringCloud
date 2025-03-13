package com.atguigu.product.controller;


import com.atgui.product.bean.Product;
import com.atguigu.product.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
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
    public Product getProduct(@PathVariable("id") Long productId,
                                HttpServletRequest request){
        System.out.println("查询商品，商品id为："+productId);
        String header = request.getHeader("X-Token");
        System.out.println("header-token = " + header);
        Product product = productService.getProductById(productId);
        return product;
    }


}
