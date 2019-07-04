/**
 * FileName: OmsorderSettingServiceImpl
 * Author:   knight
 * 订单设置管理service实现类
 * Date:     2019/7/4 9:32
 * History:
 */
package xin.yuan.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.yuan.mall.mbg.mapper.OmsOrderSettingMapper;
import xin.yuan.mall.mbg.model.OmsOrderSetting;
import xin.yuan.mall.mbg.model.OmsOrderSettingExample;
import xin.yuan.mall.service.OmsOrderSettingService;

@Service
public class OmsorderSettingServiceImpl implements OmsOrderSettingService {

    @Autowired
    private OmsOrderSettingMapper orderSettingMapper;

    @Override
    public OmsOrderSetting getItem(Long id) {
        return orderSettingMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(Long id, OmsOrderSetting orderSetting) {
        OmsOrderSettingExample example = new OmsOrderSettingExample();
        example.createCriteria().andIdEqualTo(id);
        return orderSettingMapper.updateByExample(orderSetting, example);
    }
}
