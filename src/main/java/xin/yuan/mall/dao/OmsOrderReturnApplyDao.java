package xin.yuan.mall.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import xin.yuan.mall.dto.OmsOrderReturnApplyResult;
import xin.yuan.mall.dto.OmsReturnApplyQueryParam;
import xin.yuan.mall.mbg.model.OmsOrderReturnApply;

import java.util.List;

public interface OmsOrderReturnApplyDao {

    @Select({"<script>", "SELECT id,create_time,member_username,product_real_price, product_count,return_name, status, handle_time FROM oms_order_return_apply", "WHERE 1 = 1",
            "<if test='queryParam.id!=null'>", "and id = #{queryParam.id}","</if>",
            "<if test='queryParam.status!=null'>", "and status = #{queryParam.status}", "</if>",
            "<if test='queryParam.handleMan!=null and queryParam.handleMan!=\"\"'>", "and handle_man = #{queryParam.handleMan}", "</if>",
            "<if test='queryParam.createTime!=null and queryParam.createTime!=\"\"'>", "and create_time LIKE CONCAT(#{queryParam.createTime}, '%')", "</if>",
            "<if test='queryParam.handleTime!=null and queryParam.handleTime!=\"\"'>", "and handle_time LIKE CONCAT(#{queryParam.handleTime}, '%')", "</if>",
            "<if test='queryParam.receiverKeyword!=null and queryParam.receiverKeyword!=\"\"'>",
            " AND (return_name LIKE concat(\"%\",#{queryParam.receiverKeyword},\"%\") OR " +
                    "return_phone LIKE concat(\"%\",#{queryParam.receiverKeyword},\"%\"))",
            "</if>",
            "</script>"})
    @ResultMap("xin.yuan.mall.dao.OmsOrderDao.BaseResultMap")
    List<OmsOrderReturnApply> getList(@Param("queryParam") OmsReturnApplyQueryParam queryParam);

    OmsOrderReturnApplyResult getDetail(Long id);
}
