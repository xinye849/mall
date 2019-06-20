package xin.yuan.mall.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import xin.yuan.mall.dto.OmsOrderDeliveryParam;
import xin.yuan.mall.dto.OmsOrderQueryParam;
import xin.yuan.mall.mbg.model.OmsOrder;

import java.util.List;

/**
 * author:knight xiong
 * 自定义订单查询
 * 2019/6/14
 */
public interface OmsOrderDao {
    @Select({"<script>","SELECT * FROM oms_order", "WHERE delete_status = 0",
            "<if test='queryParam.orderSn!=null and queryParam.orderSn!=\"\"'>","and order_sn = #{queryParam.orderSn}","</if>",
            "<if test='queryParam.status!=null and queryParam.status != \"\"'>","and status = #{queryParam.status}","</if>",
            "<if test='queryParam.sourceType!=null and queryParam.sourceType != \"\"'>","and source_type = #{queryParam.sourceType}","</if>",
            "<if test='queryParam.sourceType!=null and queryParam.sourceType != \"\"'>","and source_type = #{queryParam.sourceType}","</if>",
            "<if test='queryParam.orderType!=null and queryParam.orderType != \"\"'>","and order_type = #{queryParam.orderType}","</if>",
            "<if test='queryParam.createTime!=null and queryParam.createTime != \"\"'>","create_time LIKE concat(#{queryParam.createTime},\"%\")","</if>",
            "<if test='queryParam.receiverKeyword!=null and queryParam.receiverKeyword != \"\"'>",
            " AND ( receiver_name LIKE concat(\"%\",#{queryParam.receiverKeyword},\"%\") OR rceiver_phone LIKE concat(\"%\",#{queryParam.receiverKeyword},\"%\"))","</if>",
            "</script>"})
            @Results(id = "BaseResultMap",value = {
                    @Result(column = "id",property="id",jdbcType= JdbcType.BIGINT,id = true),
                    @Result(column = "member_id",property ="memberId",jdbcType = JdbcType.BIGINT),
                    @Result(column = "coupon_id",property ="couponId",jdbcType = JdbcType.BIGINT),
                    @Result(column = "order_sn",property ="orderSn",jdbcType = JdbcType.VARCHAR),
                    @Result(column = "create_time",property ="createTime",jdbcType = JdbcType.TIMESTAMP),
                    @Result(column = "member_username",property ="memberUsername",jdbcType = JdbcType.VARCHAR),
                    @Result(column = "total_amount",property ="totalAmount",jdbcType = JdbcType.DECIMAL),
                    @Result(column = "pay_amount",property ="payAmount",jdbcType = JdbcType.DECIMAL),
                    @Result(column = "freight_amount",property ="freightAmount",jdbcType = JdbcType.DECIMAL),
                    @Result(column = "promotion_amount",property ="promotionAmount",jdbcType = JdbcType.DECIMAL),
                    @Result(column = "integration_amount",property ="integrationAmount",jdbcType = JdbcType.DECIMAL),
                    @Result(column = "coupon_amount",property ="couponAmount",jdbcType = JdbcType.DECIMAL),
                    @Result(column = "discount_amount",property ="discountAmount",jdbcType = JdbcType.DECIMAL),
                    @Result(column = "pay_type",property ="payType",jdbcType = JdbcType.INTEGER),
                    @Result(column = "source_type",property ="sourceType",jdbcType = JdbcType.INTEGER),
                    @Result(column = "status",property ="status",jdbcType = JdbcType.INTEGER),
                    @Result(column = "order_type",property ="orderType",jdbcType = JdbcType.INTEGER),
                    @Result(column = "delivery_company",property ="deliveryCompany",jdbcType = JdbcType.VARCHAR),
                    @Result(column = "delivery_sn",property ="deliverySn",jdbcType = JdbcType.VARCHAR),
                    @Result(column = "auto_confirm_day",property ="autoConfirmDay",jdbcType = JdbcType.INTEGER),
                    @Result(column = "integration",property ="integration",jdbcType = JdbcType.INTEGER),
                    @Result(column = "growth",property ="growth",jdbcType = JdbcType.INTEGER),
                    @Result(column = "promotion_info",property ="promotionInfo",jdbcType = JdbcType.VARCHAR),
                    @Result(column = "bill_type",property ="billType",jdbcType = JdbcType.INTEGER),
                    @Result(column = "bill_header",property ="billHeader",jdbcType = JdbcType.VARCHAR),
                    @Result(column = "bill_content",property ="billContent",jdbcType = JdbcType.VARCHAR),
                    @Result(column = "bill_receiver_phone",property ="billReceiverPhone",jdbcType = JdbcType.VARCHAR),
                    @Result(column = "bill_receiver_email",property ="billReceiverEmail",jdbcType = JdbcType.VARCHAR),
                    @Result(column = "receiver_name",property ="receiverName",jdbcType = JdbcType.VARCHAR),
                    @Result(column = "receiver_phone",property ="receiverPhone",jdbcType = JdbcType.VARCHAR),
                    @Result(column = "receiver_post_code",property ="receiverPostCode",jdbcType = JdbcType.VARCHAR),
                    @Result(column = "receiver_province",property ="receiverProvince",jdbcType = JdbcType.VARCHAR),
                    @Result(column = "receiver_city",property ="receiverCity",jdbcType = JdbcType.VARCHAR),
                    @Result(column = "receiver_region",property ="receiverRegion",jdbcType = JdbcType.VARCHAR),
                    @Result(column = "receiver_detail_address",property ="receiverDetailAddress",jdbcType = JdbcType.VARCHAR),
                    @Result(column = "note",property ="note",jdbcType = JdbcType.VARCHAR),
                    @Result(column = "confirm_status",property ="confirmStatus",jdbcType = JdbcType.INTEGER),
                    @Result(column = "delete_status",property ="deleteStatus",jdbcType = JdbcType.INTEGER),
                    @Result(column = "use_integration",property ="useIntegration",jdbcType = JdbcType.INTEGER),
                    @Result(column = "payment_time",property ="paymentTime",jdbcType = JdbcType.TIMESTAMP),
                    @Result(column = "delivery_time",property ="deliveryTime",jdbcType = JdbcType.TIMESTAMP),
                    @Result(column = "receive_time",property ="receiveTime",jdbcType = JdbcType.TIMESTAMP),
                    @Result(column = "comment_time",property ="commentTime",jdbcType = JdbcType.TIMESTAMP),
                    @Result(column = "modify_time",property ="modifyTime",jdbcType = JdbcType.TIMESTAMP)
            })
    /**
     * 条件查询订单
     */
    List<OmsOrder> getList(@Param("queryParam")OmsOrderQueryParam queryParam);
//技术原因，无法实现，以后再来解决
    int delivery(@Param("list") List<OmsOrderDeliveryParam> deliveryParamList);
}
