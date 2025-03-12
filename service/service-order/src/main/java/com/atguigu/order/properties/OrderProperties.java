package com.atguigu.order.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @PackageName: com.atguigu.order.properties
 * @ClaseName: OrderProperties
 * @Description: OrderProperties
 * @Author: zhaoyg
 * @Date: 2025/3/11 9:59
 * @params *@params $
 */

@Data
@Component
@ConfigurationProperties(prefix = "order")
public class OrderProperties {


    String timeout;

    String autoConfirm;
}
