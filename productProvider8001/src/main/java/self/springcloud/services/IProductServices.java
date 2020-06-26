package self.springcloud.services;

import self.springcloud.domain.ProductInfo;

import java.util.List;

public interface IProductServices {
    List<ProductInfo> findUpAll();
}
