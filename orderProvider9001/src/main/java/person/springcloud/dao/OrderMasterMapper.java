package self.springcloud.dao;

import self.springcloud.domain.orderMaster;

public interface orderMasterMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(orderMaster record);

    int insertSelective(orderMaster record);

    orderMaster selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(orderMaster record);

    int updateByPrimaryKey(orderMaster record);
}