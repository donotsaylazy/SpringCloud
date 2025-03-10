package com.atgui.product.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @PackageName: com.atguigu.product.bean
 * @ClaseName: Product
 * @Description: Product
 * @Author: zhaoyg
 * @Date: 2025/3/10 10:58
 * @params *@params $
 */

@Data
public class Product {

    private Long id;
    private BigDecimal price;
    private String productName;
    private int num;
}
