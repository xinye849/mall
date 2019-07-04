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
import xin.yuan.mall.dto.*;
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

    @ApiOperation("批量关闭订单")
    @RequestMapping(value = "/update/close", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult close(@RequestParam("ids") List<Long> ids,
                              @RequestParam("note") String note) {
        int count = omsOrderService.close(ids, note);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();

    }

    @ApiOperation("批量删除订单")
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = omsOrderService.delete(ids);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取订单详情:订单信息、商品信息、操作记录--进度问题，此功能暂时无法实现")
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CommonResult<OmsOrderDetail> detail(@PathVariable Long id) {
        OmsOrderDetail orderDetailResult = omsOrderService.detail(id);
        return CommonResult.success(orderDetailResult);
    }

    @ApiOperation("修改收货人信息")
    @RequestMapping(value = "/update/receiverInfo", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateReceiverInfo(@RequestBody OmsReceiverInfoParam receiverInfoParam) {
        int count = omsOrderService.updateReceiverInfo(receiverInfoParam);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改订单费用信息")
    @RequestMapping(value = "/update/moneyInfo", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateReceiverInfo(@RequestBody OmsMoneyInfoParam moneyInfoParam) {
        int count = omsOrderService.updateMoneyInfo(moneyInfoParam);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("备注订单")
    @RequestMapping(value = "/update/note", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateNote(@RequestParam("id") Long id,
                                   @RequestParam("note") String note,
                                   @RequestParam("status") Integer status) {
        int count = omsOrderService.updateNote(id, note, status);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

}
