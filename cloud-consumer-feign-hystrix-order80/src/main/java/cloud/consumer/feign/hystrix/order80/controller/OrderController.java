package cloud.consumer.feign.hystrix.order80.controller;

import cloud.consumer.feign.hystrix.order80.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@DefaultProperties(defaultFallback = "default_Global_Fallback")
public class OrderController {

    @Autowired
    PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/hystrix/ok/{id}")
    public String orderInfo_OK(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentInfo_OK(id);
    }

    @GetMapping("/consumer/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "orderInfo_TimeOutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "8000")
//    })
    @HystrixCommand
    public String orderInfo_TimeOut(@PathVariable("id") Integer id){
//        int a = 1/0;
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }

    public String orderInfo_TimeOutHandler(@PathVariable("id") Integer id){
        return "我是消费者80,对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
    }

    public String default_Global_Fallback(){
        return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
    }
}
