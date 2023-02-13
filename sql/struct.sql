DROP TABLE IF EXISTS `accountinfo`;
CREATE TABLE `accountinfo`  (
                                `id` int NOT NULL AUTO_INCREMENT,
                                `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                                `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                                `state` int NULL DEFAULT NULL,
                                `level` int NULL DEFAULT NULL,
                                `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                                `realname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                                PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for announcment
-- ----------------------------
DROP TABLE IF EXISTS `announcment`;
CREATE TABLE `announcment`  (
                                `id` int NOT NULL,
                                `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                                PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for labname
-- ----------------------------
DROP TABLE IF EXISTS `labname`;
CREATE TABLE `labname`  (
                            `id` int NOT NULL AUTO_INCREMENT,
                            `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                            `state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                            PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for labrecord
-- ----------------------------
DROP TABLE IF EXISTS `labrecord`;
CREATE TABLE `labrecord`  (
                              `id` int NOT NULL AUTO_INCREMENT,
                              `lid` int NULL DEFAULT NULL,
                              `timestate` datetime NULL DEFAULT NULL,
                              `accountid` int NULL DEFAULT NULL,
                              `date` datetime NULL DEFAULT NULL,
                              `state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                              PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for labstate
-- ----------------------------
DROP TABLE IF EXISTS `labstate`;
CREATE TABLE `labstate`  (
                             `id` int NOT NULL AUTO_INCREMENT,
                             `lid` int NULL DEFAULT NULL,
                             `timestate` datetime NULL DEFAULT NULL,
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

