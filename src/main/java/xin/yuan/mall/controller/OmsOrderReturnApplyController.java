/**
 * FileName: OmsOrderReturnApplyController
 * Author:   knight
 * 订单退货申请管理
 * Date:     2019/7/2 9:38
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
import xin.yuan.mall.dto.OmsOrderReturnApplyResult;
import xin.yuan.mall.dto.OmsReturnApplyQueryParam;
import xin.yuan.mall.dto.OmsUpdateStatusParam;
import xin.yuan.mall.mbg.model.OmsOrderReturnApply;
import xin.yuan.mall.service.OmsOrderReturnApplyService;

import java.util.List;

@Api(tags = "OmsOrderReturnApplyController", description = "订单退货申请")
@Controller
@RequestMapping("/returnApply")
public class OmsOrderReturnApplyController {
    @Autowired
    private OmsOrderReturnApplyService returnApplyService;

    @ApiOperation("分页查询退货申请")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<OmsOrderReturnApply>> list(OmsReturnApplyQueryParam queryParam,
                                                              @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                              @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<OmsOrderReturnApply> returnApplyList = returnApplyService.list(queryParam, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(returnApplyList));
    }

    @ApiOperation("批量删除申请")
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = returnApplyService.delete(ids);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取退货申请详情--此功能尚未实现")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getIem(@PathVariable Long id) {
        OmsOrderReturnApplyResult result = returnApplyService.getItem(id);
        return CommonResult.success(result);
    }

    @ApiOperation("修改申请状态")
    @RequestMapping(value = "/update/status/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateStatus(@PathVariable Long id,
                                     @RequestBody OmsUpdateStatusParam statusParam) {
        int count = returnApplyService.updateStatus(id, statusParam);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }
}
