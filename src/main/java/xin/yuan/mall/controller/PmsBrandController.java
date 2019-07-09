/**
 * FileName: PmsBrandController
 * Author:   knigth
 * 品牌功能controller
 * Date:     2019/7/8 10:27
 * History:
 */
package xin.yuan.mall.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xin.yuan.mall.common.CommonResult;
import xin.yuan.mall.mbg.model.PmsBrand;
import xin.yuan.mall.service.PmsBrandService;

import java.util.List;

@Api(value = "PmsBrandController",description = "商品品牌管理")
@RestController
@RequestMapping("/brand")
public class PmsBrandController {
    @Autowired
    private PmsBrandService brandService;

    @ApiOperation("获取全部品牌列表")
    @RequestMapping(value = "listAll",method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('pms:brand:read')")
    public CommonResult<List<PmsBrand>> getList(){
        List<PmsBrand> pmsBrandList = brandService.listAllBrand();
        return CommonResult.success(pmsBrandList);
    }


}
