--½ºÇÁ¸µºÎÆ® 13Àå
--scott°èÁ¤

DROP TABLE myuser;

CREATE TABLE myuser(
    id varchar2(20),
    name varchar2(10)
);

insert into myuser values ( 'test1', 'È«±æµ¿1');
insert into myuser values ( 'test2', 'È«±æµ¿2');
insert into myuser values ( 'test3', 'È«±æµ¿3');


commit;

--14Àå

drop table simple_bbs;

create table simple_bbs (
    id number(4) primary key,
    writer varchar2(100),
    title varchar2(100),
    content varchar2(100)
);

drop sequence simple_bbs_seq;

create sequence simple_bbs_seq;

--22Àå Æ®·£Àè¼Ç

create table Transaction1 (
    consumerId varchar2(10),
    amount number
);

create table Transaction2 (
    consumerId varchar2(10),
    amount number
);

select * from Transaction1;

select * from Transaction2;

select * from Transaction3;

create table Transaction3 (
    consumerId varchar2(10),
    amount number
);

select * from Transaction3;

delete from transaction1;
delete from transaction2;
delete from transaction3;

commit;


--30Àå

create table user_list (
    name varchar2(20) primary key,
    password varchar2(100),
    authority varchar(20),
    enabled number(1)
);

delete from user_list;

insert into user_list values ('user', '$2a$10$.BmZOKE20d43wvYmP1u31e8u8JJiOD8g9LnU3yEvUdwo1jSj0F.Xa', 'ROLE_USER', 1);
insert into user_list values ('admin', '$2a$10$.BmZOKE20d43wvYmP1u31e8u8JJiOD8g9LnU3yEvUdwo1jSj0F.Xa', 'ROLE_ADMIN', 1);
commit;
select * from user_list;
