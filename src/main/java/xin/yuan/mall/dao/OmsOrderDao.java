package xin.yuan.mall.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import xin.yuan.mall.dto.OmsOrderQueryParam;
import xin.yuan.mall.mbg.model.OmsOrder;

import java.util.List;

/**
 * author:knight xiong
 * 自定义订单查询
 * 2019/6/14
 */
public interface OmsOrderDao {
    @Select({"<script>", "SELECT * FROM oms_order", "WHERE delete_status = 0",
            "<if test='queryParam.orderSn!=null and queryParam.orderSn!=\"\"'>", "and order_sn = #{queryParam.orderSn}", "</if>",
            "<if test='queryParam.status!=null and queryParam.status != \"\"'>", "and status = #{queryParam.status}", "</if>",
            "<if test='queryParam.sourceType!=null and queryParam.sourceType != \"\"'>", "and source_type = #{queryParam.sourceType}", "</if>",
            "<if test='queryParam.sourceType!=null and queryParam.sourceType != \"\"'>", "and source_type = #{queryParam.sourceType}", "</if>",
            "<if test='queryParam.orderType!=null and queryParam.orderType != \"\"'>", "and order_type = #{queryParam.orderType}", "</if>",
            "<if test='queryParam.createTime!=null and queryParam.createTime != \"\"'>", "create_time LIKE concat(#{queryParam.createTime},\"%\")", "</if>",
            "<if test='queryParam.receiverKeyword!=null and queryParam.receiverKeyword != \"\"'>",
            " AND ( receiver_name LIKE concat(\"%\",#{queryParam.receiverKeyword},\"%\") OR rceiver_phone LIKE concat(\"%\",#{queryParam.receiverKeyword},\"%\"))", "</if>",
            "</script>"})
    /**
     * 条件查询订单
     */
    List<OmsOrder> getList(@Param("queryParam")OmsOrderQueryParam queryParam);
}
