package cloud.provider.payment8006.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverport;

    @RequestMapping("/payment/consul")
    public String getPort(){

        return "springcloud with consul:" + serverport + "\t" + UUID.randomUUID().toString();
    }
}
