package xin.yuan.mall.service;

import xin.yuan.mall.mbg.model.OmsOrderSetting;

/**
 * 订单设置管理service接口
 */
public interface OmsOrderSettingService {
    OmsOrderSetting getItem(Long id);

    int update(Long id, OmsOrderSetting orderSetting);
}
