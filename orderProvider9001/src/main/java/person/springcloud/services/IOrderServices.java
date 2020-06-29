package person.springcloud.services;

import person.springcloud.domain.OrderDetail;
import person.springcloud.domain.OrderMaster;

import java.util.List;

public interface IOrderServices {
    public int addOrder(OrderMaster orderMaster, List<OrderDetail> orderDetailList);
}
