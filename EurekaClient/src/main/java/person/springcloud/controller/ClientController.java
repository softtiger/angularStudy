package person.springcloud.controller;

import com.infras.ResultJSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {

    @Autowired
    private RestTemplate restTemplate;

    private String url = "http://localhost:8001/product/list";

    @RequestMapping("/product/list")
    public ResultJSONObject onlineProductList(){
             return restTemplate.getForObject(url, ResultJSONObject.class);
    }
}