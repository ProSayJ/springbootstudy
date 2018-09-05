/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50639
Source Host           : localhost:3306
Source Database       : bunuo

Target Server Type    : MYSQL
Target Server Version : 50639
File Encoding         : 65001

Date: 2018-05-18 16:00:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) NOT NULL COMMENT '用户名称',
  `password` varchar(255) NOT NULL COMMENT '密码密文',
  `phone` varchar(20) NOT NULL COMMENT '手机号',
  `enable` tinyint(2) NOT NULL COMMENT '是否可用',
  `status` tinyint(3) NOT NULL COMMENT '状态：0-初始化；1-正常；2-初始化支付密码',
  `c_t` bigint(32) NOT NULL COMMENT '创建时间',
  `u_t` bigint(32) NOT NULL COMMENT '更新时间',
  `is_deleted` tinyint(2) NOT NULL COMMENT '已删除',
  `true_name` varchar(255) NOT NULL COMMENT '用户中文名称',
  `job` varchar(255) NOT NULL COMMENT '职务',
  `process` tinyint(2) NOT NULL COMMENT '注册状态- 2：添加用户，3：关联证书，4：设置权限',
  `remark` varchar(255) NOT NULL COMMENT '员工备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=372 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '129fd94aa62c285260832129bd0e5706', '', '1', '1', '1496214858739', '1496214859256', '0', '', '', '2', '');
