package cn.ubs.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ReportOut {


    @Output("order-publish-out") //这个地方得和配置文件中的对应起来
    MessageChannel sendTodo();

}
