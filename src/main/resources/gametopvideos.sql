/*
 Navicat PostgreSQL Data Transfer

 Source Server         : gtv
 Source Server Type    : PostgreSQL
 Source Server Version : 100005
 Source Host           : localhost:5432
 Source Catalog        : gtv
 Source Schema         : gametopvideos

 Target Server Type    : PostgreSQL
 Target Server Version : 100005
 File Encoding         : 65001

 Date: 02/10/2018 00:34:31
*/


-- ----------------------------
-- Sequence structure for video_sequence
-- ----------------------------
DROP SEQUENCE IF EXISTS "gametopvideos"."video_sequence";
CREATE SEQUENCE "gametopvideos"."video_sequence" 
INCREMENT 1
MINVALUE  1
MAXVALUE 999999999999
START 100
CACHE 20;

-- ----------------------------
-- Table structure for action
-- ----------------------------
DROP TABLE IF EXISTS "gametopvideos"."action";
CREATE TABLE "gametopvideos"."action" (
  "id" numeric(10) NOT NULL,
  "active" varchar(1) COLLATE "pg_catalog"."default",
  "user_id" numeric(10),
  "video_id" numeric(10),
  "actiontype_id" numeric(10)
)
;

-- ----------------------------
-- Records of action
-- ----------------------------
INSERT INTO "gametopvideos"."action" VALUES (1, 'E', 1, 1, 1);

-- ----------------------------
-- Table structure for actiontype
-- ----------------------------
DROP TABLE IF EXISTS "gametopvideos"."actiontype";
CREATE TABLE "gametopvideos"."actiontype" (
  "id" numeric(10) NOT NULL,
  "name" varchar(20) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of actiontype
-- ----------------------------
INSERT INTO "gametopvideos"."actiontype" VALUES (1, 'like');
INSERT INTO "gametopvideos"."actiontype" VALUES (2, 'favorite');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS "gametopvideos"."category";
CREATE TABLE "gametopvideos"."category" (
  "id" numeric(10) NOT NULL,
  "name" varchar(20) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO "gametopvideos"."category" VALUES (1, 'league of legends');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS "gametopvideos"."role";
CREATE TABLE "gametopvideos"."role" (
  "id" numeric(10) NOT NULL,
  "name" varchar(20) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO "gametopvideos"."role" VALUES (1, 'admin');
INSERT INTO "gametopvideos"."role" VALUES (2, 'normal user');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS "gametopvideos"."user";
CREATE TABLE "gametopvideos"."user" (
  "id" numeric(10) NOT NULL,
  "name" varchar(20) COLLATE "pg_catalog"."default",
  "surname" varchar(20) COLLATE "pg_catalog"."default",
  "email" varchar(30) COLLATE "pg_catalog"."default",
  "active" varchar(1) COLLATE "pg_catalog"."default",
  "role_id" numeric(2)
)
;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO "gametopvideos"."user" VALUES (1, 'fatih', 'yavuz', 'bu.fatih.yavuz@gmail.com', 'E', 1);

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS "gametopvideos"."video";
CREATE TABLE "gametopvideos"."video" (
  "id" numeric(10) NOT NULL,
  "title" varchar(100) COLLATE "pg_catalog"."default",
  "url" varchar(50) COLLATE "pg_catalog"."default",
  "view" numeric(8),
  "duration" numeric(5),
  "size" numeric(9),
  "category_id" numeric(10),
  "user_id" numeric(10)
)
;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO "gametopvideos"."video" VALUES (1, 'Zed Montage 71 - Best Plays 2018 by The LOLPlayVN Community ( League of Legends)', 'https://www.youtube.com/watch?v=rBsSTs9wLEw', 78158, 640, 40, 1, 1);
INSERT INTO "gametopvideos"."video" VALUES (2, 'YENİ META ERITEN 1300 AP MORGANA MID!! KESİN DENEYİN!! ZULÜM TOPRAĞI İSMİ CUK OTURUYOR!!', 'https://www.youtube.com/watch?v=38MoWbZtN-4', 368136, 1980, 126, 1, 1);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"gametopvideos"."video_sequence"', 101, false);

-- ----------------------------
-- Primary Key structure for table action
-- ----------------------------
ALTER TABLE "gametopvideos"."action" ADD CONSTRAINT "action_pk" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table actiontype
-- ----------------------------
ALTER TABLE "gametopvideos"."actiontype" ADD CONSTRAINT "actiontype_pk" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table category
-- ----------------------------
ALTER TABLE "gametopvideos"."category" ADD CONSTRAINT "category_pk" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table role
-- ----------------------------
ALTER TABLE "gametopvideos"."role" ADD CONSTRAINT "role_pk" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table user
-- ----------------------------
ALTER TABLE "gametopvideos"."user" ADD CONSTRAINT "user_pk" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table video
-- ----------------------------
ALTER TABLE "gametopvideos"."video" ADD CONSTRAINT "video_pk" PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Keys structure for table action
-- ----------------------------
ALTER TABLE "gametopvideos"."action" ADD CONSTRAINT "ACTION_actiontype_id_fkey" FOREIGN KEY ("actiontype_id") REFERENCES "gametopvideos"."actiontype" ("id") ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE "gametopvideos"."action" ADD CONSTRAINT "ACTION_user_id_fkey" FOREIGN KEY ("user_id") REFERENCES "gametopvideos"."user" ("id") ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE "gametopvideos"."action" ADD CONSTRAINT "ACTION_video_id_fkey" FOREIGN KEY ("video_id") REFERENCES "gametopvideos"."video" ("id") ON DELETE CASCADE ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Keys structure for table user
-- ----------------------------
ALTER TABLE "gametopvideos"."user" ADD CONSTRAINT "USER_role_id_fkey" FOREIGN KEY ("role_id") REFERENCES "gametopvideos"."role" ("id") ON DELETE CASCADE ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Keys structure for table video
-- ----------------------------
ALTER TABLE "gametopvideos"."video" ADD CONSTRAINT "VIDEO_category_id_fkey" FOREIGN KEY ("category_id") REFERENCES "gametopvideos"."category" ("id") ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE "gametopvideos"."video" ADD CONSTRAINT "VIDEO_user_id_fkey" FOREIGN KEY ("user_id") REFERENCES "gametopvideos"."user" ("id") ON DELETE CASCADE ON UPDATE CASCADE;
