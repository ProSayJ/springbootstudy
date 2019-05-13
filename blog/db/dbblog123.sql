/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50639
Source Host           : 127.0.0.1:3306
Source Database       : dbblog123

Target Server Type    : MYSQL
Target Server Version : 50639
File Encoding         : 65001

Date: 2019-05-13 11:48:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(50) NOT NULL COMMENT '文章标题',
  `description` varchar(255) DEFAULT NULL COMMENT '文章描述',
  `author` varchar(50) DEFAULT NULL COMMENT '文章作者',
  `content` longtext COMMENT '文章内容',
  `content_format` longtext COMMENT 'html的content',
  `read_num` int(11) DEFAULT '0' COMMENT '阅读量',
  `comment_num` int(11) DEFAULT '0' COMMENT '评论量',
  `like_num` int(11) DEFAULT '0' COMMENT '点赞量',
  `cover_type` int(11) DEFAULT NULL COMMENT '文章展示类别,1:普通，2：大图片，3：无图片',
  `cover` text COMMENT '封面',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `recommend` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否推荐文章',
  `category_id` varchar(50) DEFAULT NULL COMMENT '分类类别存在多级分类，用逗号隔开',
  `publish` tinyint(4) DEFAULT '0' COMMENT '发布状态',
  `top` tinyint(1) DEFAULT '0' COMMENT '是否置顶',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章';

