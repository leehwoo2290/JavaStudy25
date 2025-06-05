desc emp;  --emp 테이블 구조
select*from emp; --emp 테이블 내용

desc dept; --dept 테이블 구조
select*from dept; --dept테이블 내용


desc bonus; --bonus 테이블 구조
select*from bonus; --bonus 테이블 내용

desc salgrade; --salgrade 테이블 구조
select*from salgrade; --salgrade 테이블 내용

select empno,ename,deptno from emp; 
--emp 테이블 내용 중 empno,ename,deptno만 선택 조회

select distinct deptno from emp;
  --distinct(중복행 1개를 제외한 나머지 제거 위 예시는 deptno의 중복행 해당)
  
select distinct job,deptno from emp;
 --emp테이블의 empjob,deptno중복행 제거, managere데이터는 부서번호가 달라 세 행 모두 출력
 
select all job,deptno from emp; 
--ALL(DISTINCT와 반대로 중복값도 모두 출력)

select ename, sal, sal*12+comm,comm from emp;
--연산식 활용 emp테이블의  sal(급여)에 *12+comm(추가수당) 계산 후 출력

select ename,sal, sal*12+comm as annsal,comm from emp;
--별칭 지정 방법 4가지 (실무는 AS 별칭) 선호
--select 출력열 연산식  별칭  출력열 from 테이블
--select 출력열 연산식  "별칭"  출력열 from 테이블
--select 출력열 연산식   AS별칭  출력열 from 테이블 *****
--select 출력열 연산식  AS"별칭"  출력열 from 테이블

select*from emp order by sal; --ORDER BY :정렬,기본 오름차순:asc(위 예시 sal 열 정렬)

select*from emp order by sal desc; --DESC:내림차순

select*from emp order by deptno asc,sal desc;
--deptno(부서번호)오름차순 sal(급여)내림차순
--오름차순과 내림차순을 같이 사용할 경우엔 먼저 명시된 열 값을 먼저 처리 ( 위 예시 deptno이 먼저 명시되어 오름차순 처리 후 sal처리)

---실습 예제풀이---

--예제1. emp테이블의 job열 데이터 중복제거 후 출력
select distinct job from emp ;

--예제2.emp테이블 모든 열 출력 |별칭 부여 |부서번호 기준 내림차순으로 하되 부서번호가 같다면 사원 이름을 기준으로 오름차순
select empno AS EMPLOYEE_NO , ename as EMPLOYEE_NAME, mgr as MANAGER, sal as SALERY, comm as COMMISSION,deptno as DEPARTMENT_NO from emp order by deptno desc, ename asc; 


select*from emp where deptno=30;--where:특정 열의 특정값 출력 (deptno열의 행이 30인 열 출력)

select*from emp where deptno=30 and job='SALESMAN'; --and(조건2개 부합) 연산자 (deptno이 30이고 job 'SALESMAN'인 조건)

select*from emp where deptno=30 or job='CLERK'; --or(조건1개 부합) 연산자(deptno이 30이거나 job이 'clerk'인 조건)

select*from emp where sal*12=36000; --where 조건식 사용(sal*12=36000인 열 출력)

select*from emp where sal>=3000;

select*from emp where ename >='F'; --ename 열 값의 첫 문자가 대문자 F와 같거나 F보다 뒤에 있는 글자 출력

select*from emp where ename<='FORZ'; --ename 열 값이 FORZ를 포함한 문자열이 알파벳 순으로 앞에 위치할 경우 출력

select*from emp where sal!=3000; --sal이 3000이 아닐경우 true 3000인 경우 false

select*from emp where sal<>3000; --sal이 3000이 아닐경우 true 3000인 경우 false

select*from emp where sal^=3000; --sal이 3000이 아닐경우 true 3000인 경우 false

select*from emp where not sal=3000; --논리부정 연산 (true값을 false로 변환)

select*from emp where job='MANAGER' or job = 'SALESMAN' or job = 'CLERK';
select*from emp where job in('MANAGER','SALESMAN','CLERK');
--IN연산자(OR 연산자와 유사,'MANAGER','SALESMAN','CLERK'중 하나라면 모두 조회)

select*from emp where job!='MANAGER' and job<>'SALESMAN' and job ^= 'CLERK';
select*from emp where job not in('MANAGER','SALESMAN','CLERK');
--AND 연산자를 여러번 사용할 경우 IN연산자를 사용하되 IN은 OR과 흡사하기에 IN에 논리부정 연산자를 사용)

select*from emp where sal>=2000 and sal<=3000; --sal 2000이상 3000이하 값 
select*from emp where sal between 2000 and 3000;--위 예시를 between A and B로 대체 (최소값, 최대값 순서로 입력)

select*from emp where sal not between 2000 and 3000; --논리부정 연산자로 2000에서 3000사이 값을 제외한 나머지 출력

select*from emp where ename like 'S%';--like 연산자로 현 예시는 ename열에 해당하는 문자열의 시작이 S인 값을 출력

select*from emp where ename like '_L%'; --ename의 두번째 글자가 L인 사원만 출력

select*from emp where ename like '%AM%'; --ename열에 AM이라는 단어를  포함하면 출력
select*from emp where ename not like '%AM%'; --enam열에 AM이라는 단어를 미포함하면 출력

select*from SOME_TABLE where SOME_COLUMN like'A\_A%' escape'\'; --A\_A% escape '\'는 \바로 뒤 _기호를 문자열로 취급하여 출력

select*from emp where comm is null; --해당 열 값이 null인 경우 출력(위 예제 comm열의 값이 null인 데이터)
select*from emp where MGR is not null; --MGR 열이 null이 아닌 경우 출력

select*from emp where sal>null and comm is null; --sal이 null이 아니면서 comm이 null인경우
select*from emp where sal>null or comm is null; --sal이 null이 아니거나 comm이 null인경우

