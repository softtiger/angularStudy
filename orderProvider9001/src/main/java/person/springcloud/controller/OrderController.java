package person.springcloud.controller;

import com.alibaba.fastjson.JSONObject;
import com.infras.RespCode;
import com.infras.ResultJSONObject;
import com.netflix.discovery.converters.Auto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import person.springcloud.domain.OrderDetail;
import person.springcloud.domain.OrderMaster;
import person.springcloud.form.OrderForm;
import person.springcloud.services.IOrderServices;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderServices orderServices;

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);




    @PostMapping("/create")
    public ResultJSONObject save(@Valid OrderForm orderForm, BindingResult bindingResult) {

        ResultJSONObject result = new ResultJSONObject(RespCode.SUCCESS);
        if (bindingResult.hasErrors()) {
            result = new ResultJSONObject(RespCode.PARAM_ERROR);
            result.setMessage(bindingResult.getFieldError().getDefaultMessage());
            return result;
        }

        //从orderForm 生成OrderMaster
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setBuyerName(orderForm.getName());
        orderMaster.setBuyerPhone(orderForm.getPhone());
        orderMaster.setBuyerAddress(orderForm.getAddress());
        orderMaster.setBuyerOpenid(orderForm.getOpenid());


        //从orderForm 中生成orderDetail
        List<OrderDetail> orderDetails = null;
        try {
            orderDetails = JSONObject.parseArray(orderForm.getItems(), OrderDetail.class);
            if (orderDetails == null){
                 return new ResultJSONObject(RespCode.PARAM_ERROR,"购物车为空");
            }
        } catch (Exception e) {
            logger.error("请求中的订单详情不正确,请求内容，{} 错误：{}", orderForm.getItems(), e.getMessage(), e);
            return new ResultJSONObject(RespCode.PARAM_ERROR,"购物车订单详情不正确");
        }

        orderServices.addOrder(orderMaster,orderDetails);

        return result;
    }


}
