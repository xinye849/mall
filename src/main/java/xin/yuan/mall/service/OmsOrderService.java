package xin.yuan.mall.service;

import xin.yuan.mall.dto.*;
import xin.yuan.mall.mbg.model.OmsOrder;

import java.util.List;

public interface OmsOrderService {
    List<OmsOrder> list(OmsOrderQueryParam queryParam, Integer pageSize, Integer pageNum);

    int delivery(List<OmsOrderDeliveryParam> deliveryParamList);

    int close(List<Long> ids, String note);

    int delete(List<Long> ids);

    OmsOrderDetail detail(Long id);

    int updateReceiverInfo(OmsReceiverInfoParam receiverInfoParam);

    int updateMoneyInfo(OmsMoneyInfoParam moneyInfoParam);

    int updateNote(Long id, String note, Integer status);
}
