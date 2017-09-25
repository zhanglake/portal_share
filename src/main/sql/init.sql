--删除表
drop table Z_PORTAL;
-- 创建表
create table z_portal(
  id int not null,
  result_date varchar(20) not null,
  result_now varchar(20) not null,
  result_open varchar(20) not null,
  result_up varchar(20) not null,
  result_down varchar(20) not null,
  primary key(id)
);

--创建自增ID，名称为：表名_字段名_SEQ
CREATE SEQUENCE portalid_seq
INCREMENT BY 1 -- 每次加几个
START WITH 1 -- 从1开始计数
NOMAXVALUE -- 不设置最大值
NOCYCLE -- 一直累加，不循环
CACHE 10;

-- 为Insert操作创建触发器，无需在SQL语句里写NEXTVAL，名称为表名_INS_TRG
CREATE OR REPLACE TRIGGER portal_insert_trg
  BEFORE INSERT ON z_portal for each row
   begin
     select portalid_seq.nextval into :new.id FROM DUAL;
   end;

--insert语句
insert into Z_PORTAL (RESULT_DATE, RESULT_NOW, RESULT_OPEN, RESULT_UP, RESULT_DOWN)
values ('2017-09-08 09:09:09', '10', '10', '10', '10');