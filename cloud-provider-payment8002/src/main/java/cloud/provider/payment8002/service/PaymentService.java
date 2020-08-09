package cloud.provider.payment8002.service;

import com.study.cloud.entities.CommonResult;
import com.study.cloud.entities.Payment;

import java.util.List;

public interface PaymentService {

    CommonResult<List<Payment>> getByid(Payment payment);

    CommonResult<Payment> insert(Payment payment);

    CommonResult<List<Payment>> queryLikeBySerial(String serial);
}
