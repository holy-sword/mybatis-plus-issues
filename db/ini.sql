-- 测试用表
DROP TABLE IF EXISTS sys_xxx;
CREATE TABLE sys_xxx
(
    id          varchar primary key,
    a_a         varchar,
    b_b_b       varchar,
    c           varchar,
    d           json,
    e           json,
    create_time timestamp not null,
    update_time timestamp not null,
    is_frozen   int2 default 0
);