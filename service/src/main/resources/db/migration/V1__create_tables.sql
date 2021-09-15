CREATE TABLE `room` (
    `id` BIGINT             NOT NULL AUTO_INCREMENT,
    `nome`      VARCHAR(45) NOT NULL,
    `seats`     VARCHAR(45) NOT NULL,
    `active`    TINYINT     NOT NULL,
    PRIMARY KEY (`id`)
);
