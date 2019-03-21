/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : day17

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2019-03-21 17:00:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `gender` varchar(5) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `address` varchar(32) DEFAULT NULL,
  `qq` varchar(20) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `username` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'zhangsan', '女', '19', '陕西', '12345611', 'qq754885314@qq.com', 'zz', '123');
INSERT INTO `user` VALUES ('2', '吴晓彤', '女', '18', '东莞', '666666', '666@qq.com', 'wuxiaotong', '123');
INSERT INTO `user` VALUES ('3', '吴晓彤', '女', '18', '东莞', '666666', '666@qq.com', null, '123');
INSERT INTO `user` VALUES ('22', 'zhangsan', '女', '19', '陕西', '12345611', 'qq754885314@qq.com', null, '123');
INSERT INTO `user` VALUES ('23', '吴晓彤', '女', '18', '东莞', '666666', '666@qq.com', null, '123');
INSERT INTO `user` VALUES ('24', '吴晓彤', '女', '18', '东莞', '666666', '666@qq.com', null, '123');
INSERT INTO `user` VALUES ('25', 'zhangsan', '女', '19', '陕西', '12345611', 'qq754885314@qq.com', null, '123');
INSERT INTO `user` VALUES ('26', '吴晓彤', '女', '18', '东莞', '666666', '666@qq.com', null, '123');
INSERT INTO `user` VALUES ('27', '吴晓彤', '女', '18', '东莞', '666666', '666@qq.com', null, '123');
INSERT INTO `user` VALUES ('28', 'zhangsan', '女', '19', '陕西', '12345611', 'qq754885314@qq.com', null, '123');
INSERT INTO `user` VALUES ('29', '吴晓彤', '女', '18', '东莞', '666666', '666@qq.com', null, '123');
INSERT INTO `user` VALUES ('30', '吴晓彤', '女', '18', '东莞', '666666', '666@qq.com', null, '123');
INSERT INTO `user` VALUES ('31', 'zhangsan', '女', '19', '陕西', '12345611', 'qq754885314@qq.com', null, '123');
INSERT INTO `user` VALUES ('32', '吴晓彤', '女', '18', '东莞', '666666', '666@qq.com', null, '123');
INSERT INTO `user` VALUES ('55', '谢彪彪', '男', '21', '东莞', '77777', '77@qq.com', 'xierenbiao', '123456');
