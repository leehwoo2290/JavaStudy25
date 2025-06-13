create table member(
mno number(5) not null,
bwriter nvarchar2(10) not null, 
id nvarchar2(10) primary key,	--boardtable�� bwriter�� fk�� ���� ������
pw nvarchar2(10) not null,
regidate date default sysdate not null, -- �Է� ���ص� ����Ʈ������ ���� 
activate varchar(1) default 'Y' --ȸ�� Ż��� false (bool�̾���;)

)

update member set bwriter='�����̸�', pw='12345' where id='park'

insert into member(mno, bwriter, id, pw)
values(board_seq.nextval, '������', 'kkw', '1234');
insert into member(mno, bwriter, id, pw)
values(board_seq.nextval, 'ȫ����', 'hong', '1234');
insert into member(mno, bwriter, id, pw)
values(board_seq.nextval, '��ä��', 'park', '1234');
insert into member(mno, bwriter, id, pw)
values(board_seq.nextval, '������', 'yang', '1234');


select* from member

delete from member

select id from member where id = 'kkw' and pw = '123'

select id from member where id = 'admin'

drop table member
--�̹� ������ ������ ��ü ��� (board_seq)
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
) --board ���̺� ����

alter table board add constraint board_member_fk foreign key (bwriter) references member(id)
--board���̺��� member�� �ڽ� ���̺�, mname�� id ���輳��
--board�� ���̵����� ������ �θ� ���̺� id���� ��� ���� �ȵ�

create sequence board_seq increment by 1 start with 1 nocycle nocache

insert into board(nbo, btitle, bcontent, bwriter, bdate)
values(board_seq.nextval, '��1', '�μ�1', 'kkw', sysdate);
insert into board(nbo, btitle, bcontent, bwriter, bdate)
values(board_seq.nextval, '�̸�2', '�μ�2', 'lee', sysdate);
insert into board(nbo, btitle, bcontent, bwriter, bdate)
values(board_seq.nextval, '�̸�3', '�μ�3', 'park', sysdate);
insert into board(nbo, btitle, bcontent, bwriter, bdate)
values(board_seq.nextval, '�̸�4', '�μ�4', 'yang', sysdate);
insert into board(nbo, btitle, bcontent, bwriter, bdate)
values(board_seq.nextval, '�̸�5', '�μ�5', 'kkw', sysdate);
insert into board(nbo, btitle, bcontent, bwriter, bdate)
values(board_seq.nextval, '�̸�6', '�μ�6', 'kkw', sysdate);

select* from board;



--------------------------------
--���� : 2�� ���̺� �����ؼ� �� �����´�

select b.*, m.bwriter from member m inner join board b on m.id = b.bwriter where id='kkw'