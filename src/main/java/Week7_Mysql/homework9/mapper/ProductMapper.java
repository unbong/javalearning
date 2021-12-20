package Week7_Mysql.homework9.mapper;

import Week7_Mysql.homework9.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * product_id 商品ID, product_name 商品名, product_img_path  商品图片路径, product_information 商品信息, product_unit_name 商品单位, product_brand_name 品牌名称， create_timestamp 创建时间， update_timestamp 更新时间 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2021-12-20
 */
public interface ProductMapper extends BaseMapper<Product> {

}
