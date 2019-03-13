CREATE TABLE `article` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `article_id` bigint(32) NOT NULL COMMENT '文章id',
  `author` varchar(128) NOT NULL COMMENT '文章作者',
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
  `last_article_id` varchar(255) NOT NULL COMMENT '上一篇文章id',
  `next_article_id` int(11) NOT NULL COMMENT '下一篇文章id',
  `publish_date` date NOT NULL COMMENT '发布时间',
  `update_date` datetime NOT NULL COMMENT '最后一次修改时间',
  `is_delete` tinyint(2) NOT NULL COMMENT '1-删除；2-未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

