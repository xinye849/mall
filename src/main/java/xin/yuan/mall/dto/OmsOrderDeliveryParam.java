/**
 * FileName: OmsOrderDeliveryParam
 * Author:   knight xiong
 * 订单发货参数
 * Date:     2019/6/20 16:19
 * History:
 */
package xin.yuan.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class OmsOrderDeliveryParam {
    @ApiModelProperty("订单id")
    private Long orderId;
    @ApiModelProperty("物流公司")
    private String deliveryCompany;
    @ApiModelProperty("物流单号")
    private String deliverySn;
}