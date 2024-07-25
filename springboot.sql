--스프링부트 13장
--scott계정

DROP TABLE myuser;

CREATE TABLE myuser(
    id varchar2(20),
    name varchar2(10)
);

insert into myuser values ( 'test1', '홍길동1');
insert into myuser values ( 'test2', '홍길동2');
insert into myuser values ( 'test3', '홍길동3');


commit;

--14장

drop table simple_bbs;

create table simple_bbs (
    id number(4) primary key,
    writer varchar2(100),
    title varchar2(100),
    content varchar2(100)
);

drop sequence simple_bbs_seq;

create sequence simple_bbs_seq;

--22장 트랜잭션

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