/**
 * FileName: OmsOrderDetail
 * Author:   knitht
 * 订单详情信息
 * Date:     2019/7/1 10:51
 * History:
 */
package xin.yuan.mall.dto;

import lombok.Getter;
import lombok.Setter;
import xin.yuan.mall.mbg.model.OmsOrder;
import xin.yuan.mall.mbg.model.OmsOrderItem;
import xin.yuan.mall.mbg.model.OmsOrderOperateHistory;
import java.util.List;

@Getter
@Setter
public class OmsOrderDetail extends OmsOrder {
    private List<OmsOrderItem> orderItemList;
    private List<OmsOrderOperateHistory> historyList;
}