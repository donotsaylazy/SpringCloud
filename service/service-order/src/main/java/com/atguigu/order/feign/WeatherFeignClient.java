package com.atguigu.order.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

//存在url feign就先调用url域名,不存在就去nacos中心调用value的服务名
@FeignClient(value = "service-weather",url = "http://localhost:8080")
public interface WeatherFeignClient {


    @PostMapping("/whapi/json/weather") //url地址
    public String getWeather(@RequestHeader("Authorizationo") String auth,
                             @RequestParam("token") String token,
                             @RequestParam("cityId") String cityId);
}
