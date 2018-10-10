-- MySQL dump 10.13  Distrib 8.0.12, for macos10.13 (x86_64)
--
-- Host: localhost    Database: icbc
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `order_car__user`
--

DROP TABLE IF EXISTS `order_car__user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order_car__user` (
  `order_id` varchar(50) NOT NULL COMMENT '订单id',
  `user_id` varchar(50) NOT NULL COMMENT '用户id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务级 记录类 参与拼车的用户记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `order_car_already_complete`
--

DROP TABLE IF EXISTS `order_car_already_complete`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order_car_already_complete` (
  `order_id` varchar(50) NOT NULL COMMENT '订单号',
  `user_id` varchar(50) NOT NULL COMMENT '提供服务的用户id',
  `entry_id` varchar(50) NOT NULL COMMENT '拼车要求的实体id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `order_end_time` datetime NOT NULL COMMENT '订单结束时间',
  `all_end_time` datetime NOT NULL COMMENT '全部结束时间',
  `order_all_cost` varchar(17) NOT NULL COMMENT '交易总额',
  `driver_name` varchar(50) NOT NULL COMMENT '车主姓名',
  `car_number` varchar(50) NOT NULL COMMENT '车牌号',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务级 拼车类 已完成拼车';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `order_car_canceled`
--

DROP TABLE IF EXISTS `order_car_canceled`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order_car_canceled` (
  `order_id` varchar(50) NOT NULL COMMENT '订单号',
  `user_id` varchar(50) NOT NULL COMMENT '提供服务的用户id',
  `entry_id` varchar(50) DEFAULT NULL COMMENT '拼车要求的实体id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `canceled_time` datetime DEFAULT NULL COMMENT '取消时间',
  `order_all_cost` varchar(17) DEFAULT NULL COMMENT '交易总额',
  `driver_name` varchar(50) DEFAULT NULL COMMENT '车主姓名',
  `car_number` varchar(50) DEFAULT NULL COMMENT '车牌号',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务级 拼车类 已取消拼车';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `order_car_is_driving`
--

DROP TABLE IF EXISTS `order_car_is_driving`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order_car_is_driving` (
  `order_id` varchar(50) NOT NULL COMMENT '订单号',
  `user_id` varchar(50) NOT NULL COMMENT '提供服务的用户id',
  `entry_id` varchar(50) NOT NULL COMMENT '拼车要求的实体id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `order_end_time` datetime NOT NULL COMMENT '订单结束时间',
  `order_all_cost` varchar(17) NOT NULL COMMENT '交易总额',
  `driver_name` varchar(50) NOT NULL COMMENT '车主姓名',
  `car_number` varchar(50) NOT NULL COMMENT '车牌号',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务级 拼车类 正在行驶的拼车订单信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `order_car_is_waiting`
--

DROP TABLE IF EXISTS `order_car_is_waiting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order_car_is_waiting` (
  `order_id` varchar(50) NOT NULL COMMENT '订单号',
  `user_id` varchar(50) NOT NULL COMMENT '提供服务的用户id',
  `entry_id` varchar(50) NOT NULL COMMENT '拼车要求的实体id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `order_all_cost` varchar(17) NOT NULL COMMENT '交易总额',
  `driver_name` varchar(50) NOT NULL COMMENT '车主姓名',
  `car_number` varchar(50) NOT NULL COMMENT '车牌号',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务级 拼车类 正在等待加入的拼车订单信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `order_commercial__user`
--

DROP TABLE IF EXISTS `order_commercial__user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order_commercial__user` (
  `user_id` varchar(50) DEFAULT NULL COMMENT '用户主键',
  `order_id` varchar(50) NOT NULL COMMENT '订单id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务级-记录类-已完成的商品类拼单-参与拼单的用户映射';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `order_commercial_already_complete`
--

DROP TABLE IF EXISTS `order_commercial_already_complete`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order_commercial_already_complete` (
  `order_id` varchar(50) NOT NULL COMMENT '订单号',
  `user_id` varchar(50) NOT NULL COMMENT '提供服务的用户id',
  `entry_id` varchar(50) NOT NULL COMMENT '进行交易的商品实体id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `end_time` datetime NOT NULL COMMENT '结束时间',
  `order_all_cost` varchar(17) NOT NULL COMMENT '交易总金额'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务级 记录类 已完成的商品拼单记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `order_commercial_canceled`
--

DROP TABLE IF EXISTS `order_commercial_canceled`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order_commercial_canceled` (
  `order_id` varchar(50) NOT NULL COMMENT '订单号',
  `user_id` varchar(50) NOT NULL COMMENT '提供服务的用户id',
  `entry_id` varchar(50) DEFAULT NULL COMMENT '进行交易的商品实体id',
  `create_time` datetime NOT NULL COMMENT '常见时间',
  `cancel_time` datetime NOT NULL COMMENT '取消时间',
  `order_all_cost` varchar(17) NOT NULL COMMENT '交易总金额'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务级 记录类 已取消的商品拼单记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `order_commercial_is_waiting`
--

DROP TABLE IF EXISTS `order_commercial_is_waiting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order_commercial_is_waiting` (
  `order_id` varchar(50) NOT NULL COMMENT '订单号',
  `user_id` varchar(50) NOT NULL COMMENT '提供服务的用户id',
  `entry_id` varchar(50) NOT NULL COMMENT '进行交易的商品实体id',
  `create_time` datetime NOT NULL COMMENT '开始日期',
  `order_all_cost` varchar(17) NOT NULL COMMENT '交易总金额',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务级 记录类 正在进行的商品拼单记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `order_entity_car`
--

DROP TABLE IF EXISTS `order_entity_car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order_entity_car` (
  `entry_id` varchar(50) NOT NULL COMMENT '拼车实体id',
  `user_id` varchar(50) NOT NULL COMMENT '提出要求的用户id',
  `driver_sex` int(11) NOT NULL COMMENT '0-无要求 1-male 2-female',
  `companion_sex` varchar(50) NOT NULL COMMENT 'xmale#yfemale e.g. value = "3male#4female" with /^(d*)male(d*)female$/.test(value) == true',
  `other` varchar(255) DEFAULT NULL COMMENT '其他要求和备注',
  PRIMARY KEY (`entry_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务级 实体类 拼车要求实体';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `order_entity_commercial_item`
--

DROP TABLE IF EXISTS `order_entity_commercial_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order_entity_commercial_item` (
  `entry_id` varchar(50) NOT NULL COMMENT '商户商品id',
  `user_id` varchar(50) NOT NULL COMMENT '隶属商户id',
  `commercial_item_name` varchar(50) NOT NULL COMMENT '商户商品名称',
  `commercial_item_amount` varchar(17) NOT NULL COMMENT '商户商品价格',
  `commercial_item_summary` varchar(255) DEFAULT NULL COMMENT '商品备注和摘要',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `commercial_item_left_number` int(11) NOT NULL COMMENT '剩余数量',
  PRIMARY KEY (`entry_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务级 实体类 商品实体';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `order_entity_house`
--

DROP TABLE IF EXISTS `order_entity_house`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order_entity_house` (
  `entry_id` varchar(50) NOT NULL COMMENT '租房要求实体',
  `user_id` varchar(50) NOT NULL COMMENT '提出要求的用户id',
  `roommate_sex` varchar(50) NOT NULL COMMENT '室友性别 xmale#yfemale  ',
  `house_style` varchar(50) DEFAULT NULL COMMENT '户型要求',
  `house_other` varchar(255) DEFAULT NULL COMMENT '其他要求',
  PRIMARY KEY (`entry_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务级 拼单类 租房要求';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `order_house__user`
--

DROP TABLE IF EXISTS `order_house__user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order_house__user` (
  `user_id` varchar(50) NOT NULL COMMENT '用户id',
  `order_id` varchar(50) NOT NULL COMMENT '订单id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务级 记录类 参与租房的用户映射';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `order_house_already_complete`
--

DROP TABLE IF EXISTS `order_house_already_complete`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order_house_already_complete` (
  `order_id` varchar(50) NOT NULL,
  `user_id` varchar(50) NOT NULL COMMENT '参与租房的用户id',
  `entry_id` varchar(50) NOT NULL COMMENT '拼租要求的实体id',
  `create_time` datetime NOT NULL COMMENT '发起时间',
  `end_time` datetime NOT NULL COMMENT '结束时间',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务级 已完成的拼租记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `order_house_canceled`
--

DROP TABLE IF EXISTS `order_house_canceled`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order_house_canceled` (
  `order_id` varchar(50) NOT NULL,
  `user_id` varchar(50) NOT NULL COMMENT '参与租房的用户id',
  `entry_id` varchar(50) NOT NULL COMMENT '拼租要求的实体id',
  `create_time` datetime NOT NULL COMMENT '发起时间',
  `end_time` datetime NOT NULL COMMENT '结束时间',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务级 已取消的拼租记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `order_house_is_waiting`
--

DROP TABLE IF EXISTS `order_house_is_waiting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order_house_is_waiting` (
  `order_id` varchar(50) NOT NULL,
  `user_id` varchar(50) NOT NULL COMMENT '发起租房的用户id',
  `entry_id` varchar(50) NOT NULL COMMENT '拼租要求的实体id',
  `create_time` datetime NOT NULL COMMENT '发起时间',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务级 正在进行的拼租记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `other_location`
--

DROP TABLE IF EXISTS `other_location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `other_location` (
  `user_id` varchar(50) NOT NULL COMMENT '用户id',
  `longitude` varchar(20) NOT NULL COMMENT '经度',
  `latitude` varchar(20) NOT NULL COMMENT '纬度',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `other_session`
--

DROP TABLE IF EXISTS `other_session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `other_session` (
  `session_id` varchar(50) NOT NULL COMMENT 'session id',
  `user_id` varchar(50) NOT NULL COMMENT '用户主键',
  `session_token` varchar(50) NOT NULL COMMENT 'session值',
  PRIMARY KEY (`session_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户session记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `system_record_all_order`
--

DROP TABLE IF EXISTS `system_record_all_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `system_record_all_order` (
  `order_id` varchar(50) NOT NULL COMMENT '订单id',
  `create_time` datetime NOT NULL COMMENT '发起时间',
  `order_type` int(11) NOT NULL COMMENT '拼单的类型 0-商户类型 1-出行类型',
  `pay_all_amount` varchar(17) DEFAULT NULL COMMENT '拼单消费总金额',
  `order_status` int(11) NOT NULL COMMENT '0-已完成 1-未完成',
  `user_id` varchar(50) NOT NULL COMMENT '提供服务的商户主键',
  `entry_id` varchar(50) NOT NULL COMMENT '交易的实体主键',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统级 记录类 全部订单记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `system_record_all_order__user`
--

DROP TABLE IF EXISTS `system_record_all_order__user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `system_record_all_order__user` (
  `user_id` varchar(50) NOT NULL COMMENT '用户主键',
  `order_id` varchar(50) NOT NULL COMMENT '订单id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统级-记录类-全部订单信息-订单号与用户id的映射表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `system_record_all_trans`
--

DROP TABLE IF EXISTS `system_record_all_trans`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `system_record_all_trans` (
  `api_corp_no` varchar(20) DEFAULT NULL COMMENT 'api字段 合作方机构编号',
  `api_trx_acc_date` date NOT NULL COMMENT 'api字段 交易日期',
  `api_trx_acc_time` varchar(8) DEFAULT NULL COMMENT 'api字段 交易时间',
  `api_corp_serno` varchar(10) NOT NULL COMMENT 'api字段交易订单号',
  `api_out_service_code` varchar(20) NOT NULL COMMENT 'api字段 外部服务代码',
  `api_medium_id` varchar(44) DEFAULT NULL COMMENT 'api字段 卡号',
  `api_amount` varchar(17) DEFAULT NULL COMMENT '交易额',
  `api_summary` varchar(20) DEFAULT NULL COMMENT 'api字段 摘要 考虑存储商品名称',
  `user_id` varchar(50) NOT NULL COMMENT '发起人的用户id',
  `entry_id` varchar(50) NOT NULL COMMENT '交易的实体id',
  `order_id` varchar(50) NOT NULL COMMENT '业务字段 拼单的订单id',
  `order_type` int(11) NOT NULL COMMENT '业务字段 拼单结果 0-转账 1-已退款 2-返现',
  PRIMARY KEY (`api_out_service_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统级 记录类 记录全部交易转账记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `system_registered_commercial`
--

DROP TABLE IF EXISTS `system_registered_commercial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `system_registered_commercial` (
  `api_bind_medium` varchar(50) NOT NULL COMMENT 'api字段 绑定的一类卡号',
  `api_cert_type` int(11) DEFAULT '0' COMMENT 'api字段 认证的类型（默认为身份证，一般不变）',
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键 用户id\n',
  `user_alive_code` int(11) NOT NULL COMMENT '用户唯一识别介质码（类似与微信号）',
  `real_name` varchar(255) NOT NULL COMMENT 'api字段 用户姓名',
  `sex` int(11) NOT NULL COMMENT 'api字段 性别(1-男 2-女)',
  `phone` varchar(11) NOT NULL COMMENT 'api字段 用户手机号',
  `nick_name` varchar(255) NOT NULL COMMENT '业务字段 昵称',
  `hash_password` varchar(50) NOT NULL COMMENT 'hash后的密码',
  `credit_line` int(11) DEFAULT '0' COMMENT '业务字段 信用度',
  `create_time` datetime DEFAULT NULL COMMENT '业务字段 创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间\n',
  `commercial_vertify_info` text COMMENT '业务字段 商户认证信息',
  `commercial_type` int(11) DEFAULT NULL COMMENT '商户类型 0-商家类型 1-出行类型',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统级-已注册用户-商户 定义全部已注册的商户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `system_registered_user`
--

DROP TABLE IF EXISTS `system_registered_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `system_registered_user` (
  `api_bind_medium` varchar(50) NOT NULL COMMENT 'api字段 绑定的一类卡号',
  `api_cert_type` int(11) DEFAULT '0' COMMENT 'api字段 认证的类型（默认为身份证，一般不变）',
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键 用户id\n',
  `user_alive_code` int(11) NOT NULL COMMENT '用户唯一识别介质码（类似与微信号）',
  `real_name` varchar(255) NOT NULL COMMENT 'api字段 用户姓名',
  `sex` int(11) NOT NULL COMMENT 'api字段 性别(1-男 2-女)',
  `phone` varchar(11) NOT NULL COMMENT 'api字段 用户手机号',
  `nick_name` varchar(255) NOT NULL COMMENT '业务字段 昵称',
  `hash_password` varchar(50) NOT NULL COMMENT 'hash后的密码',
  `credit_line` int(11) DEFAULT '0' COMMENT '业务字段 信用度',
  `create_time` datetime DEFAULT NULL COMMENT '业务字段 创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间\n',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='系统级-已注册用户-消费者 定义全部已注册的消费者';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `system_temporary_commercial`
--

DROP TABLE IF EXISTS `system_temporary_commercial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `system_temporary_commercial` (
  `api_bind_medium` varchar(50) NOT NULL COMMENT 'api字段 绑定的一类卡号',
  `api_cert_type` int(11) DEFAULT '0' COMMENT 'api字段 认证的类型（默认为身份证，一般不变）',
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键 用户id\n',
  `user_alive_code` int(11) NOT NULL COMMENT '用户唯一识别介质码（类似与微信号）',
  `real_name` varchar(255) NOT NULL COMMENT 'api字段 用户姓名',
  `sex` int(11) NOT NULL COMMENT 'api字段 性别(1-男 2-女)',
  `phone` varchar(11) NOT NULL COMMENT 'api字段 用户手机号',
  `nick_name` varchar(255) NOT NULL COMMENT '业务字段 昵称',
  `hash_password` varchar(50) NOT NULL COMMENT 'hash后的密码',
  `credit_line` int(11) DEFAULT '0' COMMENT '业务字段 信用度',
  `create_time` datetime DEFAULT NULL COMMENT '业务字段 创建时间',
  `vertify_code` varchar(10) DEFAULT NULL COMMENT '业务字段 待验证的验证码',
  `commercial_type` int(11) NOT NULL COMMENT '业务字段 商户类型 0-商家类型 1-出行类型',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统级-未注册用户-商户 定义正在注册的临时商户信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `system_temporary_user`
--

DROP TABLE IF EXISTS `system_temporary_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `system_temporary_user` (
  `api_bind_medium` varchar(50) NOT NULL COMMENT 'api字段 绑定的一类卡号',
  `api_cert_type` int(11) DEFAULT '0' COMMENT 'api字段 认证的类型（默认为身份证，一般不变）',
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键 用户id\n',
  `user_alive_code` int(11) NOT NULL COMMENT '用户唯一识别介质码（类似与微信号）',
  `real_name` varchar(255) NOT NULL COMMENT 'api字段 用户姓名',
  `sex` int(11) NOT NULL COMMENT 'api字段 性别(1-男 2-女)',
  `phone` varchar(11) NOT NULL COMMENT 'api字段 用户手机号',
  `nick_name` varchar(255) NOT NULL COMMENT '业务字段 昵称',
  `hash_password` varchar(50) NOT NULL COMMENT 'hash后的密码',
  `credit_line` int(11) DEFAULT '0' COMMENT '业务字段 信用度',
  `create_time` datetime DEFAULT NULL COMMENT '业务字段 创建时间',
  `vertify_code` varchar(10) DEFAULT NULL COMMENT '业务字段 待验证的验证码',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统级-未注册用户-消费者 定义正在注册的临时消费者信息';
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-21  1:51:08
