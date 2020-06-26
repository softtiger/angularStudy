package self.springcloud.services;

import self.springcloud.domain.ProductCategory;

import java.util.List;

public interface IProductCategoryServices {
        List<ProductCategory>  findProductCategoryByIds(List<Integer> ids);
}
