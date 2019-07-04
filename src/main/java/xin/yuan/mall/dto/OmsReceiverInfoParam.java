/**
 * FileName: OmsReceiverInfoParam
 * Author:   Dragon
 * Date:     2019/7/1 16:01
 * History:
 */
package xin.yuan.mall.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class OmsReceiverInfoParam {
    private Long orderId;
    private String receiverName;
    private String receiverPhone;
    private String receiverPostCode;
    private String receiverDetailAddress;
    private String receiverProvince;
    private String receiverCity;
    private String receiverRegion;
    private Integer status;
}
