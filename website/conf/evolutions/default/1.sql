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


create table movie_user (
  movie_movie_id                 bigint not null,
  user_user_id                   bigint not null,
  constraint pk_movie_user primary key (movie_movie_id, user_user_id))
;

create table user_movie (
  user_user_id                   bigint not null,
  movie_movie_id                 bigint not null,
  constraint pk_user_movie primary key (user_user_id, movie_movie_id))
;
create sequence movie_seq;

create sequence user_seq;




alter table movie_user add constraint fk_movie_user_movie_01 foreign key (movie_movie_id) references movie (movie_id) on delete restrict on update restrict;

alter table movie_user add constraint fk_movie_user_user_02 foreign key (user_user_id) references user (user_id) on delete restrict on update restrict;

alter table user_movie add constraint fk_user_movie_user_01 foreign key (user_user_id) references user (user_id) on delete restrict on update restrict;

alter table user_movie add constraint fk_user_movie_movie_02 foreign key (movie_movie_id) references movie (movie_id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists movie;

drop table if exists movie_user;

drop table if exists user;

drop table if exists user_movie;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists movie_seq;

drop sequence if exists user_seq;

