### initial schema.
CREATE TABLE `test` (
                        `id` BIGINT UNSIGNED AUTO_INCREMENT,
                        `title` varchar(200) not null default '',
                        `create_time` datetime not null default CURRENT_TIMESTAMP,
                        PRIMARY KEY (`id`)
);

### initial data
insert into test(`title`) values ('test');