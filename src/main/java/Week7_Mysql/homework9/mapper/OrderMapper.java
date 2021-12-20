package Week7_Mysql.homework9.mapper;

import Week7_Mysql.homework9.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * order_id 订单号，user_id 用户ID，product_id 产品ID， amount 总金额， coupon 优惠券， quantity 数量， create_timestamp 创建时间， update_timestamp 更新时间 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2021-12-20
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
