-- ----------------------------
-- Table structure for ums_admin_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin_permission_relation`;
CREATE TABLE `ums_admin_permission_relation` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `admin_id` bigint(20) DEFAULT NULL,
    `permission_id` bigint(20) DEFAULT NULL,
    `type` int(1) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台用户和权限关系表(除角色中定义的权限以外的加减权限)';
