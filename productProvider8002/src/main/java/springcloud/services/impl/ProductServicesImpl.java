package self.springcloud.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import self.springcloud.dao.ProductInfoMapper;
import self.springcloud.domain.ProductInfo;
import self.springcloud.domain.ProductStatusEnum;
import self.springcloud.services.IProductServices;

import java.util.List;

@Service
public class ProductServicesImpl implements IProductServices {

    @Autowired
    ProductInfoMapper productInfoDao;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoDao.findByProductStatus(ProductStatusEnum.UP.getCode());
    }
}
