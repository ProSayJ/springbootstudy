/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50722
Source Host           : 127.0.0.1:3306
Source Database       : yinuojr_user

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-09-19 11:08:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) NOT NULL COMMENT '用户名',
  `true_name` varchar(255) NOT NULL COMMENT '用户中文名称',
  `salt` varchar(100) NOT NULL COMMENT '盐值',
  `password` varchar(255) NOT NULL COMMENT '登录密码密文',
  `pay_password` varchar(255) NOT NULL COMMENT '支付密码密文',
  `phone` varchar(20) NOT NULL COMMENT '手机号',
  `enable` tinyint(2) NOT NULL COMMENT '账号是否可用 0-不可用 1-可用',
  `status` tinyint(3) NOT NULL COMMENT '状态：0-初始化；1-正常；2-初始化支付密码',
  `remark` varchar(255) NOT NULL COMMENT '用户备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(2) NOT NULL COMMENT ' 是否删除 0-未删除;1-已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=596 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '', 'etcmTk', '129fd94aa62c285260832129bd0e5706', '', '', '1', '1', '', '2017-05-31 03:14:18', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('282', 'admin1', '', 'paJWZz', 'c54211a970e74076e32a15bf235f1bfd', '9ffca794b3bbd6be199672fbd565fbb8', '', '1', '1', '', '2018-04-27 08:32:12', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('283', 'admin2', '', 'i05AtM', '66963c948898c0df94d43cc618461a7c', '755eb4708586b7c8aa2f0105d6ab3725', '', '1', '1', '', '2018-04-28 09:05:37', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('288', 'yjybank1', '', '0vlPOw', '31c7fbeff77c4a17031e4cf1f3cdcf57', '3f963da766b22a45b765f2d611fdd7bf', '', '1', '1', '', '2018-04-28 10:38:26', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('291', 'yjycore1', '', 'vWfj4I', 'e342cc60db31ea7478b5645a37dd3053', 'ae34abd0db27404199e27ff159396af7', '', '1', '1', '', '2018-04-28 12:22:07', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('300', '28bank1', '', 'VWJ3s9', '1712079a50e50d1c4233381805c95677', '7568c122ec5eeb51c61ff80066ffd990', '', '1', '1', '', '2018-04-28 07:26:05', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('304', '28core1', '', 'n5DDf3', '1d0d5f0b1c40fcc2a6d46efd0cf1073e', '4eed59624536e70bcd2c4b88b8fdc56a', '', '1', '1', '', '2018-05-02 09:42:19', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('305', 'yjyuser1', '', 'fS3LLY', 'f6858a18215cd23478c594ea945c97b6', '2c00bd805d920f08bb4bb8c073b8a0f8', '', '1', '1', '', '2018-05-02 10:16:58', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('314', 'dbank1', '', 'QEkntv', 'b619fcb3ceb9334ca0e151e5edd7627a', '568448574cff11ea1a0099e7dac14fbd', '', '1', '1', '', '2018-05-04 11:05:38', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('315', 'dcore1', '', 'fTy4Ng', 'eb651005c040c6a8119c2c4a6ed80076', '9bfd66562657c3a74ce954221a871fca', '', '1', '1', '', '2018-05-04 11:15:05', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('316', 'dsup1', '', 'honixd', '94dd98c844dab68c0e547cb57adbe55f', '691e959ade428719b1d213c35edbeb97', '', '1', '1', '', '2018-05-04 11:19:55', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('317', 'yjycore2', '', 'Ip7edl', 'fd1760f42a0f3c320ba34c87e1f921f5', '4263795f9d47ad6574fd7d5be2537c14', '', '1', '1', '', '2018-05-04 03:09:38', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('319', 'qiuyan1', '', 'ut9WGr', '5624829f3ca3b2e06a6edbe19c4b8b12', '58d8f48cfa328aed5f1b2581aec77cd6', '', '1', '1', '', '2018-05-07 10:06:55', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('320', 'Lhe1', '', 'HwOnOT', '5e6116b3c53b4428771a3da561a6cb61', 'fb138a9fd1d81ade9f27c0da724ce1d0', '', '1', '1', '', '2018-05-07 10:32:30', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('322', 'cqbank1', '', 'rbKwnI', '124b6061d4b4d4f5fcf834b9d79f1c59', '', '', '1', '1', '', '2018-05-07 04:11:03', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('323', 'qiuyan3', 'fevdvfve', '5GhQnA', '211b1afc1a1b016638e3c62359cf4b54', '5e3ca473b6d04a16c6fbf3f0a6f41d82', '13555555555', '1', '1', '4444', '2018-05-08 09:54:41', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('324', 'qiuyan2', '', 'khMAkC', '08b38ced671d1535dd34dde0cb17c6d1', '27f901fdd1366229909c99f3583566b5', '', '1', '1', '', '2018-05-08 10:04:53', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('326', 'abc1', '', 'R7XACV', '332966d1c4bc49011d1aed07dbf3ea0d', '', '', '1', '1', '', '2018-05-09 10:13:27', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('327', 'ljc001', '', 'mpTGC8', '545d672eda261140e3b6897425174577', '0dc294fed2f28444a5926c242f118832', '', '1', '1', '', '2018-05-10 04:35:59', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('329', 'sccbank1', '', 'bV8KXf', 'd71ba2df9c777c79f7ed8817b13be7da', 'f99d7d4e47992e962957ffa1b45c430c', '', '1', '1', '', '2018-05-12 03:17:07', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('331', 'wabank1', '', '1A9fit', '21adcc59a6d33d4bc4aff01143498820', '', '', '1', '1', '', '2018-05-12 05:13:14', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('332', 'scccore1', '', 'yqR947', '49de16e3d0f56f92152554eda4b0ad13', 'bb9afaa4f0cc35371c9c9308fdf571f9', '', '1', '1', '', '2018-05-12 05:19:32', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('333', 'sccuser1', '', 'rKk0B3', '1be8cdcd23a43d7347f0d6f2ded6b37c', '7e2e249aef3c4cae38099fb4b8fd1cbc', '', '1', '1', '', '2018-05-12 05:25:07', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('334', 'sccuser2', '', 'HY0gmc', '0dd8427ef5b3724f83282699c94980b8', 'cbd1a1eca0ff832e921501a4d836543b', '', '1', '1', '', '2018-05-12 05:41:17', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('339', 'wcore1', '', 'RHSFtv', '6049b2325fcb089b831e022de0360181', 'cfc1cebbfa25f7960ce405f3c9aa4b59', '', '1', '1', '', '2018-05-14 11:02:05', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('340', 'qyuser1', '', '0nTX44', '14cf62c2269471a4d8ac40b7e9df5925', 'ff9f3b22a4954a5c915f270fe651a60b', '', '1', '1', '', '2018-05-14 11:26:54', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('341', 'wsup1', '', 'sYHAkY', 'eb86a4d3c08e6d63b3d49ccdbff6c6a8', 'f43513b8d4407241248a4e9782e0ef37', '', '1', '1', '', '2018-05-14 11:57:29', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('343', 'eee7', 'e', 'S3yhdx', '3ee600e5760c1d374cce7946d7e53bba', '', '5', '1', '0', '', '2018-05-14 03:00:23', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('345', 'abc0', '1', 'jqNKV8', 'fded6913cd08280512d00c0f2e1145c6', '7b95e6ad670e205b48d058795d7d3974', '1', '1', '1', '1', '2018-05-15 11:09:37', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('346', 'core0', '', 'mU3tEB', 'feec53d1c480f0ad2400c8160ba0759c', '381c6747149999647f9da87fa796bdfe', '', '1', '1', '', '2018-05-15 11:17:07', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('347', 'sup0', '', 'N7FFlH', '35b39ab857e0d72fe53df0808c4db5ea', 'ba21ce7f98bd061632f8aa3afd23fb3c', '', '1', '1', '', '2018-05-15 11:20:20', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('350', 'sup00', '', 'VH9am3', 'd658ea5db193239cbb153cf68e06b712', 'bf9ea72a0788086a40f0beb94672ba4d', '', '1', '1', '', '2018-05-15 _01_SingleThreadedExecution:23:27', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('351', 'yjyuser2', '', 'WZhOKa', 'c2ac726322a4c54347314a132029362a', '2e4eef29076fa159837ddead3bfbfece', '', '1', '1', '', '2018-05-15 03:41:46', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('356', '28sup1', '', 'pdKhJ9', '8c0f6ae40ad62210e437ed9480204200', 'a295f982dbc5eab47cc9d7e9608aabc7', '', '1', '1', '', '2018-05-16 11:05:45', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('361', 'clcore2', '', ' ', 'f544e7e8651e5edc9f79eba665350ed4', ' ', '', '1', '1', '', '2018-05-17 10:51:14', '2018-05-17 10:51:14', '1');
INSERT INTO `user` VALUES ('362', 'szbank2', '', 'ihFuqz', '3dcfca651c0dfb396f7fa1f16a091431', '', '', '1', '1', '', '2018-05-17 11:14:27', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('363', 'wemp1', 'jerry', 'Q0QWEh', '7c3410600ed8c33929144d7fcdcc5596', '6d39a0816c51ccee6b63d241096f5629', '1', '1', '1', '1', '2018-05-17 02:35:34', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('364', 'wsemp1', 'jerryou', '0i2GQo', '30a5bce25b4f51799cefc0efd39a517b', '92767278708d44f1b60b99ffb463d0a3', '11', '1', '1', '员工备注', '2018-05-17 02:51:16', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('365', 'peiqi1', '佩奇', 'Vtlukq', '01e5254b2c8f35d04e9f7da2b97faea2', '', '', '1', '0', '', '2018-05-17 02:55:41', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('366', '28sup01', '1', 'M8HKWK', '2ba62cca376353be17059632974af31d', '', '1', '1', '0', '1', '2018-05-17 03:19:29', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('367', '28core01', '1', 'LmeXCb', '94eec56efe16f6861f5c55445fc0830f', '', '1', '1', '0', '1', '2018-05-17 03:22:11', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('368', '28core2', '1', 'v8EMlu', '6588b8b7faa5ef80f8b1ba1806f7b870', '', '1', '1', '0', '1', '2018-05-17 03:29:30', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('369', 'zijinfang2', '', 'v6RYzO', 'c02dde70c9b17355fedca10dd1ddbb0a', '8767fea6f80bd643565e01fb56f5ee44', '', '1', '1', '', '2018-05-17 03:31:_01_SingleThreadedExecution', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('370', '28sup2', '1', 'aF4BH1', '8b62eb6287f67d5b4f1dbe5e9e911061', '6408a89006fb00af0c7a7e8b08d8200c', '1', '1', '1', '1', '2018-05-17 03:35:50', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('371', 'q1q1', 'jw', 'ljfHVU', 'ad4cc63f9181d3c0ca735977e3910d23', '', '1', '1', '0', '3213', '2018-05-17 03:52:13', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('373', 'abank1', 'casfsd', 'HEs0hz', '880d7d808aa4d741d70edf25365aacb6', 'ccf165aec024f2fca059e773d56d6df8', '', '1', '1', '', '2018-05-21 04:50:32', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('374', 'core00', '陈', 'vsJlUl', '12b10766c81f059ca839167731ad4ece', '953cdcabda4af945a060e8a37388f47f', '', '1', '1', '', '2018-05-21 09:07:49', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('375', 'test1', '', 'EkIs0J', '8ebf1616f358e2f7986f30882c2c2b4c', '020e1de28390731001708f99081fe946', '', '1', '1', '', '2018-05-22 09:40:47', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('376', 'kbank1', '', 'BXLugr', '2641c3f70f8d78e64c813e3430a63b88', '426e16ec5a9be97cb12787be73969db3', '', '1', '1', '', '2018-05-22 11:36:27', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('377', 'kcore1', '', 'Tdtbde', '3a672a8f13d47a79b6b9c4d925191596', 'f055042b661f72b29b76c7070bc1411d', '', '1', '1', '', '2018-05-22 11:46:05', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('378', 'ksup1', '', 'WK7Dki', '404cb7ecfe8f5da5efc9adfba577a20c', 'c44542c120284140e8b57e33bff418cb', '', '1', '1', '', '2018-05-22 11:58:_01_SingleThreadedExecution', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('379', 'lbank0', '', 'R3LObU', '20740b84917de17b2a9e14e61b1293bd', 'bd900f3d9b24debe8f369fc0e785104c', '', '1', '1', '', '2018-05-22 07:24:59', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('380', 'ere1', 'r', 'oSP1Wr', '562efd43ef2e5d4956f04f6b52491cd6', '', '11', '1', '0', '', '2018-05-23 11:10:14', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('381', 'iiii4', '4', '1A8gl7', 'e9084c97c0ea335ed9300065caa85f1a', '', '11', '1', '0', '', '2018-05-23 12:04:14', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('384', 'abc01', 'abc01', 'uawcDf', '2be688051123d166ba67d3b65012d84c', '810ec6970969cae503e03c718a73ead9', '', '1', '1', '', '2018-05-23 02:50:06', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('385', 'cksup1', '', 'qquZEC', 'bfc8eb8c053d36f057a80d7550d1c552', 'a9efd2ac8cf57d77007c08eb38ff38a2', '', '1', '1', '', '2018-05-23 03:28:26', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('386', 'wcore2', '', 'kZLARY', 'a7a936dd89b4d6b49c8d90cecff1650b', '4bb7b551e0833b7aa6782944f0da92d6', '', '1', '1', '', '2018-05-23 04:35:59', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('387', 'wcemp2', '1', 'lJ7wmB', 'a31975667f24966f5550cd919bfd0387', '19a031dfbb4c7376c5f4c515cc52a500', '', '1', '1', '', '2018-05-23 04:44:11', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('388', 'wcemp3', '3', 'bCwZPi', 'de2bc2357faf94bf59771b435d5e9fd6', 'e469ae366f86a899888f316b41bcfa80', '', '1', '1', '', '2018-05-23 04:49:31', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('389', 'test2', '', 'dQ7QBD', 'e8172d32a0c1bfdce87abb5a847a4ac4', '21f7c773dfb0b0e24109d375f2db90e8', '', '1', '1', '', '2018-05-24 02:48:46', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('394', 'aaa1', '1', 'GpN11V', 'aa4ac8e5585e08747e616a62976ec765', '', '1', '1', '0', '1', '2018-05-25 06:10:00', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('395', 'wcemp1', '12', '2ochK3', '55081faef2b4c75a3cd114d40eb4b5f5', '', '1', '1', '0', '', '2018-05-30 06:06:18', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('397', 'abc22', '', 'Im5jJi', 'c733425c96e155697bb4020f51541078', '', '', '1', '1', '', '2018-06-_01_SingleThreadedExecution 09:33:33', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('398', 'wtest1', '1', 'G9ji3d', '64e1d990e256382a2ebf0ab26b6aa021', '', '', '1', '0', '', '2018-06-_01_SingleThreadedExecution 10:33:11', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('399', 'eqew1', 'w', 'MkmtbZ', 'aa419f878fecb5a5b434d2af0e43d951', '', '', '1', '0', '', '2018-06-_01_SingleThreadedExecution 11:03:21', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('402', 'asup21', '', 'K6przx', 'a82849f87b11609da718759d4525035b', '', '', '1', '1', '', '2018-06-02 12:45:07', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('404', 'ddd4', 'hj', 'J5mgWE', 'b1f008b8b4a3a3e075a62e6d966b2c75', '', '', '1', '0', '', '2018-06-05 04:45:29', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('405', 'frgd41', '灌灌灌灌', 'pw8Xa6', '0b541c7ab92d223ddc2b0767d02bc4db', '', '', '1', '0', '', '2018-06-05 05:17:17', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('406', 'abc123456', '', 'XWlkDG', '51cf79384029d8fd84ca95b110e1fb2a', '', '', '1', '1', '', '2018-06-11 10:08:09', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('409', 'lidong1', '', 'pTUZOR', '28183fc6ca14d4cdf5b83bac0377e4c2', '6818cfeeb593fc635325a605b29d3be1', '', '1', '1', '', '2018-06-15 10:00:58', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('410', 'lidong420', '', 'PRO1ed', 'b7e533f4e9e0f4c0babf8e04c69dff46', '6b1436052715e1c5fc8328c7ff24b323', '', '1', '1', '', '2018-06-15 10:12:25', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('411', 'test3', 'test', 'LR6rMS', 'afde8c6bcffbadea7c9f809034d12b56', '', '', '1', '0', '', '2018-06-20 03:51:04', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('414', '22jjjj', 'j', 'rPRC03', '543d2380acdd8dc1d77d048ba747f69c', '', '', '1', '0', '', '2018-06-21 03:47:39', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('419', 'liuwenjieb1', '', 'ckdRVH', '9f6937100a9783885f5e4aaa9807145a', '07ea972c99e2f7aeff88970c0b1b8f72', '', '1', '1', '', '2018-06-25 03:11:41', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('422', 'liuwenjiec1', '', 'pJo3ka', '652af6a87b03df4acec8e4b45e04be4a', '48ca0f67ede71def24a609e992e57f5b', '', '1', '1', '', '2018-06-26 10:44:17', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('423', 'eeeee1', 'ee', 'FizAMa', '8d75956f9fc4ae322e00d07ae58a0cce', '', '', '1', '0', '', '2018-07-02 03:11:03', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('424', 'rrrrr1', 'g', 'zd68qh', '86781c0113aada67bbf7a01fd122c7d1', '', '', '1', '0', '', '2018-07-02 03:25:20', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('425', 'ggg555', '5', 'GemxJZ', '5bc614060eea349dd14430716adb0e88', '', '', '1', '0', '', '2018-07-02 03:34:17', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('426', 'ggg1', 'f', 'r439AA', '2bd89284a6557c450fa5a724a13629b3', '', '', '1', '0', '', '2018-07-02 03:40:15', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('427', 'deede1', '4', 'WrEbYv', 'c3ee5e0428a67d4c94267393e8489889', '', '', '1', '0', '', '2018-07-02 03:41:15', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('428', 'sds7', 'd', 'dBSCBJ', '1ed6c78fc8ea523fe97d94daccc8fd04', '', '', '1', '0', '', '2018-07-02 03:41:51', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('429', 'cvddvd5', 'd', 'AyMSyQ', '8317a80a12da3f5f69f67b3f56d23149', '', '', '1', '0', '', '2018-07-02 03:43:34', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('430', 'vdsgsgb11', 'dss', 'oZdeM4', '162fbfbc2cc04925010ab70226484d49', '', '', '1', '0', '', '2018-07-02 04:38:54', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('431', 'vgrrwgre444', 'jkjjj', 'Fs1miW', '8295980a71362186c76a5a6f1176092b', '', '', '1', '0', '', '2018-07-02 04:39:34', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('432', 'gsgsd444', '414', 'cPx1Ct', '65971c159302ad9b39a64574f66e8134', '', '', '1', '0', '', '2018-07-02 04:40:20', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('436', 'hdqbank01', '', 'MkCFLs', '44bf18edba6a939a0c3183564cf5978e', '99f8f3fe97aa510dced6370c3fff502e', '', '1', '1', '', '2018-07-03 03:26:44', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('438', 'xybank1', '', 'oaflz8', '310e27a68697e939b4b1648f80edd61d', '', '', '1', '1', '', '2018-07-04 11:03:32', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('439', 'xybank1', '', 'DomT1u', 'd2ce66e14fa001e2da02595a766bccc6', '', '', '1', '1', '', '2018-07-04 11:03:30', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('441', 'xybank2', '', 'QPmdO1', '8b26474aa45ade456218c0a55ecef13d', '7e4d83f960f4756d69b250d03449f0bc', '', '1', '1', '', '2018-07-04 11:09:47', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('442', 'xycore2', '', 'GHxH7y', '7369d04c82f217d5d3322280d6a68bfd', 'b2f6e688324e676eee4894aa6e296e5e', '', '1', '1', '', '2018-07-04 11:23:31', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('443', 'xyuser2', '', 'f1nwHV', 'aec1b5ed9a2881523fa35be65fbc28a5', '6f0dc7e0f322c47cacc6f57bee7257d0', '', '1', '1', '', '2018-07-04 11:30:39', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('444', 'cwkbank1', '奎务曹', 'P9yOPJ', 'e53a0802af89b900543eb02a1cfbe08d', '1fca0ebcaacb766c62601a2bc4587fb2', '15932145698', '1', '1', '尴尬', '2018-07-05 11:15:49', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('445', 'cwkcore1', '', 'OMruEO', '77c35f44ba61bfc791078ef10a3d0e0f', '770b9efac30d17eec0cd906cc9becfe1', '', '1', '1', '', '2018-07-05 11:36:42', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('446', 'hdq1', '', 'BTP1kz', 'd8b1b585fc1c1a291919b30c0832756f', '', '', '1', '1', '', '2018-07-05 02:21:29', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('447', 'cwksup1', '', 'mHdOi7', '5c0996d7112e96b052bd06e67c9cd823', '38edb4815a85647290522995cc7e051e', '', '1', '1', '', '2018-07-05 02:51:12', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('448', 'hdqcore01', '', 'clrwdQ', '49b7d3de818aab7490cd4ca9892b8c8c', 'e8fe5c12d1b540d349290fe8e8483af4', '', '1', '1', '', '2018-07-05 04:17:54', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('450', 'hdqsup01', '', '0bxQOs', 'c15bd399397957878247f261bc4b0d1e', '20220d09df30db35bbc0c9dd23f47c28', '', '1', '1', '', '2018-07-05 05:24:26', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('451', 'ffff44', 'f', 'rvGgkC', '05ae01ac76ad707411491a4c039f488b', '', '', '1', '0', '', '2018-07-06 04:32:31', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('452', 'dsfds1', 'fdf', '0AiPZ1', 'b2f066dfb60f3795b95623f21e8fe65b', '', '', '1', '0', '', '2018-07-10 07:48:55', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('453', 'fdds1', '44', 'K4Kjl4', '963b85905d4f01ac7b2a7da450275dbc', '', '', '1', '0', '', '2018-07-10 07:51:25', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('454', 'fsdfd11', 'bgfd', 'Q9Uxu1', 'f7f5546d9eb7453add1e7a27e12b78b6', '', '', '1', '0', '', '2018-07-10 07:55:52', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('455', 'ghfdfd1', 'dhfdhfd', 'ruYy07', 'aed153d8bdd017ec124e9c3319a9ea56', '', '', '1', '0', '', '2018-07-10 07:56:15', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('456', 'szbank1', '', '20ceXK', 'c087209e7dd2020df535714b0919f52f', '9d1a66b8e1f1c98f12b9e55c2576b33c', '', '1', '1', '', '2018-07-11 11:47:09', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('458', 'wwww1', 'ww', '3EXDuJ', '4ae27011f86d0d20fb4913c817ef8f98', '', '', '1', '0', '', '2018-07-11 05:45:53', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('459', 'fasfa1', 'gfds', '2FXX4K', 'fcf6e81db6cf77041d99cf2a387c41a6', '', '', '1', '0', '', '2018-07-11 05:57:33', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('460', 'szcore1', '', 'KYN6WE', '54f89db83de8a9162c98d69d92c9f2c5', '9bc847c555b2d4f6648cd21f81501357', '', '1', '1', '', '2018-07-12 10:07:16', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('461', 'szsup1', '', 'zXh8EG', '8b91cb277565d9147e7c5d2ba4c52c56', 'dccea19a46de7e4e19015adea6ad337a', '', '1', '1', '', '2018-07-12 10:16:04', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('462', 'szb1', '深圳银行001', '9AsPn8', 'd5bc48eede5f63964511462cd8280154', '', '', '1', '2', '', '2018-07-12 03:05:59', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('463', 'szc1', '汽车人变形', 'IizDft', '1a304575069c222698b48d1f6136f70e', '6f65c37887fae7ff931666b410b67554', '', '1', '1', '', '2018-07-12 03:08:58', '2018-09-12 11:03:02', '0');
INSERT INTO `user` VALUES ('464', 'szs1', 'abc123456', 'sGRRWi', '08a65fdd920e4068e5881e2722f64780', '68a7388bca244b28b76bc0c9a8264a8d', '', '1', '1', '', '2018-07-12 03:10:12', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('466', 'xyuser3', '', 'RQHZ9T', '3617ff6107810cb270e512f6ef8843d1', '60f57c91de28b9be19b70d74fdded2bb', '', '1', '1', '', '2018-07-13 02:31:50', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('467', 'test112', '1', 'z1GLX7', '26cbc76620b6d363b34b9b067912b4e0', '', '', '1', '0', '', '2018-07-13 06:04:45', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('470', 'qycore0', '', '2l5ySq', '823886cfd2677df231e53f4ac7912992', '', '', '1', '1', '', '2018-07-18 02:43:19', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('473', 'fcore1', '', 'dEZEVB', 'f3c7ce9f2537d30f2a7e4255e0e93be5', 'dee4bdbb74b9c29755d9995622601b62', '', '1', '1', '', '2018-07-20 09:32:31', '2018-09-13 16:52:32', '1');
INSERT INTO `user` VALUES ('479', 'yjcore001', '', 'GU4qqD', 'c56bbe131ee2670d18bf127fa444d607', 'ac480a1935c665cef2bb7698785304e9', '', '1', '1', '', '2018-07-25 10:19:39', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('487', 'core0001', '', 'er9bBB', 'aaca06ccece3561cc9bca1f01cb73b15', 'c515bd3a064e6bc87ba9bf53262349d6', '', '1', '1', '', '2018-07-26 _01_SingleThreadedExecution:07:27', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('488', 'sup0001', '', 'M2Ez4D', '0ab8339cae4173e69cc6b5b4dda6f426', '0945c198fd07312c60f1d1cefb729b72', '', '1', '1', '', '2018-07-26 _01_SingleThreadedExecution:31:56', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('489', 'ygysup1', '岳根友', 'pg5Lln', '42e7ca7ded1ca55f09797c8f4cc7e940', '2e8a31bde06ec63506b1d1db9de9bdcf', '15901492336', '1', '1', '供应商管理员', '2018-07-26 02:50:40', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('494', 'ygysemp1', '王昊', 'qtzHFP', '52e642f867e76e38532687cbb21e58f6', '89d8fd356c64bfa4ff562f7a96666ed7', '15901492336', '1', '1', 'java开发工程师', '2018-07-26 03:21:22', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('495', 'ygybank1', '', 'tzFcVk', 'b93594c4f67868ed452900713b0ed37a', 'bf7d7ab8ff17b7104956e75236bbcc6a', '', '1', '1', '', '2018-07-26 06:33:41', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('496', 'ygycore1', '', 'znTxP7', 'd8d61ceec8e2c553539a17c53d2fc076', '565a2e8c7d5bd175af3eb8dfff59501c', '', '1', '1', '', '2018-07-26 06:47:43', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('497', 'ygysup12', '', 'eBZNTU', '57a8164381b35c7f05ef62bd544f17c3', 'c342d4f465b87d76c5af1e11520a759b', '', '1', '1', '', '2018-07-26 06:57:33', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('498', 'bank0001', '', 'Lyuw2A', 'c7a8889e6f18cac78a7212f968b5f9a9', '48f8c0e4ae5831fca871e7d23f2ddfdf', '', '1', '1', '', '2018-07-26 08:12:38', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('499', 'liuwenjie2', '', 'sKQ18v', 'b75731d1c81839db405609f81f20c4fc', '', '', '1', '1', '', '2018-07-26 08:55:26', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('503', 'yyf001', '', '9Pm3nw', 'fe1798df1eaf2e9a3f5e589a5dc7da0e', 'b950e0491624cd7515c2b32b80e502f6', '', '1', '1', '', '2018-07-27 05:19:53', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('504', 'zjf001', '', 'CBNEhG', '62faea7cc6cb8c24baf7af81095e891e', '1424f570b3f63538fc0684783deeac38', '', '1', '1', '', '2018-07-27 05:30:47', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('505', 'core001', '', 'TfCOgu', 'a4a86a735f10f54bc2b3dc4c9591ee64', '0a07908a01afeaeffd76c47f6be6bada', '', '1', '1', '', '2018-07-27 05:34:47', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('506', 'sup001', '', 'pzdPnx', '65e512b512b6f22cdf4254361e6a6c8f', '8c5db734a8c8411458b7f7100bbb122d', '', '1', '1', '', '2018-07-27 05:46:45', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('508', 'opr1', '', 'Ar3bUn', '26190be06be8f6fe51121556c6c96f36', '9c1f898e9d03b8d870ffbc2c16d3629c', '', '1', '1', '', '2018-07-30 11:43:33', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('511', 'opr00', '', 'exi3oo', '0b24b0327eab2c09e43728f333615721', 'ce3d35488d5ab09f6ec3d0559257b693', '', '1', '1', '', '2018-07-31 10:34:57', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('512', 'wbank0', '', 'RE42uT', '8ba2f3f144217afbd0a3a9d4df8c6a2d', '5cd191313b6054a9646e0e288df63e6c', '', '1', '1', '', '2018-07-31 03:11:23', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('513', 'wcore0', '', 'WpJAMO', '566b5032991e6f60ef59d2544e889dbc', '2cbc144216e8e8928d4409b16ac74744', '', '1', '1', '', '2018-07-31 03:32:06', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('514', 'wsup0', '', '4bwqK3', 'd897284066b7864a2af0b71c8ebbd9e5', '313b3052ce5f9dcdae808f07a02b41d1', '', '1', '1', '', '2018-07-31 03:50:17', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('515', 'wsup02', '', '5YvKKV', 'f1c7bf4420a8f20dca7e49164228cab1', '6ff7c6b36f73e9c9a5a96057e2e8819d', '', '1', '1', '', '2018-07-31 04:20:52', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('516', 'bank1', '', '1nNuS8', '358aae7b7faa57a50b2f3ba743e187d4', '1c3f2f4687855c9c1dddf72734cf5498', '', '1', '1', '', '2018-07-31 04:25:05', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('517', 'core1', '', 'FDhvez', 'e6d24e2bd13258c97062c05c7bb6b3e5', '07f702b9a929c67789013ecdcc653b14', '', '1', '1', '', '2018-07-31 04:33:53', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('518', 'sup1', '', 'k1f9xI', '9a8a559298a2b6c55fa407a7024ed083', '783e736b63acb527656c7e4ca1a644da', '', '1', '1', '', '2018-07-31 04:40:45', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('519', 'lbank1', '', '79LG9N', 'e08e49a4ad116b0ca85e08af64d27d97', '3392ac2fa55e973b109b1cac33942708', '', '1', '1', '', '2018-08-_01_SingleThreadedExecution 11:35:18', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('520', 'lcore1', '', 'hLSQ3W', '184a28fb371d95a172f25a1600d07786', '60bc53517aa6e8f20b52fe2b5b7a4c5f', '', '1', '1', '', '2018-08-_01_SingleThreadedExecution 11:41:48', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('521', 'luser1', '', '5YCcQS', '8e1e31f14eee8b4fd58a1f99945e3a1d', '30e4e46a452cb767635544704ea39228', '', '1', '1', '', '2018-08-_01_SingleThreadedExecution 11:50:47', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('524', 'kltbank1', '', 'b6jp3O', '687dea4508970497e365671473f5de27', '4349405c8a2c18480f56a4ad8f40570f', '', '1', '1', '', '2018-08-02 10:45:24', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('525', 'kltcore1', '', 'i8TrAG', '14df691fd14640d98a9a55fb0cf1ddfe', '166e404411c92df6a526a3cb6136025c', '', '1', '1', '', '2018-08-02 12:_01_SingleThreadedExecution:33', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('526', 'kltuser1', '孔令童', 'wejIcE', 'dd755bab02d5ca8507889de99bd324c6', '6d086c45546101be690a3bbfb18a0187', '18911321500', '1', '1', '', '2018-08-02 02:35:36', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('527', 'kltuser2', '', 'Xbm3zb', 'c18ae167344538e0fffb1333b3f67750', '08e450bcc7943fec6cf6ca3c1b9c65b7', '', '1', '1', '', '2018-08-02 02:46:40', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('528', 'liuwenjied1', '', '08oSO0', 'bfd5d4ad9727c6e78d012110b5e7bbaa', '5e72bd4246b6affab6a9680b763e126b', '', '1', '1', '', '2018-08-02 05:54:44', '2018-09-11 15:04:28', '0');
INSERT INTO `user` VALUES ('529', 'csup1', '', 'jChECQ', '526b8e28cf049408eae8d358b4caf0e0', '', '', '1', '1', '', '2018-08-02 10:04:35', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('530', 'luser2', '', 'x4ALwR', 'caff23629f06e5192db191059153d075', '4957af99e1c394ca1f4a68b684e86262', '', '1', '1', '', '2018-08-03 02:13:59', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('533', 'qycore1', '', 'u8GGEK', 'a9ed1716db7a3a4cb4d998a2f1208255', '3789b4736b10a9900427584f44e98131', '', '1', '1', '', '2018-08-13 10:50:47', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('535', 'yjyyf1', '', 'lkkSjm', '51e535e2463e9cf877adcb0caced30a3', '8bb03cfd35fc47e587703109a1b88dbf', '', '1', '1', '', '2018-08-14 03:59:00', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('540', 'wj01', '', 'N37xdY', '6b4b4fb5ef541c3219c51c69743bcf33', 'd7a69c172e59cec9d9ecd01c5d5355bb', '', '1', '1', '', '2018-08-15 11:52:37', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('543', 'rybank01', '', 'VIGDKf', 'c9feff0566dc73fde2bc73404c6b6b80', '6322c8d93638eda44cd27ed8f53eee54', '', '1', '1', '', '2018-08-16 02:17:37', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('544', 'rycore01', '', 'SrEdLx', '41102ce2aab59463e9daf5c0b8395a17', '0fb384cb8ee44d16a351029e9175908e', '', '1', '1', '', '2018-08-16 02:28:50', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('545', 'bank00', '', '4LiD4D', 'e8e1ab05369442dea0de27615f820a9f', '31e3016b8873a2d96814c7cc7e476424', '', '1', '1', '', '2018-08-16 06:42:47', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('546', 'fbank1', '', 'bnDRWS', '3bb757229bbf53d8884ff4a1d86eb5cf', 'f2410a2774ee9acc96cc3edb5cc368ca', '', '1', '1', '', '2018-08-17 10:44:40', '2018-09-13 16:17:51', '1');
INSERT INTO `user` VALUES ('547', 'wj02', '', 'LSsJ5P', '5d410cbbb54c7b800f5bc9a81b67515f', 'b15396c72b4a4dd2a2fe445772466599', '', '1', '1', '', '2018-08-17 11:15:29', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('550', 'wj03', '', 'sIkBiQ', 'd016cd5fe9b6f7e7e2db9655aaadad9a', 'ca8f0b9bf2e77ccd70f84cb0ecc77bb7', '', '1', '1', '', '2018-08-17 04:55:48', '2018-09-13 15:22:55', '0');
INSERT INTO `user` VALUES ('551', 'wj04', '', 'gM4Y4W', '9aa00035a7bb3df69b2114982e51a819', '0596cd04a8a8d8a3161583f0aebbe959', '', '1', '1', '', '2018-08-17 05:08:20', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('552', 'qyopr1', '', 'eyrVjP', 'dcea72610c6cdfee8beba52452592aa5', '6e2fb1713c80818ded6a1dbaed29fce1', '', '1', '1', '', '2018-08-21 05:42:02', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('553', 'gaojinhuan1', '', 'rpmhLb', '014cbe869083057e621d5f6daf4c4483', 'dd4069feee171e7598cd3f203964cee9', '', '1', '1', '', '2018-08-21 05:48:14', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('554', 'yj123', '', 'VLrpw8', '45a36e6422b81f515ad33d40d5cbaf6f', '659e1369d47052af03b7338dafd1b5d7', '', '1', '1', '', '2018-08-29 09:30:44', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('555', 'VirtualUser1', '', ' ', '', '', '', '1', '0', '', '2018-08-29 04:53:_01_SingleThreadedExecution', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('556', 'kkondwr343', 'dwqdwqdd', 'BVHMux', '1a2770c3d70a1fe12d195e46b6cd52fe', '', '', '1', '0', '', '2018-08-31 11:27:58', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('557', 'ljc002', '', 'HoRZgY', '4f4e52e9b69464bbf69ba25e73f604e4', '', '', '1', '1', '', '2018-09-04 09:55:14', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('558', 'ljc002', '', 'KpDtbu', '2823c499aa15371c44addc3dd74722b9', '', '', '1', '1', '', '2018-09-04 09:55:14', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('559', 'hsah678678', '侃大山', 'UzfdFW', '0659d03e11a114808456f6dbf952b0f1', '', '15678897789', '1', '0', '吼吼吼吼', '2018-09-04 04:55:51', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('560', 'ljccore1', '', 'EAIQqn', 'b07ac113cbb10b43eee31a6f44513ad3', '', '', '1', '1', '', '2018-09-05 06:42:51', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('561', 'test001', 'test001', 'AeRAnD', '8477990a67649eb5702d8d7f4db90133', '', '', '1', '0', '123', '2018-09-06 _01_SingleThreadedExecution:14:45', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('562', '28bank2', '金融机构员工', 'uibmTP', 'a1674df5da4735f4065a1165be1a9554', '', '', '1', '0', '', '2018-09-10 09:58:04', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('563', '10bank1', '', 'Z4EXuK', 'a1f21bacbd2dccdb65fff0ec593d4bda', 'd5582a940e79cd25ba78baf194a33dd2', '', '1', '1', '', '2018-09-10 11:51:48', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('564', '10core1', '', '6XfUdS', 'be6920fd4cf0c0079a8b59d6afaf7cf4', 'd84d6909c8eb9f219ae9d35c2b277a11', '', '1', '1', '', '2018-09-10 12:04:19', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('565', '10sup1', '', 'eRpD9e', '95ccd1da0439309784dbc99f8947cd40', '4713e5f7a3b587ec1d00ac45248fbebc', '', '1', '1', '', '2018-09-10 12:08:05', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('566', '10core2', '', 'Y5ir0T', '57228f1dd33e10e278c7115278a50964', 'f2061549c7fa7f7097d3fd668c4c013e', '', '1', '1', '', '2018-09-10 12:11:13', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('567', 'VirtualUser2', '', ' ', '', '', '', '1', '0', '', '2018-09-10 12:19:31', '2018-09-13 15:44:08', '0');
INSERT INTO `user` VALUES ('568', '10sup2', '', 'qPXfEW', '906d6f6d2b7f47998c78ff40f35daa95', 'bd4f24c1ca7cab4565d6c2211f537589', '', '1', '1', '', '2018-09-10 12:21:22', '2018-09-10 20:27:13', '0');
INSERT INTO `user` VALUES ('569', '10core1user1', '尚无', 'jRaRQi', 'b69e8ce07a6e222f6eafc6d01c259301', '55a6e8a4a36d606a5847a07748098945', '', '1', '1', '', '2018-09-10 03:37:49', '2018-09-18 11:52:03', '0');
INSERT INTO `user` VALUES ('570', 'cemp1', '核心企业员工1', 'Oe7PmU', 'ee53d56b22dd99ee1e146048c40d501b', '', '15665662468', '1', '0', '开发备注', '2018-09-12 17:19:10', '2018-09-12 17:21:34', '1');
INSERT INTO `user` VALUES ('571', 'cemp1', '核心企业员工1', 'crQnQV', '6177bc84a040043c5e8e452aea9c3d12', '', '', '1', '0', '', '2018-09-12 17:22:40', '2018-09-12 17:47:43', '1');
INSERT INTO `user` VALUES ('572', 'cemp1', '山东', 'IKRuHJ', 'a4777821324f43c17121e1533610ec9d', '', '1', '1', '0', '1', '2018-09-12 17:58:08', '2018-09-12 17:58:07', '0');
INSERT INTO `user` VALUES ('573', 'rysup01', '', 'XqQf8A', '10e6190d6b770d05306da0daa632d2c5', '6ca0846cc9b0894243916b1c59653e73', '', '1', '1', '', '2018-09-13 15:02:44', '2018-09-13 15:07:58', '0');
INSERT INTO `user` VALUES ('574', 'fbank1', '', 'QhtyHR', 'd62ac41a8e7112793c107d5c419ce943', '', '', '1', '1', '', '2018-09-13 16:18:03', '2018-09-13 16:20:13', '1');
INSERT INTO `user` VALUES ('575', 'fbank1', '', 'rGPhbQ', 'e21970855c3db261f73222c154ef05a9', '39e0f61892072f0c697be70096c3d36d', '', '1', '1', '', '2018-09-13 16:24:35', '2018-09-13 16:29:44', '0');
INSERT INTO `user` VALUES ('576', 'fcore1', '', 'yqJKCg', '2ae57ebce4f2cd8cf0d40214fd934f78', 'd08a5620e2bb6a9ae8f817f20d069e93', '', '1', '1', '', '2018-09-13 16:58:36', '2018-09-13 17:05:42', '0');
INSERT INTO `user` VALUES ('577', 'cgmcore1', '', '5gilSC', 'c518caf61d10f3b8392beaadf334262e', 'c096a73a9d934c5766e0fcb41257d0e8', '', '1', '1', '', '2018-09-13 17:09:58', '2018-09-13 19:46:30', '0');
INSERT INTO `user` VALUES ('578', 'yinuo01', '', 'PBrXl4', '2b91668a8dece4e63b75f7fe0e12eb50', '71afad0e5e71cfdf373e7038b4b17973', '', '1', '1', '', '2018-09-13 17:48:29', '2018-09-13 17:51:55', '0');
INSERT INTO `user` VALUES ('579', '10sup3', '', 'y38Qve', '0d5674fa0e404fb82ae2a719c167b72c', 'acb11da73e7ea27e48d30492f4acb370', '', '1', '1', '', '2018-09-13 19:22:20', '2018-09-13 19:27:02', '0');
INSERT INTO `user` VALUES ('580', 'rysup02', '', '8hwQ86', 'f5440623e2159ed17e0b209c76165dec', '29c01139d11f044ca4020a79c1deafb8', '', '1', '1', '', '2018-09-13 19:29:53', '2018-09-13 19:33:11', '0');
INSERT INTO `user` VALUES ('583', 'jbank1', '', 'Ez0F2a', 'ff7d6fc175d75201da358da03c8717a0', '10a86d62be4b33e51f9f7578935fdf69', '', '1', '1', '', '2018-09-13 23:09:31', '2018-09-13 23:14:58', '0');
INSERT INTO `user` VALUES ('584', 'rysup012222', '31发多少多少', 'G3Lyq7', '5f9b2917cacd35d7b8c6110c963288d6', '', '', '1', '0', '', '2018-09-13 23:15:46', '2018-09-13 23:15:46', '0');
INSERT INTO `user` VALUES ('585', 'ry01', '2312321', 'NcgO1H', '29e6345fbae1a645007fd8c2fe03826d', '', '32131133', '1', '0', '3333不粘锅', '2018-09-13 23:16:10', '2018-09-13 23:20:28', '0');
INSERT INTO `user` VALUES ('586', 'jcore1', '', 'ldXZJe', 'edaa86ba1d78eaf1a6e59a9bd0f94ffb', '01b06cd3cfa2edcd810db0799fcc54d2', '', '1', '1', '', '2018-09-13 23:40:02', '2018-09-13 23:43:30', '0');
INSERT INTO `user` VALUES ('587', 'jsup1', '', 'VkikJm', '62926b7a68bef1b9f203b1bdfe159e11', '72057704451acf4c8c4294b99024f7fe', '', '1', '1', '', '2018-09-13 23:51:37', '2018-09-13 23:55:46', '0');
INSERT INTO `user` VALUES ('588', 'jbemp1', '资金方员工', '53vbxS', 'f2a3ecbbb535cc6de7ef968caf437c27', '', '15665662468', '1', '0', '开发备注', '2018-09-14 00:24:30', '2018-09-14 00:24:29', '0');
INSERT INTO `user` VALUES ('589', 'lidongbank1', '', 'sYcjzp', '44e68d650578986ae27143a5518ba18a', 'b54062b0681972ab114c64d1f8666ed4', '', '1', '1', '', '2018-09-14 14:40:04', '2018-09-14 14:46:28', '0');
INSERT INTO `user` VALUES ('590', 'lidongcore1', '', '38Crgo', 'e11eff65edb9c1e5a7c144a573675ba0', '027538f1038628df3d1888400e29fa21', '', '1', '1', '', '2018-09-14 14:49:10', '2018-09-14 14:51:34', '0');
INSERT INTO `user` VALUES ('591', 'lidongsup1', '', 'Prv4mU', '39c2979fcec106baad15c7f229e185f0', '36af8fa97cc3e1baa328f69211ea2510', '', '1', '1', '', '2018-09-14 14:53:20', '2018-09-14 14:57:12', '0');
INSERT INTO `user` VALUES ('592', 'wsuptest01', '文杰', 'm3b2Xv', 'c622bfb7a81d43e0c9ad9451e0dda0b6', '95c4dd83b58df327556a1cfab237c4f0', '', '1', '1', '', '2018-09-17 19:24:43', '2018-09-17 19:26:51', '0');
INSERT INTO `user` VALUES ('593', '10sup4', '', 'OOw0fo', '889fbbdc2450618c34a79c93bb0585d1', '7a60ad36ad001ad95c840e3df0e3ca9d', '', '1', '1', '', '2018-09-18 10:21:36', '2018-09-18 10:23:30', '0');
INSERT INTO `user` VALUES ('594', '10bank3', '', 's77cIL', '279bfbeeb620dee8bcdfba0cb6b6610f', 'e95f12a94c0ba4fa6585de0f68345a8a', '', '1', '1', '', '2018-09-18 10:57:43', '2018-09-18 11:22:28', '0');
INSERT INTO `user` VALUES ('595', 'yjyyfemp1', '运营方员工', 'EAOueo', '640f97d84941be8f304882d75e7f27cb', '6b837715cf1e31ee97583ac8ccfab238', '15665665555', '1', '1', '开发', '2018-09-18 11:47:49', '2018-09-18 11:50:53', '0');
