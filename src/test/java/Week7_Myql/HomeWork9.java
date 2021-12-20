package Week7_Myql;

import Week7_Mysql.homework9.entity.Order;
import Week7_Mysql.homework9.service.IOrderService;
import Week7_Mysql.homework9.service.impl.OrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeWork9 {

    @Autowired
    IOrderService orderService;
    Order order = new Order();


    @Test
    public void add()
    {

        order.setOrder_id(1);
        order.setAmount(1000L);
        order.setCoupon("1");
        order.setQuantity(100000);
        order.setProduct_id(1);
        order.setUser_id(1);

        order.setCreate_timestamp("" + System.currentTimeMillis());
        order.setUpdate_timestamp("" + System.currentTimeMillis());

        orderService.Add(order);
    }

    @Test
    public void getOrder()
    {
        Order o = orderService.getOne(order.getOrder_id());

        if( !o.equals(order))
        {
            log.error("获取的数据不相同 " );
            log.error("insert: " + order.toString());
            log.error("get: " + o.toString());
        }



    }
}
