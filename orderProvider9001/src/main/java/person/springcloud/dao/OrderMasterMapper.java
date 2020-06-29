package person.springcloud.dao;


import org.apache.ibatis.annotations.Mapper;
import person.springcloud.domain.OrderMaster;

@Mapper
public interface OrderMasterMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(OrderMaster record);

    int insertSelective(OrderMaster record);

    OrderMaster selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(OrderMaster record);

    int updateByPrimaryKey(OrderMaster record);
}