select empno,ename,sal,deptno from emp where deptno =10 UNION select empno,ename,sal,deptno from emp where deptno = 20;
--집합연산자(UNION):두 개 이상의 select문의 결과 값을 연결할 떄 사용 (위 예제 deptno=10과 demptno=20 값 출력

select empno, ename, sal, deptno from emp where deptno = 10 union select empno, ename, sal from emp where deptno=20;
--error 질의 블록은 부정확한 수의 결과 열을 가지고 있음. (출력 열 개수가 다름)

select empno, ename, sal, deptno from emp where deptno=10 union select ename, empno, deptno, sal from emp where deptno=20;
--error 대응하는 식과 같은 데이터 유형이어야 함 (출력 열의 자료형이 다름)

select empno, ename, sal, deptno from emp where deptno=10 union select sal, job, deptno, sal from emp where deptno=20;
--열이 다르지만 양쪽 다 숫자 데이터이기 때문에 지장없이 연결 됨(출력 열 개수와 자료형이 같음), 최종출력 시 열 이름은 먼저 작성한 select문의 열 이름으로 표기

--집합연산자 종류
--UNION:연결된 select문의 결과 값을 합집합으로 묵음, 결과갑의 중복은 제거
--UNION ALL:연결된 select문의 결과값을 합집합으로 묶음, 중복된 결과값도 모두 출력
--MINUS:먼저 작성한 select문의 결과 값에서 다음 select문의 결과값을 차집합 처리, 먼저 작성한 select문의 결과 값 중 다음 select문에 존재하지 않는 데이터만 출력
--INTERSECT:먼저 작성한 select문과 다음select문의 결과 값이 같은 데이터만 출력, 교집합과 같은 의미

select empno, ename, sal, deptno from emp where deptno=10 union select empno, ename, sal, deptno from emp where deptno =10; --데이터 중복 제거

select empno, ename, sal, deptno from emp where deptno=10 union all select empno, ename, sal, deptno from emp where deptno =10;--데이터 중복 관계 없이 출력

select empno, ename, sal, deptno from emp minus select empno, ename, sal, deptno from emp where deptno=10;--두 select문의 결과 값이 같은 데이터는 제외하고 첫 번쨰 select문의 결과 값 출력

select empno, ename, sal, deptno from emp intersect select empno, ename, sal, deptno from emp where deptno=10; --교집합 의미 두 select문의 결과 값이 같은 데이터 출력


---실습예제 풀이---

--1.emp 테이블을 사용하여 사원이름이 s로 끝나는 사원데이터 출력--
select*from emp where ename like '%S';

--2.emp테이블 사용 30번 부서에 근무중인 사원 직책이 SALESMAN인 사원의 번호, 이름 , 직책, 급여 , 부서번호를 출력
select empno, ename, job,sal, deptno from emp where job ='SALESMAN' and deptno=30;

--3.emp테이블을 사용하여 20,30번 부서 근무중인 사원 급여가 2000초과인 사원을 두 가지 방식으로 사원번호,이름,급여,부서번호 출력
select empno, ename ,job ,sal ,deptno from emp where deptno between 20 and 30 and sal>2000;--집합연산자 미사용
select empno, ename ,job ,sal ,deptno from emp where deptno between 20 and 30 intersect select empno,ename,job,sal,deptno from emp where sal>2000;--집합연산자 사용

--4.NOT BETWEEN 연산자 사용하지 않고 급여 열 값이 2000이상 3000이하 범위 외의 값을 가진 데이터 출력
select*from emp where not sal >=2000 and sal<=3000;

--5.사원 이름에 E가 포함되어 있는 30번 부서 사원중 급여가 1000~2000사이가 아닌 사원 이름, 번호, 급여, 부서 출력
select ename, empno, sal, deptno from emp where ename like '%E%' and deptno=30 minus select ename ,empno,sal,deptno from emp where sal>=1000 and sal<=2000;

--6. 추가수당이 존재하지 않고 상급자가 있으며 직책이 MANAGER,CLERK인 사원중, 사원이름의 두번쨰 글자가L이 아닌 사원의 정보 출력
select*from emp where job = 'MANAGER' or job = 'CLERK' and mgr is not null intersect select*from emp where ename not like'_L%';

select ename, upper(ename),lower(ename),initcap(ename)from emp;
--UPPER (대문자) lower(소문자) Initcap(첫글자 대문자, 나머지 소문자)

select*from emp where upper(ename)=upper('scott');
select*from emp where upper(ename) like upper('%scott%');

select ename, length(ename) from emp; --length 문자열 길이

select ename, length(ename) from emp where length(ename)>=5; --사원 이름 길이가 5이상인 행 출력

select length('한글'),lengthb('한글')from dual; --length는 문자열 길이를 반환, lengthb는 문자열 바이트 수 반환

select job, substr(job,1,2),substr(job,3,2),substr(job,5)from emp; --substr(문자열 일부 추출)

select job, substr(job,-length(job)),substr(job,-length(job),2),substr(job,-3)from emp;--추출 하려는 문자열의 문자가 음수 값일 경우 뒤에서부터

select instr ('hello, oracle','l') as instar_1, instr ('hello, oracle','l',5)as instr_2,instr ('hello, oracle','l',2,2)as instr_3 from dual;  
-- instr 구조: instr('문자열','찾는 문자','시작위치','n번째 문자')

select*from emp where instr(ename,'S')>0;

select*from emp where ename like'%S%';

select '010-1234-5678' as REPLACE_BEFOR, replace('010-1234-5678','-',' ') as replace_1, replace('010-1234-5678','-') as replace_2 from dual;
--replace : 특정 문자를 다른 문자로 바꾸는 함수

select 'Oraacle', lpad('Oracle',10,'#') as lpad_1, rpad('Oracle',10,'*') as rapd_2,lpad('Oriacle',10)as LPAD_2,rpad('Oracle',10)as rapd_2 from dual;
--LPAD (왼쪽부터 특정 문자로 채움) RPAD(오른쪽부터 특정 문자로 채움)

select RPAD('971225-',14,'*') as RPAD_JMNO, RPAD('010-1234-',13,'*') as RPAD_PHONE from dual;
 --14자리 문자열 중 '971225-' 를 제외한 공백을 *로 오른쪽 부터 채움, 
 
select concat(empno, ename), concat(empno, concat(':',ename))from emp where ename = 'SCOTT';
--concat 두 문자열을 합침 / ||연산자는 concat과 유사

select'['||trim('__Oracle__')||']' as TRIM, '['||trim(LEADING FROM '__Oracle__')||']' as TRIM_LEADING, '['||TRIM(TRAILING FROM'__Oracle__')||']' as TRIM_TRAILING, '['||TRIM(BOTH FROM '__Oracle__')||']' as TRIM_BOTH from dual;
--TRIM 특정 문자 제거

select'['||TRIM('_'from'_ _Oracle_ _')||']' as TRIM, '['|| trim(leading'_'from '_ _Oracle_ _')||']' as TRIM_LEADING, '['||trim(trailing '_'from'_ _Oracle_ _')||']' as TRIM_TRAILING, '['||trim(both'_'from '_ _Oracle_ _')||']'as TRIM_BOTH from dual;

select'['||trim(' _Oracle_ ')||']' as TRIM, '['||ltrim(' _Oracle_ ')||']' as LTRIM, '['||ltrim('<_Oracle_>')||']'as LTRIM_2, '['||RTRIM(' _Oracle_ ')||']' as RTRIM, '['||RTRIM('<_Oracle_>','>_')||']' as RTIRM_2 from dual;

select round(1234.5678) as ROUND, ROUND(1234.5678,0) as ROUND0, round(1234.5678,1) as ROUND1, round(1234.5678,2) as ROUND2, round(1234.5678,-1) as ROUND_MINUS1, round(1234.5678,-2) as ROUND_MINUS2 from dual;
--round 반올림 함수 (정수 n번째 자리 반올림 ,음수 n번째 소수자리 반올림)

select trunc(1234.5678) as TRUNC, trunc(1234.5678,0) as ROUND0, trunc(1234.5678,1) as TRUNC1, trunc(1234.5678,2) as TRUNC2, trunc(1234.5678,-1) as TRUNC_MINUS1, trunc(1234.5678,-2) as TRUNC_MINUS2 from dual;
--trunc 버림 함수

select ceil(3.14),floor(3.14),ceil(-3.14),floor(-3.14) from dual;
--ceil:지정한 숫자와 가까운 큰 수 floor:지정한 숫자와 가까운 작은 수

select mod(15,6),mod(10,2),mod(11,2) from dual;
--mod :나머지 구하는 함수

select sysdate as NOW, sysdate-1 as YESTERDAY, sysdate+1 as TOMORROW from dual;
--SYSDATE 날짜 출력 함수

select stsdate, add_months(sysdate,3) from dual;
--ADD_MONTHS n개월 후 출력 (예제 3개월 후 출력)

select empno, ename, hiredate, add_months(hiredate,120) as WORK10YEAR from emp;
--입사 10주년 사원 출력

select empno, ename, hiredate, sysdate, months_between(hiredate, sysdate)as MONTH1, months_between(sysdate,hiredate)as MONTHS2, trunc(months_between(sysdate,hiredate))as MONTHS3 from emp;
--HIREDATE와 SYSDATE사이의 개월 수를 MONTHS_BETWEEN 함수로 출력

SELECT SYSDATE, NEXT_DAY(SYSDATE,'월요일'),LAST_DAY(SYSDATE) FROM DUAL;
--NEXT_DAY 돌아오는 요일에 해당하는 날짜, LAST_DAY 어제


SELECT SYSDATE, ROUND(SYSDATE,'CC') AS FORMAT_CC, ROUND(SYSDATE, 'YYYY') AS FORMAT_YYYY,ROUND(SYSDATE,'Q') AS FORMAT_Q,ROUND(SYSDATE,'DDD') AS FORMAT_DDD, ROUND(SYSDATE, 'HH')AS FORMAT_HH FROM DUAL;

SELECT SYSDATE, TRUNC(SYSDATE,'CC') AS FORMAT_CC, TRUNC(SYSDATE, 'YYYY') AS FORMAT_YYYY,TRUNC(SYSDATE,'Q') AS FORMAT_Q,TRUNC(SYSDATE,'DDD') AS FORMAT_DDD, TRUNC(SYSDATE, 'HH')AS FORMAT_HH FROM DUAL;


SELECT EMPNO, ENAME, EMPNO+'500' FROM EMP WHERE ENAME = 'SCOTT';

SELECT 'ABCD'+EMPNO,EMPNO FROM EMP WHERE ENAME = 'SCOTT';
--숫자형 자료형에 문자열 500은 숫자로 형변환되어 가능하나, 숫자형 자료형인 EMPNO에 문자형'ABCD'는 자동 형변환이 안됨

SELECT TO_CHAR(SYSDATE,'YYYY/MM/DD HH24:MI:SS')AS 현재날짜시간 FROM DUAL;
--현재 날짜 및 시간 형식 지정

SELECT SYSDATE, TO_CHAR(SYSDATE, 'MM') AS MM, TO_CHAR(SYSDATE,'MON') AS MON, TO_CHAR(SYSDATE, 'MONTH') AS MONTH, TO_CHAR(SYSDATE,'DD') AS DD, TO_CHAR(SYSDATE,'DY') AS DY, TO_CHAR(SYSDATE,'DAY') AS DAY FROM DUAL;
--현재 날짜에 해당하는 월 일 요일 형식 지정 출력

SELECT SYSDATE, TO_CHAR(SYSDATE,'MM') AS MM, TO_CHAR(SYSDATE,'MON','NLS_DATE_LANGUAGE = KOREAN') AS MON_KOR, TO_CHAR(SYSDATE, 'MON', 'NLS_DATE_LANGUAGE=JAPANESE')AS MON_JPN,TO_CHAR(SYSDATE,'MON','NLS_DATE_LANGUAGE=ENGLISH')AS MON_ENG,TO_CHAR(SYSDATE, 'MONTH','NLS_DATE_LANGUAGE=KOREAN')AS MONTH_KOR,TO_CHAR(SYSDATE,'MONTH','NLS_DATE_LANGUAGE=JAPANESE')AS MONTH_JPN, TO_CHAR(SYSDATE, 'MONTH','NLS_DATE_LANGUAGE=ENGLISH')AS MONTH_ENG FROM DUAL;
--NLS_DATE_LANGUAGE = KOR 한국 언어로 날짜 표기

SELECT SYSDATE, TO_CHAR(SYSDATE, 'MM')AS MM, TO_CHAR(SYSDATE, 'DD') AS DD, TO_CHAR(SYSDATE,'DY','NLS_DATE_LANGUAGE=KOREAN') AS DY_KOR,TO_CHAR(SYSDATE,'DY','NLS_DATE_LANGUAGE=JAPANESE') AS DY_JPN, TO_CHAR(SYSDATE, 'DY','NLS_DATE_LANGUAGE=ENGLISH') AS DY_ENG, TO_CHAR(SYSDATE,'DAY','NLS_DATE_LANGUAGE=KOREAN') AS DAY_KOR,TO_CHAR(SYSDATE,'DAY','NLS_DATE_LANGUAGE=JAPANESE')AS DAY_JPN,TO_CHAR(SYSDATE,'DAY','NLS_DATE_LANGUAGE=ENGLISH')AS DAY_ENG FROM DUAL;
--각 언어별 날짜에 해당하는 요일 지정 출력

SELECT SYSDATE, TO_CHAR(SYSDATE,'HH24:MI:SS') AS HH24MISS,TO_CHAR(SYSDATE, 'HH12:MI:SS AM') AS HHMISS_AM,TO_CHAR(SYSDATE, 'HH:MI:SS P.M.') AS HHMISS_PM FROM DUAL;
--현재 시각 형식 지정 출력

SELECT SAL, TO_CHAR(SAL, '$999,999') AS SAL_$, TO_CHAR (SAL, 'L999,999')AS SAL_L, TO_CHAR(SAL, '999,999.00') AS SAL_1, TO_CHAR(SAL,'000,999,999.00')AS SAL_2,TO_CHAR(SAL,'000999999.99')AS SAL_3,TO_CHAR(SAL,'999,999,00')AS SAL_4 FROM EMP;
--숫자 데이터 형식 지정 출력

SELECT TO_NUMBER('1,300','999,999') -  TO_NUMBER('1,500','999,999') FROM DUAL;
--문자데이터를 숫자로 변환

SELECT TO_DATE('2018-07-14', 'YYYY-MM-DD')AS TODATE1,TO_DATE('20180714','YYYY-MM-DD')AS TODATE2 FROM DUAL;

SELECT*FROM EMP WHERE HIREDATE>TO_DATE('1981/06/01','YYYY/MM/DD');
--1981/06/01 이후 입사한 사원 출력

SELECT TO_DATE('49/12/10','YY/MM/DD') ASYY_YEAR_49,TO_DATE('49/12/10','RR/MM/DD') AS RR_YEAR_49, TO_DATE('50/12/10','YY/MM/DD')AS YY_YEAR_50,TO_DATE('50/12/10','RR/MM/DD')AS RR_YEAR_50, TO_DATE('51/12/10','YY/MM/DD')AS YY_YEAR_51, TO_DATE('51/12/10','RR/MM/DD') AS RR_YEAR_51 FROM DUAL;
--날짜 형식 지정 출력


SELECT EMPNO, ENAME, SAL, COMM, SAL+COMM, NVL(COMM,0), SAL+NVL(COMM,0) FROM EMP;
--NVL:첫 번째 입력데이터가 NULL이 아니면 데이터를 그대로 반환, NULL이면 두 번쨰 입력 데이터에 지정 값 반환

SELECT EMPNO, ENAME, COMM, NVL2(COMM,'O','X'),NVL2(COMM,SAL*12+COMM, SAL*12) AS ANNSAL FROM EMP;
--NVL2:NVL과 유사하나 NULL이 아닌 경우의 반환 데이터까지 지정 가능

SELECT EMPNO, ENAME, JOB, SAL, DECODE(JOB,'MANAGER',SAL*1.1,'SALESMAN',SAL*1.05,'ANALYST',SAL,SAL*1.03) AS UPSAL FROM EMP;
--DECODE: 기준이 되는 데이터를 먼저 지정한 후 해당 데이터값에 따라 다른 결과 값을 출력)

