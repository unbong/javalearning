package Week7_Mysql.homework9.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * product_id 商品ID, product_name 商品名, product_img_path  商品图片路径, product_information 商品信息, product_unit_name 商品单位, product_brand_name 品牌名称， create_timestamp 创建时间， update_timestamp 更新时间
 * </p>
 *
 * @author jobob
 * @since 2021-12-20
 */
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer product_id;

    private String product_name;

    private String product_img_path;

    private String product_information;

    private String product_unit_name;

    private String product_brand_name;

    private LocalDateTime create_timestamp;

    private LocalDateTime update_timestamp;


    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_img_path() {
        return product_img_path;
    }

    public void setProduct_img_path(String product_img_path) {
        this.product_img_path = product_img_path;
    }

    public String getProduct_information() {
        return product_information;
    }

    public void setProduct_information(String product_information) {
        this.product_information = product_information;
    }

    public String getProduct_unit_name() {
        return product_unit_name;
    }

    public void setProduct_unit_name(String product_unit_name) {
        this.product_unit_name = product_unit_name;
    }

    public String getProduct_brand_name() {
        return product_brand_name;
    }

    public void setProduct_brand_name(String product_brand_name) {
        this.product_brand_name = product_brand_name;
    }

    public LocalDateTime getCreate_timestamp() {
        return create_timestamp;
    }

    public void setCreate_timestamp(LocalDateTime create_timestamp) {
        this.create_timestamp = create_timestamp;
    }

    public LocalDateTime getUpdate_timestamp() {
        return update_timestamp;
    }

    public void setUpdate_timestamp(LocalDateTime update_timestamp) {
        this.update_timestamp = update_timestamp;
    }

    @Override
    public String toString() {
        return "Product{" +
        "product_id=" + product_id +
        ", product_name=" + product_name +
        ", product_img_path=" + product_img_path +
        ", product_information=" + product_information +
        ", product_unit_name=" + product_unit_name +
        ", product_brand_name=" + product_brand_name +
        ", create_timestamp=" + create_timestamp +
        ", update_timestamp=" + update_timestamp +
        "}";
    }
}
