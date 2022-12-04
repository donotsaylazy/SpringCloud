package com.amos.springcloud.utils;


import com.alibaba.csb.sdk.ContentBody;
import com.alibaba.csb.sdk.HttpCaller;
import com.alibaba.csb.sdk.HttpCallerException;
import com.alibaba.csb.sdk.HttpParameters;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.HashMap;
import java.util.Map;

/**
 * @PackageName: com.amos.springcloud.utils
 * @ClaseName: CSBDemoESSC
 * @Description: 模拟第三方接入渠道调用CSB上发布的API服务
 * @Author: zhaoyg
 * @Date: 2022/8/30 14:03
 * @params *@params $
 */

public class CSBDemoESSC {


    private static final Logger logger = LoggerFactory.getLogger(CSBDemoESSC.class);

    /** 专网-生产环境   start */
//    private String csburl="http://10.1.189.189:8086/CSB/";
//    private String accessKey="";
//    private String securityKey="";
//    private String encryptKey = "";
    /** 专网-生产环境   end */

    /** 互联网-生产环境   start */
//    private String csburl="https://ssc.mohrss.gov.cn/CSB/";
//    private String accessKey="";
//    private String securityKey="";
//    private String encryptKey = "";
    /** 互联网-生产环境   end */


    /** 专网-测试环境  start */
//    private String csburl="https://10.1.189.168:8086/CSB/";
//    private String accessKey="";
//    private String securityKey="=";
//    private String encryptKey = "";
//    /** 专网-测试环境  end */

    /** 互联网-测试环境  start */
    private String csburl="https://test-ssc.mohrss.gov.cn/CSB/";
    private String accessKey="";
    private String securityKey="=";
    private String encryptKey = "";
    /** 互联网-测试环境  end */

    private String api_version="1.0.0";
    private String api_method="post";
    public static int SUCCESS = 000000;

    public void v2_sign_valid_encrypt() {
        HttpParameters.Builder builder = HttpParameters.newBuilder();
        builder.requestURL(csburl) // 设置请求的URL
                .api("v2_sign_valid_encrypt") // 设置服务名
                .version(api_version) // 设置版本号
                .method(api_method) // 设置调用方式, get/post
                .accessKey(accessKey).secretKey(securityKey); // 设置accessKey 和 设置secretKey

        // 设置请求参数（json格式)
        Map<String,String> param = new HashMap<>();
        param.put("channelNo","");
        param.put("accessNo","");
        param.put("aac002","");
        param.put("aac003","");
        AESUtils.encrypt(JSON.toJSONString(param),encryptKey);
        Map<String,String> encryptParam = new HashMap<>();
        encryptParam.put("security", AESUtils.encrypt(JSON.toJSONString(param),encryptKey));

        ContentBody cb = new ContentBody(JSON.toJSONString(encryptParam));
        builder.contentBody(cb);

        //进行调用 返回结果（json格式)
        String result = null;
        try {
            result = HttpCaller.invoke(builder.build());
            logger.info("================sign_info==================");
            logger.info(result);
            /**返回的result内容如下：
             {"msgCode":700,"msg":"失败","result":null}
             */
            JSONObject retJson = JSON.parseObject(result);//返回的json对象
            if(retJson.getIntValue("msgCode") == CSBDemoESSC.SUCCESS){//msgCode=200说明返回成功的
                JSONObject resultJson = retJson.getJSONObject("result");
                String encryptValue = resultJson.getString("encrypt");
                // 打印解密后出参
                logger.info(AESUtils.decrypt(encryptValue, encryptKey));
            }
        } catch (HttpCallerException e) {
            logger.error(e.getMessage());
        }
    }


    public static void main(String[] args) throws Exception{
        CSBDemoESSC _inst=new CSBDemoESSC();
        _inst.v2_sign_valid_encrypt();

    }
}