SELECT EMPNO, ENAME, JOB, SAL, CASE JOB WHEN 'MANAHER' THEN SAL+1.1 WHEN 'SALESMAN' THEN SAL+1.05 WHEN 'ANALYST' THEN SAL ELSE SAL*1.03 END AS UPSAL FROM EMP;
--CASE: 특정 조건에 따라 반환할 데이터를 설정할 때 사용
--구조: CASE[검사대상이 될 열 OR 데이터, 연산이나 함수 결과] WHEN[조건1] THEN[조건1 결과 값 TRUE일떄 반환] ELSE[위 조건1~조건N과 일치하는 경우가 없을 떄 반환]END.

SELECT EMPNO, ENAME, COMM, CASE WHEN COMM IS NULL THEN '해당사항 없음' WHEN COMM=0 THEN'수당없음' WHEN COMM>0THEN '수당: '||COMM END AS COMM_TEXT FROM EMP;

--예제1.
SELECT EMPNO, RPAD(SUBSTR(EMPNO,1,2),4,'*') AS MASKING_EMPNO,ENAME,RPAD(SUBSTR(ENAME,1,1),5,'*')AS MASKING_ENAME FROM EMP;

--예제2.
SELECT EMPNO, ENAME,SAL, TRUNC(SAL/21.5,1) AS DAYPAY,ROUND(SAL/21.5/8,1) AS TIMEPAY FROM EMP;

