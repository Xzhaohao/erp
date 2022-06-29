/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : erp

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 29/06/2022 21:13:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `code` varchar(30) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '编码',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称',
  `descript` varchar(100) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '描述',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态，0启用，1禁用',
  `del_flag` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除状态，0正常，1删除',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='字典管理表';

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
BEGIN;
INSERT INTO `sys_dict` VALUES ('1538881131018108928', 'gender', '性别', '性别的数据字典', 0, 0, '2022-06-01 21:48:35', '2022-06-20 21:48:38');
INSERT INTO `sys_dict` VALUES ('1538881131018108929', 'status', '数据状态', '状态的数据字典', 0, 0, '2022-06-02 20:34:50', '2022-06-21 20:34:52');
INSERT INTO `sys_dict` VALUES ('1538881131018108930', 'del_flag', '删除状态', '删除状态', 0, 0, '2022-06-01 20:34:46', '2022-06-21 20:34:48');
INSERT INTO `sys_dict` VALUES ('1538881131018108931', 'emp_state', '员工状态', '员工在职离职状态', 0, 0, '2022-06-03 20:34:42', '2022-06-21 20:34:45');
INSERT INTO `sys_dict` VALUES ('1538881131018108932', 'needs', '是否送货', '供应商是否送货', 0, 0, '2022-06-02 20:34:36', '2022-06-21 20:34:41');
INSERT INTO `sys_dict` VALUES ('1538881131018108933', 'order_type', '订单类型', '订单类型', 0, 0, '2022-06-01 14:41:16', '2022-06-23 14:41:27');
INSERT INTO `sys_dict` VALUES ('1538881131018108934', 'order_state', '订单状态', '订单状态', 0, 0, '2022-06-01 14:41:50', NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_dict_detail
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_detail`;
CREATE TABLE `sys_dict_detail` (
  `id` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `dict_code` varchar(30) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '字典编码',
  `code` varchar(30) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '编码',
  `name` varchar(30) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='字典配置表';

-- ----------------------------
-- Records of sys_dict_detail
-- ----------------------------
BEGIN;
INSERT INTO `sys_dict_detail` VALUES ('1538883274227748864', 'gender', '1', '男', NULL, NULL);
INSERT INTO `sys_dict_detail` VALUES ('1538883274231943168', 'gender', '2', '女', NULL, NULL);
INSERT INTO `sys_dict_detail` VALUES ('1538883274231943169', 'status', '0', '启用', NULL, NULL);
INSERT INTO `sys_dict_detail` VALUES ('1538883274231943170', 'status', '1', '禁用', NULL, NULL);
INSERT INTO `sys_dict_detail` VALUES ('1538883274231943171', 'del_flag', '0', '正常', NULL, NULL);
INSERT INTO `sys_dict_detail` VALUES ('1538883274231943172', 'del_flag', '1', '删除', NULL, NULL);
INSERT INTO `sys_dict_detail` VALUES ('1538883274231943173', 'emp_state', '1', '在职', NULL, NULL);
INSERT INTO `sys_dict_detail` VALUES ('1538883274231943174', 'emp_state', '2', '离职', NULL, NULL);
INSERT INTO `sys_dict_detail` VALUES ('1538883274231943175', 'needs', '1', '送货', NULL, NULL);
INSERT INTO `sys_dict_detail` VALUES ('1538883274231943176', 'needs', '2', '自提', NULL, NULL);
INSERT INTO `sys_dict_detail` VALUES ('1538883274231943177', 'order_type', '1', '采购单', NULL, NULL);
INSERT INTO `sys_dict_detail` VALUES ('1538883274231943178', 'order_type', '2', '运输单', NULL, NULL);
INSERT INTO `sys_dict_detail` VALUES ('1538883274231943179', 'order_type', '3', '入库单', NULL, NULL);
INSERT INTO `sys_dict_detail` VALUES ('1538883274231943180', 'order_type', '4', '销售单', NULL, NULL);
INSERT INTO `sys_dict_detail` VALUES ('1538883274231943181', 'order_state', '1', '未审核', NULL, NULL);
INSERT INTO `sys_dict_detail` VALUES ('1538883274231943182', 'order_state', '2', '审核未通过', NULL, NULL);
INSERT INTO `sys_dict_detail` VALUES ('1538883274231943183', 'order_state', '3', '审核通过', NULL, NULL);
INSERT INTO `sys_dict_detail` VALUES ('1538883274231943184', 'order_state', '4', '待采购', NULL, NULL);
INSERT INTO `sys_dict_detail` VALUES ('1538883274231943185', 'order_state', '5', '待指派', NULL, NULL);
INSERT INTO `sys_dict_detail` VALUES ('1538883274231943186', 'order_state', '6', '采购中', NULL, NULL);
INSERT INTO `sys_dict_detail` VALUES ('1538883274231943187', 'order_state', '7', '采购完成', NULL, NULL);
INSERT INTO `sys_dict_detail` VALUES ('1538883274231943188', 'order_state', '8', '待入库', NULL, NULL);
INSERT INTO `sys_dict_detail` VALUES ('1538883274231943189', 'order_state', '9', '入库中', NULL, NULL);
INSERT INTO `sys_dict_detail` VALUES ('1538883274231943190', 'order_state', '10', '入库完成', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_emp_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_emp_role`;
CREATE TABLE `sys_emp_role` (
  `id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `emp_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `role_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='员工-角色中间表';

-- ----------------------------
-- Records of sys_emp_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_emp_role` VALUES ('1536665323391045632', '1538874512666435584', '1536263111896612864', '2022-06-01 14:09:58', '2022-06-21 14:10:22');
COMMIT;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `parent_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT '父ID',
  `permission_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '权限名称',
  `permission_mark` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '权限标识',
  `permission_desc` varchar(160) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '权限描述',
  `del_flag` int unsigned NOT NULL DEFAULT '0' COMMENT '状态，0正常，1删除',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='权限表，菜单+API操作';

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `role_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '角色名称',
  `role_code` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '角色编码',
  `del_flag` int NOT NULL DEFAULT '0' COMMENT '状态，0正常，1删除',
  `description` varchar(160) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '描述',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES ('1536263111896612864', '超级管理员', 'super_admin', 0, '可以操作系统所有功能', '2022-06-09 16:24:35', '2022-06-21 14:50:14');
INSERT INTO `sys_role` VALUES ('1536263111896612865', '管理员', 'admin', 0, '协助超管管理系统', '2022-06-09 16:26:07', '2022-06-21 14:50:17');
INSERT INTO `sys_role` VALUES ('1536263111896612866', '人事经理', 'hr', 0, '主管人事相关业务', '2022-06-09 16:27:22', '2022-06-21 14:50:19');
INSERT INTO `sys_role` VALUES ('1536263111896612867', '销售经理', 'sale', 0, '主管销售相关业务', '2022-06-09 16:28:44', '2022-06-21 14:50:22');
COMMIT;

-- ----------------------------
-- Table structure for t_dep
-- ----------------------------
DROP TABLE IF EXISTS `t_dep`;
CREATE TABLE `t_dep` (
  `id` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(50) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '部门名',
  `tele` varchar(60) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '电话',
  `description` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '描述',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '邮箱',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态，0启用，1禁用',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_dep_name` (`name`) USING BTREE COMMENT '部门名称唯一'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='部门';

-- ----------------------------
-- Records of t_dep
-- ----------------------------
BEGIN;
INSERT INTO `t_dep` VALUES ('1539069850522140672', '财务部', '0771-0000000', '负责公司财务', 'cw@163.com', 0, '2022-06-01 10:17:33', '2022-06-23 20:51:56');
INSERT INTO `t_dep` VALUES ('1539069850522140673', '销售部', '0771-0000001', '', '', 0, '2022-06-01 10:18:01', NULL);
INSERT INTO `t_dep` VALUES ('1539069850522140674', '市场部', '0771-0000002', '', '', 0, '2022-06-01 10:18:23', NULL);
INSERT INTO `t_dep` VALUES ('1539069850522140675', '运营部', '0771-0000003', '', '', 0, '2022-06-01 10:18:42', NULL);
INSERT INTO `t_dep` VALUES ('1539069850522140676', '人事部', '0771-0000004', '', '', 0, '2022-06-01 10:19:04', NULL);
INSERT INTO `t_dep` VALUES ('1539069850522140677', '策划部', '0771-0000005', '', '', 0, '2022-06-01 10:19:29', NULL);
INSERT INTO `t_dep` VALUES ('1539069850522140678', '技术部', '0771-0000006', '', '', 0, '2022-06-01 10:19:51', NULL);
INSERT INTO `t_dep` VALUES ('1539069850522140679', '采购部', '0771-0000007', '', '', 0, '2022-06-01 10:20:15', NULL);
INSERT INTO `t_dep` VALUES ('1539069850522140680', '运输部', '0771-0000008', '', '', 0, '2022-06-01 10:20:42', NULL);
INSERT INTO `t_dep` VALUES ('1539069850522140681', '仓储部', '0771-0000009', '', '', 0, '2022-06-01 10:21:12', NULL);
COMMIT;

-- ----------------------------
-- Table structure for t_emp
-- ----------------------------
DROP TABLE IF EXISTS `t_emp`;
CREATE TABLE `t_emp` (
  `id` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `nation` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '民族',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '密码',
  `name` varchar(50) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '真实姓名',
  `email` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT '邮箱',
  `mobile` varchar(50) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '手机号',
  `address` varchar(150) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '地址',
  `gender` tinyint(1) NOT NULL COMMENT '1男，2女',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '头像',
  `dep_id` varchar(30) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '部门ID',
  `dep_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '部门名称',
  `last_login_ip` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '最后一次登陆的IP',
  `login_times` int unsigned NOT NULL DEFAULT '0' COMMENT '登陆次数',
  `state` int unsigned NOT NULL DEFAULT '1' COMMENT '1在职，2离职',
  `last_login_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_mobile` (`mobile`) USING BTREE COMMENT '手机号唯一'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='员工表';

-- ----------------------------
-- Records of t_emp
-- ----------------------------
BEGIN;
INSERT INTO `t_emp` VALUES ('1538874512666435584', '壮族', '$2a$10$Eph0ejiCDSdDQctnYlVKFOxGN/vQfpRGQwUyTZXQ8fP8j7O7rYsTa', '许星海', 'xh@163.com', '13555555555', '南宁市西乡塘区大学路', 1, '2000-06-01 21:19:32', 'https://nlgc-api.oss-cn-shenzhen.aliyuncs.com/avatar/1.png', '1539069850522140678', '技术部', '', 0, 1, NULL, '2022-06-01 21:19:51', NULL);
INSERT INTO `t_emp` VALUES ('1539161567376076800', '汉族', '$2a$10$nM31abIN0jj8NAbLcgBsBeJtZ5Q2XxFwyPv1pdJSmRaTFUGZN4muu', '王勃', 'wb@163.com', '13333333333', '河南省', 1, '2000-01-02 16:00:00', 'https://nlgc-api.oss-cn-shenzhen.aliyuncs.com/avatar/4.png', '1539069850522140676', '人事部', '', 0, 1, NULL, '2022-06-21 08:21:29', NULL);
INSERT INTO `t_emp` VALUES ('1539162035980496896', '苗族', '$2a$10$Z2bQ5IOs.HTeK50AXtUqvOmvdZ1OIqqHgtXEIypi4Cl2kBP2kf0pS', '张若虚', 'zrx@163.com', '13222222222', '扬州', 1, '2000-01-19 16:00:00', 'https://nlgc-api.oss-cn-shenzhen.aliyuncs.com/avatar/2.png', '1539069850522140680', '运输部', '', 0, 1, NULL, '2022-06-21 08:23:20', NULL);
INSERT INTO `t_emp` VALUES ('1539176641822085120', '汉族', '$2a$10$IsNExdmsJ77GanYUrES9be9371AupfWv4sDTbGqa.th/XamB2bHJ6', '李白', 'lb@qq.com', '13111111111', '四川', 1, '1990-06-11 15:00:00', 'https://nlgc-api.oss-cn-shenzhen.aliyuncs.com/avatar/3.png', '1539069850522140674', '市场部', '', 0, 1, NULL, '2022-06-21 09:21:23', NULL);
COMMIT;

-- ----------------------------
-- Table structure for t_goods
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods` (
  `id` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(60) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '商品名称',
  `origin` varchar(60) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '产地',
  `producer` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '生产厂家',
  `unit` varchar(30) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '单位',
  `in_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '进货价',
  `out_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '售价',
  `goods_type_id` varchar(30) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '商品类别ID',
  `del_flag` int unsigned NOT NULL DEFAULT '0' COMMENT '0正常，1删除',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品';

-- ----------------------------
-- Records of t_goods
-- ----------------------------
BEGIN;
INSERT INTO `t_goods` VALUES ('1', '100%纯棉短袖', '江苏', '苏州服装工厂', '件', 5.00, 50.00, '1539434735584059417', 0, '2022-06-02 17:40:26', '2022-06-22 18:13:17');
INSERT INTO `t_goods` VALUES ('2', '夏季新款短袖T恤 男', '浙江', '安徽合肥服装工厂', '件', 10.00, 39.00, '1539434735584059402', 0, '2022-06-01 18:10:04', '2022-06-22 18:13:24');
INSERT INTO `t_goods` VALUES ('3', '电脑桌暖白色140*60*74', '江苏', '江苏家具厂', '张', 50.00, 118.00, '1539434735584059395', 0, '2022-06-02 18:12:54', NULL);
INSERT INTO `t_goods` VALUES ('4', '宜家洛贝里特转椅', '广东', '深圳工厂', '把', 80.00, 199.00, '1539434735584059395', 0, '2022-06-01 18:18:37', '2022-06-22 18:18:40');
INSERT INTO `t_goods` VALUES ('5', '红木沙发', '广东', '广西东兴工厂', '张', 2300.00, 4800.00, '1539434735584059392', 0, '2022-06-02 18:18:33', NULL);
INSERT INTO `t_goods` VALUES ('6', 'LED吸顶方形灯', '江苏', '江苏常州工厂', '盏', 100.00, 155.00, '1539434735584059397', 0, '2022-06-02 18:20:30', NULL);
COMMIT;

-- ----------------------------
-- Table structure for t_goods_type
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_type`;
CREATE TABLE `t_goods_type` (
  `id` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(60) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '商品类别名称',
  `supplier_id` varchar(30) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '供应商ID',
  `supplier_name` varchar(60) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '供应商名称',
  `del_flag` int unsigned NOT NULL DEFAULT '0' COMMENT '是否删除，0正常，1删除',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品类别';

-- ----------------------------
-- Records of t_goods_type
-- ----------------------------
BEGIN;
INSERT INTO `t_goods_type` VALUES ('1539434735584059392', '沙发', '1539247340007927808', '苏州上集家具有限公司', 0, '2022-06-02 10:18:55', '2022-06-22 16:04:46');
INSERT INTO `t_goods_type` VALUES ('1539434735584059393', '床', '1539247340007927808', '苏州上集家具有限公司', 0, '2022-06-02 10:18:55', '2022-06-22 10:27:27');
INSERT INTO `t_goods_type` VALUES ('1539434735584059394', '衣柜', '1539247340007927808', '苏州上集家具有限公司', 0, '2022-06-02 10:18:55', '2022-06-22 10:27:33');
INSERT INTO `t_goods_type` VALUES ('1539434735584059395', '桌椅', '1539247340007927808', '苏州上集家具有限公司', 0, '2022-06-02 10:18:55', '2022-06-22 10:27:40');
INSERT INTO `t_goods_type` VALUES ('1539434735584059396', '浴室产品', '1539247340007927808', '苏州上集家具有限公司', 0, '2022-06-02 10:18:55', '2022-06-22 10:27:47');
INSERT INTO `t_goods_type` VALUES ('1539434735584059397', '灯具照明', '1539247340007927808', '苏州上集家具有限公司', 0, '2022-06-02 10:18:55', '2022-06-22 10:27:53');
INSERT INTO `t_goods_type` VALUES ('1539434735584059398', '纺织品', '1539247340007927808', '苏州上集家具有限公司', 0, '2022-06-02 10:18:55', '2022-06-22 10:27:59');
INSERT INTO `t_goods_type` VALUES ('1539434735584059399', '装饰品', '1539247340007927808', '苏州上集家具有限公司', 0, '2022-06-02 10:18:55', '2022-06-22 10:28:06');
INSERT INTO `t_goods_type` VALUES ('1539434735584059400', '餐具厨具', '1539247340007927808', '苏州上集家具有限公司', 0, '2022-06-02 10:18:55', '2022-06-22 10:28:12');
INSERT INTO `t_goods_type` VALUES ('1539434735584059401', '宠物用品', '1539247340007927808', '苏州上集家具有限公司', 0, '2022-06-02 10:18:55', '2022-06-22 10:28:17');
INSERT INTO `t_goods_type` VALUES ('1539434735584059402', '男装T恤', '1539247340007927809', '成都汐辰服饰有限公司', 0, '2022-06-01 10:30:05', '2022-06-01 10:30:08');
INSERT INTO `t_goods_type` VALUES ('1539434735584059403', '男装衬衫', '1539247340007927809', '成都汐辰服饰有限公司', 0, '2022-06-01 10:30:05', '2022-06-01 10:30:08');
INSERT INTO `t_goods_type` VALUES ('1539434735584059404', '男装卫衣', '1539247340007927809', '成都汐辰服饰有限公司', 0, '2022-06-01 10:30:05', '2022-06-01 10:30:08');
INSERT INTO `t_goods_type` VALUES ('1539434735584059405', '背心/马甲', '1539247340007927809', '成都汐辰服饰有限公司', 0, '2022-06-01 10:30:05', '2022-06-01 10:30:08');
INSERT INTO `t_goods_type` VALUES ('1539434735584059406', '男装风衣', '1539247340007927809', '成都汐辰服饰有限公司', 0, '2022-06-01 10:30:05', '2022-06-01 10:30:08');
INSERT INTO `t_goods_type` VALUES ('1539434735584059407', '男装皮衣', '1539247340007927809', '成都汐辰服饰有限公司', 0, '2022-06-01 10:30:05', '2022-06-01 10:30:08');
INSERT INTO `t_goods_type` VALUES ('1539434735584059408', '男装羽绒服', '1539247340007927809', '成都汐辰服饰有限公司', 0, '2022-06-01 10:30:05', '2022-06-01 10:30:08');
INSERT INTO `t_goods_type` VALUES ('1539434735584059409', '男装短外套', '1539247340007927809', '成都汐辰服饰有限公司', 0, '2022-06-01 10:30:05', '2022-06-01 10:30:08');
INSERT INTO `t_goods_type` VALUES ('1539434735584059410', '男装棉服', '1539247340007927809', '成都汐辰服饰有限公司', 0, '2022-06-01 10:30:05', '2022-06-01 10:30:08');
INSERT INTO `t_goods_type` VALUES ('1539434735584059411', '休闲裤男', '1539247340007927809', '成都汐辰服饰有限公司', 0, '2022-06-01 10:30:05', '2022-06-01 10:30:08');
INSERT INTO `t_goods_type` VALUES ('1539434735584059412', '短裤男', '1539247340007927809', '成都汐辰服饰有限公司', 0, '2022-06-01 10:30:05', '2022-06-01 10:30:08');
INSERT INTO `t_goods_type` VALUES ('1539434735584059413', '牛仔裤男', '1539247340007927809', '成都汐辰服饰有限公司', 0, '2022-06-01 10:30:05', '2022-06-01 10:30:08');
INSERT INTO `t_goods_type` VALUES ('1539434735584059414', '运动裤男', '1539247340007927809', '成都汐辰服饰有限公司', 0, '2022-06-01 10:30:05', '2022-06-01 10:30:08');
INSERT INTO `t_goods_type` VALUES ('1539434735584059415', '连衣裙', '1539247340007927809', '成都汐辰服饰有限公司', 0, '2022-06-01 10:30:05', '2022-06-01 10:30:08');
INSERT INTO `t_goods_type` VALUES ('1539434735584059416', '半身裙', '1539247340007927809', '成都汐辰服饰有限公司', 0, '2022-06-01 10:30:05', '2022-06-01 10:30:08');
INSERT INTO `t_goods_type` VALUES ('1539434735584059417', '女装T恤', '1539247340007927809', '成都汐辰服饰有限公司', 0, '2022-06-01 10:30:05', '2022-06-01 10:30:08');
INSERT INTO `t_goods_type` VALUES ('1539434735584059418', '女装衬衫', '1539247340007927809', '成都汐辰服饰有限公司', 0, '2022-06-01 10:30:05', '2022-06-01 10:30:08');
INSERT INTO `t_goods_type` VALUES ('1539434735584059419', '蕾丝雪纺衫', '1539247340007927809', '成都汐辰服饰有限公司', 0, '2022-06-01 10:30:05', '2022-06-01 10:30:08');
INSERT INTO `t_goods_type` VALUES ('1539434735584059420', '毛衣针织', '1539247340007927809', '成都汐辰服饰有限公司', 0, '2022-06-01 10:30:05', '2022-06-01 10:30:08');
INSERT INTO `t_goods_type` VALUES ('1539434735584059421', '女装卫衣', '1539247340007927809', '成都汐辰服饰有限公司', 0, '2022-06-01 10:30:05', '2022-06-01 10:30:08');
INSERT INTO `t_goods_type` VALUES ('1539434735584059422', '女装风衣', '1539247340007927809', '成都汐辰服饰有限公司', 0, '2022-06-01 10:30:05', '2022-06-01 10:30:08');
INSERT INTO `t_goods_type` VALUES ('1539434735584059423', '女装皮衣', '1539247340007927809', '成都汐辰服饰有限公司', 0, '2022-06-01 10:30:05', '2022-06-01 10:30:08');
INSERT INTO `t_goods_type` VALUES ('1539434735584059424', '女装短外套', '1539247340007927809', '成都汐辰服饰有限公司', 0, '2022-06-01 10:30:05', '2022-06-01 10:30:08');
INSERT INTO `t_goods_type` VALUES ('1539434735584059425', '女装羽绒服', '1539247340007927809', '成都汐辰服饰有限公司', 0, '2022-06-01 10:30:05', '2022-06-01 10:30:08');
INSERT INTO `t_goods_type` VALUES ('1539434735584059426', '洛丽塔', '1539247340007927809', '成都汐辰服饰有限公司', 0, '2022-06-01 10:30:05', '2022-06-01 10:30:08');
INSERT INTO `t_goods_type` VALUES ('1539434735584059427', '汉服', '1539247340007927809', '成都汐辰服饰有限公司', 0, '2022-06-01 10:30:05', '2022-06-01 10:30:08');
INSERT INTO `t_goods_type` VALUES ('1539434735584059428', '牛仔裤女', '1539247340007927809', '成都汐辰服饰有限公司', 0, '2022-06-01 10:30:05', '2022-06-01 10:30:08');
INSERT INTO `t_goods_type` VALUES ('1539434735584059429', '工装裤女', '1539247340007927809', '成都汐辰服饰有限公司', 0, '2022-06-01 10:30:05', '2022-06-01 10:30:08');
INSERT INTO `t_goods_type` VALUES ('1539434735584059430', '短裤女', '1539247340007927809', '成都汐辰服饰有限公司', 0, '2022-06-01 10:30:05', '2022-06-01 10:30:08');
INSERT INTO `t_goods_type` VALUES ('1539434735584059431', '休闲裤女', '1539247340007927809', '成都汐辰服饰有限公司', 0, '2022-06-01 10:30:05', '2022-06-01 10:30:08');
INSERT INTO `t_goods_type` VALUES ('1539434735584059432', '打底裤', '1539247340007927809', '成都汐辰服饰有限公司', 0, '2022-06-01 10:30:05', '2022-06-01 10:30:08');
INSERT INTO `t_goods_type` VALUES ('1539434735584059433', '男士内裤', '1539247340007927809', '成都汐辰服饰有限公司', 0, '2022-06-01 10:30:05', '2022-06-01 10:30:08');
INSERT INTO `t_goods_type` VALUES ('1539434735584059434', '女士内裤', '1539247340007927809', '成都汐辰服饰有限公司', 0, '2022-06-01 10:30:05', '2022-06-01 10:30:08');
COMMIT;

-- ----------------------------
-- Table structure for t_log
-- ----------------------------
DROP TABLE IF EXISTS `t_log`;
CREATE TABLE `t_log` (
  `id` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `entity_id` varchar(30) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '实体ID',
  `table_name` varchar(50) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '表名',
  `opt_type` varchar(60) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '操作类型',
  `opt_time` datetime DEFAULT NULL COMMENT '操作时间',
  `emp_id` varchar(30) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '操作人员',
  `emp_name` varchar(50) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '操作人员姓名',
  `remark` varchar(255) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='操作日志';

-- ----------------------------
-- Records of t_log
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for t_meeting
-- ----------------------------
DROP TABLE IF EXISTS `t_meeting`;
CREATE TABLE `t_meeting` (
  `id` varchar(30) CHARACTER SET utf8mb3 NOT NULL COMMENT '主键',
  `uuid` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'UUID',
  `title` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '会议题目',
  `creator_id` bigint NOT NULL COMMENT '创建人ID',
  `date` date NOT NULL COMMENT '日期',
  `place` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '开会地点',
  `start` time NOT NULL COMMENT '开始时间',
  `end` time NOT NULL COMMENT '结束时间',
  `type` int unsigned NOT NULL DEFAULT '1' COMMENT '会议类型（1在线会议，2线下会议）',
  `members` json NOT NULL COMMENT '参与者',
  `content` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '会议内容',
  `instance_id` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '工作流实例ID',
  `present` json DEFAULT NULL COMMENT '出席人员名单',
  `unpresent` json DEFAULT NULL COMMENT '未出席人员名单',
  `status` int unsigned NOT NULL DEFAULT '1' COMMENT '状态（1.申请中，2.审批未通过，3.审批通过，4.会议进行中，5.会议结束）',
  `create_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_creator_id` (`creator_id`) USING BTREE,
  KEY `idx_date` (`date`) USING BTREE,
  KEY `idx_type` (`type`) USING BTREE,
  KEY `idx_status` (`status`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='会议表';

-- ----------------------------
-- Records of t_meeting
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for t_meeting_room
-- ----------------------------
DROP TABLE IF EXISTS `t_meeting_room`;
CREATE TABLE `t_meeting_room` (
  `id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '会议室名称',
  `max` int unsigned NOT NULL DEFAULT '0' COMMENT '最大人数',
  `remark` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  `status` tinyint DEFAULT '1' COMMENT '状态，0启用，1禁用',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='会议室表';

-- ----------------------------
-- Records of t_meeting_room
-- ----------------------------
BEGIN;
INSERT INTO `t_meeting_room` VALUES ('1541594950379180032', '大会议室A01', 80, '公司公共会议室', 0, NULL, NULL);
INSERT INTO `t_meeting_room` VALUES ('1541594950379180033', '大会议室A02', 30, '销售部会议室', 0, NULL, NULL);
INSERT INTO `t_meeting_room` VALUES ('1541594950379180034', '小会议室C01', 10, '公共会议室', 0, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `order_num` varchar(30) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '订单编号',
  `creater_id` varchar(30) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建人ID',
  `creater` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '订单创建人',
  `order_type` int unsigned NOT NULL DEFAULT '1' COMMENT '订单类型，1采购单，2运输单，3入库单，4销售单',
  `order_state` int unsigned NOT NULL DEFAULT '1' COMMENT '订单状态，1未审核，2审核未通过，3审核通过，4待采购，5待指派，6采购中，7采购完成，8待入库，9入库中，10入库完成',
  `total` int unsigned NOT NULL DEFAULT '0' COMMENT '订单商品总数',
  `order_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '订单商品总价',
  `checker_id` varchar(30) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '审核人ID',
  `checker` varchar(50) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '订单审核人',
  `checker_time` datetime DEFAULT NULL COMMENT '审核时间',
  `completer_id` varchar(30) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '订单负责人ID',
  `completer` varchar(50) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '订单负责人',
  `supplier_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '供应商ID',
  `supplier_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '供应商名称',
  `create_time` datetime DEFAULT NULL COMMENT '订单创建时间',
  `end_time` datetime DEFAULT NULL COMMENT '订单结束时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `no` (`order_num`) USING BTREE COMMENT '订单号唯一'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='订单';

-- ----------------------------
-- Records of t_order
-- ----------------------------
BEGIN;
INSERT INTO `t_order` VALUES ('1', 'A06011200451111', '1538874512666435584', '许星海', 1, 1, 2, 10.00, '1538874512666435584', '许星海', '2022-06-03 18:20:28', '1539162035980496896', '张若虚', '1539247340007927809', '成都汐辰服饰有限公司', '2022-06-01 18:21:42', '2022-06-05 18:21:45', '2022-06-26 18:21:51');
COMMIT;

-- ----------------------------
-- Table structure for t_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_order_detail`;
CREATE TABLE `t_order_detail` (
  `id` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `price` decimal(10,2) NOT NULL COMMENT '商品进价单价',
  `num` int unsigned NOT NULL DEFAULT '0' COMMENT '商品总数目',
  `surplus` int unsigned NOT NULL DEFAULT '0' COMMENT '剩余数目',
  `goods_id` varchar(30) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '商品ID',
  `order_id` varchar(30) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '订单ID',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='订单明细';

-- ----------------------------
-- Records of t_order_detail
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for t_store
-- ----------------------------
DROP TABLE IF EXISTS `t_store`;
CREATE TABLE `t_store` (
  `id` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(60) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '仓库名称',
  `address` varchar(100) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '仓库地址',
  `emp_id` varchar(30) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '仓库管理员ID',
  `emp_name` varchar(660) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '仓库管理员名称',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='仓库';

-- ----------------------------
-- Records of t_store
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for t_store_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_store_detail`;
CREATE TABLE `t_store_detail` (
  `id` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `store_id` varchar(30) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '仓库ID',
  `goods_id` varchar(30) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '商品ID',
  `goods_name` varchar(60) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '商品名称',
  `num` int unsigned NOT NULL DEFAULT '0' COMMENT '数量',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='仓库明细';

-- ----------------------------
-- Records of t_store_detail
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for t_supplier
-- ----------------------------
DROP TABLE IF EXISTS `t_supplier`;
CREATE TABLE `t_supplier` (
  `id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '供应商公司名称',
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '供应商公司地址',
  `contact` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '联系人',
  `mobile` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '电话',
  `needs` int NOT NULL COMMENT '是否送货，1送货，2自提',
  `del_flag` int NOT NULL DEFAULT '0' COMMENT '0正常，1删除',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_mobile` (`mobile`) USING BTREE COMMENT '手机号唯一'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='供应商';

-- ----------------------------
-- Records of t_supplier
-- ----------------------------
BEGIN;
INSERT INTO `t_supplier` VALUES ('1539247340007927808', '苏州上集家具有限公司', '江苏省苏州市相城区名扬路16号', '欧天赐', '4008-113-229', 1, 0, NULL, NULL);
INSERT INTO `t_supplier` VALUES ('1539247340007927809', '成都汐辰服饰有限公司', '四川省成都市新都区大丰街道三元路', '聂华祥', '18919575289', 2, 0, NULL, NULL);
INSERT INTO `t_supplier` VALUES ('1539906707698995200', '测试供应商', '白沙大道', '白女士', '13555555555', 1, 0, '2022-06-23 09:42:24', '2022-06-23 10:04:23');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
