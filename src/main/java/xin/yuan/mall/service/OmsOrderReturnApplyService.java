package xin.yuan.mall.service;

import xin.yuan.mall.dto.OmsOrderReturnApplyResult;
import xin.yuan.mall.dto.OmsReturnApplyQueryParam;
import xin.yuan.mall.dto.OmsUpdateStatusParam;
import xin.yuan.mall.mbg.model.OmsOrderReturnApply;

import java.util.List;

public interface OmsOrderReturnApplyService {
    List<OmsOrderReturnApply> list(OmsReturnApplyQueryParam queryParam, Integer pageNum, Integer pageSize);

    int delete(List<Long> ids);

    OmsOrderReturnApplyResult getItem(Long id);

    int updateStatus(Long id, OmsUpdateStatusParam statusParam);
}
