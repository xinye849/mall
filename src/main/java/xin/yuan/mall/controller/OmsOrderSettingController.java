/**
 * FileName: OmsOrderSettingController
 * Author:   knight
 * 订单设置Controller
 * Date:     2019/7/3 15:11
 * History:
 */
package xin.yuan.mall.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xin.yuan.mall.common.CommonResult;
import xin.yuan.mall.mbg.model.OmsOrderSetting;
import xin.yuan.mall.service.OmsOrderSettingService;

@Api(tags = "OmsOrderSettingController", description = "订单设置管理")
@RestController
@RequestMapping("/orderSetting")
public class OmsOrderSettingController {
    @Autowired
    private OmsOrderSettingService orderSettingService;

    @ApiOperation("获取指定订单设置")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CommonResult<OmsOrderSetting> getItem(@PathVariable("id") Long id) {
        OmsOrderSetting orderSetting = orderSettingService.getItem(id);
        return CommonResult.success(orderSetting);

    }

    @ApiOperation("修改指定订单设置")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public CommonResult update(@PathVariable("id") Long id,
                               @RequestBody OmsOrderSetting orderSetting) {
        int count = orderSettingService.update(id, orderSetting);
        if (count > 0) {
            CommonResult.success(count);
        }
        return CommonResult.failed();
    }


}
