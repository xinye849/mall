/**
 * FileName: OmsCompanyAddressController
 * Author:   knight xiong
 * 收货地址管理
 * Date:     2019/6/14 13:44
 * History:
 */
package xin.yuan.mall.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xin.yuan.mall.common.CommonResult;
import xin.yuan.mall.mbg.model.OmsCompanyAddress;
import xin.yuan.mall.service.OmsCompanyAddressService;

import java.util.List;

@Controller
@Api(tags = "OmsCompanyAddressController",description = "收货地址管理")
@RequestMapping(value = "/companyAddress")
public class OmsCompanyAddressController {
    @Autowired
    private OmsCompanyAddressService omsCompanyAddressService;

    @ApiOperation("获取所有收货地址")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<OmsCompanyAddress>> list(){
        List<OmsCompanyAddress> companyAddressesList = omsCompanyAddressService.list();
        return CommonResult.success(companyAddressesList);
    }
}
