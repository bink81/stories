drop table story if exists;

create table story (id bigint generated by default as identity (start with 1), name varchar(255), 
description varchar(255),  primary key (id))
