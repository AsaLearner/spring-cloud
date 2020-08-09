package cloud.provider.payment8001.controller;

import cloud.provider.payment8001.service.PaymentService;
import com.study.cloud.entities.CommonResult;
import com.study.cloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    /**
     * 服务发现 获取服务信息
     */
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        CommonResult<Payment> commonResult = paymentService.insert(payment);
        log.info("------插入成功!----");
        return commonResult;
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<List<Payment>> getById(@PathVariable Long id){
        Payment payment = new Payment(id,null);
        return paymentService.getByid(payment);
    }

    /**
     * 服务发现
     *
     * @return
     */
    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("*****element:" + element);
        }
        // 一个微服务下的全部实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVER");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }


    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            // 暂停3秒钟
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

}
