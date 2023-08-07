# 프로그래머스 SQL 고득점 kit
- 총 74문제
- 문제 풀면서 개념 정리 하기

# MySQL
## REGEXP - 정규식을 이용한 검색
- Like '% %' 검색과 달리 조금 더 다양한 검색을 할 수 있도록 도움을 준다.

> select * from test where name regexp '가|나|다|라';
- select * from test where name like '%가%' or name like '%나%' or name like '%다%' or name like '%라%'; (동일 쿼리)

> select * from test where name regexp '[가-힇]';
- name 필드에 한글이 포함된 모든 레코드를 검색한다.

> select * from test where name regexp '^[가-힇]+$';
- name 필드에 한글로만 구성된 모든 레코드를 검색한다.

### REGEXP 정규식 기호 간단 소개 
- \. : 문자 하나를 나타낸다.
- \* : 앞에 나온 문자의 0개 이상 반복을 나타낸다.
- \^ : 문자열의 처음을 나타낸다.
- \$ : 문자열의 끝을 나타낸다.
- \[.] : 괄호 안의 문자열 일치를 확인한다.
- \{.} : 반복을 나타낸다.
- \| : or 를 나타낸다.

### REGEXP 참고사항
- 사용자에게 정규식 기능을 제공해선 안된다.
- 각 종 오류 포함할 수 있고, sql 인젝션에 취약해지기 때문에 개발자가 미리 정한 테두리 안에 행해져야 한다.

## ORDER BY COUNT(*) DESC LIMIT 1
> SELECT MEMBER_ID FROM REST_REVIEW GROUP BY MEMBER_ID ORDER BY COUNT(*) DESC LIMIT 1;
- SELECT 절에서 SEQ만 보이고 그룹화한 SEQ의 개수의 내림차순으로 해야할 때 위의 쿼리로 작성해야한다.
- LIMIT n은 리턴할 행의 제한된 수(n)를 지정합니다.
- 위에서 count로 집계된 최대 개수가 여러개인 경우 최대 개수 중 아무거나 한개가 반환된다. 