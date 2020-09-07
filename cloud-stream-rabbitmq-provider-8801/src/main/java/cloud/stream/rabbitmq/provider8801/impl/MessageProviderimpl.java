package cloud.stream.rabbitmq.provider8801.impl;

import cloud.stream.rabbitmq.provider8801.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

@EnableBinding(Source.class)
public class MessageProviderimpl implements IMessageProvider {

    @Autowired
    private MessageChannel output;


    @Override
    public String send() {

        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("------serial:"+serial);
        return serial;
    }
}
