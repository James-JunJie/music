/*
 Navicat Premium Data Transfer

 Source Server         : music
 Source Server Type    : MySQL
 Source Server Version : 50649
 Source Host           : 118.31.121.237:3306
 Source Schema         : music

 Target Server Type    : MySQL
 Target Server Version : 50649
 File Encoding         : 65001

 Date: 03/01/2021 11:47:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '名字',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '管理员' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', '123456');
INSERT INTO `admin` VALUES (15, 'ljj', NULL);

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `type` tinyint(1) NULL DEFAULT NULL COMMENT '收藏类型   (0歌曲 1歌单）',
  `song_id` int(11) NULL DEFAULT NULL COMMENT '歌曲id',
  `song_list_id` int(11) NULL DEFAULT NULL COMMENT '收藏歌单',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '收藏时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '收藏' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES (8, 1, 0, 32, NULL, '2021-01-01 11:54:47');
INSERT INTO `collect` VALUES (9, 1, 0, 30, NULL, '2021-01-01 12:02:22');
INSERT INTO `collect` VALUES (16, 1, 0, 31, NULL, '2021-01-01 15:12:35');
INSERT INTO `collect` VALUES (17, 51, 0, 30, NULL, '2021-01-02 16:29:01');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `type` tinyint(1) NULL DEFAULT NULL COMMENT '收藏类型   (0歌曲 1歌单）',
  `song_id` int(11) NULL DEFAULT NULL COMMENT '歌曲id',
  `song_list_id` int(11) NULL DEFAULT NULL COMMENT '收藏歌单',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '收藏时间',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '评论内容',
  `up` int(11) NULL DEFAULT 0 COMMENT '评论点赞数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '评论' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (8, 52, 1, NULL, 12, '2021-01-02 11:54:38', '我来了', 26);

-- ----------------------------
-- Table structure for consumer
-- ----------------------------
DROP TABLE IF EXISTS `consumer`;
CREATE TABLE `consumer`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `sex` tinyint(1) NULL DEFAULT NULL COMMENT '性别 1男 0女',
  `phone_num` char(15) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '电话',
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `birth` datetime(0) NULL DEFAULT NULL COMMENT '生日',
  `introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '签名',
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '地址',
  `avator` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '头像',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 55 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '用户' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of consumer
-- ----------------------------
INSERT INTO `consumer` VALUES (1, '李俊杰', '123456', 0, '19961510527', '19961510552@163.com', '2021-01-01 22:16:50', 'happy', '四川宜宾', '/img/userPic/1609502640246git_photo.jpg', '2020-12-29 09:51:27', '2021-01-01 22:16:50');
INSERT INTO `consumer` VALUES (52, '李俊杰爸爸林宇驹', '123456', 1, '', '', '2021-01-07 00:00:00', '', '', '/img/user.jpg', '2021-01-02 11:53:32', NULL);
INSERT INTO `consumer` VALUES (53, '111111', '111111', 1, '11111111111', '1112@123.com', '2021-01-05 00:00:00', '123', '天津', '/img/user.jpg', '2021-01-02 20:20:49', NULL);
INSERT INTO `consumer` VALUES (54, '1044204713', '1044204713', 1, '18674666336', '', '2021-01-11 00:00:00', '俊杰的父亲', '', '/img/user.jpg', '2021-01-03 10:38:49', NULL);

-- ----------------------------
-- Table structure for list_song
-- ----------------------------
DROP TABLE IF EXISTS `list_song`;
CREATE TABLE `list_song`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `song_id` int(11) NULL DEFAULT NULL COMMENT '歌曲id',
  `song_list_id` int(11) NULL DEFAULT NULL COMMENT '歌单id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `song_id`(`song_id`) USING BTREE,
  INDEX `song_list_id`(`song_list_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '歌单包含歌曲列表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of list_song
-- ----------------------------
INSERT INTO `list_song` VALUES (9, 26, 12);
INSERT INTO `list_song` VALUES (10, 31, 13);
INSERT INTO `list_song` VALUES (11, 32, 13);
INSERT INTO `list_song` VALUES (12, 51, 14);

-- ----------------------------
-- Table structure for ranks
-- ----------------------------
DROP TABLE IF EXISTS `ranks`;
CREATE TABLE `ranks`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `song_list_id` int(11) NULL DEFAULT NULL COMMENT '歌单id',
  `consumer_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `score` int(11) NULL DEFAULT NULL COMMENT '评分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ranks
-- ----------------------------
INSERT INTO `ranks` VALUES (8, 12, 1, 4);
INSERT INTO `ranks` VALUES (15, 12, 1, 100);
INSERT INTO `ranks` VALUES (16, 12, 1, 100);
INSERT INTO `ranks` VALUES (17, 12, 1, 100);
INSERT INTO `ranks` VALUES (18, 12, 1, 100);
INSERT INTO `ranks` VALUES (19, 12, 1, 100);
INSERT INTO `ranks` VALUES (20, 12, 1, 100);
INSERT INTO `ranks` VALUES (21, 12, 1, 100);
INSERT INTO `ranks` VALUES (22, 12, 1, 100);
INSERT INTO `ranks` VALUES (23, 13, 53, 8);
INSERT INTO `ranks` VALUES (24, 13, 53, 10);
INSERT INTO `ranks` VALUES (25, 13, 53, 9);

-- ----------------------------
-- Table structure for singer
-- ----------------------------
DROP TABLE IF EXISTS `singer`;
CREATE TABLE `singer`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `sex` tinyint(1) NULL DEFAULT NULL COMMENT '1男 0女',
  `birth` datetime(0) NULL DEFAULT NULL,
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '地区',
  `introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '简介',
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '照片URL',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of singer
-- ----------------------------
INSERT INTO `singer` VALUES (27, '伍佰', 1, '1968-01-14 00:00:00', '台湾省新北市新店区', '中国台湾男歌手、音乐人、吉他手、影视演员、摄影家。1990年以歌曲《小人国》正式出道。1992年发行首张个人专辑《爱上别人是快乐的事》，成立摇滚乐团“China Blue”并担任主唱兼主音吉他手。', '/img/singerPic/1609406675131伍佰.jpg');
INSERT INTO `singer` VALUES (28, 'tylor swift', 0, '1989-12-13 00:00:00', '美国宾夕法尼亚州雷丁', '1989年12月13日出生于美国宾夕法尼亚州，美国女歌手、词曲作者、音乐制作人、演员。2006年，发行个人首张音乐专辑《Taylor Swift》，该专辑获得美国唱片业协会认证5倍白金唱片销量。2008年，发行音乐专辑《Fearless》，该专辑在美国公告牌专辑榜上获11周冠军', '/img/singerPic/1609415228610tylor swift.jpg');
INSERT INTO `singer` VALUES (31, '李智勇', 1, '2021-01-04 00:00:00', '火星', '2个字:傻逼', '/img/singerPic/source.jpg');
INSERT INTO `singer` VALUES (32, '林宇驹', 1, '1919-07-23 00:00:00', '月球', '宇驹者，广东人士也。江南四大才子之一，与李俊杰等人闻名江南。其著名著作中写有“夫君子之行，静以修身，俭以养德；非澹泊无以明志，非宁静无以致远。夫学须静也，才须学也；非学无以广才，非志无以成学。怠慢则不能励精，险躁则不能冶性。年与时驰，意与岁去，遂成枯落，多不接世。悲守穷庐，将复何及！”，其神人也，至未存于世！', '/img/singerPic/source.jpg');
INSERT INTO `singer` VALUES (33, '肖云峰', 1, '1998-02-03 00:00:00', '重庆', '云峰者,重庆人士。其父李俊杰，高大威猛，英俊潇洒，风流倜傥，但龙生九子各有不同,其大儿峰峰,奈何年少受挫，故一如道门，现在擅长江湖术道，论道修仙，决心得道升天。', '/img/singerPic/source.jpg');

-- ----------------------------
-- Table structure for song
-- ----------------------------
DROP TABLE IF EXISTS `song`;
CREATE TABLE `song`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `singer_id` int(11) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `lyric` text CHARACTER SET utf8 COLLATE utf8_bin NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `play_count` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '播放量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 52 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of song
-- ----------------------------
INSERT INTO `song` VALUES (26, 27, '伍佰-晚风', '伍佰的歌', '2020-12-29 15:27:44', '2021-01-01 20:23:54', '/img/songPic/1609414840100伍佰.jpg', '12345346', '/song/1609503689264晚风 - 伍佰.mp3', NULL);
INSERT INTO `song` VALUES (30, 27, '伍佰-梦醒时分', '单程车票', '2020-12-31 17:27:24', '2020-12-31 17:27:47', '/img/songPic/1609406867133伍佰.jpg', '[00:00:00]暂无歌词', '/song/1609406843645梦醒时分 - 伍佰.mp3', NULL);
INSERT INTO `song` VALUES (31, 28, 'tylor swiftt-Afterglow', 'Lover', '2020-12-31 19:48:58', '2021-01-01 20:48:14', '/img/songPic/1609415372501tylor swift.jpg', '[00:00.00]Afterglow - Taylor Swift (泰勒·斯威夫特)\n[00:01.68]Lyrics by：Taylor Swift/Louis Bell/Adam King Feeney\n[00:03.36]Composed by：Taylor Swift/Louis Bell/Adam King Feeney\n[00:05.04]I blew things out of proportion now you\'re blue\n[00:09.34]Put you in jail for something you didn\'t do\n[00:13.67]I pinned your hands behind your back oh\n[00:17.93]Thought I had reason to attack but no\n[00:21.98]Fighting with a true love is boxing with no gloves\n[00:26.24]Chemistry \'til it blows up \'til there\'s no us\n[00:30.69]Why I had to break what I love so much\n[00:34.75]It\'s on your face and I\'m to blame I need to say\n[00:39.33]Hey it\'s on me\n[00:42.91]In my head I\'m the one who burned us\n[00:48.09]D**n but it\'s not what I meant\n[00:54.16]Sorry that I hurt you\n[00:56.60]I don\'t wanna do I don\'t wanna do this to you\n[01:00.95]I don\'t wanna lose I don\'t wanna lose this with you\n[01:04.10]I need to say hey it\'s on me just don\'t go\n[01:11.77]Leave me in the afterglow\n[01:16.42]It\'s so excruciating to see you low\n[01:20.65]Just wanna lift you up and not let you go\n[01:24.97]This ultraviolet morning light below\n[01:29.23]Tells me this love is worth the fight oh\n[01:33.36]Island took an island punished you in silence\n[01:37.68]Went off like sirens just crying\n[01:42.05]Why I had to break what I love so much\n[01:46.08]It\'s on your face\n[01:48.20]Don\'t walk away I need to say\n[01:50.67]Hey it\'s on me\n[01:54.30]In my head I\'m the one who burned us\n[01:59.22]D**n but it\'s not what I meant\n[02:05.56]Sorry that I hurt you\n[02:07.88]I don\'t wanna do I don\'t wanna do this to you\n[02:12.33]I don\'t wanna lose I don\'t wanna lose this with you\n[02:15.39]I need to say hey it\'s on me just don\'t go\n[02:23.15]Leave me in the afterglow\n[02:25.13]Tell me that you\'re still mine\n[02:27.27]Tell me that we\'ll be just fine\n[02:29.42]Even when I lose my mind\n[02:32.64]I need to say\n[02:33.87]Tell me that it\'s not my fault\n[02:35.92]Tell me that I\'m all you want\n[02:38.05]Even when I break your heart\n[02:41.27]I need to say\n[02:42.50]Hey it\'s on me\n[02:46.05]In my head I\'m the one who burned us\n[02:51.16]D**n but it\'s not what I meant\n[02:57.62]Sorry that I hurt you\n[02:59.89]I don\'t wanna do I don\'t wanna do this to you\n[03:04.05]I don\'t wanna lose I don\'t wanna lose this with you\n[03:07.29]I need to say hey it\'s on me just don\'t go\n[03:15.02]Leave me in the afterglow\n', '/song/1609415338099Taylor Swift - Lover.mp3', NULL);
INSERT INTO `song` VALUES (32, 28, 'tylor swift-You Need To Calm Down', 'Lover', '2020-12-31 19:49:25', '2020-12-31 19:51:01', '/img/songPic/1609415376863tylor swift.jpg', '[00:00:00]暂无歌词', '/song/1609415364704Taylor Swift - You Need To Calm Down.mp3', NULL);
INSERT INTO `song` VALUES (33, 27, '伍佰-浪人情歌', ' ', '2021-01-01 09:56:05', '2021-01-01 10:08:20', '/img/songPic/1609466881365伍佰.jpg', '[00:00:00]暂无歌词', '/song/1609466164735再度重相逢 - 伍佰.mp3', NULL);
INSERT INTO `song` VALUES (51, 27, '伍佰-Last Dance', '爱情的尽头', '2021-01-01 21:42:32', '2021-01-01 21:42:48', '/img/songPic/1609508567561伍佰.jpg', '[00:00:00]暂无歌词', '/song/1609508552099Last Dance - 伍佰 & China Blue.mp3', NULL);

-- ----------------------------
-- Table structure for song_list
-- ----------------------------
DROP TABLE IF EXISTS `song_list`;
CREATE TABLE `song_list`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '标题',
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '图片',
  `introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '简介',
  `style` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '风格',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '歌单' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of song_list
-- ----------------------------
INSERT INTO `song_list` VALUES (12, '单程车票', '/img/songListPic/1609416153971单车车票.png', '发行时间：2011-09-09\n\n发行公司： 环球唱片 ', '华语');
INSERT INTO `song_list` VALUES (13, 'Lover', '/img/songListPic/1609415163832tylor swift.jpg', '泰勒·斯威夫特将专辑的基调设定为“浪漫”，她认为“Lover”不仅指爱情，还是一种生活态度，它不一定发生在快乐的时候，在朋友、家庭、愤怒之间、在失望中重新站起和你爱的所有事物，同样可以寻找浪漫。泰勒·斯威夫特写歌时以一种浪漫的眼光来看待生活中的一切，因此最终将专辑取名为《Lover》', '欧美');
INSERT INTO `song_list` VALUES (14, '爱情的尽头', '/img/songListPic/1609508644993爱情尽头.jpg', '《爱情的尽头》是伍佰1996年的最新作品, 在一片幡然成风的台语再兴声中, 何以推出一张全部都是国语创作的专辑? 面对长年久居台北都会造成环境语言的更变,无可避免地, 伍佰必须正视他每次创作阶段的不同语言媒介, 才能避开“泛文化”的陷阱, 不让语言限制住音乐的无边国界。这未尝不是一种预告,藉以抛开live专辑带来的成功包袱, 将一切归零再重新出发。', '华语');

SET FOREIGN_KEY_CHECKS = 1;
