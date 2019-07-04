/**
 * FileName: OmsOrderReturnApplyServiceImpl
 * Author:   knight
 * 订单退货管理
 * Date:     2019/7/2 10:27
 * History:
 */
package xin.yuan.mall.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.yuan.mall.dao.OmsOrderReturnApplyDao;
import xin.yuan.mall.dto.OmsOrderReturnApplyResult;
import xin.yuan.mall.dto.OmsReturnApplyQueryParam;
import xin.yuan.mall.dto.OmsUpdateStatusParam;
import xin.yuan.mall.mbg.mapper.OmsOrderReturnApplyMapper;
import xin.yuan.mall.mbg.model.OmsOrderReturnApply;
import xin.yuan.mall.mbg.model.OmsOrderReturnApplyExample;
import xin.yuan.mall.service.OmsOrderReturnApplyService;

import java.util.Date;
import java.util.List;

@Service
public class OmsOrderReturnApplyServiceImpl implements OmsOrderReturnApplyService {
    @Autowired
    private OmsOrderReturnApplyDao returnApplyDao;
    @Autowired
    private OmsOrderReturnApplyMapper returnApplyMapper;


    @Override
    public List<OmsOrderReturnApply> list(OmsReturnApplyQueryParam queryParam, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return returnApplyDao.getList(queryParam);
    }

    @Override
    public int delete(List<Long> ids) {
        OmsOrderReturnApplyExample example = new OmsOrderReturnApplyExample();
        example.createCriteria().andIdIn(ids).andStatusEqualTo(3);
        return returnApplyMapper.deleteByExample(example);
    }

    @Override
    public OmsOrderReturnApplyResult getItem(Long id) {

        return  returnApplyDao.getDetail(id);
    }

    @Override
    public int updateStatus(Long id, OmsUpdateStatusParam statusParam) {
        Integer status = statusParam.getStatus();
        OmsOrderReturnApply returnApply = new OmsOrderReturnApply();
        //确认退货
        if (status.equals(1)){
            returnApply.setId(id);
            returnApply.setStatus(1);
            returnApply.setReturnAmount(statusParam.getReturnAmount());
            returnApply.setCompanyAddressId(statusParam.getCompanyAddressId());
            returnApply.setHandleTime(new Date());
            returnApply.setHandleMan(statusParam.getHandleMan());
            returnApply.setHandleNote(statusParam.getHandleNote());
            //完成退货
        }else if (status.equals(2)){
            returnApply.setId(id);
            returnApply.setStatus(2);
            returnApply.setReceiveTime(new Date());
            returnApply.setReceiveMan(statusParam.getReceiveMan());
            returnApply.setReceiveNote(statusParam.getReceiveNote());
            //拒绝退货
        }else if(status.equals(3)){
            returnApply.setHandleTime(new Date());
            returnApply.setHandleMan(statusParam.getHandleMan());
            returnApply.setHandleNote(statusParam.getHandleNote());
        }else{
            return 0;
        }
        return returnApplyMapper.updateByPrimaryKeySelective(returnApply);
        }

}
