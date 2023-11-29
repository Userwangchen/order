package cn.ubs.message;


import cn.ubs.POJO.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(Status1In.class)
public class StatusConsumer1 {
    private static final Logger logger = LoggerFactory.getLogger(StatusConsumer1.class);
    //业务调用


    @StreamListener(target = "order-status1-in")
    public void handle(String message) {
        ObjectMapper objectMapper = new ObjectMapper();
        Order order;
        try {
            order = objectMapper.readValue(message, Order.class);
            logger.info("Status111111In order is {}",order.toString());
        } catch (JsonProcessingException e) {
            logger.error("转换对象异常");
            throw new RuntimeException(e);
        }
        //业务调用获取到的kafka信息
    }

}
