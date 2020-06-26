package self.springcloud.controller;

import com.infras.RespCode;
import com.infras.ResultJSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import self.springcloud.domain.ProductCategory;
import self.springcloud.domain.ProductInfo;
import self.springcloud.services.IProductCategoryServices;
import self.springcloud.services.IProductServices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductServices productServices;

    @Autowired
    private IProductCategoryServices productCategoryServices;

    @GetMapping("/list")
    public ResultJSONObject list() {
        ResultJSONObject result = new ResultJSONObject(RespCode.SUCCESS);

        List<ProductInfo> productInfoList = productServices.findUpAll();
        List<Integer> categoryTypeList = productInfoList.stream().map(item -> item.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> categoryList = productCategoryServices.findProductCategoryByIds(categoryTypeList);

        for(ProductCategory category:categoryList){
            Map<String,Object> categoryAndProductMap = new HashMap<String,Object>();
            categoryAndProductMap.put("name",category.getCategoryName());
            categoryAndProductMap.put("type",category.getCategoryType());
            List foods = new ArrayList();
            for(ProductInfo productInfo:productInfoList){
                    if(productInfo.getCategoryType().equals(category.getCategoryType())){
                        foods.add(productInfo);
                }
            }
            categoryAndProductMap.put("foods",foods);
            result.getData().add(categoryAndProductMap);
        }
        return result;
    }
}