--예제3.
SELECT EMPNO, ENAME, HIREDATE, TO_CHAR(ADD_MONTHS(NEXT_DAY(HIREDATE,'월요일'),3),'YYYY/MM/DD') AS R_JOB,NVL(TO_CHAR(COMM),'N/A') COMM FROM EMP;

--예제4.
SELECT EMPNO, ENAME, MGR, CASE WHEN MGR IS NULL THEN '0000' WHEN SUBSTR(MGR,1,2)='78' THEN '8888' WHEN SUBSTR(MGR,1,2)='77' THEN '7777' WHEN SUBSTR(MGR,1,2)='76' THEN '6666' WHEN SUBSTR(MGR,1,2)='75' THEN '5555' ELSE TO_CHAR(MGR) END AS CHG_MGR FROM EMP;



SELECT SUM(SAL) FROM EMP;

SELECT ENAME, SUM(SAL)FROM EMP;


SELECT SUM(COMM) FROM EMP;

SELECT SUM(DISTINCT SAL),SUM(ALL SAL),SUM(SAL) FROM EMP;

SELECT COUNT(*) FROM EMP WHERE DEPTNO=30;


SELECT COUNT(DISTINCT SAL), COUNT(ALL SAL), COUNT(SAL) FROM EMP;

SELECT COUNT(COMM)FROM EMP;
SELECT COUNT (COMM) FROM EMP WHERE COMM IS NOT NULL;

SELECT MAX(SAL) FROM EMP WHERE DEPTNO=10; --부서번호가 10번인 사원들 중 최대 급여액
SELECT MIN(SAL) FROM EMP WHERE DEPTNO=10; --부서 번호가 10번인 사원들 중 최소 급여액

SELECT MAX(HIREDATE) FROM EMP WHERE DEPTNO = 20; --부서번호가 20인 사원들 중 제일 최근 입사일
SELECT MIN(HIREDATE) FROM EMP WHERE DEPTNO=20;-- 부서번호가 20인 사원중 제일 오래된 입사일

SELECT AVG(SAL) FROM EMP WHERE DEPTNO=30; --부서번호가 30인 사원들 평균 급여
SELECT AVG(DISTINCT SAL) FROM EMP WHERE DEPTNO = 30; --중복제거한 급여 열 평균 급여

SELECT DEPTNO, JOB, AVG(SAL)FROM EMP GROUP BY DEPTNO, JOB ORDER BY DEPTNO, JOB;--부서번호 및 직책별 평균 급여로 정렬
SELECT ENAME, DEPTNO, AVG(SAL) FROM EMP GROUP BY DEPTNO;--GROUP BY절에 없는 열을 SELECT절에 포함할 경우

SELECT DEPTNO, JOB, AVG(SAL) FROM EMP GROUP BY DEPTNO, JOB HAVING AVG(SAL)>=2000 ORDER BY DEPTNO, JOB;
--GROUP BY(그룹화) ,HAVING(그룹화 결과 값의 범위 제한) 사용하여 출력

SELECT DEPTNO, JOB, AVG(SAL) FROM EMP WHERE AVG(SAL)>=2000 GROUP BY DEPTNO, JOB ORDER BY DEPTNO, JOB;
--HAVING 이 아닌 WHERE로 오류 WHERE:출력대상 제한, HAVING: 그룹화된 대상 출력 제한

SELECT DEPTNO, JOB, AVG(SAL) FROM EMP GROUP BY DEPTNO, JOB HAVING AVG(SAL)>=2000 ORDER BY DEPTNO, JOB;
--HAVING 만 사용한 경우

SELECT DEPTNO, JOB, AVG(SAL) FROM EMP WHERE SAL<=3000 GROUP BY DEPTNO, JOB HAVING AVG(SAL)>=2000 ORDER BY DEPTNO, JOB;
--WHERE, HAVING 모두 사용한 경우 (WHERE절이 GROUP BY, HAVING보다 먼저 실행)