INSERT INTO `user` VALUES ('282', 'admin1', 'c54211a970e74076e32a15bf235f1bfd', '', '1', '1', '1524832332963', '1524832332963', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('283', 'admin2', '66963c948898c0df94d43cc618461a7c', '', '1', '1', '1524877537025', '1524877537025', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('284', 'jbank1', '343f11808f7b42c9337cb087e9534887', '', '1', '1', '1524879483803', '1524879483803', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('285', 'clbank1', '2bce886d419abc8b1bd2632ae24b6b40', '', '1', '1', '1524880148819', '1524880148819', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('286', 'jcore1', 'bb07b4e1ca244812cb1d7e99f1f1b853', '', '1', '1', '1524880711850', '1524880711850', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('287', 'clcore1', 'a8f02b7b08cd3445953de91ec0b43b64', '', '1', '1', '1524881788998', '1524881788998', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('288', 'yjybank1', '31c7fbeff77c4a17031e4cf1f3cdcf57', '', '1', '1', '1524883106035', '1524883106035', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('289', 'cluser1', '940374b1315be656d908f099e7a1ed8e', '', '1', '1', '1524883953133', '1524883953133', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('291', 'yjycore1', 'e342cc60db31ea7478b5645a37dd3053', '', '1', '1', '1524889327671', '1524889327671', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('298', 'liuwenjieb1', 'cdd2a029fb1ddfb3544ce4509617e1f9', '', '1', '1', '1524899838161', '1524899838161', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('299', 'wbank0', '6c3258d46a6da11733a4f4ec5563e997', '', '1', '1', '1524905646245', '1526538638526', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('300', '28bank1', '1712079a50e50d1c4233381805c95677', '', '1', '1', '1524914765217', '1524914765217', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('301', 'jbemp1', '100fbb4ff4304db5d47365adb0a9bfca', '15665662468', '1', '1', '1524922240012', '1526549028467', '0', '资金方员工', '开发', '4', '资金方员工备注');
INSERT INTO `user` VALUES ('302', 'jcemp1', '4a871be42d14928362f57fce34e28cac', '15555555555', '1', '1', '1524922642142', '1526537698622', '0', '核心企业普通员工', '开发', '4', '核心企业普通员工备注');
INSERT INTO `user` VALUES ('303', 'jsup1', '5f61b537e077e9d27be6a91eccf67359', '', '1', '1', '1524923195659', '1524923195659', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('304', '28core1', '1d0d5f0b1c40fcc2a6d46efd0cf1073e', '', '1', '1', '1525225339512', '1525225339512', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('305', 'yjyuser1', 'f6858a18215cd23478c594ea945c97b6', '', '1', '1', '1525227418048', '1525227418048', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('306', 'wcore0', 'd73bc6c032d9c5e5162c4a15253d1331', '12132', '1', '1', '1525242135603', '1525242135603', '0', '梦君', 'CET', '4', '不晓得');
INSERT INTO `user` VALUES ('307', 'wsup0', 'bbf493b943d877059f0317070f0504e1', '', '1', '1', '1525243937875', '1525243937875', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('308', 'wsup02', '3f06c4b8f61ebf96527faa62373c26dc', '', '1', '1', '1525244862372', '1525244862372', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('309', 'jsemp1', '2b894cb3b0a9ef2c83e7de561eb4eb56', '15665662468', '1', '1', '1525247630705', '1526548126314', '0', '供应商员工', '测试', '4', '供应商员工备注');
INSERT INTO `user` VALUES ('314', 'dbank1', 'b619fcb3ceb9334ca0e151e5edd7627a', '', '1', '1', '1525403138209', '1525403138209', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('315', 'dcore1', 'eb651005c040c6a8119c2c4a6ed80076', '', '1', '1', '1525403705073', '1525403705073', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('316', 'dsup1', '94dd98c844dab68c0e547cb57adbe55f', '', '1', '1', '1525403995972', '1525403995972', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('317', 'yjycore2', 'fd1760f42a0f3c320ba34c87e1f921f5', '', '1', '1', '1525417778472', '1525417778472', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('318', 'lidong520', 'd24358edaa7191ac724601d3bf56a6c2', '', '1', '1', '1525492437959', '1525492437959', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('319', 'qiuyan1', '5624829f3ca3b2e06a6edbe19c4b8b12', '', '1', '1', '1525658815381', '1525658815381', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('320', 'Lhe1', '5e6116b3c53b4428771a3da561a6cb61', '', '1', '1', '1525660350428', '1525660350428', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('321', 'icbc1', '4722c9bd6d89ebc925ea17b9b202fee0', '', '1', '1', '1525675561812', '1525675561812', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('322', 'cqbank1', '124b6061d4b4d4f5fcf834b9d79f1c59', '', '1', '1', '1525680663486', '1525680663486', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('323', 'qiuyan3', '211b1afc1a1b016638e3c62359cf4b54', '', '1', '1', '1525744481881', '1525744481881', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('324', 'qiuyan2', '08b38ced671d1535dd34dde0cb17c6d1', '', '1', '1', '1525745093619', '1525745093619', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('326', 'abc1', '332966d1c4bc49011d1aed07dbf3ea0d', '', '1', '1', '1525832007189', '1525832007189', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('327', 'ljc001', '545d672eda261140e3b6897425174577', '', '1', '1', '1525941359097', '1525941359097', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('328', 'zxy000', 'b4289c555a539da468b34226a1c097e4', '15261468557', '1', '0', '1525951479546', '1525951479546', '0', 'zxy', '职务', '2', '备注');
INSERT INTO `user` VALUES ('329', 'sccbank1', 'd71ba2df9c777c79f7ed8817b13be7da', '', '1', '1', '1526109427415', '1526109427415', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('331', 'wabank1', '21adcc59a6d33d4bc4aff01143498820', '', '1', '1', '1526116394500', '1526116394500', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('332', 'scccore1', '49de16e3d0f56f92152554eda4b0ad13', '', '1', '1', '1526116772531', '1526116772531', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('333', 'sccuser1', '1be8cdcd23a43d7347f0d6f2ded6b37c', '', '1', '1', '1526117107689', '1526117107689', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('334', 'sccuser2', '0dd8427ef5b3724f83282699c94980b8', '', '1', '1', '1526118077321', '1526118077321', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('337', 'wbank1', '959accdda11add90ee2c918d4b721167', '', '1', '1', '1526259843005', '1526259843005', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('338', 'qybank1', '7b6b2e05cabf33e1b69cfbdbae013a89', '', '1', '1', '1526266586089', '1526266586089', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('339', 'wcore1', '6049b2325fcb089b831e022de0360181', '', '1', '1', '1526266925581', '1526266925581', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('340', 'qyuser1', '14cf62c2269471a4d8ac40b7e9df5925', '', '1', '1', '1526268414103', '1526268414103', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('341', 'wsup1', 'eb86a4d3c08e6d63b3d49ccdbff6c6a8', '', '1', '1', '1526270249869', '1526270249869', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('343', 'eee7', '3ee600e5760c1d374cce7946d7e53bba', '5', '1', '0', '1526281223175', '1526281223175', '0', 'e', '', '2', '');
INSERT INTO `user` VALUES ('344', 'kltbank1', '03f9ffa24b35432fc4d99f72ff81d10f', '', '1', '1', '1526350491295', '1526350491295', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('345', 'abc0', 'fded6913cd08280512d00c0f2e1145c6', '', '1', '1', '1526353777216', '1526353777216', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('346', 'core0', 'feec53d1c480f0ad2400c8160ba0759c', '', '1', '1', '1526354227714', '1526354227714', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('347', 'sup0', '35b39ab857e0d72fe53df0808c4db5ea', '', '1', '1', '1526354420667', '1526354420667', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('348', 'kltcore1', 'd04f40211e5de46e0ba1f21e9e5a07c8', '', '1', '1', '1526356031973', '1526356031973', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('349', 'kltuser1', 'e142052f30633be0b23aed0d7b97a132', '', '1', '1', '1526357007667', '1526357007667', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('350', 'sup00', 'd658ea5db193239cbb153cf68e06b712', '', '1', '1', '1526361807082', '1526361807082', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('351', 'yjyuser2', 'c2ac726322a4c54347314a132029362a', '', '1', '1', '1526370106220', '1526370106220', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('353', 'tcyyf1', '33f7cbf54f2e189bfbc207d57c2705cd', '', '1', '1', '1526376778783', '1526376778783', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('354', 'tcbank1', 'b8ff6222d51d9934316a544b60fd8763', '', '1', '1', '1526379721299', '1526379721299', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('355', 'tccore1', '9e334f46e1cb18d90e73c00cb83f07d4', '', '1', '1', '1526380016243', '1526380016243', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('356', '28sup1', '8c0f6ae40ad62210e437ed9480204200', '', '1', '1', '1526439945033', '1526439945033', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('357', 'rybank1', '7e45cc3054ed0f50ad6d152c4b13f6da', '', '1', '1', '1526523112913', '1526523112913', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('358', 'rycore1', '6068ac861cec39eaa071928d5b9be39e', '', '1', '1', '1526524159089', '1526524159089', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('360', 'rysup1', '47c06d6c11cb86832dde958911d15572', '', '1', '1', '1526525268154', '1526525268154', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('361', 'clcore2', 'f544e7e8651e5edc9f79eba665350ed4', '', '1', '1', '1526525474607', '1526525474607', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('362', 'szbank2', '3dcfca651c0dfb396f7fa1f16a091431', '', '1', '1', '1526526867413', '1526526867413', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('363', 'wemp1', '7c3410600ed8c33929144d7fcdcc5596', '1', '1', '1', '1526538934159', '1526539378147', '0', 'jerry', '1', '4', '1');
INSERT INTO `user` VALUES ('364', 'wsemp1', '30a5bce25b4f51799cefc0efd39a517b', '11', '1', '1', '1526539876530', '1526542534554', '0', 'jerryou', '植物', '4', '员工备注');
INSERT INTO `user` VALUES ('365', 'peiqi1', '01e5254b2c8f35d04e9f7da2b97faea2', '', '1', '0', '1526540141815', '1526540141815', '0', '佩奇', '', '2', '');
INSERT INTO `user` VALUES ('366', '28sup01', '2ba62cca376353be17059632974af31d', '1', '1', '0', '1526541569453', '1526541569453', '0', '1', '1', '2', '1');
INSERT INTO `user` VALUES ('367', '28core01', '94eec56efe16f6861f5c55445fc0830f', '1', '1', '0', '1526541731888', '1526541731888', '0', '1', '1', '2', '1');
INSERT INTO `user` VALUES ('368', '28core2', '6588b8b7faa5ef80f8b1ba1806f7b870', '1', '1', '0', '1526542170989', '1526542170989', '0', '1', '1', '2', '1');
INSERT INTO `user` VALUES ('369', 'zijinfang2', 'c02dde70c9b17355fedca10dd1ddbb0a', '', '1', '1', '1526542261848', '1526542261848', '0', '', '', '4', '');
INSERT INTO `user` VALUES ('370', '28sup2', '8b62eb6287f67d5b4f1dbe5e9e911061', '1', '1', '1', '1526542550186', '1526542644203', '0', '1', '1', '4', '1');
INSERT INTO `user` VALUES ('371', 'q1q1', 'ad4cc63f9181d3c0ca735977e3910d23', '1', '1', '0', '1526543533252', '1526543533252', '0', 'jw', '11', '2', '3213');
