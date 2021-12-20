package Week7_Mysql.homework9.service.impl;

import Week7_Mysql.homework9.entity.Product;
import Week7_Mysql.homework9.mapper.ProductMapper;
import Week7_Mysql.homework9.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * product_id 商品ID, product_name 商品名, product_img_path  商品图片路径, product_information 商品信息, product_unit_name 商品单位, product_brand_name 品牌名称， create_timestamp 创建时间， update_timestamp 更新时间 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-12-20
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}
