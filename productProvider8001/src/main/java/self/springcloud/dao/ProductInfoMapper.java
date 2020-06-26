package self.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import self.springcloud.domain.ProductInfo;

import java.util.List;

@Mapper
public interface ProductInfoMapper {
    int deleteByPrimaryKey(String productId);

    int insert(ProductInfo record);

    int insertSelective(ProductInfo record);

    ProductInfo selectByPrimaryKey(String productId);

    int updateByPrimaryKeySelective(ProductInfo record);

    int updateByPrimaryKey(ProductInfo record);

    List<ProductInfo> findByProductStatus(Integer productStatus);
}