--ROLLUP, CUBE,GROUPING SETS(그룹화 전용 함수)
--ROLLUP, CUBE 그룹화 데이터의 합계를 출력
--ROLLUP:명시한 열을 소그룹부터 대그룹 순서로 결과 출력, 마지막에 총 데이터 결과 출력/그룹 함수 지정 불가
--CUBE: 지정한 모든 열에서 가능한 조합 결과를 모두 출력)
--GROUPING SETS: 지정한 열이 그룹화된 상태로 결과가 집계되었는지 확인하는데 사용, 명시된 열 중 하나를 지정할 수 있음
SELECT DEPTNO, JOB, COUNT(*), MAX(SAL), SUM(SAL), AVG(SAL) FROM EMP GROUP BY DEPTNO, JOB ORDER BY DEPTNO, JOB;
--기존 GROUP BY절만 사용 
SELECT DEPTNO, JOB, COUNT(*), MAX(SAL), SUM(SAL), AVG(SAL) FROM EMP GROUP BY ROLLUP(DEPTNO, JOB);
--ROLLUP사용
SELECT DEPTNO, JOB, COUNT(*),MAX(SAL),SUM(SAL),AVG(SAL) FROM EMP GROUP BY CUBE(DEPTNO, JOB) ORDER BY DEPTNO, JOB;
--CUBE 사용/CUBE함수 특성상 가시성이 좋지 않아 예제에선 ORDER BY함께 사용

SELECT DEPTNO, JOB, COUNT(*) FROM EMP GROUP BY DEPTNO, ROLLUP(JOB);
--DEPTNO을 그룹화 한 후 ROLLUP함수에 JOB지정
SELECT DEPTNO, JOB, COUNT(*) FROM EMP GROUP BY JOB, ROLLUP(DEPTNO);
--JOB을 그룹화 한 후 ROLLUP함수에 DEPTNO,지정

SELECT DEPTNO, JOB, COUNT(*) FROM EMP GROUP BY GROUPING SETS(DEPTNO, JOB) ORDER BY DEPTNO, JOB;

SELECT DEPTNO, JOB, COUNT(*), MAX(SAL), SUM(SAL), AVG(SAL), GROUPING(DEPTNO),GROUPING(JOB) FROM EMP GROUP BY CUBE(DEPTNO, JOB) ORDER BY DEPTNO, JOB;

SELECT DECODE(GROUPING(DEPTNO),1,'ALL_DEPT',DEPTNO) AS DEPTNO, 
DECODE(GROUPING(JOB),1,'ALL_JOB',JOB) AS JOB, COUNT(*),MAX(SAL),SUM(SAL),AVG(SAL) FROM EMP GROUP BY CUBE(DEPTNO, JOB) ORDER BY DEPTNO, JOB;

SELECT DEPTNO, JOB, COUNT(*), SUM(SAL), GROUPING(DEPTNO), GROUPING(JOB), GROUPING_ID(DEPTNO, JOB)FROM EMP GROUP BY CUBE(DEPTNO,JOB) ORDER BY DEPTNO,JOB;

--LISTAGG:그룹에 속한 데이터를 가로로 나열할 때 사용
SELECT DEPTNO, ENAME FROM EMP GROUP BY DEPTNO, ENAME;--기존
SELECT DEPTNO, LISTAGG(ENAME,',') WITHIN GROUP (ORDER BY SAL DESC) AS ENAMES FROM EMP GROUP BY DEPTNO;




----------------------------------------------------------------------------


CREATE TABLE DEPT_TEMP AS SELECT*FROM DEPT; --DEPT_TEMP 테이블 생성
INSERT INTO DEPT_TEMP(DEPTNO, DNAME, LOC)VALUES(50, 'DATABASE','SEOUL'); --DEPT_TEMP테이블 데이터 추가
SELECT*FROM DEPT_TEMP;

INSERT INTO DEPT_TEMP VALUES(60 ,'NETWORK','BUSAN');--열 지정 없이 데이터 추가
SELECT*FROM DEPT_TEMP;

INSERT INTO DEPT_TEMP (DEPTNO, DNAME, LOC)VALUES(70 ,'WEB',NULL);--NULL 지정하여 입력
SELECT*FROM DEPT_TEMP;

INSERT INTO DEPT_TEMP (DEPTNO,DNAME ,LOC) VALUES(80 ,'MOBILE','');--NULL을 공백 문자열로 입력
SELECT*FROM DEPT_TEMP;

INSERT INTO DEPT_TEMP (DEPTNO,LOC) VALUES(90    ,'INCHEON'); --열 데이터를 넣지 않는 방식으로 NULL입력
SELECT*FROM DEPT_TEMP;

CREATE TABLE EMP_TEMP AS SELECT*FROM EMP WHERE 1<>1; --EMP 테이블 복사해서 EMP_TEMP 테이블 생성
SELECT*FROM EMP_TEMP;

INSERT INTO EMP_TEMP (EMPNO, ENAME, JOB, MGR,HIREDATE,SAL,COMM,DEPTNO) VALUES(9999,'홍길동','PRESIDENT',NULL, '2001/01/01',5000,1000,10);
SELECT*FROM EMP_TEMP;

INSERT INTO EMP_TEMP (EMPNO,ENAME, JOB, MGR, HIREDATE,SAL,COMM,DEPTNO) VALUES(1111,'성춘향','MANAGER',9999,'2001-01-05',4000,NULL,20);
SELECT*FROM EMP_TEMP

INSERT INTO EMP_TEMP(EMPNO, ENAME, JOB, MGR,HIREDATE,SAL,COMM,DEPTNO) VALUES(2111,'이순신','MANAGER',9999,TO_DATE('07/01/2001','DD/MM/YYYY'),4000,NULL,20);
SELECT*FROM EMP_TEMP;

INSERT INTO EMP_TEMP(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL,COMM,DEPTNO) VALUES (3111,'심청이','MANAGER',9999,SYSDATE,4000,NULL,30);
SELECT*FROM EMP_TEMP;

INSERT INTO EMP_TEMP(EMPNO, ENAME, JOB,MGR, HIREDATE,SAL,COMM,DEPTNO) SELECT E.EMPNO,E.ENAME,E.JOB,E.MGR,E.HIREDATE,E.SAL,E.COMM,E.DEPTNO FROM EMP E, SALGRADE S WHERE E.SAL BETWEEN S.LOSAL AND S.HISAL AND S.GRADE =1;
--서브쿼리로 여러 데이터 추가
SELECT*FROM EMP_TEMP;


CREATE TABLE DEPT_TEMP2 AS SELECT*FROM DEPT; --DEPT테이블 복사로 DEPT_TEMP2테이블 생성
SELECT*FROM DEPT_TEMP2;

UPDATE DEPT_TEMP2 SET LOC = 'SEOUL';
SELECT*FROM DEPT_TEMP2;
ROLLBACK;

