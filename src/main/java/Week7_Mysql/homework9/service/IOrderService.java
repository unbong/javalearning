package Week7_Mysql.homework9.service;

import Week7_Mysql.homework9.datasource.DataSourceNames;
import Week7_Mysql.homework9.datasource.DataSourceType;
import Week7_Mysql.homework9.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * order_id 订单号，user_id 用户ID，product_id 产品ID， amount 总金额， coupon 优惠券， quantity 数量， create_timestamp 创建时间， update_timestamp 更新时间 服务类
 * </p>
 *
 * @author jobob
 * @since 2021-12-20
 */
public interface IOrderService extends IService<Order> {

    public void Add(Order order);


    public Order getOne(int id);
}
