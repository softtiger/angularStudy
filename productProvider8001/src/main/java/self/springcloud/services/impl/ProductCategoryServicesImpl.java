package self.springcloud.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import self.springcloud.dao.ProductCategoryMapper;
import self.springcloud.domain.ProductCategory;
import self.springcloud.services.IProductCategoryServices;

import java.util.List;

@Service
public class ProductCategoryServicesImpl implements IProductCategoryServices {

    @Autowired
    private ProductCategoryMapper ProductCategoryDao;

    @Override
    public List<ProductCategory> findProductCategoryByIds(List<Integer> ids) {
        return ProductCategoryDao.findCategoryTypeIn(ids);
    }
}
