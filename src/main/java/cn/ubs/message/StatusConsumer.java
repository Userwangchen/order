package cn.ubs.message;


import cn.ubs.POJO.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.support.json.Jackson2JsonObjectMapper;

@EnableBinding(StatusIn.class)
public class StatusConsumer {
    private static final Logger logger = LoggerFactory.getLogger(StatusConsumer.class);
    //业务调用


    @StreamListener(target = "order-status-in")
    public void handle(String message) {
        ObjectMapper objectMapper = new ObjectMapper();
        Order order;
        try {
            order = objectMapper.readValue(message, Order.class);
            logger.info("StatusIn order is {}",order.toString());
        } catch (JsonProcessingException e) {
            logger.error("转换对象异常");
            throw new RuntimeException(e);
        }
        //业务调用获取到的kafka信息
    }

}
