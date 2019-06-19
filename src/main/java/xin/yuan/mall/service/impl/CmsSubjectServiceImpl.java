/**
 * FileName: CmsSubjectServiceImpl
 * Author:   knight xiong
 * 商品专题实现类
 * Date:     2019/6/13 16:10
 * History:
 */
package xin.yuan.mall.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
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

    @Override
    public List<CmsSubject> list(String keyWord, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        CmsSubjectExample example = new CmsSubjectExample();
        CmsSubjectExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(keyWord)){
            criteria.andTitleLike("%" + keyWord+ "%");
        }
        return cmsSubjectMapper.selectByExample(example);
    }
}
