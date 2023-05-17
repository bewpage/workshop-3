CREATE DATABASE IF NOT EXISTS workshop3
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE workshop3;

--
-- Table structure for table `users`
--

CREATE TABLE `users`
(
    `id`       int                                     NOT NULL AUTO_INCREMENT,
    `email`    varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
    `username` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
    `password` varchar(60) COLLATE utf8mb4_unicode_ci  NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `email` (`email`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 8
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;