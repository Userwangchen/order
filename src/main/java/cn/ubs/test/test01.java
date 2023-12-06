package cn.ubs.test;

import cn.ubs.service.FunctionA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.util.HashMap;

public class test01 {

    {

    }

    private Logger logger = LoggerFactory.getLogger(test01.class);

    public void jedisMethod(){
        Jedis jedis = new Jedis("192.168.2.2",6379);
        //2.设置密码
        /*jedis.auth("1234");*/
        //3.选择库
        jedis.select(0);

        String secCde = "882358";
        String year = "2022";
        String bussnessId = secCde + year;
        Long setnx = jedis.setnx(bussnessId, "value");
        logger.info("add result setnx is {}",setnx);
        String s = jedis.get(bussnessId);
        logger.info("query result is {}",s);
    }

    public void method01(){
        FunctionA aa = new FunctionA(){
            @Override
            public void getA(){
                logger.info("zhangsan");
            }
        };
    }

    public static void main(String[] args) {

        HashMap<String, String> map2 = new HashMap() {
            {
                put("A",1);
            }
        };
    }


}