-- ----------------------------
-- Records of article
-- ----------------------------

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `cover` varchar(255) DEFAULT NULL COMMENT '封面',
  `author` varchar(50) DEFAULT NULL COMMENT '作者',
  `category_id` varchar(20) DEFAULT NULL COMMENT '分类类别',
  `recommend` tinyint(1) DEFAULT '0' COMMENT '是否推荐',
  `publisher` varchar(100) DEFAULT NULL COMMENT '出版社',
  `publish_date` date DEFAULT NULL COMMENT '出版日期',
  `page_num` int(11) DEFAULT NULL COMMENT '页数',
  `grade` double DEFAULT NULL COMMENT '评分',
  `description` text COMMENT '简介',
  `catalogue` text COMMENT '原书目录',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `read_num` int(11) DEFAULT '0' COMMENT '阅读量',
  `comment_num` int(11) DEFAULT '0' COMMENT '评论量',
  `like_num` int(11) DEFAULT '0' COMMENT '点赞量',
  `publish` tinyint(1) DEFAULT '0' COMMENT '是否发布',
  `progress` int(11) DEFAULT '0' COMMENT '读书状态',
  `reading` tinyint(1) DEFAULT NULL COMMENT '是否阅读',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='图书表';

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '深入理解Java虚拟机（第2版）', 'http://oss.dblearn.cn/dbblog/20190303/01c91a28bf944010ade45fd876e94b8c.jpg', '周志明', '4,5,6', '1', '机械工业出版社', '2013-09-01', '0', '4', '<p class=\"ql-align-justify\">周志明，资深Java技术专家，对JavaEE企业级应用开发、OSGi、Java虚拟机和工作流等都有深入的研究，并在大量的实践中积累了丰富的经验。尤其精通Java虚拟机，撰写了大量与JVM相关的经典文章，被各大技术社区争相转载，是ITeye等技术社区公认的Java虚拟机方面的领袖人物之一。除本书外，还著有经典著作《深入理解OSGi：Equinox原理、应用与最佳实践》，广获读者好评。现任远光软件股份有限公司开发部总经理兼架构师，先后参与过国家电网、南方电网等多个国家级大型ERP项目的平台架构工作，对软件系统架构也有深刻的认识和体会。</p><p class=\"ql-align-justify\">《深入理解Java虚拟机:JVM高级特性与最佳实践(第2版)》内容简介：第1版两年内印刷近10次，4家网上书店的评论近4?000条，98%以上的评论全部为5星级的好评，是整个Java图书领域公认的经典著作和超级畅销书，繁体版在台湾也十分受欢迎。第2版在第1版的基础上做了很大的改进：根据最新的JDK 1.7对全书内容进行了全面的升级和补充；增加了大量处理各种常见JVM问题的技巧和最佳实践；增加了若干与生产环境相结合的实战案例；对第1版中的错误和不足之处的修正；等等。第2版不仅技术更新、内容更丰富，而且实战性更强。</p><p class=\"ql-align-justify\">《深入理解Java虚拟机:JVM高级特性与最佳实践(第2版)》共分为五大部分，围绕内存管理、执行子系统、程序编译与优化、高效并发等核心主题对JVM进行了全面而深入的分析，深刻揭示了JVM的工作原理。</p><p class=\"ql-align-justify\">第一部分从宏观的角度介绍了整个Java技术体系、Java和JVM的发展历程、模块化，以及JDK的编译，这对理解书中后面内容有重要帮助。</p><p class=\"ql-align-justify\">第二部分讲解了JVM的自动内存管理，包括虚拟机内存区域的划分原理以及各种内存溢出异常产生的原因；常见的垃圾收集算法以及垃圾收集器的特点和工作原理；常见虚拟机监控与故障处理工具的原理和使用方法。</p><p class=\"ql-align-justify\">第三部分分析了虚拟机的执行子系统，包括类文件结构、虚拟机类加载机制、虚拟机字节码执行引擎。</p><p class=\"ql-align-justify\">第四部分讲解了程序的编译与代码的优化，阐述了泛型、自动装箱拆箱、条件编译等语法糖的原理；讲解了虚拟机的热点探测方法、HotSpot的即时编译器、编译触发条件，以及如何从虚拟机外部观察和分析JIT编译的数据和结果；</p><p class=\"ql-align-justify\">第五部分探讨了Java实现高效并发的原理，包括JVM内存模型的结构和操作；原子性、可见性和有序性在Java内存模型中的体现；先行发生原则的规则和使用；线程在Java语言中的实现原理；虚拟机实现高效并发所做的一系列锁优化措施。</p><p><br></p>', '<p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">前言</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">第一部分走近Java</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">第1章走近Java2</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">1.1概述2</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">1.2Java技术体系3</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">1.3Java发展史5</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">1.4Java虚拟机发展史9</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">1.4.1SunClassicExactVM9</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">1.4.2SunHotSpotVM11</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">1.4.3SunMobile—EmbeddedVMMeta—CircularVM12</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">1.4.4BEAJRockitIBMJ9VM13</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">1.4.5AzulVMBEALiquidVM14</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">1.4.6ApacheHarmonyGoogleAndroidDalvikVM14</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">1.4.7MicrosoftJVM及其他15</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">1.5展望Java技术的未来16</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">1.5.1模块化17</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">1.5.2混合语言17</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">1.5.3多核并行19</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">1.5.4进一步丰富语法20</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">1.5.564位虚拟机21</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">1.6实战：自己编译JDK22</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">1.6.1获取JDK源码22</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">1.6.2系统需求24</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">1.6.3构建编译环境25</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">1.6.4进行编译26</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">1.6.5在IDE工具中进行源码调试31</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">1.7本章小结35</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">第二部分自动内存管理机制</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">第2章Java内存区域与内存溢出异常38</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">2.1概述38</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">2.2运行时数据区域38</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">2.2.1程序计数器39</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">2.2.2Java虚拟机栈39</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">2.2.3本地方法栈40</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">2.2.4Java堆41</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">2.2.5方法区41</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">2.2.6运行时常量池42</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">2.2.7直接内存43</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">2.3HotSpot虚拟机对象探秘43</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">2.3.1对象的创建44</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">2.3.2对象的内存布局47</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">2.3.3对象的访问定位48</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">2.4实战：OutOfMemoryError异常50</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">2.4.1Java堆溢出51</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">2.4.2虚拟机栈和本地方法栈溢出53</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">2.4.3方法区和运行时常量池溢出56</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">2.4.4本机直接内存溢出59</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">2.5本章小结60</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">第3章垃圾收集器与内存分配策略61</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">3.1概述61</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">3.2对象已死吗62</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">3.2.1引用计数算法62</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">3.2.2可达性分析算法64</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">3.2.3再谈引用65</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">3.2.4生存还是死亡66</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">3.2.5回收方法区68</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">3.3垃圾收集算法69</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">3.3.1标记—清除算法69</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">3.3.2复制算法70</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">3.3.3标记—整理算法71</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">3.3.4分代收集算法72</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">3.4HotSpot的算法实现72</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">3.4.1枚举根节点72</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">3.4.2安全点73</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">3.4.3安全区域74</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">3.5垃圾收集器75</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">3.5.1Serial收集器76</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">3.5.2ParNew收集器77</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">3.5.3ParallelScavenge收集器79</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">3.5.4SerialOld收集器80</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">3.5.5ParallelOld收集器80</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">3.5.6CMS收集器81</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">3.5.7G1收集器84</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">3.5.8理解GC日志89</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">3.5.9垃圾收集器参数总结90</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">3.6内存分配与回收策略91</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">3.6.1对象优先在Eden分配91</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">3.6.2大对象直接进入老年代93</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">3.6.3长期存活的对象将进入老年代95</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">3.6.4动态对象年龄判定97</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">3.6.5空间分配担保98</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">3.7本章小结100</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">第4章虚拟机性能监控与故障处理工具101</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">4.1概述101</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">4.2JDK的命令行工具101</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">4.2.1jps：虚拟机进程状况工具104</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">4.2.2jstat：虚拟机统计信息监视工具105</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">4.2.3jinfo：Java配置信息工具106</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">4.2.4jmap：Java内存映像工具107</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">4.2.5jhat：虚拟机堆转储快照分析工具108</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">4.2.6jstack：Java堆栈跟踪工具109</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">4.2.7HSDIS：JIT生成代码反汇编111</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">4.3JDK的可视化工具114</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">4.3.1JConsole：Java监视与管理控制台115</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">4.3.2VisualVM：多合一故障处理工具122</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">4.4本章小结131</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">第5章调优案例分析与实战132</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">5.1概述132</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">5.2案例分析132</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">5.2.1高性能硬件上的程序部署策略132</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">5.2.2集群间同步导致的内存溢出135</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">5.2.3堆外内存导致的溢出错误136</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">5.2.4外部命令导致系统缓慢137</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">5.2.5服务器JVM进程崩溃138</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">5.2.6不恰当数据结构导致内存占用过大139</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">5.2.7由Windows虚拟内存导致的长时间停顿141</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">5.3实战：Eclipse运行速度调优142</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">5.3.1调优前的程序运行状态142</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">5.3.2升级JDK1.6的性能变化及兼容问题145</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">5.3.3编译时间和类加载时间的优化150</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">5.3.4调整内存设置控制垃圾收集频率153</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">5.3.5选择收集器降低延迟157</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">5.4本章小结160</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">第三部分虚拟机执行子系统</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">第6章类文件结构162</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">6.1概述162</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">6.2无关性的基石162</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">6.3Class类文件的结构164</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">6.3.1魔数与Class文件的版本166</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">6.3.2常量池167</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">6.3.3访问标志173</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">6.3.4类索引、父类索引与接口索引集合174</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">6.3.5字段表集合175</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">6.3.6方法表集合178</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">6.3.7属性表集合180</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">6.4字节码指令简介196</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">6.4.1字节码与数据类型197</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">6.4.2加载和存储指令199</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">6.4.3运算指令200</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">6.4.4类型转换指令202</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">6.4.5对象创建与访问指令203</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">6.4.6操作数栈管理指令203</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">6.4.7控制转移指令204</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">6.4.8方法调用和返回指令204</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">6.4.9异常处理指令205</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">6.4.10同步指令205</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">6.5公有设计和私有实现206</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">6.6Class文件结构的发展207</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">6.7本章小结208</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">第7章虚拟机类加载机制209</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">7.1概述209</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">7.2类加载的时机210</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">7.3类加载的过程214</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">7.3.1加载214</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">7.3.2验证216</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">7.3.3准备219</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">7.3.4解析220</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">7.3.5初始化225</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">7.4类加载器227</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">7.4.1类与类加载器228</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">7.4.2双亲委派模型229</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">7.4.3破坏双亲委派模型233</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">7.5本章小结235</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">第8章虚拟机字节码执行引擎236</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">8.1概述236</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">8.2运行时栈帧结构236</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">8.2.1局部变量表238</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">8.2.2操作数栈242</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">8.2.3动态连接243</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">8.2.4方法返回地址243</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">8.2.5附加信息244</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">8.3方法调用244</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">8.3.1解析244</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">8.3.2分派246</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">8.3.3动态类型语言支持258</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">8.4基于栈的字节码解释执行引擎269</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">8.4.1解释执行269</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">8.4.2基于栈的指令集与基于寄存器的指令集270</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">8.4.3基于栈的解释器执行过程272</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">8.5本章小结275</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">第9章类加载及执行子系统的案例与实战276</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">9.1概述276</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">9.2案例分析276</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">9.2.1Tomcat：正统的类加载器架构276</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">9.2.2OSGi：灵活的类加载器架构279</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">9.2.3字节码生成技术与动态代理的实现282</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">9.2.4Retrotranslator：跨越JDK版本286</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">9.3实战：自己动手实现远程执行功能289</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">9.3.1目标290</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">9.3.2思路290</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">9.3.3实现291</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">9.3.4验证298</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">9.4本章小结299</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">第四部分程序编译与代码优化</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">第10章早期（编译期）优化302</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">10.1概述302</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">10.2Javac编译器303</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">10.2.1Javac的源码与调试303</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">10.2.2解析与填充符号表305</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">10.2.3注解处理器307</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">10.2.4语义分析与字节码生成307</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">10.3Java语法糖的味道311</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">10.3.1泛型与类型擦除311</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">10.3.2自动装箱、拆箱与遍历循环315</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">10.3.3条件编译317</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">10.4实战：插入式注解处理器318</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">10.4.1实战目标318</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">10.4.2代码实现319</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">10.4.3运行与测试326</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">10.4.4其他应用案例327</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">10.5本章小结328</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">第11章晚期（运行期）优化329</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">11.1概述329</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">11.2HotSpot虚拟机内的即时编译器329</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">11.2.1解释器与编译器330</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">11.2.2编译对象与触发条件332</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">11.2.3编译过程337</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">11.2.4查看及分析即时编译结果339</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">11.3编译优化技术345</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">11.3.1优化技术概览346</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">11.3.2公共子表达式消除350</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">11.3.3数组边界检查消除351</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">11.3.4方法内联352</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">11.3.5逃逸分析354</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">11.4Java与C/C++的编译器对比356</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">11.5本章小结358</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">第五部分高效并发</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">第12章Java内存模型与线程360</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">12.1概述360</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">12.2硬件的效率与一致性361</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">12.3Java内存模型362</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">12.3.1主内存与工作内存363</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">12.3.2内存间交互操作364</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">12.3.3对于volatile型变量的特殊规则366</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">12.3.4对于long和double型变量的特殊规则372</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">12.3.5原子性、可见性与有序性373</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">12.3.6先行发生原则375</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">12.4Java与线程378</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">12.4.1线程的实现378</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">12.4.2Java线程调度381</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">12.4.3状态转换383</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">12.5本章小结384</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">第13章线程安全与锁优化385</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">13.1概述385</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">13.2线程安全385</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">13.2.1Java语言中的线程安全386</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">13.2.2线程安全的实现方法390</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">13.3锁优化397</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">13.3.1自旋锁与自适应自旋398</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">13.3.2锁消除398</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">13.3.3锁粗化400</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">13.3.4轻量级锁400</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">13.3.5偏向锁402</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">13.4本章小结403</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">附录</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">附录A编译Windows版的OpenJDK406</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">附录B虚拟机字节码指令表414</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">附录CHotSpot虚拟机主要参数表420</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">附录D对象查询语言（OQL）简介424</span></p><p><span style=\"background-color: rgb(250, 250, 250); color: rgb(68, 68, 68);\">附录EJDK历史版本轨迹430</span></p>', '2019-03-03 23:33:11', '2019-03-03 23:33:11', '19', '0', '0', '1', '10', '1');

