/**
 * FileName: OmsOrderReturnReasonServiceImpl
 * Author:   Dragon
 * Date:     2019/7/2 16:48
 * History:
 */
package xin.yuan.mall.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.yuan.mall.mbg.mapper.OmsOrderReturnReasonMapper;
import xin.yuan.mall.mbg.model.OmsOrderReturnReason;
import xin.yuan.mall.mbg.model.OmsOrderReturnReasonExample;
import xin.yuan.mall.service.OmsOrderReturnReasonService;

import java.util.Date;
import java.util.List;

@Service
public class OmsOrderReturnReasonServiceImpl implements OmsOrderReturnReasonService {
    @Autowired
    private OmsOrderReturnReasonMapper orderReturnReasonMapper;

    @Override
    public int create(OmsOrderReturnReason returnReason) {
        returnReason.setCreateTime(new Date());
        return orderReturnReasonMapper.insert(returnReason);
    }

    @Override
    public int update(Long id, OmsOrderReturnReason returnReason) {
        returnReason.setId(id);
        return orderReturnReasonMapper.updateByPrimaryKey(returnReason);
    }

    @Override
    public int delete(List<Long> ids) {
        OmsOrderReturnReasonExample example = new OmsOrderReturnReasonExample();
        example.createCriteria().andIdIn(ids);
        return orderReturnReasonMapper.deleteByExample(example);

    }

    @Override
    public List<OmsOrderReturnReason> list(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        OmsOrderReturnReasonExample example = new OmsOrderReturnReasonExample();
        example.setOrderByClause("sort desc");
        return orderReturnReasonMapper.selectByExample(example);
    }

    @Override
    public OmsOrderReturnReason getItem(Long id) {
        return orderReturnReasonMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateStatus(Integer status, List<Long> ids) {
        if (!status.equals(0) && !status.equals(1)) {
            return 0;
        }
        OmsOrderReturnReason reason = new OmsOrderReturnReason();
        reason.setStatus(status);
        OmsOrderReturnReasonExample example = new OmsOrderReturnReasonExample();
        example.createCriteria().andIdIn(ids);
        return orderReturnReasonMapper.updateByExampleSelective(reason, example);
    }
}
