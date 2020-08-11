-- ----------------------------
-- Table structure for ums_permission
-- ----------------------------
DROP TABLE IF EXISTS `ums_permission`;
CREATE TABLE `ums_permission` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `pid` bigint(20) DEFAULT NULL COMMENT '父级权限id',
    `name` varchar(100) DEFAULT NULL COMMENT '名称',
    `value` varchar(200) DEFAULT NULL COMMENT '权限值',
    `icon` varchar(500) DEFAULT NULL COMMENT '图标',
    `type` int(1) DEFAULT NULL COMMENT '权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）',
    `uri` varchar(200) DEFAULT NULL COMMENT '前端资源路径',
    `status` int(1) DEFAULT NULL COMMENT '启用状态；0->禁用；1->启用',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `sort` int(11) DEFAULT NULL COMMENT '排序',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='后台用户权限表';
