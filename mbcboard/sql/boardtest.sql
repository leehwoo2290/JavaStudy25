create table member(
mno number(5) not null,
bwriter nvarchar2(10) not null, 
id nvarchar2(10) primary key,	--boardtable에 bwriter와 fk로 관계 설정함
pw nvarchar2(10) not null,
regidate date default sysdate not null, -- 입력 안해도 디폴트값으로 값들어감 
activate varchar(1) default 'Y' --회원 탈퇴시 false (bool이없음;)

)

update member set bwriter='더미이름', pw='12345' where id='park'

insert into member(mno, bwriter, id, pw)
values(board_seq.nextval, '이현우', 'kkw', '1234');
insert into member(mno, bwriter, id, pw)
values(board_seq.nextval, '홍경훈', 'hong', '1234');
insert into member(mno, bwriter, id, pw)
values(board_seq.nextval, '박채은', 'park', '1234');
insert into member(mno, bwriter, id, pw)
values(board_seq.nextval, '양지민', 'yang', '1234');


select* from member

delete from member

select id from member where id = 'kkw' and pw = '123'

select id from member where id = 'admin'

drop table member
--이미 만들어둔 시퀀스 객체 사용 (board_seq)
--------------------------------
delete from board
drop table board

drop sequence board_seq

create table board(
	nbo number(5) primary key, 
	btitle nvarchar2(30) not null, 
	bcontent nvarchar2(1000) not null,        
	bwriter nvarchar2(10) not null,
	bdate date not null           
) --board 테이블 생성

alter table board add constraint board_member_fk foreign key (bwriter) references member(id)
--board테이블은 member의 자식 테이블, mname과 id 관계설정
--board에 더미데이터 넣으면 부모 테이블에 id값이 없어서 값이 안들어감

create sequence board_seq increment by 1 start with 1 nocycle nocache

insert into board(nbo, btitle, bcontent, bwriter, bdate)
values(board_seq.nextval, '이1', '부서1', 'kkw', sysdate);
insert into board(nbo, btitle, bcontent, bwriter, bdate)
values(board_seq.nextval, '이름2', '부서2', 'lee', sysdate);
insert into board(nbo, btitle, bcontent, bwriter, bdate)
values(board_seq.nextval, '이름3', '부서3', 'park', sysdate);
insert into board(nbo, btitle, bcontent, bwriter, bdate)
values(board_seq.nextval, '이름4', '부서4', 'yang', sysdate);
insert into board(nbo, btitle, bcontent, bwriter, bdate)
values(board_seq.nextval, '이름5', '부서5', 'kkw', sysdate);
insert into board(nbo, btitle, bcontent, bwriter, bdate)
values(board_seq.nextval, '이름6', '부서6', 'kkw', sysdate);

select* from board;



--------------------------------
--조인 : 2개 테이블 연결해서 값 가져온다

select b.*, m.bwriter from member m inner join board b on m.id = b.bwriter where id='kkw'