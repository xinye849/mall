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
import xin.yuan.mall.dto.OmsOrderDeliveryParam;
import xin.yuan.mall.dto.OmsOrderQueryParam;
import xin.yuan.mall.mbg.mapper.OmsOrderMapper;
import xin.yuan.mall.mbg.model.OmsOrder;
import xin.yuan.mall.mbg.model.OmsOrderExample;
import xin.yuan.mall.mbg.model.OmsOrderOperateHistory;
import xin.yuan.mall.service.OmsOrderService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public int delivery(List<OmsOrderDeliveryParam> deliveryParamList) {
        int count = omsOrderDao.delivery(deliveryParamList);
        return 0;
    }

    @Override
    public int close(List<Long> ids, String note) {
        OmsOrder record = new OmsOrder();
        //4：订单关闭
        record.setStatus(4);
        OmsOrderExample example = new OmsOrderExample();
        example.createCriteria().andDeleteStatusEqualTo(0).andIdIn(ids);
        int count = omsOrderMapper.updateByExampleSelective(record,example);
        ids.stream().map(orderId ->{
            OmsOrderOperateHistory history = new OmsOrderOperateHistory();
            history.setOrderId(orderId);
            history.setCreateTime(new Date());
            history.setOperateMan("后台管理员");
            history.setOrderStatus(4);
            history.setNote("订单关闭:"+note);
            return history;
        }).collect(Collectors.toList());



        return 0;
    }
}
