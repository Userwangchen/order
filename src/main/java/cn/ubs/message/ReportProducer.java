package cn.ubs.message;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(ReportOut.class)
public class ReportProducer {

    @Autowired
    private ReportOut todoOut;

    public boolean send(Object message) {
        boolean flag;

        try {
            flag = todoOut.sendTodo().send(MessageBuilder.withPayload(message).build());
        } catch (Exception e) {
            flag = false;
            throw new RuntimeException(e);
        }

        return flag;
    }

}
