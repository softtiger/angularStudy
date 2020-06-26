package self.springcloud.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import self.springcloud.domain.ProductInfo;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductServicesImplTest {

    @Autowired
    IProductServices productServices;

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoList = productServices.findUpAll();
        Assert.assertTrue(productInfoList.size() > 0);
        System.out.println(productInfoList.get(0).getProductName());
    }
}