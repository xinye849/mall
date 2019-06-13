/**
 * FileName: CmsSubjectServiceImpl
 * Author:   knight xiong
 * 商品专题实现类
 * Date:     2019/6/13 16:10
 * History:
 */
package xin.yuan.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.yuan.mall.mbg.mapper.CmsSubjectMapper;
import xin.yuan.mall.mbg.model.CmsSubject;
import xin.yuan.mall.mbg.model.CmsSubjectExample;
import xin.yuan.mall.service.CmsSubjectService;

import java.util.List;
@Service
public class CmsSubjectServiceImpl implements CmsSubjectService {
    @Autowired
    private CmsSubjectMapper cmsSubjectMapper;

    @Override
    public List<CmsSubject> listAll() {
        return cmsSubjectMapper.selectByExample(new CmsSubjectExample());
    }
}
