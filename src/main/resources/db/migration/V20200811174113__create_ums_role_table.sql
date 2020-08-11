-- ----------------------------
-- Table structure for ums_role
-- ----------------------------
DROP TABLE IF EXISTS `ums_role`;
CREATE TABLE `ums_role` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(100) DEFAULT NULL COMMENT '名称',
    `description` varchar(500) DEFAULT NULL COMMENT '描述',
    `admin_count` int(11) DEFAULT NULL COMMENT '后台用户数量',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `status` int(1) DEFAULT '1' COMMENT '启用状态：0->禁用；1->启用',
    `sort` int(11) DEFAULT '0',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='后台用户角色表';
