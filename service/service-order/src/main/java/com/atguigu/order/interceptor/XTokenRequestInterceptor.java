package com.atguigu.order.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @PackageName: com.atguigu.order.interceptor
 * @ClaseName: XTokenRequestInterceptor
 * @Description: XTokenRequestInterceptor
 * @Author: zhaoyg
 * @Date: 2025/3/12 14:53
 * @params *@params $
 */

@Component
public class XTokenRequestInterceptor implements RequestInterceptor {

    /**
     * @ClaseName: XTokenRequestInterceptor
     * @Description: 请求拦截器
     * @Author: ZHAOYG
     * @Date: 2025/3/12 14:54
     * @Param requestTemplate  请求的模板参数
     * @return: void
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {
        System.out.println("xTokenRequestInterceptor = :" + requestTemplate);
        requestTemplate.header("X-Token", UUID.randomUUID().toString());
    }
}
