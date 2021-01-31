CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_code` varchar(100) NOT NULL COMMENT '用户账号',
  `user_name` varchar(100) NOT NULL COMMENT '用户名称',
    `age` int(4) default 0 COMMENT '年龄',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete` tinyint(2) default 0 COMMENT '是否删除',
  `version` tinyint(5) default NULL  COMMENT '逻辑锁',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `user_code_unique` (`user_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;