-- ----------------------------
-- Table structure for book_note
-- ----------------------------
DROP TABLE IF EXISTS `book_note`;
CREATE TABLE `book_note` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(50) NOT NULL COMMENT '笔记标题',
  `description` varchar(255) DEFAULT NULL COMMENT '笔记描述',
  `author` varchar(50) DEFAULT NULL COMMENT '笔记作者',
  `content` longtext COMMENT '笔记内容',
  `content_format` longtext COMMENT 'html的context',
  `read_num` int(11) DEFAULT '0' COMMENT '阅读量',
  `comment_num` int(11) DEFAULT '0' COMMENT '评论量',
  `like_num` int(11) DEFAULT '0' COMMENT '点赞量',
  `cover` text COMMENT '封面',
  `book_id` int(11) DEFAULT NULL COMMENT '所属书本',
  `chapter` varchar(255) DEFAULT NULL COMMENT '所属章节',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `recommend` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否推荐笔记',
  `category_id` varchar(50) DEFAULT NULL COMMENT '分类类别存在多级分类，用逗号隔开',
  `publish` tinyint(4) DEFAULT '0' COMMENT '发布状态',
  `cover_type` int(11) DEFAULT NULL COMMENT '封面类型',
  `top` tinyint(1) DEFAULT NULL COMMENT '是否置顶',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='笔记';

