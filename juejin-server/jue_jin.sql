/*
 Navicat Premium Data Transfer

 Source Server         : aliyun
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : rm-wz9mc28o4x3thxw56bo.mysql.rds.aliyuncs.com:3306
 Source Schema         : jue_jin

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 26/08/2022 10:26:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article_content
-- ----------------------------
DROP TABLE IF EXISTS `article_content`;
CREATE TABLE `article_content` (
  `article_id` varchar(255) CHARACTER SET utf8 NOT NULL,
  `mark_content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for article_info
-- ----------------------------
DROP TABLE IF EXISTS `article_info`;
CREATE TABLE `article_info` (
  `article_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `category_id` varchar(255) DEFAULT NULL,
  `tag_ids` varchar(255) DEFAULT NULL,
  `visible_level` int(11) DEFAULT NULL,
  `link_url` varchar(255) DEFAULT NULL,
  `cover_image` varchar(255) DEFAULT NULL,
  `is_gfw` smallint(6) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `brief_content` varchar(255) DEFAULT NULL,
  `is_english` smallint(6) DEFAULT NULL,
  `is_original` smallint(6) DEFAULT NULL,
  `user_index` double DEFAULT NULL,
  `original_type` smallint(6) DEFAULT NULL,
  `original_author` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `ctime` varchar(255) DEFAULT NULL,
  `mtime` varchar(255) DEFAULT NULL,
  `rtime` varchar(255) DEFAULT NULL,
  `draft_id` varchar(255) DEFAULT NULL,
  `view_count` int(11) DEFAULT NULL,
  `collect_count` int(11) DEFAULT NULL,
  `digg_count` int(11) DEFAULT NULL,
  `comment_count` int(11) DEFAULT NULL,
  `hot_index` int(11) DEFAULT NULL,
  `is_hot` smallint(6) DEFAULT NULL,
  `rank_index` double DEFAULT NULL,
  `status` smallint(6) DEFAULT NULL,
  `verify_status` smallint(6) DEFAULT NULL,
  `audit_status` smallint(6) DEFAULT NULL,
  `mark_content` varchar(255) DEFAULT NULL,
  `display_count` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for author_user
-- ----------------------------
DROP TABLE IF EXISTS `author_user`;
CREATE TABLE `author_user` (
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `job_title` varchar(255) DEFAULT NULL,
  `avatar_large` varchar(255) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `followee_count` int(11) DEFAULT NULL,
  `follower_count` int(11) DEFAULT NULL,
  `post_article_count` int(11) DEFAULT NULL,
  `digg_article_count` int(11) DEFAULT NULL,
  `got_digg_count` int(11) DEFAULT NULL,
  `got_view_count` int(11) DEFAULT NULL,
  `post_shortmsg_count` int(11) DEFAULT NULL,
  `digg_shortmsg_count` int(11) DEFAULT NULL,
  `isfollowed` varchar(255) DEFAULT NULL,
  `favorable_author` int(11) DEFAULT NULL,
  `power` int(11) DEFAULT NULL,
  `study_point` int(11) DEFAULT NULL,
  `university` varchar(255) DEFAULT NULL,
  `major` varchar(255) DEFAULT NULL,
  `student_status` int(11) DEFAULT NULL,
  `select_event_count` int(11) DEFAULT NULL,
  `select_online_course_count` int(11) DEFAULT NULL,
  `identity` int(11) DEFAULT NULL,
  `is_select_annual` varchar(255) DEFAULT NULL,
  `select_annual_rank` int(11) DEFAULT NULL,
  `annual_list_type` int(11) DEFAULT NULL,
  `extraMap` varchar(255) DEFAULT NULL,
  `is_logout` int(11) DEFAULT NULL,
  `annual_info` varchar(255) DEFAULT NULL,
  `account_amount` int(11) DEFAULT NULL,
  `user_growth_info` varchar(255) DEFAULT NULL,
  `is_vip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tags
-- ----------------------------
DROP TABLE IF EXISTS `tags`;
CREATE TABLE `tags` (
  `id` varchar(255) NOT NULL,
  `tag_id` varchar(255) DEFAULT NULL,
  `tag_name` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `back_ground` varchar(255) DEFAULT NULL,
  `show_navi` smallint(6) DEFAULT NULL,
  `ctime` varchar(255) DEFAULT NULL,
  `mtime` varchar(255) DEFAULT NULL,
  `id_type` int(11) DEFAULT NULL,
  `tag_alias` varchar(255) DEFAULT NULL,
  `post_article_count` varchar(255) DEFAULT NULL,
  `concern_user_count` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
