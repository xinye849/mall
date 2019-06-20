/**
 * FileName: OmsOrderController
 * Author:   knight xiong
 * 订单管理
 * Date:     2019/6/14 14:17
 * History:
 */
package xin.yuan.mall.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xin.yuan.mall.common.CommonPage;
import xin.yuan.mall.common.CommonResult;
import xin.yuan.mall.dto.OmsOrderDeliveryParam;
import xin.yuan.mall.dto.OmsOrderQueryParam;
import xin.yuan.mall.mbg.model.OmsOrder;
import xin.yuan.mall.service.OmsOrderService;

import java.util.List;

@Controller
@Api(tags = "OmsOrderController", description = "订单管理")
@RequestMapping("/order")
public class OmsOrderController {
    @Autowired
    private OmsOrderService omsOrderService;

    @ApiOperation("查询订单")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<OmsOrder>> list(OmsOrderQueryParam queryParam,
                                                   @RequestParam(value = "pageSize", defaultValue
                                                           = "5") Integer pageSize,
                                                   @RequestParam(value = "pageNum", defaultValue =
                                                           "1") Integer pageNum
    ) {
        List<OmsOrder> orderList = omsOrderService.list(queryParam, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(orderList));

    }

    @ApiOperation("批量发货(此接口因技术问题尚未打通)")
    @ResponseBody
    @RequestMapping(value = "/update/delivery", method = RequestMethod.POST)
    public CommonResult delivery(@RequestBody List<OmsOrderDeliveryParam> deliveryParamList) {
        int count = omsOrderService.delivery(deliveryParamList);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();

    }


    public CommonResult close(@RequestParam("ids") List<Long> ids,
                              @RequestParam("note") String note ){
        int count = omsOrderService.close(ids,note);
        if (count>0){
            return CommonResult.success(count);
        }
        return CommonResult.failed();

    }

}
