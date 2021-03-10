/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : zsslg1

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 10/04/2020 10:40:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account_new
-- ----------------------------
DROP TABLE IF EXISTS `account_new`;
CREATE TABLE `account_new`  (
  `pcAccount` varchar(40) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `gameUid` bigint(20) NULL DEFAULT NULL,
  `server` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `phone` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`pcAccount`) USING BTREE,
  INDEX `pcAccount`(`pcAccount`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for alliance
-- ----------------------------
DROP TABLE IF EXISTS `alliance`;
CREATE TABLE `alliance`  (
  `uid` bigint(20) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `abbr` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `announcement` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL,
  `guildUids` json NULL,
  `leaderUid` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for area_sea
-- ----------------------------
DROP TABLE IF EXISTS `area_sea`;
CREATE TABLE `area_sea`  (
  `id` int(10) NOT NULL,
  `refreshCityTaskTime` bigint(20) NULL DEFAULT NULL,
  `cityMap` json NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for auction_house
-- ----------------------------
DROP TABLE IF EXISTS `auction_house`;
CREATE TABLE `auction_house`  (
  `cityId` int(10) NOT NULL,
  `itemRecordMap` json NULL,
  PRIMARY KEY (`cityId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for auction_item
-- ----------------------------
DROP TABLE IF EXISTS `auction_item`;
CREATE TABLE `auction_item`  (
  `uid` bigint(20) NOT NULL,
  `ownerUid` bigint(20) NULL DEFAULT NULL,
  `itemId` int(10) NULL DEFAULT NULL,
  `amount` int(10) NULL DEFAULT NULL,
  `time` bigint(20) NULL DEFAULT NULL,
  `cityId` int(10) NULL DEFAULT NULL,
  `price` int(10) NULL DEFAULT NULL,
  `offShelf` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for chat_msg
-- ----------------------------
DROP TABLE IF EXISTS `chat_msg`;
CREATE TABLE `chat_msg`  (
  `chatRoomUid` bigint(20) NOT NULL,
  `msgUid` bigint(20) NOT NULL,
  `msg` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `sender` bigint(20) NULL DEFAULT NULL,
  `createTime` bigint(20) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for chat_room
-- ----------------------------
DROP TABLE IF EXISTS `chat_room`;
CREATE TABLE `chat_room`  (
  `chatRoomUid` bigint(20) NOT NULL,
  `chatRoomType` int(10) NOT NULL,
  `chatRoomKey` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `founder` bigint(20) NULL DEFAULT NULL,
  `members` json NOT NULL,
  PRIMARY KEY (`chatRoomUid`) USING BTREE,
  INDEX `chatRoomKey`(`chatRoomKey`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for city_war
-- ----------------------------
DROP TABLE IF EXISTS `city_war`;
CREATE TABLE `city_war`  (
  `cityId` int(11) NOT NULL,
  `allianceUid` bigint(255) NULL DEFAULT NULL,
  `guildUid` bigint(255) NULL DEFAULT NULL,
  `attackAllianceUid` bigint(255) NULL DEFAULT NULL,
  `declareWarTime` bigint(255) NULL DEFAULT NULL,
  `startWarTime` bigint(255) NULL DEFAULT NULL,
  `lastWarEndTime` bigint(20) NULL DEFAULT NULL,
  `warState` int(11) NULL DEFAULT NULL,
  `fortBeans` json NULL,
  PRIMARY KEY (`cityId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for common_name
-- ----------------------------
DROP TABLE IF EXISTS `common_name`;
CREATE TABLE `common_name`  (
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `uid` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for common_user_black
-- ----------------------------
DROP TABLE IF EXISTS `common_user_black`;
CREATE TABLE `common_user_black`  (
  `userUid` bigint(20) NOT NULL,
  `targetUid` bigint(20) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for common_user_chat
-- ----------------------------
DROP TABLE IF EXISTS `common_user_chat`;
CREATE TABLE `common_user_chat`  (
  `userUid` bigint(20) NOT NULL,
  `targetUid` bigint(20) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for common_user_friend
-- ----------------------------
DROP TABLE IF EXISTS `common_user_friend`;
CREATE TABLE `common_user_friend`  (
  `userUid` bigint(20) NOT NULL,
  `targetUid` bigint(20) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for common_user_private
-- ----------------------------
DROP TABLE IF EXISTS `common_user_private`;
CREATE TABLE `common_user_private`  (
  `userUid` bigint(20) NOT NULL,
  `targetUid` bigint(20) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for common_user_stick
-- ----------------------------
DROP TABLE IF EXISTS `common_user_stick`;
CREATE TABLE `common_user_stick`  (
  `userUid` bigint(20) NOT NULL,
  `targetUid` bigint(20) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for fightworld
-- ----------------------------
DROP TABLE IF EXISTS `fightworld`;
CREATE TABLE `fightworld`  (
  `uid` bigint(20) NOT NULL,
  `id` int(10) NULL DEFAULT NULL,
  `point` int(10) NULL DEFAULT NULL,
  `resourceJson` json NULL,
  `monsterJson` json NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for guild
-- ----------------------------
DROP TABLE IF EXISTS `guild`;
CREATE TABLE `guild`  (
  `uid` bigint(20) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `abbr` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `memberCount` int(11) NULL DEFAULT NULL,
  `maxCount` int(11) NULL DEFAULT NULL,
  `allianceUid` bigint(20) NULL DEFAULT NULL,
  `leaderUid` bigint(20) NULL DEFAULT NULL,
  `announcement` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL,
  `needApply` tinyint(2) NULL DEFAULT NULL,
  `fund` int(11) NULL DEFAULT NULL,
  `cityId` int(11) NULL DEFAULT NULL,
  `memberMap` json NULL,
  `groupList` json NULL,
  `storeMap` json NULL,
  `groupMap` json NULL,
  `manorSet` json NULL,
  `relationMap` json NULL,
  `warMap` json NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for guild_apply
-- ----------------------------
DROP TABLE IF EXISTS `guild_apply`;
CREATE TABLE `guild_apply`  (
  `uid` bigint(20) NOT NULL,
  `items` json NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for guild_record
-- ----------------------------
DROP TABLE IF EXISTS `guild_record`;
CREATE TABLE `guild_record`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `params` json NULL,
  `guildUid` bigint(20) NULL DEFAULT NULL,
  `type` int(10) NULL DEFAULT NULL,
  `time` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for guild_tmp
-- ----------------------------
DROP TABLE IF EXISTS `guild_tmp`;
CREATE TABLE `guild_tmp`  (
  `uid` bigint(20) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `abbr` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `memberCount` int(10) NULL DEFAULT NULL,
  `maxCount` int(10) NULL DEFAULT NULL,
  `announcement` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `needApply` tinyint(255) NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mmo_player
-- ----------------------------
DROP TABLE IF EXISTS `mmo_player`;
CREATE TABLE `mmo_player`  (
  `uid` bigint(20) NOT NULL,
  `items` json NOT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for name
-- ----------------------------
DROP TABLE IF EXISTS `name`;
CREATE TABLE `name`  (
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `uid` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order_item
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item`  (
  `uid` bigint(20) NOT NULL,
  `ownerUid` bigint(20) NULL DEFAULT NULL,
  `ownerName` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `itemId` int(11) NULL DEFAULT NULL,
  `amount` int(11) NULL DEFAULT NULL,
  `cityId` int(11) NULL DEFAULT NULL,
  `time` bigint(20) NULL DEFAULT NULL,
  `price` int(10) NULL DEFAULT NULL,
  `appointUid` bigint(20) NULL DEFAULT NULL,
  `appointName` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `offShelf` tinyint(1) NULL DEFAULT NULL,
  `refuse` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order_record
-- ----------------------------
DROP TABLE IF EXISTS `order_record`;
CREATE TABLE `order_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` bigint(20) NULL DEFAULT NULL,
  `ownerUid` bigint(20) NULL DEFAULT NULL,
  `ownerName` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `itemId` int(11) NULL DEFAULT NULL,
  `amount` int(11) NULL DEFAULT NULL,
  `cityId` int(11) NULL DEFAULT NULL,
  `time` bigint(20) NULL DEFAULT NULL,
  `price` int(10) NULL DEFAULT NULL,
  `appointUid` bigint(20) NULL DEFAULT NULL,
  `appointName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ownerUidindex`(`ownerUid`) USING BTREE,
  INDEX `appointUidindex`(`appointUid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for server_uid
-- ----------------------------
DROP TABLE IF EXISTS `server_uid`;
CREATE TABLE `server_uid`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `areaId` int(11) NULL DEFAULT NULL,
  `nodeId` int(11) NULL DEFAULT NULL,
  `uidType` int(11) NULL DEFAULT NULL,
  `curMaxUid` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 164 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for society_relation
-- ----------------------------
DROP TABLE IF EXISTS `society_relation`;
CREATE TABLE `society_relation`  (
  `uid` bigint(20) NOT NULL,
  `friend` json NULL,
  `enemy` json NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for test_mysql
-- ----------------------------
DROP TABLE IF EXISTS `test_mysql`;
CREATE TABLE `test_mysql`  (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for trade_good_base
-- ----------------------------
DROP TABLE IF EXISTS `trade_good_base`;
CREATE TABLE `trade_good_base`  (
  `cityId` int(11) NOT NULL,
  `buyMap` json NULL,
  `sellMap` json NULL,
  PRIMARY KEY (`cityId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for trade_good_server
-- ----------------------------
DROP TABLE IF EXISTS `trade_good_server`;
CREATE TABLE `trade_good_server`  (
  `goodId` int(10) NOT NULL,
  `items` json NULL,
  PRIMARY KEY (`goodId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_armada
-- ----------------------------
DROP TABLE IF EXISTS `user_armada`;
CREATE TABLE `user_armada`  (
  `uid` bigint(255) NOT NULL,
  `items` json NOT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_build
-- ----------------------------
DROP TABLE IF EXISTS `user_build`;
CREATE TABLE `user_build`  (
  `uid` bigint(20) NOT NULL,
  `items` json NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_cycles
-- ----------------------------
DROP TABLE IF EXISTS `user_cycles`;
CREATE TABLE `user_cycles`  (
  `uid` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `dayDatas` json NULL,
  `weekDatas` json NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_data
-- ----------------------------
DROP TABLE IF EXISTS `user_data`;
CREATE TABLE `user_data`  (
  `uid` bigint(20) NOT NULL,
  `datas` json NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_deposite
-- ----------------------------
DROP TABLE IF EXISTS `user_deposite`;
CREATE TABLE `user_deposite`  (
  `uid` bigint(20) NOT NULL,
  `items` json NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_email
-- ----------------------------
DROP TABLE IF EXISTS `user_email`;
CREATE TABLE `user_email`  (
  `uid` bigint(20) NOT NULL,
  `type` int(11) NULL DEFAULT NULL,
  `items` json NULL,
  `auctionMap` json NULL,
  `orderMap` json NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_equip
-- ----------------------------
DROP TABLE IF EXISTS `user_equip`;
CREATE TABLE `user_equip`  (
  `uid` bigint(20) NOT NULL,
  `items` json NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_guild
-- ----------------------------
DROP TABLE IF EXISTS `user_guild`;
CREATE TABLE `user_guild`  (
  `uid` bigint(20) NOT NULL,
  `guildUid` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_hero
-- ----------------------------
DROP TABLE IF EXISTS `user_hero`;
CREATE TABLE `user_hero`  (
  `uid` bigint(20) NOT NULL,
  `items` json NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_item
-- ----------------------------
DROP TABLE IF EXISTS `user_item`;
CREATE TABLE `user_item`  (
  `uid` bigint(20) NOT NULL,
  `id` int(11) NULL DEFAULT NULL,
  `items` json NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_manor
-- ----------------------------
DROP TABLE IF EXISTS `user_manor`;
CREATE TABLE `user_manor`  (
  `uid` bigint(20) NOT NULL,
  `items` json NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_profile
-- ----------------------------
DROP TABLE IF EXISTS `user_profile`;
CREATE TABLE `user_profile`  (
  `uid` bigint(20) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `regTime` bigint(20) NOT NULL DEFAULT 0,
  `offLineTime` bigint(20) NULL DEFAULT 0,
  `lastOnlineTime` bigint(20) NULL DEFAULT 0,
  `level` int(10) NULL DEFAULT NULL,
  `exp` int(20) NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_queue
-- ----------------------------
DROP TABLE IF EXISTS `user_queue`;
CREATE TABLE `user_queue`  (
  `uid` bigint(20) NOT NULL,
  `items` json NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_ship
-- ----------------------------
DROP TABLE IF EXISTS `user_ship`;
CREATE TABLE `user_ship`  (
  `uid` bigint(20) NOT NULL,
  `items` json NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_task
-- ----------------------------
DROP TABLE IF EXISTS `user_task`;
CREATE TABLE `user_task`  (
  `uid` bigint(20) NOT NULL,
  `items` json NULL,
  `finish` json NULL,
  `follow` json NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_tech
-- ----------------------------
DROP TABLE IF EXISTS `user_tech`;
CREATE TABLE `user_tech`  (
  `uid` bigint(20) NOT NULL,
  `items` json NULL,
  `buyTechs` json NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for worldpoint
-- ----------------------------
DROP TABLE IF EXISTS `worldpoint`;
CREATE TABLE `worldpoint`  (
  `id` int(11) NOT NULL,
  `x` int(11) NOT NULL,
  `y` int(11) NOT NULL,
  `fortUuid` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `expireTime` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cdk
-- ----------------------------
DROP TABLE IF EXISTS `cdk`;
CREATE TABLE `cdk` (
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for cdk
-- ----------------------------
DROP TABLE IF EXISTS `fight_entity_main`;
CREATE TABLE `fight_entity_main` (
  `armadaUid` bigint(20) NOT NULL,
  `mmoId` int(11) DEFAULT NULL,
  `userUid` bigint(20) DEFAULT NULL,
  `mmoInfo` json DEFAULT NULL,
  PRIMARY KEY (`armadaUid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
