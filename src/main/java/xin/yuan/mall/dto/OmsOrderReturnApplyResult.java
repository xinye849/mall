/**
 * FileName: OmsOrderReturnApplyResult
 * Author:   knight
 * Date:     2019/7/2 14:19
 * History:
 */
package xin.yuan.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.annotations.Select;
import xin.yuan.mall.mbg.model.OmsCompanyAddress;
import xin.yuan.mall.mbg.model.OmsOrderReturnApply;

@Setter
@Getter
@ToString
public class OmsOrderReturnApplyResult extends OmsOrderReturnApply {
    @ApiModelProperty("公司地址")
    private OmsCompanyAddress companyAddress;
}
