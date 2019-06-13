/**
 * FileName: CmsPrefrenceAreaController
 * Author:   Dragon
 * Date:     2019/6/12 17:09
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
import xin.yuan.mall.mbg.model.CmsPrefrenceArea;
import xin.yuan.mall.service.CmsPrefrenceAreaService;

import java.util.List;

@Controller
@Api(tags = "CmsPrefrenceAreaController",description = "商品优选管理")
@RequestMapping("/prefrenceArea")
public class CmsPrefrenceAreaController {
    @Autowired
    private CmsPrefrenceAreaService prefrenceAreaService;

    @ApiOperation("获取所有商品优选")
    @RequestMapping(value ="/listAll",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<CmsPrefrenceArea>> listAll(){
        List<CmsPrefrenceArea> prefrenceAreaList = prefrenceAreaService.listAll();

        return CommonResult.success(prefrenceAreaList);
    }



}
