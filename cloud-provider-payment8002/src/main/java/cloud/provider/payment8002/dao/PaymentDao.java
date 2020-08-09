package cloud.provider.payment8002.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.cloud.entities.Payment;

import java.util.List;

public interface PaymentDao extends BaseMapper<Payment> {

    List<Payment> queryLikeByserial(String serial);
}
