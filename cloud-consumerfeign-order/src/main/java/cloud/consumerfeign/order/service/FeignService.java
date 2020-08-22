package cloud.consumerfeign.order.service;

import com.study.cloud.entities.CommonResult;
import com.study.cloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import feign.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVER")
public interface FeignService {

    @PostMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment);

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getById(@PathVariable("id")  Long id);
}

