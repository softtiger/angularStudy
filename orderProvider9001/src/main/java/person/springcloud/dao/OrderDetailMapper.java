package person.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import person.springcloud.domain.OrderDetail;


@Mapper
public interface OrderDetailMapper {
    int deleteByPrimaryKey(String detailId);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(String detailId);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);
}