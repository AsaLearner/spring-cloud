package cloud.provider.payment8002.service;

import cloud.provider.payment8002.dao.PaymentDao;
import com.study.cloud.entities.CommonResult;
import com.study.cloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    PaymentDao paymentDao;

    @Value("${server.port}")
    private String serverPort;

    @Override
    public CommonResult<List<Payment>> getByid(Payment payment) {
        Payment payments = paymentDao.selectById(payment);
        return new CommonResult(200,"----数据查询成功!---"+serverPort,payments);
    }

    @Override
    public CommonResult<Payment> insert(Payment payment) {
        int insert = paymentDao.insert(payment);
        if(insert>0){
            return new CommonResult(200,"----插入数据成功!---"+serverPort,payment);
        }else {
            return new CommonResult(500,"----插入数据失败!---"+serverPort,null);
        }

    }

    @Override
    public CommonResult<List<Payment>> queryLikeBySerial(String serial) {
        List<Payment> payments = paymentDao.queryLikeByserial(serial);

        return new CommonResult(200,"----数据查询成功!---"+serverPort,payments);
    }
}
