create table job(
name varchar(64) primary key,
create_time datetime default null,
update_time datetime default current_timestamp
);

create table department(
name varchar(64) primary key,
create_time datetime default null,
update_time datetime default current_timestamp
);