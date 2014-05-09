create table t_user (
    username varchar(255) primary key,
    password varchar(255) not null
);

insert into t_user (username,password)
values ('endy', '123');

insert into t_user (username,password)
values ('dadang', '321');

create table t_role (
    username varchar(255) references t_user(username),
    rolename varchar(255) not null
);

insert into t_role (username, rolename)
values ('endy', 'ROLE_ADMIN');

insert into t_role (username, rolename)
values ('endy', 'ROLE_USER');


insert into t_role (username, rolename)
values ('dadang', 'ROLE_USER');

select username,password, true as enabled from t_user where username = 'endy';

select username,rolename as authority from t_role where username = 'endy';