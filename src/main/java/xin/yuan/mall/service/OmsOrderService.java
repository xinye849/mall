package xin.yuan.mall.service;

import xin.yuan.mall.dto.OmsOrderQueryParam;
import xin.yuan.mall.mbg.model.OmsOrder;

import java.util.List;

public interface OmsOrderService {
    List<OmsOrder> list(OmsOrderQueryParam queryParam, Integer pageSize, Integer pageNum);
}
