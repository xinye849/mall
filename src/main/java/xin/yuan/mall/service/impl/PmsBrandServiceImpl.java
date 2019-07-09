/**
 * FileName: PmsBrandServiceImpl
 * Author:   knight
 * 商品品牌service实现类
 * Date:     2019/7/8 10:36
 * History:
 */
package xin.yuan.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.yuan.mall.mbg.mapper.PmsBrandMapper;
import xin.yuan.mall.mbg.model.PmsBrand;
import xin.yuan.mall.mbg.model.PmsBrandExample;
import xin.yuan.mall.service.PmsBrandService;

import java.util.List;

@Service
public class PmsBrandServiceImpl implements PmsBrandService {
    @Autowired
    private PmsBrandMapper brandMapper;

    @Override
    public List<PmsBrand> listAllBrand() {
        PmsBrandExample example = new PmsBrandExample();
        List<PmsBrand> pmsBrandList = brandMapper.selectByExample(example);
        return pmsBrandList;
    }
}