-- ----------------------------
-- Records of book_note
-- ----------------------------
INSERT INTO `book_note` VALUES ('1', 'Java虚拟机01——Java内存数据区域和内存溢出异常', 'Java虚拟机在执行Java程序的过程中会把它所管理的内存划分为若干个不同的数据区域。这些区域都有各自的用途，以及创建和销毁的时间，有的区域随着虚拟机进程的启动而存在，有些区域则依赖用户线程的启动和结束而建立和销毁.', 'Bobbi', '# 运行时数据区域\r\n> Java虚拟机在执行Java程序的过程中会把它所管理的内存划分为若干个不同的数据区域。这些区域都有各自的用途，以及创建和销毁的时间，有的区域随着虚拟机进程的启动而存在，有些区域则依赖用户线程的启动和结束而建立和销毁。根据《Java虚拟机规范（Java SE 7版）》的规定，Java虚拟机所管理的内存将会包括以下几个运行时数据区域，如下图所示：\r\n我们可以将上面的数据区域分为线程独有、线程共享及其他三大区域：\r\n## 1.1. 线程独有的数据区域\r\n### 1. 程序计数器（Program Counter Register）\r\n1.   当前线程所执行的字节码的行号指示器。\r\n2. 用于选取下一条需要执行的字节码指令，分支、循环、跳转、异常处理、线程恢复需要依赖这个计数\r\n\r\n### 2. 虚拟机栈（Java Stack）\r\n位于线程私有的内存中，生命周期与线程相同。\r\n描述了Java方法执行的内存模型。\r\n方法执行时使用栈帧（Stack Frame）来存储局部变量表、操作数栈、动态链接、方法出口等信息。\r\n如果线程请求的栈深度大于虚拟机所允许的深度，将抛出StackOverflowError异常。\r\n如果虚拟机栈可以动态扩展，如果扩展时无法申请到足够的内存，就会抛出OutOfMemoryError异常。\r\n### 3. 本地方法栈（Native Method Stack）\r\n与虚拟机栈相类似，区域在于本地方法栈为虚拟机使用到的Native方法服务。\r\n可以由虚拟机设计者自己实现。\r\n本地方法栈区域也会抛出==StackOverflowError==和==OutOfMemoryError==异常\r\n## 1.2. 线程共享的数据区域\r\nJava堆（Heap）\r\n是Java虚拟机所管理内存中最大的一块，在虚拟机启动时创建。\r\n在Java虚拟机规范中的描述是：所有的对象实例以及数组都要在堆上分配。随着JIT编译器的发展与逃逸分析技术逐渐成熟，栈上分配、标量替换优化技术导致某些对象并没有分配在堆上。\r\nJava GC工作的主要区域。现代收集器基本都采用分代收集算法，所以Java堆中还可以细分为新生代和老年代；再细致一点的有Eden空间、From Survivor空间、To Survivor空间等。\r\n如果在堆中没有内存完成实例分配，并且堆也无法再扩展时，将会抛出==OutOfMemoryError==异常。\r\n方法区（Method Area）\r\n用于存储已被虚拟机加载的类信息、常量、静态变量、即时编译器编译后的代码等数据。\r\n它有一个别名叫做Non-Heap（非堆），目的应该是与Java堆区分开来。\r\nHotSpot虚拟机选择把GC分代收集扩展至方法区，即使用永久代来实现方法区，因此也有人将此区域称为“永久代”；JDK 1.7的HotSpot中，已经把原本放在永久代的字符串常量池移出，并逐步改为采用Native Memory来实现方法区的规划。\r\n根据Java虚拟机规范的规定，当方法区无法满足内存分配需求时，将抛出==OutOfMemoryError==异常。\r\n运行时常量池（Runtime Constant Pool）\r\n运行时常量池是方法区的一部分。\r\nClass文件中除了有类的版本、字段、方法、接口等描述信息外，还有一项信息是常量池（Constant Pool Table），用于存放编译期生成的各种字面量和符号引用，这部分内容将在类加载后进入方法区的运行时常量池中存放。\r\n当常量池无法再申请到内存时会抛出==OutOfMemoryError==异常。\r\n## 1.3. 其他区域\r\n直接内存（Direct Memory）\r\n直接内存并不是虚拟机运行时数据区的一部分，也不是Java虚拟机规范中定义的内存区域。\r\n这部分内存也可能导致OutOfMemoryError异常出现。\r\n', '<h1 id=\"-\">运行时数据区域</h1>\r\n<blockquote>\r\n<p>Java虚拟机在执行Java程序的过程中会把它所管理的内存划分为若干个不同的数据区域。这些区域都有各自的用途，以及创建和销毁的时间，有的区域随着虚拟机进程的启动而存在，有些区域则依赖用户线程的启动和结束而建立和销毁。根据《Java虚拟机规范（Java SE 7版）》的规定，Java虚拟机所管理的内存将会包括以下几个运行时数据区域，如下图所示：\r\n我们可以将上面的数据区域分为线程独有、线程共享及其他三大区域：</p>\r\n</blockquote>\r\n<h2 id=\"1-1-\">1.1. 线程独有的数据区域</h2>\r\n<h3 id=\"1-program-counter-register-\">1. 程序计数器（Program Counter Register）</h3>\r\n<ol>\r\n<li>当前线程所执行的字节码的行号指示器。</li>\r\n<li>用于选取下一条需要执行的字节码指令，分支、循环、跳转、异常处理、线程恢复需要依赖这个计数</li>\r\n</ol>\r\n<h3 id=\"2-java-stack-\">2. 虚拟机栈（Java Stack）</h3>\r\n<p>位于线程私有的内存中，生命周期与线程相同。\r\n描述了Java方法执行的内存模型。\r\n方法执行时使用栈帧（Stack Frame）来存储局部变量表、操作数栈、动态链接、方法出口等信息。\r\n如果线程请求的栈深度大于虚拟机所允许的深度，将抛出StackOverflowError异常。\r\n如果虚拟机栈可以动态扩展，如果扩展时无法申请到足够的内存，就会抛出OutOfMemoryError异常。</p>\r\n<h3 id=\"3-native-method-stack-\">3. 本地方法栈（Native Method Stack）</h3>\r\n<p>与虚拟机栈相类似，区域在于本地方法栈为虚拟机使用到的Native方法服务。\r\n可以由虚拟机设计者自己实现。\r\n本地方法栈区域也会抛出==StackOverflowError==和==OutOfMemoryError==异常</p>\r\n<h2 id=\"1-2-\">1.2. 线程共享的数据区域</h2>\r\n<p>Java堆（Heap）\r\n是Java虚拟机所管理内存中最大的一块，在虚拟机启动时创建。\r\n在Java虚拟机规范中的描述是：所有的对象实例以及数组都要在堆上分配。随着JIT编译器的发展与逃逸分析技术逐渐成熟，栈上分配、标量替换优化技术导致某些对象并没有分配在堆上。\r\nJava GC工作的主要区域。现代收集器基本都采用分代收集算法，所以Java堆中还可以细分为新生代和老年代；再细致一点的有Eden空间、From Survivor空间、To Survivor空间等。\r\n如果在堆中没有内存完成实例分配，并且堆也无法再扩展时，将会抛出==OutOfMemoryError==异常。\r\n方法区（Method Area）\r\n用于存储已被虚拟机加载的类信息、常量、静态变量、即时编译器编译后的代码等数据。\r\n它有一个别名叫做Non-Heap（非堆），目的应该是与Java堆区分开来。\r\nHotSpot虚拟机选择把GC分代收集扩展至方法区，即使用永久代来实现方法区，因此也有人将此区域称为“永久代”；JDK 1.7的HotSpot中，已经把原本放在永久代的字符串常量池移出，并逐步改为采用Native Memory来实现方法区的规划。\r\n根据Java虚拟机规范的规定，当方法区无法满足内存分配需求时，将抛出==OutOfMemoryError==异常。\r\n运行时常量池（Runtime Constant Pool）\r\n运行时常量池是方法区的一部分。\r\nClass文件中除了有类的版本、字段、方法、接口等描述信息外，还有一项信息是常量池（Constant Pool Table），用于存放编译期生成的各种字面量和符号引用，这部分内容将在类加载后进入方法区的运行时常量池中存放。\r\n当常量池无法再申请到内存时会抛出==OutOfMemoryError==异常。</p>\r\n<h2 id=\"1-3-\">1.3. 其他区域</h2>\r\n<p>直接内存（Direct Memory）\r\n直接内存并不是虚拟机运行时数据区的一部分，也不是Java虚拟机规范中定义的内存区域。\r\n这部分内存也可能导致OutOfMemoryError异常出现。</p>\r\n', '11', '0', '1', null, '1', '第2章 Java内存区域与内存溢出异常', '2019-03-09 17:11:05', '2019-03-04 17:51:15', '1', '4,5,6', '1', '2', null);

