CREATE TABLE `article` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `article_id` bigint(32) NOT NULL COMMENT '文章id',
  `author_id` bigint(128) NOT NULL COMMENT '文章作者id',
  `original_author` varchar(125) NOT NULL COMMENT '文章原作者',
  `article_title` varchar(255) NOT NULL COMMENT '文章名称',
  `article_summary` text NOT NULL COMMENT '文章摘要',
  `article_html_content` longtext NOT NULL COMMENT '文章内容_html',
  `article_md_content` longtext NOT NULL COMMENT '文章内容_md',
  `article_tags` varchar(1024) NOT NULL COMMENT '文章标签',
  `article_type` tinyint(2) NOT NULL COMMENT '文章类型: 1-博客',
  `article_categories` varchar(255) NOT NULL COMMENT '博客分类',
  `article_url` varchar(255) NOT NULL COMMENT '原文链接',
  `likes` varchar(255) NOT NULL COMMENT '喜欢',
  `last_article_id` bigint(32) NOT NULL COMMENT '上一篇文章id',
  `next_article_id` bigint(32) NOT NULL COMMENT '下一篇文章id',
  `publish_date` date NOT NULL COMMENT '发布时间',
  `update_date` datetime NOT NULL COMMENT '最后一次修改时间',
  `is_delete` tinyint(2) NOT NULL COMMENT '1-删除；2-未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;





CREATE TABLE `image` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(32) NOT NULL COMMENT '用户id',
  `article_id` bigint(32) NOT NULL COMMENT '文章id',
  `img_name` varchar(255) NOT NULL COMMENT '图片名称',
  `img_suffix` varchar(255) NOT NULL COMMENT '图片后缀',
  `img_db_url` varchar(128) NOT NULL COMMENT '图片db存储路径',
  `img_static_url` varchar(128) NOT NULL COMMENT '图片静态资源存储路径',
  `img_source` longblob NOT NULL COMMENT '图片源文件',
  `create_date` date NOT NULL COMMENT '创建时间',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `is_delete` tinyint(2) NOT NULL COMMENT '1-删除；2-未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

