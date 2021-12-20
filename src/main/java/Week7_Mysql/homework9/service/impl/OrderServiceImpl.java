package Week7_Mysql.homework9.service.impl;

import Week7_Mysql.homework9.datasource.DataSourceNames;
import Week7_Mysql.homework9.datasource.DataSourceType;
import Week7_Mysql.homework9.entity.Order;
import Week7_Mysql.homework9.mapper.OrderMapper;
import Week7_Mysql.homework9.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * order_id 订单号，user_id 用户ID，product_id 产品ID， amount 总金额， coupon 优惠券， quantity 数量， create_timestamp 创建时间， update_timestamp 更新时间 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-12-20
 */
@Slf4j
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {


    @DataSourceType(name= DataSourceNames.MASTER)
    public void Add(Order order)
    {
        baseMapper.insert(order);
    }


    @DataSourceType(name= DataSourceNames.SLAVE)
    public Order getOne(int id)
    {
        return baseMapper.selectById(id);
    }

}
