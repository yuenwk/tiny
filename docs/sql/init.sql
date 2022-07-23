create table sm_admin
(
    id          bigserial primary key,
    username    varchar(64)  DEFAULT NULL,
    password    varchar(64)  DEFAULT NULL,
    icon        varchar(500) DEFAULT NULL,
    email       varchar(100) DEFAULT NULL,
    nick_name   varchar(200) DEFAULT NULL,
    note        varchar(500) DEFAULT NULL,
    status      smallint     DEFAULT 1,
    login_time  timestamp    DEFAULT NULL,
    create_time timestamp    default current_timestamp NOT NULL
);

comment on column sm_admin.status is '帐号启用状态：0->禁用；1->启用';

CREATE TABLE sm_role
(
    id          bigserial primary key,
    parent_id   bigint       DEFAULT NULL,
    name        varchar(100) DEFAULT NULL,
    description varchar(500) DEFAULT NULL,
    status      smallint     DEFAULT 1,
    sort        int          DEFAULT 0,
    create_time timestamp    default current_timestamp NOT NULL
);

CREATE TABLE sm_admin_role_relation
(
    id       bigserial primary key,
    admin_id bigint DEFAULT NULL,
    role_id  bigint DEFAULT NULL
);

CREATE TABLE sm_menu
(
    id          bigserial primary key,
    parent_id   bigint       DEFAULT NULL,
    name        varchar(100) DEFAULT NULL,
    path        varchar(500) DEFAULT NULL,
    level       smallint     DEFAULT NULL,
    sort        smallint     DEFAULT NULL,
    icon        varchar(200) DEFAULT NULL,
    hidden      smallint     DEFAULT NULL,
    create_time timestamp    default current_timestamp NOT NULL
);


CREATE TABLE sm_role_menu_relation
(
    id      bigserial primary key,
    role_id bigint DEFAULT NULL,
    menu_id bigint DEFAULT NULL
);


CREATE TABLE sm_resource_category
(
    id          bigserial primary key,
    name        varchar(200) DEFAULT NULL,
    sort        smallint     DEFAULT NULL,
    create_time timestamp    default current_timestamp NOT NULL
);

CREATE TABLE sm_resource
(
    id          bigserial primary key,
    name        varchar(200) DEFAULT NULL,
    url         varchar(500) DEFAULT NULL,
    description varchar(500) DEFAULT NULL,
    category_id bigint       DEFAULT NULL,
    create_time timestamp    default current_timestamp NOT NULL
);


CREATE TABLE sm_role_resource_relation
(
    id          bigserial primary key,
    role_id     bigint DEFAULT NULL,
    resource_id bigint DEFAULT NULL
);