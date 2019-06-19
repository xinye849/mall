/**
 * FileName: OmsOrderQueryParam
 * Author:   knitht xiong
 * 订单查询参数
 * Date:     2019/6/14 14:25
 * History:
 */
package xin.yuan.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OmsOrderQueryParam {
    @ApiModelProperty(value = "订单编号")
    private String orderSn;
    @ApiModelProperty("收货人姓名/号码")
    private String receiverKeyword;
    @ApiModelProperty("订单状态：0:待付款;1:待收货;2:已发货;3:已完成;4:已关闭;5:无效订单")
    private Integer status;
    @ApiModelProperty("订单类型：0:正常订单;1:秒杀订单")
    private Integer orderType;
    @ApiModelProperty("订单来源:0:pc订单;1:APP订单")
    private Integer sourceType;
    @ApiModelProperty("订单提交时间")
    private String createTime;
}