-- ----------------------------
-- Table structure for book_sense
-- ----------------------------
DROP TABLE IF EXISTS `book_sense`;
CREATE TABLE `book_sense` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `author` varchar(20) DEFAULT NULL COMMENT '作者',
  `content` text COMMENT '内容',
  `book_id` int(11) DEFAULT NULL COMMENT '关联图书Id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='读后感';

-- ----------------------------
-- Records of book_sense
-- ----------------------------

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `type` int(11) DEFAULT NULL COMMENT '类型：0文章，1阅读',
  `rank` int(11) DEFAULT NULL COMMENT '级别',
  `parent_id` int(11) DEFAULT '0' COMMENT '父主键',
  PRIMARY KEY (`id`),
  UNIQUE KEY `operation_category_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '漫谈', '0', '0', '-1');
INSERT INTO `category` VALUES ('2', '本站相关', '0', '1', '1');
INSERT INTO `category` VALUES ('3', '关于', '0', '2', '2');
INSERT INTO `category` VALUES ('4', '后端', '1', '0', '-1');
INSERT INTO `category` VALUES ('5', 'Java进阶', '1', '1', '4');
INSERT INTO `category` VALUES ('6', 'JVM', '1', '2', '5');
INSERT INTO `category` VALUES ('9', '后端', '0', '0', '-1');
INSERT INTO `category` VALUES ('11', 'Java基础', '0', '1', '9');
INSERT INTO `category` VALUES ('12', '面试', '0', '2', '11');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `nick_name` varchar(50) DEFAULT NULL COMMENT '昵称',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `content` text COMMENT '评论内容',
  `parent_id` int(11) DEFAULT NULL COMMENT '关联父Id',
  `link_id` int(11) DEFAULT NULL COMMENT '关联Id',
  `like_num` int(11) DEFAULT '0' COMMENT '点赞数量',
  `dislike_num` int(11) DEFAULT '0' COMMENT '不喜欢数量',
  `comment_level` int(11) DEFAULT '0' COMMENT '评论层级: 0：第一层，1：第二层，2：第三层',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `type` int(11) DEFAULT NULL COMMENT '评论类型：0文章，1，阅读',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论';

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for link
-- ----------------------------
DROP TABLE IF EXISTS `link`;
CREATE TABLE `link` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(50) DEFAULT NULL COMMENT '链接名称',
  `url` varchar(500) DEFAULT NULL COMMENT '链接地址',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='友链';

-- ----------------------------
-- Records of link
-- ----------------------------

-- ----------------------------
-- Table structure for log_like
-- ----------------------------
DROP TABLE IF EXISTS `log_like`;
CREATE TABLE `log_like` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) DEFAULT NULL COMMENT '点赞类型',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `time` bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='点赞日志';

-- ----------------------------
-- Records of log_like
-- ----------------------------

-- ----------------------------
-- Table structure for log_view
-- ----------------------------
DROP TABLE IF EXISTS `log_view`;
CREATE TABLE `log_view` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) DEFAULT NULL COMMENT '浏览类型',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `time` bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='阅读日志';

-- ----------------------------
-- Records of log_view
-- ----------------------------

-- ----------------------------
-- Table structure for oss_resource
-- ----------------------------
DROP TABLE IF EXISTS `oss_resource`;
CREATE TABLE `oss_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='云存储资源表';

