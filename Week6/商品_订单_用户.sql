CREATE TABLE `product` (
  `product_id` INT NOT NULL,
  `product_name` VARCHAR(100) NULL,
  `product_img_path` VARCHAR(100) NULL,
  `product_information` VARCHAR(1000) NULL,
  `product_unit_name` VARCHAR(45) NULL,
  `product_brand_name` VARCHAR(45) NULL,
   `create_timestamp` DATETIME NULL,
  `update_timestamp` DATETIME NULL,
  PRIMARY KEY (`product_id`))
COMMENT = 'product_id 商品ID, product_name 商品名, product_img_path  商品图片路径, product_information 商品信息, product_unit_name 商品单位, product_brand_name 品牌名称， create_timestamp 创建时间， update_timestamp 更新时间';


CREATE TABLE `user` (
  `user_id` INT NOT NULL,
  `user_name` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `mail` VARCHAR(45) NULL,
  `phone_number` VARCHAR(45) NULL,
  `user_address` VARCHAR(45) NULL,
   `create_timestamp` DATETIME NULL,
  `update_timestamp` DATETIME NULL,
  PRIMARY KEY (`user_id`))
COMMENT = 'user_id 用户ID， user_name 用户名， password 密码， mail 邮箱， phone_number 手机号 user_address 用户地址， create_timestamp 创建时间， update_timestamp 更新时间';


CREATE TABLE `order` (
  `order_id` INT NOT NULL,
  `user_id` INT NULL,
  `product_id` INT NULL,
  `amount` BIGINT(10) NULL,
  `coupon` CHAR(10) NULL,
  `quantity` INT NULL,
  `create_timestamp` DATETIME NULL,
  `update_timestamp` DATETIME NULL,
  PRIMARY KEY (`order_id`))
COMMENT = 'order_id 订单号，user_id 用户ID，product_id 产品ID， amount 总金额， coupon 优惠券， quantity 数量， create_timestamp 创建时间， update_timestamp 更新时间';
