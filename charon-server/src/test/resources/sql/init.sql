create table test
(
    id          bigint auto_increment,
    name        varchar(255) default ''                not null,
    create_time datetime     default CURRENT_TIMESTAMP not null,
    constraint id
        primary key (id)
);

insert into test(name) values('foo')