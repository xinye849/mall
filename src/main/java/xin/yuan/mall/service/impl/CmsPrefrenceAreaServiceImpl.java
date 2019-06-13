/**
 * FileName: CmsPrefrenceAreaServiceImpl
 * Author:   Dragon
 * Date:     2019/6/13 9:27
 * History:
 */
package xin.yuan.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.yuan.mall.mbg.mapper.CmsPrefrenceAreaMapper;
import xin.yuan.mall.mbg.model.CmsPrefrenceArea;
import xin.yuan.mall.mbg.model.CmsPrefrenceAreaExample;
import xin.yuan.mall.service.CmsPrefrenceAreaService;

import java.util.List;

/**
 * 商品优选service实现类
 * 2019/6/13
 *author: knight Xiong
 */
@Service
public class CmsPrefrenceAreaServiceImpl implements CmsPrefrenceAreaService {
    @Autowired
    private CmsPrefrenceAreaMapper prefrenceAreaMapper;
    @Override
    public List<CmsPrefrenceArea> listAll() {
        return prefrenceAreaMapper.selectByExample(new CmsPrefrenceAreaExample());
    }
}