UPDATE DEPT_TEMP2 SET DNAME = 'DATEBASE', LOC = 'SEOUL' WHERE DEPTNO = 40;
SELECT*FROM DEPT_TEMP2;

UPDATE DEPT_TEMP2 SET(DNAME, LOC)=(SELECT DNAME, LOC FROM DEPT WHERE DEPTNO=40) WHERE DEPTNO =40;
SELECT*FROM DEPT_TEMP2;

UPDATE DEPT_TEMP2 SET LOC='SEOUL' WHERE DEPTNO = (SELECT DEPTNO FROM DEPT_TEMP2 WHERE DNAME='OPERATIONS');
SELECT*FROM DEPT_TEMP2;



CREATE TABLE EMP_TEMP2 AS SELECT*FROM EMP;
SELECT*FROM EMP_TEMP2;

DELETE FROM EMP_TEMP2 WHERE JOB = 'MANAGER';
SELECT*FROM EMP_TEMP2;

DELETE FROM EMP_TEMP2 WHERE EMPNO IN(SELECT E.EMPNO FROM EMP_TEMP2 E, SALGRADE S WHERE E.SAL BETWEEN S.LOSAL AND S.HISAL AND S.GRADE =3 AND DEPTNO=30);
SELECT*FROM EMP_TEMP2;
DELETE FROM EMP_TEMP2;
SELECT*FROM EMP_TEMP2;

CREATE TABLE DEPT_TCL AS SELECT*FROM DEPT;
SELECT*FROM DEPT_TCL

INSERT INTO DEPT_TCL VALUES(50,'DATABASE','SEOUL');
UPDATE DEPT_TCL SET LOC = 'BUSAN' WHERE DEPTNO=40;
DELETE FROM DEPT_TCL WHERE DNAME = 'RESEARCH';
SELECT*FROM DEPT_TCL;
ROLLBACK;
SELECT*FROM DEPT_TCL;

INSERT INTO DEPT_TCL VALUES(50,'NETWORK','SEOUL');
UPDATE DEPT_TCL SET LOC = 'BUSAN' WHERE DEPTNO =20;
DELETE FROM DEPT_TCL WHERE DEPTNO =40;
SELECT*FROM DEPT_TCL;

CREATE TABLE EMP_DDL(--자료 형 정의하여 테이블 생성
EMPNO   NUMBER(4),
ENAME   VARCHAR2(10),
JOB     VARCHAR2(9),
MGR     NUMBER(4),
HIREDATE DATE,
SAL     NUMBER(7,2),
COMM    NUMBER(7,2),
DEPTNO  NEMBER(2)
);
DESC EMP_DDL;
SELECT*from EMP DDL;

CREATE TABLE DEPT_DDL AS SELECT*FROM DEPT;--기존 테이블 복사하여 테이블 생성
DESC DEPT_DDL;
SELECT*FROM DEPT_DDL;


CREATE TABLE EMP_DDL_30 AS SELECT*from EMP WHERE DEPTNO=30;
--테이블 일부 복사하여 테이블 생성 (DEPTNO=30 구간)
SELECT*FROM EMP_DDL_30;

CREATE TABLE EMPDEPT_DDL AS SELECT E.EMPNO, E.ENAME, E.JOB,E.MGR,E.HIREDATE,
E.SAL,E.COMM,D.DEPTNO,D.DNAME,D.LOC FROM EMP E, DEPT D WHERE 1<>1;
SELECT*FROM EMPDEPT_DDL;
--1<>1 결과값은 항상 FALSE이기 떄문에 EMP,DEPT테이블의 조인 결과행이 출력대상에서 제외

CREATE TABLE EMP_ALTER AS SELECT*FROM EMP;
SELECT*FROM EMP_ALTER;

ALTER TABLE EMP_ALTER ADD HP VARCHAR2(20); --ALTER:이미 생성된 오라클 객체 변경 시 사용
SELECT*FROM EMP_ALTER;                     --ADD: 테이블에 열 추가

ALTER TABLE EMP_ALTER RENAME COLUMN HP TO TEL; --RENAME: 열 이름 변경
SELECT*FROM EMP_ALTER;

ALTER TABLE EMP_ALTER MODIFY EMPNO NUMBER(5); --MODIFY:자료형 변경 (예제에선 DMPNO의 자료형인 NUMBER 열 길이 변경)
DESC EMP_ALTER;

ALTER TABLE EMP_ALTER DROP COLUMN TEL; --DROP키워드 사용 TEL 열 삭제
SELECT*FROM EMP_ALTER;

RENAME EMP_ALTER TO EMP_RENAME; --EMP_ALTER 테이블 명 EMP_RENAME 변경
DESC EMP_ALTER; --EMP_RENAME으로 변경되여 조회 불가
SELECT*FROM EMP_RENAME;

TRUNCATE TABLE EMP_RENAME; --TRUNCATE: 테이블 데이터 삭제
SELECT*FROM EMP_RENAME;
DROP TABLE EMP_RENAME; --테이블 삭제

SELECT*FROM DICT; --SCOTT 계정에서 사용 가능한 데이터 사전 (DICT사용)
SELECT*FROM DICTIONARY; --(DICTIONARY사용)

SELECT TABLE_NAME FROM USER_TABLES; --SCOTT이 가지고 있는 객체 정보 (USER_접두어사용)
SELECT OWNER, TABLE_NAME FROM ALL_TABLES; --SCOTT이 가지고 있는 객체 정보(ALL_접두어 사용)
SELECT*FROM DBA_TABLES; --사용 권한이 없는 계정으로 조회 시 에러 발생 (조회불가능)

SELECT*FROM USER_INDEXES; -- SCOTT계정이 소유한 인덱스 정보
SELECT*FROM USER_IND_COLUMNS; --SCOTT계정이 소유한 인덱스 컬럼 정보

CREATE INDEX IDX_EMP_SAL ON EMP(SAL);--인덱스 생성
SELECT*FROM USER_IND_COLUMNS;
DROP INDEX IDX_EMP_SAL; --인덱스 삭제
SELECT*FROM USER_IND_COLUMNS;

CREATE VIEW VW_EMP20 AS(SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE DEPTNO=20); --뷰 생성
SELECT*FROM USER_VIEWS;--뷰 조회
SELECT*FROM VW_EMP20;
DROP VIEW VW_EMP20;--뷰 삭제

SELECT ROWNUM,E.*FROM EMP E; --ROWNUM 추가조회
SELECT ROWNUM, E.*FROM EMP E ORDER BY SAL DESC; --SAL기준 내림차 순으로 지정해도 특수 열의 값은 변동되지않음

