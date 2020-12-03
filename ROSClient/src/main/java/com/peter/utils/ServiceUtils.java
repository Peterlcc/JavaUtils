package com.peter.utils;

import edu.wpi.rail.jrosbridge.Ros;
import edu.wpi.rail.jrosbridge.Service;
import edu.wpi.rail.jrosbridge.services.ServiceRequest;
import edu.wpi.rail.jrosbridge.services.ServiceResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * @author lcc
 * @date 2020/12/3 下午2:53
 */
public class ServiceUtils {
    /**
     * 服务请求的工具类
     * @param ros ros连接
     * @param serviceName 服务名称
     * @param serviceType srv类型
     * @param requestJson 请求的json
     * @return 响应的字符串
     */
    public static String doService(Ros ros,String serviceName,String serviceType,String requestJson){
        Service service = new Service(ros, serviceName,serviceType);
        ServiceRequest req = new ServiceRequest(requestJson);
        ServiceResponse response = service.callServiceAndWait(req);
        return response.toString();
    }
}
