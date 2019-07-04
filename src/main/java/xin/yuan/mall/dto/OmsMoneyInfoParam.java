/**
 * FileName: OmsMoneyInfoParam
 * Author:   knight
 *  修改订单费用信息参数
 * Date:     2019/7/1 16:50
 * History:
 */
package xin.yuan.mall.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
@Setter
@Getter
@ToString
public class OmsMoneyInfoParam {
    private Long orderId;
    private BigDecimal freightAmount;
    private BigDecimal discountAmount;
    private Integer status;
}
