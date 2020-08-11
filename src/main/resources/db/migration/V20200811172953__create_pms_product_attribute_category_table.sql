-- ----------------------------
-- Table structure for pms_product_attribute_category
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_attribute_category`;
CREATE TABLE `pms_product_attribute_category` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(64) DEFAULT NULL,
    `attribute_count` int(11) DEFAULT '0' COMMENT '属性数量',
    `param_count` int(11) DEFAULT '0' COMMENT '参数数量',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='产品属性分类表';
