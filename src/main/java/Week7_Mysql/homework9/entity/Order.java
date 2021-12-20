package Week7_Mysql.homework9.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * order_id 订单号，user_id 用户ID，product_id 产品ID， amount 总金额， coupon 优惠券， quantity 数量， create_timestamp 创建时间， update_timestamp 更新时间
 * </p>
 *
 * @author jobob
 * @since 2021-12-20
 */
@Data
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer order_id;

    private Integer user_id;

    private Integer product_id;

    private Long amount;

    private String coupon;

    private Integer quantity;

    private String create_timestamp;

    private String update_timestamp;


//    public Integer getOrder_id() {
//        return order_id;
//    }
//
//    public void setOrder_id(Integer order_id) {
//        this.order_id = order_id;
//    }
//
//    public Integer getUser_id() {
//        return user_id;
//    }
//
//    public void setUser_id(Integer user_id) {
//        this.user_id = user_id;
//    }
//
//    public Integer getProduct_id() {
//        return product_id;
//    }
//
//    public void setProduct_id(Integer product_id) {
//        this.product_id = product_id;
//    }
//
//    public Long getAmount() {
//        return amount;
//    }
//
//    public void setAmount(Long amount) {
//        this.amount = amount;
//    }
//
//    public String getCoupon() {
//        return coupon;
//    }
//
//    public void setCoupon(String coupon) {
//        this.coupon = coupon;
//    }
//
//    public Integer getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(Integer quantity) {
//        this.quantity = quantity;
//    }
//
//    public String getCreate_timestamp() {
//        return create_timestamp;
//    }
//
//    public void setCreate_timestamp(String create_timestamp) {
//        this.create_timestamp = create_timestamp;
//    }
//
//    public String getUpdate_timestamp() {
//        return update_timestamp;
//    }
//
//    public void setUpdate_timestamp(String update_timestamp) {
//        this.update_timestamp = update_timestamp;
//    }

//    @Override
//    public String toString() {
//        return "Order{" +
//        "order_id=" + order_id +
//        ", user_id=" + user_id +
//        ", product_id=" + product_id +
//        ", amount=" + amount +
//        ", coupon=" + coupon +
//        ", quantity=" + quantity +
//        ", create_timestamp=" + create_timestamp +
//        ", update_timestamp=" + update_timestamp +
//        "}";
//    }
}
