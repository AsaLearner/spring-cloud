package cloud.consumerfeign.order.controller;

import cloud.consumerfeign.order.service.FeignService;
import com.study.cloud.entities.CommonResult;
import com.study.cloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class FeignController {


    @Autowired
    private FeignService feignService;
//
    @PostMapping("/consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        return feignService.create(payment);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable Long id){
        return feignService.getById(id);
    }
}