-- ----------------------------
-- Records of oss_resource
-- ----------------------------

-- ----------------------------
-- Table structure for recommend
-- ----------------------------
DROP TABLE IF EXISTS `recommend`;
CREATE TABLE `recommend` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `link_id` int(11) DEFAULT NULL COMMENT '推荐的文章Id',
  `type` int(11) DEFAULT NULL COMMENT '推荐类型',
  `order_num` int(11) DEFAULT '0' COMMENT '顺序',
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `top` tinyint(1) DEFAULT '0' COMMENT '置顶',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='推荐';

-- ----------------------------
-- Records of recommend
-- ----------------------------
INSERT INTO `recommend` VALUES ('3', '1', '0', '1', '关于本站和博主', '1');
INSERT INTO `recommend` VALUES ('4', '1', '2', '2', 'Java虚拟机01——Java内存数据区域和内存溢出异常', '0');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `name` tinytext,
  `url` varchar(200) DEFAULT NULL,
  `perms` varchar(500) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `icon` tinytext,
  `order_num` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '0', '系统管理', null, null, '0', 'config', '3');
INSERT INTO `sys_menu` VALUES ('2', '1', '管理员列表', 'sys/user', null, '1', 'admin', '1');
INSERT INTO `sys_menu` VALUES ('3', '1', '角色管理', 'sys/role', null, '1', 'role', '2');
INSERT INTO `sys_menu` VALUES ('4', '1', '菜单管理', 'sys/menu', null, '1', 'menu', '3');
INSERT INTO `sys_menu` VALUES ('5', '1', 'SQL监控', 'http://localhost:8080/dbBlog/druid/sql.html', null, '1', 'sql', '5');
INSERT INTO `sys_menu` VALUES ('15', '2', '查看', null, 'sys:user:list,sys:user:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('16', '2', '新增', null, 'sys:user:save,sys:role:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('17', '2', '修改', null, 'sys:user:update,sys:role:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('18', '2', '删除', null, 'sys:user:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('19', '3', '查看', null, 'sys:role:list,sys:role:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('20', '3', '新增', null, 'sys:role:save,sys:menu:list', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('21', '3', '修改', null, 'sys:role:update,sys:menu:list', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('22', '3', '删除', null, 'sys:role:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('23', '4', '查看', null, 'sys:menu:list,sys:menu:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('24', '4', '新增', null, 'sys:menu:save,sys:menu:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('25', '4', '修改', null, 'sys:menu:update,sys:menu:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('26', '4', '删除', null, 'sys:menu:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('30', '0', '博文管理', null, null, '0', 'article', '0');
INSERT INTO `sys_menu` VALUES ('31', '30', '新增博文', 'article/article-add-or-update', 'article:save,article:update', '1', 'add', '0');
INSERT INTO `sys_menu` VALUES ('32', '30', '博文列表', 'article/article', null, '1', 'list', '0');
INSERT INTO `sys_menu` VALUES ('33', '32', '删除', null, 'article:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('34', '32', '查看', null, 'article:list', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('38', '43', '分类管理', 'operation/category', null, '1', 'category', '6');
INSERT INTO `sys_menu` VALUES ('39', '38', '查看', null, 'operation:category:list,operation:category:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('40', '38', '新增', null, 'operation:category:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('41', '38', '修改', null, 'operation:category:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('42', '38', '删除', null, 'operation:category:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('43', '0', '运营管理', null, null, '0', 'operation', '2');
INSERT INTO `sys_menu` VALUES ('45', '1', '系统参数', 'sys/param', null, '1', 'param', '4');
INSERT INTO `sys_menu` VALUES ('46', '45', '查看', null, 'sys:param:list,sys:param:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('47', '45', '新增', null, 'sys:param:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('48', '45', '修改', null, 'sys:param:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('49', '45', '删除', null, 'sys:param:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('50', '43', '标签管理', 'operation/tag', null, '1', 'tag', '6');
INSERT INTO `sys_menu` VALUES ('51', '50', '查看', null, 'operation:tag:list,operation:tag:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('52', '50', '新增', null, 'operation:tag:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('53', '50', '修改', null, 'operation:tag:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('54', '50', '删除', null, 'operation:tag:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('55', '60', '评论管理', 'comment/comment', null, '1', 'comment', '6');
INSERT INTO `sys_menu` VALUES ('56', '55', '查看', null, 'comment:list,comment:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('57', '55', '新增', null, 'comment:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('58', '55', '修改', null, 'comment:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('59', '55', '删除', null, 'comment:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('60', '0', '评论管理', null, null, '0', 'comment', '5');
INSERT INTO `sys_menu` VALUES ('61', '66', '图书管理', 'book/book', null, '1', 'list', '3');
INSERT INTO `sys_menu` VALUES ('62', '61', '查看', null, 'book:list,book:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('63', '61', '新增', null, 'book:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('64', '61', '修改', null, 'book:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('65', '61', '删除', null, 'book:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('66', '0', '阅读管理', null, null, '0', 'read', '1');
INSERT INTO `sys_menu` VALUES ('67', '66', '新增图书', 'book/book-add-or-update', '', '1', 'add', '1');
INSERT INTO `sys_menu` VALUES ('68', '66', '笔记管理', 'book/note', null, '1', 'list', '2');
INSERT INTO `sys_menu` VALUES ('69', '68', '查看', null, 'book:note:list,book:note:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('70', '68', '新增', null, 'book:note:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('71', '68', '修改', null, 'book:note:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('72', '68', '删除', null, 'book:note:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('73', '66', '新增笔记', 'book/note-add-or-update', '', '1', 'add', '0');
INSERT INTO `sys_menu` VALUES ('74', '43', '友链管理', 'operation/link', null, '1', 'link', '6');
INSERT INTO `sys_menu` VALUES ('75', '74', '查看', null, 'operation:link:list,operation:link:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('76', '74', '新增', null, 'operation:link:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('77', '74', '修改', null, 'operation:link:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('78', '74', '删除', null, 'operation:link:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('79', '43', '推荐管理', 'operation/recommend', null, '1', 'recommend', '6');
INSERT INTO `sys_menu` VALUES ('80', '79', '查看', null, 'operation:recommend:list,operation:recommend:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('81', '79', '新增', null, 'operation:recommend:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('82', '79', '修改', null, 'operation:recommend:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('83', '79', '删除', null, 'operation:recommend:delete', '2', null, '6');

-- ----------------------------
-- Table structure for sys_param
-- ----------------------------
DROP TABLE IF EXISTS `sys_param`;
CREATE TABLE `sys_param` (
  `id` int(11) DEFAULT NULL,
  `par_key` int(11) DEFAULT NULL,
  `par_value` varchar(255) DEFAULT NULL,
  `menu_url` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统参数';

-- ----------------------------
-- Records of sys_param
-- ----------------------------
INSERT INTO `sys_param` VALUES ('2', '0', '一级', '/operation-category', 'CATEGORY_RANK');
INSERT INTO `sys_param` VALUES ('3', '1', '二级', '/operation-category', 'CATEGORY_RANK');
INSERT INTO `sys_param` VALUES ('4', '2', '三级', '/operation-category', 'CATEGORY_RANK');
INSERT INTO `sys_param` VALUES ('7', '0', '小图片', '/article-addOrUpdate', 'ARTICLE_COVER_TYPE');
INSERT INTO `sys_param` VALUES ('8', '1', '大图片', '/article-addOrUpdate', 'ARTICLE_COVER_TYPE');
INSERT INTO `sys_param` VALUES ('9', '2', '无图片', '/article-addOrUpdate', 'ARTICLE_COVER_TYPE');
INSERT INTO `sys_param` VALUES ('10', '0', '文章', null, 'MODULE_TYPE');
INSERT INTO `sys_param` VALUES ('11', '1', '图书', null, 'MODULE_TYPE');
INSERT INTO `sys_param` VALUES ('12', '2', '笔记', null, 'MODULE_TYPE');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` int(11) DEFAULT NULL,
  `username` tinytext,
  `password` varchar(255) DEFAULT NULL,
  `email` tinytext,
  `salt` tinytext,
  `create_user_id` tinytext,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'cdac762d0ba79875489f6a8b430fa8b5dfe0cdd81da38b80f02f33328af7fd4a', '571002217@qq.com', 'YzcmCZNvbXocrsz9dm8e', '1', '2019-04-23 19:17:00', '1');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '标签名字',
  `type` int(11) DEFAULT NULL COMMENT '所属类别：0文章，1类别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='标签';

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES ('1', '本站相关', '0');
INSERT INTO `tag` VALUES ('2', '关于', '0');
INSERT INTO `tag` VALUES ('3', 'Java', '1');
INSERT INTO `tag` VALUES ('4', 'JVM', '1');
INSERT INTO `tag` VALUES ('5', 'Java', '2');
INSERT INTO `tag` VALUES ('6', 'JVM', '2');
INSERT INTO `tag` VALUES ('7', 'Java', '0');
INSERT INTO `tag` VALUES ('8', '面试', '0');
INSERT INTO `tag` VALUES ('9', 'ElasticSearch', '0');
INSERT INTO `tag` VALUES ('10', 'Arthas', '0');

-- ----------------------------
-- Table structure for tag_link
-- ----------------------------
DROP TABLE IF EXISTS `tag_link`;
CREATE TABLE `tag_link` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tag_id` int(11) DEFAULT NULL COMMENT '标签Id',
  `link_id` int(11) DEFAULT NULL COMMENT '关联Id',
  `type` int(11) DEFAULT NULL COMMENT '所属类别：0文章，1阅读',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8 COMMENT='标签多对多维护表';

-- ----------------------------
-- Records of tag_link
-- ----------------------------
INSERT INTO `tag_link` VALUES ('3', '3', '1', '1');
INSERT INTO `tag_link` VALUES ('4', '4', '1', '1');
INSERT INTO `tag_link` VALUES ('49', '1', '1', '0');
INSERT INTO `tag_link` VALUES ('50', '2', '1', '0');
INSERT INTO `tag_link` VALUES ('55', '5', '1', '2');
INSERT INTO `tag_link` VALUES ('56', '6', '1', '2');
INSERT INTO `tag_link` VALUES ('75', '7', '3', '0');
INSERT INTO `tag_link` VALUES ('76', '8', '3', '0');
INSERT INTO `tag_link` VALUES ('77', '9', '4', '0');
INSERT INTO `tag_link` VALUES ('78', '7', '4', '0');
INSERT INTO `tag_link` VALUES ('82', '10', '5', '0');
