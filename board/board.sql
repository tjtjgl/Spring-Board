create database studyboard;
use studyboard;

create table board (
    id bigint not null auto_increment comment 'PK',
    title varchar(100) not null comment '제목',
    content text not null comment '내용',
    writer varchar(20) not null comment '작성자',
    hits int not null comment '조회 수',
    delete_yn enum('Y', 'N') not null comment '삭제 여부',
    created_date datetime not null comment '생성일',
    modified_date datetime comment '수정일',
    primary key (id)
) comment '게시판';

delete from board;
select * from board;
select count(*) from board;

insert into board(title,content,writer,hits,created_date,delete_yn) values ('안녕1','하세요1','테스트1',0,now(),'N');
insert into board(title,content,writer,hits,created_date,delete_yn) values ('안녕2','하세요2','테스트2',0,now(),'N');
insert into board(title,content,writer,hits,created_date,delete_yn) values ('안녕3','하세요3','테스트3',0,now(),'N');
insert into board(title,content,writer,hits,created_date,delete_yn) values ('안녕4','하세요4','테스트4',0,now(),'N');
insert into board(title,content,writer,hits,created_date,delete_yn) values ('안녕5','하세요5','테스트5',0,now(),'N');

create table comment (
      id bigint not null auto_increment comment '댓글 번호 (PK)'
    , post_id bigint not null comment '게시글 번호 (FK)'
    , content varchar(1000) not null comment '내용'
    , writer varchar(20) not null comment '작성자'
    , delete_yn tinyint(1) not null comment '삭제 여부'
    , created_date datetime not null default CURRENT_TIMESTAMP comment '생성일시'
    , modified_date datetime comment '최종 수정일시'
    , primary key(id)
) comment '댓글';

alter table comment add constraint foreign key(post_id) references board(id);


select * from comment;
select count(*) from board;

show full columns from comment; -- 테이블 구조 확인 1 (코멘트 포함)
desc tb_comment; -- 테이블 구조 확인 2

select * from information_schema.table_constraints where table_name = 'comment';









