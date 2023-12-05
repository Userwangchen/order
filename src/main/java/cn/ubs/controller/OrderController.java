package cn.ubs.controller;


import cn.ubs.POJO.Order;
import cn.ubs.POJO.Tbuser;
import cn.ubs.mapper.TbuserMapper;
import cn.ubs.message.ReportProducer;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final static Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private ReportProducer producer;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    TbuserMapper tbuserMapper;

    @GetMapping("/getAll")
    public List<String> getAll(){
        List<String> list = new ArrayList<>();
        list.add("order1");
        list.add("order2");
        list.add("order3");
        list.add("order4");
        return list;
    }

    @GetMapping("/getTbUserById")
    public void getTbUserById(Long id){
        Tbuser tbuser = tbuserMapper.selectByPrimaryKey(id);
        logger.info("tbUser is {}", JSON.toJSONString(tbuser));
    }

    /*
        测试redis中字符串是否一致问题
     */
    @GetMapping("getRedisResult")
    public void getRedisResult(){
        String secCde = "882358";
        String year = "2022";
        String bussnessId = secCde + year;
        Boolean vaaa = redisTemplate.opsForValue().setIfAbsent(bussnessId, "vaaa", 30L, TimeUnit.SECONDS);
        boolean aNull = Objects.isNull(vaaa ? false : vaaa);
        logger.info("result is {}",aNull);
    }


    @GetMapping("sendMessage")
    public boolean sendMessage(Order order){
        return producer.send(order);

    }


    public static void main(String[] args) {


        List<String> ids = new ArrayList<>();
        ids.add("1");
        ids.add("2");
        ids.add("3");
        ids.add("4");


        System.out.println(ids);


    }

}
