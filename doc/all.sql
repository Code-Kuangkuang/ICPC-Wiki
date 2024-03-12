drop table if exists `test`;
create table `test` (
    `id` bigint not null comment 'id',
    `name` varchar(50) comment '名称',
    primary key (`id`)
) engine=innodb default charset=utf8mb4 comment='测试';


# Demo表
drop table if exists `demo`;
create table `demo` (
                        `id` bigint not null COMMENT 'id',
                        `name` varchar(50) COMMENT '名称',
                        `password` varchar(50) COMMENT '名称',
                        primary key (`id`)
) engine=InnoDB default charset=utf8mb4 comment= '测试';
insert into `demo` (id, name) values (1,'测试');

# 电子书表
drop table if exists `ebook`;
create table `ebook` (
                         `id` bigint not null comment 'id',
                         `name` varchar(50) comment '名称',
                         `category1_id` bigint comment '分类1',
                         `category2_id` bigint comment '分类2',
                         `description` varchar(200) comment '描述',
                         `cover` varchar(200) comment '封面',
                         `doc_count` int comment '文档数',
                         `view_count` int comment '阅读数',
                         `vote_count` int comment '点赞数',
                         primary key (`id`)
) engine=InnoDB default charset=utf8mb4 comment= '电子书';

insert into`ebook`(id, name, description) values(1,'DFS（搜索）','深度优先搜索');
insert into`ebook`(id, name, description) values(2, 'BFS（搜索）', '广度优先搜索');
insert into`ebook`(id, name, description) values(3, '栈', '基本数据结构——栈');
insert into`ebook`(id, name, description) values(4, '队列', '基本数据结构——队列');
insert into`ebook`(id, name, description) values(5,'链表','基本数据结构——链表');
insert into`ebook`(id, name, description) values(6,'字符串匹配','字符串基础');
