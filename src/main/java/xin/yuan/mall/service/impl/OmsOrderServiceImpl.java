/**
 * FileName: OmsOrderServiceImpl
 * Author:   knigth xiong
 * 订单管理实现类
 * Date:     2019/6/14 14:57
 * History:
 */
package xin.yuan.mall.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.yuan.mall.dao.OmsOrderDao;
import xin.yuan.mall.dto.OmsOrderQueryParam;
import xin.yuan.mall.mbg.mapper.OmsOrderMapper;
import xin.yuan.mall.mbg.model.OmsOrder;
import xin.yuan.mall.mbg.model.OmsOrderExample;
import xin.yuan.mall.service.OmsOrderService;

import java.util.List;

@Service
public class OmsOrderServiceImpl implements OmsOrderService {
    @Autowired
    private OmsOrderMapper omsOrderMapper;
    @Autowired
    private OmsOrderDao omsOrderDao;
    @Override
    public List<OmsOrder> list(OmsOrderQueryParam queryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return omsOrderDao.getList(queryParam);
    }
}
