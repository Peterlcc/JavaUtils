package com.peter;

import com.peter.bean.OperatorType;
import com.peter.bean.Param;
import com.peter.bean.Result;
import com.peter.bean.ServiceType;
import com.peter.utils.BridgeUtils;
import com.peter.utils.ServiceUtils;
import edu.wpi.rail.jrosbridge.Ros;
import edu.wpi.rail.jrosbridge.Topic;
import edu.wpi.rail.jrosbridge.callback.TopicCallback;
import edu.wpi.rail.jrosbridge.messages.Message;
import lombok.extern.slf4j.Slf4j;

/**
 * @author lcc
 * @date 2020/11/29 下午10:23
 */
@Slf4j
public class App {

    public static void main(String[] args) throws InterruptedException {
        Ros ros = new Ros("localhost");
        ros.connect();

        paramTest(ros);

        ros.disconnect();
    }

    private static void paramTest(Ros ros) {
        //初始化param对象
        Param param = new Param(OperatorType.GET, "mybridge3", ServiceType.STRING, "bridge");

        String requestJson = BridgeUtils.getRequestJson(param);
        log.info(requestJson);

        String response = ServiceUtils.doService(ros, "/param_operation", "param_server/Messsage", requestJson);
        log.info(response);
        Result result = BridgeUtils.getResult(response);
        log.info(result.toString());
    }

    private static void example(Ros ros) {
        Topic echo = new Topic(ros, "/echo", "std_msgs/String");
        Message toSend = new Message("{\"data\": \"hello, world!\"}");
        echo.publish(toSend);

        Topic echoBack = new Topic(ros, "/echo_back", "std_msgs/String");
        echoBack.subscribe(new TopicCallback() {
            @Override
            public void handleMessage(Message message) {
                System.out.println("From ROS: " + message.toString());
            }
        });
    }
}
