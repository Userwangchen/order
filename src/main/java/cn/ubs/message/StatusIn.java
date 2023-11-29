package cn.ubs.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface StatusIn {
    @Input("order-status-in")
    SubscribableChannel receiveStatus();

}
