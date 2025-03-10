package com.atgui.order.bean;

import com.atgui.product.bean.Product;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @PackageName: com.atguigu.order.bean
 * @ClaseName: Order
 * @Description: Order
 * @Author: zhaoyg
 * @Date: 2025/3/10 14:27
 * @params *@params $
 */

@Data
public class Order {
    private Long id;
    private BigDecimal totalAmount;
    private Long userId;
    private String nickName;
    private String address;
    private List<Product> productList;
}