--인라인뷰: SQL문에서 일회성으로 만들어서 사용하는 뷰 
--(EX. SELECT문에서의 서브쿼리,  WITH절에서 미리 정의한 SELECT문 등이 해당
SELECT ROWNUM, E.*from (SELECT*FROM EMP E ORDER BY SAL DESC)E; --인라인 뷰(서브쿼리 사용)
WITH E AS(SELECT*FROM EMP ORDER BY SAL DESC) SELECT ROWNUM,E.*FROM E; --인라인뷰(WITH 절 사용)

SELECT ROWNUM, E.*FROM(SELECT*FROM EMP E ORDER BY SAL DESC)E WHERE ROWNUM<=3; --인라인 뷰(서브쿼리)로 상위 3(TOP-N)추출
WITH E AS(SELECT*FROM EMP ORDER BY SAL DESC) SELECT ROWNUM, E.* FROM E WHERE ROWNUM<=3;--인라인 뷰(WITH 절)로 상위 3(TOP-N)추출


--SEQUENCE: 특정 규칙에 맞는 연속 숫자를 생성하는 객체
--EX.은행이나 병원 대기 순번표
CREATE TABLE DEPT_SEQUENCE AS SELECT*FROM DEPT WHERE 1<>1; --기존 테이블 복사하여 DEPT_SEQUENCE테이블 생성
SELECT*FROM DEPT_SEQUENCE;

CREATE SEQUENCE SEQ_DEPT_SEQUENCE INCREMENT BY 10 START WITH 10 MAXVALUE 90 MINVALUE 0 NOCYCLE CACHE 2;
--SEQ_DEPT_SEQUENCE 시퀸스 생성     번호증가 값        시작 값        최대값        최소값   반복 유무  메모리에 미리 할당해 놓은 수 지정          
SELECT*FROM USER_SEQUENCES;

INSERT INTO DEPT_SEQUENCE (DEPTNO, DNAME, LOC) VALUES (SEQ_DEPT_SEQUENCE.NEXTVAL, 'DATABASE','SEOUL');
SELECT*FROM DEPT_SEQUENCE ORDER BY DEPTNO;

SELECT SEQ_DEPT_SEQUENCE.CURRVAL FROM DUAL; --가장 마지막으로 생성된 시퀀스

INSERT INTO DEPT_SEQUENCE (DEPTNO, DNAME, LOC) VALUES(SEQ_DEPT_SEQUENCE.NEXTVAL,'DATEBASE','SEOUL');
SELECT*FROM DEPT_SEQUENCE ORDER BY DEPTNO;

ALTER SEQUENCE SEQ_DEPT_SEQUENCE INCREMENT BY 3 MAXVALUE 99 CYCLE;
SELECT*from USER_SEQUENCES;

INSERT INTO DEPT_SEQUENCE (DEPTNO, DNAME, LOC) VALUES(SEQ_DEPT_SEQUENCE.NEXTVAL,'DATABASE','SEOUL');
SELECT*FROM DEPT_SEQUENCE ORDER BY DEPTNO;

DROP SEQUENCE SEQ_DEPT_SEQUENCE;
SELECT*FROM USER_SEQUENCE;

--동의어
--테이블, 뷰, 시퀸스 등 객체 이름 대신 사용할 수 잇는 다른 이름을 부여하는 객체

CREATE SYNONYM E FOR EMP;
SELECT*FROM E;
DROP SYNONYM E;



CREATE TABLE TABLE_NOTNULL(LOGIN_ID VARCHAR2(20) NOT NULL, LOGIN_PWD VARCHAR2(20) NOT NULL,TEL VARCHAR2(20));
--NOT NULL로 제약을 걸어 NULL값을 입력 못 하도록 지정
DESC TABLE_NOTNULL;

INSERT INTO TABLE_NOTNULL (LOGIN_ID, LOGIN_PWD,TEL) VALUES('TEST_ID_01',NULL,'010-1234-5678');
--NOT NULL 제약으로 인해 LOGIN PWD NULL값 입력 오류로 에러 발생

INSERT INTO TABLE_NOTNULL (LOGIN_ID, LOGIN_PWD) VALUES('TESI_ID_01','1234');
SELECT*FROM TABLE_NOTNULL;

UPDATE TABLE_NOTNULL SET LOGIN_PWD = NULL WHERE LOGIN_ID = 'TEST_ID_01';
--UPDATE 문을 이용한 수정도 불가능

SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE,TABLE_NAME FROM USER_CONSTRAINTS; --SCOTT 제약조건 조회

CREATE TABLE TABLE_NOTNULL2(--테이블 생성 시에 제약 조건에 이름 지정
LOGIN_ID VARCHAR2(20) CONSTRAINT TBLNN2_LGNID_NN NOT NULL,
LOGIN_PWD VARCHAR2(20) CONSTRAINT TBLNN2_LGNPW_NN NOT NULL,
TEL     VARCHAR2(20));
SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS;


DESC TABLE_NOTNULL ; 
ALTER TABLE TABLE_NOTNULL MODIFY(TEL NOT NULL); --이미 TEL열에 NULL값이 존재하기 때문에 NOT NULL조건 지정 불가
UPDATE TABLE_NOTNULL SET TEL = '010-1234-5678' WHERE LOGIN_ID = 'TESI_ID_01';
SELECT*FROM TABLE_NOTNULL;
drop table table_notnull;

ALTER TABLE TABLE_NOTNULL2 MODIFY(TEL CONSTRAINT TBLNN_TEL_NN NOT NULL);
SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS;

DESC TABLE_NOTNULL2;
ALTER TABLE TABLE_NOTNULL2 RENAME CONSTRAINT TBLNN_TEL_NN TO TBLNN2_TEL_NN;
SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS;

ALTER TABLE TABLE_NOTNULL2 DROP CONSTRAINT TBLNN2_TEL_NN; --제약조건 삭제
DESC TABLE_NOTNULL2;

--UNIQUE: 중복 적용X
CREATE TABLE TABLE_UNIQUE(LOGIN_ID VARCHAR2(20) UNIQUE, LOGIN_PWD VARCHAR2(20) NOT NULL, TEL VARCHAR2(20));
DESC TABLE_UNIQUE;

SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME='TABLE_UNIQUE';
--데이터 사전 뷰로 제약 조건 확인

INSERT INTO TABLE_UNIQUE (LOGIN_ID,LOGIN_PWD,TEL) VALUES('TEST_ID_01','PWD01','010-1234-5678');
SELECT*FROM TABLE_UNIQUE;

INSERT INTO TABLE_UNIQUE(LOGIN_ID, LOGIN_PWD, TEL) VALUES('TEST_ID_01','PWD01','010-1234-5678');
--중복 값 입력 UNIQUE 테스트 (제약 조건 위배 에러)

INSERT INTO TABLE_UNIQUE(LOGIN_ID, LOGIN_PWD, TEL) VALUES('TEST_ID_02','PWD01','010-1234-5678');
SELECT*FROM TABLE_UNIQUE;

INSERT INTO TABLE_UNIQUE(LOGIN_ID, LOGIN_PWD, TEL) VALUES(NULL, 'PWD01','010-2345-6789');
SELECT*FROM TABLE_UNIQUE

UPDATE TABLE_UNIQUE SET LOGIN_ID='TEST_ID_01' WHERE LOGIN_ID IS NULL;
--UNIQUE제약 조건 으로 인한 수정불가

CREATE TABLE TABLE_UNIQUE2(LOGIN_ID VARCHAR2(20) CONSTRAINT TBLUNQ2_LGNID_UNQ UNIQUE,
LOGIN_PWD VARCHAR2(20) CONSTRAINT TBLUNQ2_LGNPW_NN NOT NULL, TEL VARCHAR2(20));

SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS
WHERE TABLE_NAME LIKE 'TABLE_UNIQUE%'; 

ALTER TABLE TABLE_UNIQUE MODIFY(TEL UNIQUE); --테이블 제약 조건 수정

UPDATE TABLE_UNIQUE SET TEL=NULL;--제약 조건 내 데이터 수정

SELECT*FROM TABLE_UNIQUE;


ALTER TABLE TABLE_UNIQUE2 MODIFY(TEL CONSTRAINT TBLUNQ_TEL_UNQ UNIQUE);

SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME LIKE 'TABLE_UNIQUE%';
--제약 조건 이름 직접 지정

ALTER TABLE TABLE_UNIQUE2 RENAME CONSTRAINT TBLUNQ_TEL_UNQ TO TBLUNQ2_TEL_UNQ;
--제약 조건 이름 수정

SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME LIKE 'TABLE_UNIQUE%';

ALTER TABLE TABLE_UNIQUE2 DROP CONSTRAINT TBLUNQ2_TEL_UNQ;
--제약 조건 삭제



--PRIMARY KET: NOT NULL, UNIQUE 두 가지 제약 조건의 특성을 가짐

CREATE TABLE TABLE_PK( LOGIN_ID VARCHAR2(20) PRIMARY KEY, LOGIN_PWD VARCHAR2(20) NOT NULL, TEL VARCHAR2 (20));
--테이블 생성시 특정 열에 PRIMARY KEY설정 (예제 LOGIN ID)
DESC TABLE_PK;

SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME LIKE 'TABLE_PK%'
--생성된 PK 확인

SELECT INDEX_NAME, TABLE_OWNER, TABLE_NAME FROM USER_INDEXES WHERE TABLE_NAME LIKE 'TABLE_PK%';
--자동 생성된 INDEX확인

CREATE TABLE TABLE_PK2( LOGIN_ID VARCHAR2(20) CONSTRAINT TBLPK2_LGNID_PK PRIMARY KEY,
LOGIN_PWD VARCHAR2(20) CONSTRAINT TBLPK2_LGNPW_NN NOT NULL, TEL VARCHAR2(20));
--제약 조건 이름 직접 지정
DESC TABLE_PK2;

INSERT INTO TABLE_PK(LOGIN_ID, LOGIN_PWD, TEL) VALUES('TEST_ID_01','PWD01', '010-1234-5678');
SELECT*FROM TABLE_PK;

INSERT INTO TABLE_PK(LOGIN_ID, LOGIN_PWD, TEL) VALUES('TEST_ID_01', 'PWD02', '010-2345-6789');
--중복 데이터 입력 (에러)

INSERT INTO TABLE_PK(LOGIN_PWD, TEL) VALUES('PWD02', '010-2345-6789');
--NULL 값 입력 불가 (PRIMARY KEY 제약 조건 지정)

SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, R_OWNER, R_CONSTRAINT_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME IN('EMP','DEPT');
--EMP,DEPT테이블의 제약 조건 확인


--FOREIGN KEY
--서로 다른 테이블 간 관계를 정의하는데 사용
--해당 제약 조건을 다른 테이블의 특정 열에서 참조
CREATE TABLE DEPT_FK(DEPTNO NUMBER(2) CONSTRAINT DEPTFK_DEPTNO_PK PRIMARY KEY, DNAME VARCHAR2(14) ,LOC VARCHAR2(13));
DESC DEPT_FK;

CREATE TABLE EMP_FK(
EMPNO   NUMBER(4) CONSTRAINT EMPFK_EMPNO_PK PRIMARY KEY,
ENAME   VARCHAR2(10),
JOB     VARCHAR2(9),
MGR     NUMBER(4),
HIREDATE DATE,
SAL     NUMBER(7,2),
COMM    NUMBER(7,2),
DEPTNO NUMBER(2) CONSTRAINT EMPFK_DEPTNO_FK REFERENCES DEPT_FK(DEPTNO));
DESC EMP_FK;

INSERT INTO EMP_FK VALUES(9999,'TEST_NAME','TEST_JOB',NULL,TO_DATE('2001/01/01','YYYY/MM/DD'),3000,NULL,10);
--DEPT_FK에 데이터가 없으므로 에러
INSERT INTO DEPT_FK VALUES(10,'TEST_DNAME','TEST_LOC');
--DEPT_FK에 데이터 입력

SELECT*FROM DEPT_FK;
SELECT*FROM EMP_FK;

DELETE FROM DEPT_FK WHERE DEPTNO=10;
--DEPTNO을 참조하는 데이터가 있어 DELETE불가능


--CHECK
--열에 저장할 수 있는 값의 범위, 패턴을 정의할 때 사용

CREATE TABLE TABLE_CHECK( LOGIN_ID VARCHAR2(20) CONSTRAINT TBLCK_LOGINID_PK PRIMARY KEY,
LOGIN_PWD VARCHAR2(20) CONSTRAINT TBLCK_LOGINPW_CK CHECK (LENGTH(LOGIN_PWD)>3), TEL VARCHAR2(20));
--TBLCK__LOGINID_PK->PRIMARY KEY, TBLCK_LOGINPW->CHECK (조건: LENGTH(LOGIN_PWD)>3 /LOGIN_PWD가 4글자 이상)
DESC TABLE_CHECK;

INSERT INTO TABLE_CHECK VALUES('TEST_ID','123', '010-1234-5678');
--비밀번호가 3글자 이므로 에러
INSERT INTO TABLE_CHECK VALUES('TEST_ID','1234','010-1234-5678');
SELECT*FROM TABLE_CHECK;

SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME LIKE'TABLE_CHECK';


--DEFAULT
--제약 조건과 별개로 특정 열에 저장할 값이 지정되지 않을 경우 기본값을 지정할때 사용

CREATE TABLE TABLE_DEFAULT(LOGIN_ID VARCHAR2(20) CONSTRAINT TBLCK2_LOGINID_PK PRIMARY KEY,
LOGIN_PWD VARCHAR2(20) DEFAULT '1234', TEL  VARCHAR2(20));

DESC TABLE_DEFAULT;

INSERT INTO TABLE_DEFAULT VALUES('TEST_ID',NULL, '010-1234-5678');
INSERT INTO TABLE_DEFAULT (LOGIN_ID, TEL) VALUES('TEST_ID2', '010-1234-5678');
SELECT*FROM TABLE_DEFAULT;


