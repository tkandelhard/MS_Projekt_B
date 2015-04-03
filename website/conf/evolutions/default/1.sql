# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table movie (
  movie_id                  bigint not null,
  title                     varchar(255),
  summary                   varchar(255),
  genre                     varchar(255),
  rating_overall            varchar(255),
  constraint pk_movie primary key (movie_id))
;

create table user (
  user_id                   bigint not null,
  name                      varchar(255),
  email                     varchar(255),
  constraint pk_user primary key (user_id))
;

create sequence movie_seq;

create sequence user_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists movie;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists movie_seq;

drop sequence if exists user_seq;

