/*
Navicat MySQL Data Transfer

Source Server         : MySQL5.6
Source Server Version : 50647
Source Host           : localhost:3306
Source Database       : bbs

Target Server Type    : MYSQL
Target Server Version : 50647
File Encoding         : 65001

Date: 2021-05-23 09:42:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book_tb
-- ----------------------------
DROP TABLE IF EXISTS `book_tb`;
CREATE TABLE `book_tb` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(255) DEFAULT NULL,
  `book_author` varchar(255) DEFAULT NULL,
  `book_publisher` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=171 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book_tb
-- ----------------------------
INSERT INTO `book_tb` VALUES ('154', '《高等数学》---------------22222222222', '不是孙悟空', '清华------------北大');
INSERT INTO `book_tb` VALUES ('155', '《操作系统》5855', '东海龙王5445445', '清华778887');
INSERT INTO `book_tb` VALUES ('157', '《软件工程》', '沙师弟', '东南大学');
INSERT INTO `book_tb` VALUES ('158', '《深度学习》', 'Hitton', '麻省理工学院');
INSERT INTO `book_tb` VALUES ('159', '《数据库》', '陈独秀', '三国');
INSERT INTO `book_tb` VALUES ('160', '《红楼梦》', '曹雪芹', '清朝');
INSERT INTO `book_tb` VALUES ('161', '《嵌入式》', '宋江', '清华');
INSERT INTO `book_tb` VALUES ('162', '《数据结构》', '李白', '白砂糖');
INSERT INTO `book_tb` VALUES ('163', '《计算机网络》', '杜小甫', '华南理工大学');
INSERT INTO `book_tb` VALUES ('164', '《机器学习》', '周志华', '南京大学');
INSERT INTO `book_tb` VALUES ('165', '《机器学习》', '周志华', '南京大学');
INSERT INTO `book_tb` VALUES ('166', '《线性代数》', '鲁智深', '北京理工');
INSERT INTO `book_tb` VALUES ('168', '《C++程序设计》', '高手在民间', '清华大学');
INSERT INTO `book_tb` VALUES ('169', '《读者》', '青年', '中国教育');
INSERT INTO `book_tb` VALUES ('170', '745454', '788787', '455454');

-- ----------------------------
-- Table structure for borrow_tb
-- ----------------------------
DROP TABLE IF EXISTS `borrow_tb`;
CREATE TABLE `borrow_tb` (
  `reader_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  PRIMARY KEY (`reader_id`,`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrow_tb
-- ----------------------------
INSERT INTO `borrow_tb` VALUES ('1', '1');
INSERT INTO `borrow_tb` VALUES ('1', '2');
INSERT INTO `borrow_tb` VALUES ('1', '3');
INSERT INTO `borrow_tb` VALUES ('2', '1');
INSERT INTO `borrow_tb` VALUES ('2', '3');

-- ----------------------------
-- Table structure for reader_tb
-- ----------------------------
DROP TABLE IF EXISTS `reader_tb`;
CREATE TABLE `reader_tb` (
  `reader_id` int(11) NOT NULL AUTO_INCREMENT,
  `reader_name` varchar(255) DEFAULT NULL,
  `reader_sex` varchar(255) DEFAULT NULL,
  `reader_age` int(11) DEFAULT NULL,
  PRIMARY KEY (`reader_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reader_tb
-- ----------------------------
INSERT INTO `reader_tb` VALUES ('1', 'bob', '男', '12');
INSERT INTO `reader_tb` VALUES ('2', '李四', '女', '30');
INSERT INTO `reader_tb` VALUES ('3', '王六', '男', '40');
INSERT INTO `reader_tb` VALUES ('5', 'adad', 'xyshhsfsfay2', '45');

-- ----------------------------
-- Table structure for user_tb
-- ----------------------------
DROP TABLE IF EXISTS `user_tb`;
CREATE TABLE `user_tb` (
  `uid` int(11) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_tb
-- ----------------------------
INSERT INTO `user_tb` VALUES ('123', 'aaa', 'aaa', 'admin');
INSERT INTO `user_tb` VALUES ('456', 'bbb', 'bbb', 'reader');
