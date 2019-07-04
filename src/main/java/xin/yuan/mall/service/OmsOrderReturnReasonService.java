package xin.yuan.mall.service;

import xin.yuan.mall.mbg.model.OmsOrderReturnReason;

import java.util.List;

public interface OmsOrderReturnReasonService {
    int create(OmsOrderReturnReason returnReason);

    int update(Long id, OmsOrderReturnReason returnReason);

    int delete(List<Long> ids);

    List<OmsOrderReturnReason> list(Integer pageNum, Integer pageSize);

    OmsOrderReturnReason getItem(Long id);

    int updateStatus(Integer status, List<Long> ids);
}
