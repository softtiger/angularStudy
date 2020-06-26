package self.springcloud.services.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import self.springcloud.domain.ProductCategory;
import self.springcloud.services.IProductCategoryServices;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductCategoryServicesImplTest {

    @Autowired
    IProductCategoryServices productCategoryServices;

    @Test
    public void findProductCategoryByIds() {
        Integer ids[] = {11,22};
        List<Integer> categoryTypesList = Arrays.asList(ids);
        List<ProductCategory> productCategoryList = productCategoryServices.findProductCategoryByIds(categoryTypesList);
        Assert.assertTrue(productCategoryList.size()>0);
    }
}