/**
 * FileName: CmsSubjectController
 * Author:   knight xiong
 * 商品专题控制器
 * Date:     2019/6/13 16:01
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
import xin.yuan.mall.mbg.model.CmsSubject;
import xin.yuan.mall.service.CmsSubjectService;

import java.util.List;

@Controller
@Api(tags = "CmsSubjectController",description = "商品专题管理")
@RequestMapping("/subject")
public class CmsSubjectController {
    @Autowired
    private CmsSubjectService cmsSubjectService;
    @ApiOperation("获取全部商品专题")
    @RequestMapping(value = "/listAll",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<CmsSubject>> listAll(){
        List<CmsSubject> subjectList = cmsSubjectService.listAll();
        return CommonResult.success(subjectList);
    }
}
