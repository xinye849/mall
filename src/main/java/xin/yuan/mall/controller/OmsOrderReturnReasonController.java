/**
 * FileName: OmsOrderReturnReasonController
 * Author:   knight
 * 退货原因管理controller
 * Date:     2019/7/2 16:15
 * History:
 */
package xin.yuan.mall.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.java2d.cmm.kcms.CMM;
import xin.yuan.mall.common.CommonPage;
import xin.yuan.mall.common.CommonResult;
import xin.yuan.mall.mbg.model.OmsOrderReturnReason;
import xin.yuan.mall.service.OmsOrderReturnReasonService;

import java.util.List;

@Api(tags = "OmsOrderReturnReasonController", description = "退货原因管理")
@RestController
@RequestMapping("/returnReason")
public class OmsOrderReturnReasonController {
    @Autowired
    private OmsOrderReturnReasonService orderReturnReasonService;

    @ApiOperation("添加退货原因")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonResult create(OmsOrderReturnReason returnReason) {
        int count = orderReturnReasonService.create(returnReason);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改退货原因")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public CommonResult update(@PathVariable Long id,
                               @RequestBody OmsOrderReturnReason returnReason) {
        int count = orderReturnReasonService.update(id, returnReason);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("批量删除退货原因")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public CommonResult delete(List<Long> ids) {
        int count = orderReturnReasonService.delete(ids);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("分页查询全部退货原因")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult<CommonPage<OmsOrderReturnReason>> list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                               @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        List<OmsOrderReturnReason> reasonList = orderReturnReasonService.list(pageNum, pageSize);
        CommonPage<OmsOrderReturnReason> omsOrderReturnReasonCommonPage = CommonPage.restPage(reasonList);
        return CommonResult.success(omsOrderReturnReasonCommonPage);
    }

    @ApiOperation("获取单个退货原因详情信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CommonResult<OmsOrderReturnReason> getItem(Long id) {
        OmsOrderReturnReason reason = orderReturnReasonService.getItem(id);
        return CommonResult.success(reason);
    }

    @ApiOperation("修改退货原因启用状态")
    @RequestMapping(value = "/update/status", method = RequestMethod.POST)
    public CommonResult updateStatus(@RequestParam("status") Integer status,
                                     @RequestParam("ids") List<Long> ids) {
        int count = orderReturnReasonService.updateStatus(status, ids);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();

    }


}
