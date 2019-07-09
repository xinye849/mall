/**
 * FileName: OssController
 * Author:   knight
 * oss操作controller
 * Date:     2019/7/5 9:31
 * History:
 */
package xin.yuan.mall.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xin.yuan.mall.common.CommonResult;
import xin.yuan.mall.dto.OssCallbackResult;
import xin.yuan.mall.dto.OssPolicyResult;
import xin.yuan.mall.service.OssService;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "OssController", description = "oss管理")
@RestController
@RequestMapping("/aliyun/oss")
public class OssController {
    @Autowired
    private OssService ossService;

    @ApiOperation("oss上传签名生成")
    @RequestMapping(value = "/policy", method = RequestMethod.GET)
    public CommonResult<OssPolicyResult> policy() {
        OssPolicyResult result = ossService.policy();
        return CommonResult.success(result);
    }

    @ApiOperation("上传成功回调")
    @RequestMapping(value = "callBack", method = RequestMethod.POST)
    public CommonResult<OssCallbackResult> callBack(HttpServletRequest request) {
        OssCallbackResult ossCallbackResult = ossService.callBack(request);
        return CommonResult.success(ossCallbackResult);
    }
}
