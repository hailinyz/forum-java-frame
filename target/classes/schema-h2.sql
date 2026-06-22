-- H2 内存数据库建表脚本
-- 使用 MODE=MySQL 兼容模式，表名用反引号包裹以避开 H2 保留字

CREATE TABLE IF NOT EXISTS `user` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `username` VARCHAR(50) NOT NULL UNIQUE,
    `password` VARCHAR(100) NOT NULL,
    `email` VARCHAR(100) NOT NULL UNIQUE,
    `nickname` VARCHAR(50),
    `avatar` VARCHAR(255),
    `status` INT DEFAULT 1,
    `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP,
    `update_time` DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS `category` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    `description` VARCHAR(200),
    `sort` INT DEFAULT 0,
    `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS `article` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `user_id` BIGINT NOT NULL,
    `category_id` BIGINT,
    `title` VARCHAR(200) NOT NULL,
    `summary` VARCHAR(500),
    `content` TEXT,
    `view_count` INT DEFAULT 0,
    `like_count` INT DEFAULT 0,
    `comment_count` INT DEFAULT 0,
    `status` INT DEFAULT 1,
    `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP,
    `update_time` DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_article_user FOREIGN KEY (`user_id`) REFERENCES `user`(`id`),
    CONSTRAINT fk_article_category FOREIGN KEY (`category_id`) REFERENCES `category`(`id`)
);

CREATE INDEX IF NOT EXISTS idx_article_user ON `article`(`user_id`);
CREATE INDEX IF NOT EXISTS idx_article_category ON `article`(`category_id`);

CREATE TABLE IF NOT EXISTS `comment` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `article_id` BIGINT NOT NULL,
    `user_id` BIGINT NOT NULL,
    `parent_id` BIGINT DEFAULT 0,
    `content` VARCHAR(1000) NOT NULL,
    `status` INT DEFAULT 1,
    `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_comment_article FOREIGN KEY (`article_id`) REFERENCES `article`(`id`),
    CONSTRAINT fk_comment_user FOREIGN KEY (`user_id`) REFERENCES `user`(`id`)
);

CREATE INDEX IF NOT EXISTS idx_comment_article ON `comment`(`article_id`);
CREATE INDEX IF NOT EXISTS idx_comment_user ON `comment`(`user_id`);
