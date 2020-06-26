package person.springcloud.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.springcloud.dao.OrderDetailMapper;
import person.springcloud.dao.OrderMasterMapper;
import person.springcloud.domain.OrderDetail;
import person.springcloud.domain.OrderMaster;
import person.springcloud.domain.OrderStatus;
import person.springcloud.domain.PayStatus;
import person.springcloud.services.IOrderServices;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class IOrderServicesImpl implements IOrderServices {

    @Autowired
    private OrderMasterMapper orderMasterDao;
    @Autowired
    private OrderDetailMapper orderDetailDao;

    @Override
    public int addOrder(OrderMaster orderMaster, List<OrderDetail> orderDetailList) {

        //订单入库
        orderMaster.setOrderStatus(OrderStatus.NEW.getCode());
        orderMaster.setPayStatus(PayStatus.UNPAID.getCode());
        orderMaster.setOrderId(UUID.randomUUID().toString());
        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMasterDao.insertSelective(orderMaster);

  /*      for(OrderDetail orderDetail:orderDetailList){
             orderDetail.setOrderId(orderMaster.getOrderId());
             orderDetailDao.insertSelective(orderDetail);
        }*/
        return 0;
    }
}
