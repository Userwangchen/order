package cn.ubs.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Status1In {
    @Input("order-status1-in")
    SubscribableChannel receiveStatus();

}
