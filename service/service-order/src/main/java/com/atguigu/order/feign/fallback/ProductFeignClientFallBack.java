package com.atguigu.order.feign.fallback;

import com.atgui.product.bean.Product;
import com.atguigu.order.feign.ProductFeignClient;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @PackageName: com.atguigu.order.feign.fallback
 * @ClaseName: ProductFeignClientFallBack
 * @Description: ProductFeignClientFallBack
 * @Author: zhaoyg
 * @Date: 2025/3/12 15:23
 * @params *@params $
 */

@Component
public class ProductFeignClientFallBack implements ProductFeignClient {

    /**
     * @ClaseName: ProductFeignClientFallBack
     * @Description: 远程兜底方法
     * @Author: ZHAOYG
     * @Date: 2025/3/12 15:23
     * @Param productId
     * @return: com.atgui.product.bean.Product
     */
    @Override
    public Product getProductById(Long productId) {
        System.out.println("远程调用失败，进入了fallback方法");
        Product product = new Product();
        product.setId(productId);
        product.setPrice(new BigDecimal(0));
        product.setProductName("未知");
        product.setNum(0);
        return product;
    }
}
