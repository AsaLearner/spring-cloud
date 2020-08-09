package cloud.consumerzk.order.controller;

import com.study.cloud.entities.CommonResult;
import com.study.cloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    public static final String PAYMENT_URL = "http://cloud-provider-payment";

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/consumer/zk")
    public String getPayment(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/zk",String.class);
    }
}
