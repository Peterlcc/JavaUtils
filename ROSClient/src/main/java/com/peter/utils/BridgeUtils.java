package com.peter.utils;

import com.alibaba.fastjson.JSONObject;
import com.peter.bean.Param;
import com.peter.bean.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @author lcc
 * @date 2020/12/3 下午2:51
 */
public class BridgeUtils {
    /**
     * 根据param生成请求json
     * @param param
     * @return
     */
    public static String getRequestJson(Param param){
        JSONObject request = new JSONObject();
        request.put("request",JSONObject.toJSONString(param));
        return request.toJSONString();
    }

    /**
     * 根据json解析result对象
     * @param resultJson
     * @return
     */
    public static Result getResult(String resultJson){
        resultJson= StringUtils.replace(resultJson,"\\n","");
        Result result = JSONObject.parseObject(resultJson, Result.class);
        return result;
    }
}
