package cloud.stream.rabbitmq.provider8801.controller;

import cloud.stream.rabbitmq.provider8801.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private IMessageProvider provider;

    @GetMapping("/send")
    public String send(){
        return provider.send();
    }
}
