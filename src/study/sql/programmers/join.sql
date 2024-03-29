-- Level 4 그룹별 조건에 맞는 식당 목록 출력하기
-- 가장 많이 작성한 회원의 리뷰들을 조회
-- (실수회고) 가장 많이 작성한 회원들의 리뷰 조회로 착각했다.

SELECT A.MEMBER_NAME, B.REVIEW_TEXT, DATE_FORMAT(B.REVIEW_DATE,"%Y-%m-%d") AS REVIEW_DATE
  FROM MEMBER_PROFILE AS A
  JOIN REST_REVIEW AS B
    ON A.MEMBER_ID = B.MEMBER_ID
 WHERE A.MEMBER_ID = (SELECT MEMBER_ID FROM REST_REVIEW GROUP BY MEMBER_ID ORDER BY COUNT(*) DESC LIMIT 1)
 ORDER BY B.REVIEW_DATE ASC, B.REVIEW_TEXT ASC;

-- Level 4 주문량이 많은 아이스크림들 조회하기
-- 7월에는 아이스크림 주문량이 많아 같은 아이스크림에 대하여 서로 다른 두 공장에서 아이스크림 가게로 출하를 진행하는 경우가 있습니다.
-- 이 경우 같은 맛의 아이스크림이라도 다른 출하 번호를 갖게 됩니다.
-- FIRST_HALF,JULY 테이블의 데이터 확인 후 SHIPMENT_ID,FLAVOR 매핑이 되는 인덱스 키를 선정한다.
-- 확인 결과, JULY 테이블의 출하번호가 FIRST_HALF 테이블에 없는 경우가 확인되므로 FLAVOR를 인덱스로 JOIN 해야한다.
-- (문제 풀때) 두 테이블의 정보/기본키/왜래키 확인 후 JOIN으로 채택할 인덱스 키 파악하기!
-- v1
SELECT A.FLAVOR
 FROM FIRST_HALF A
 JOIN (SELECT FLAVOR, SUM(TOTAL_ORDER) AS TOTAL_ORDER FROM JULY GROUP BY FLAㅂVOR) B
   ON A.FLAVOR = B.FLAVOR
GROUP BY A.FLAVOR
ORDER BY SUM(A.TOTAL_ORDER + B.TOTAL_ORDER) DESC LIMIT 3;

-- v2
SELECT T.FLAVOR
  FROM (
           SELECT A.FLAVOR, SUM(A.TOTAL_ORDER + B.TOTAL_ORDER) AS TOTAL_CNT
             FROM FIRST_HALF A
             JOIN JULY B
               ON A.FLAVOR = B.FLAVOR
            GROUP BY FLAVOR
            ORDER BY TOTAL_CNT DESC LIMIT 3
  )T

-- Level 4 5월 식품들의 총매출 조회하기
-- 생산일자가 2022년 5월인 식품들의 식품 ID, 식품 이름, 총매출을 조회, 총매출 내림차순, 총매출 같으면 식품 ID 오름차순
SELECT A.PRODUCT_ID, A.PRODUCT_NAME, TOTAL_AMOUNT * A.PRICE AS TOTAL_PRICE
  FROM FOOD_PRODUCT A
  JOIN (SELECT PRODUCT_ID, SUM(AMOUNT) AS TOTAL_AMOUNT
          FROM FOOD_ORDER
         WHERE PRODUCE_DATE BETWEEN DATE('2022-05-01') AND DATE('2022-05-31')
         GROUP BY PRODUCT_ID) B
    ON A.PRODUCT_ID = B.PRODUCT_ID
 ORDER BY TOTAL_PRICE DESC, PRODUCT_ID ASC

-- Level 2 조건에 맞는 도서와 저자 리스트 출력하기
-- (회고) 문제 잘 읽기, 출판일 기준으로 오름차순인데 내림차순으로 착각함. 그리고 주의사항도 잘 보기. 날짜 포맷도 안하고 제출해버렸음.
SELECT A.BOOK_ID, B.AUTHOR_NAME, DATE_FORMAT(A.PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE
  FROM BOOK A
  JOIN AUTHOR B
    ON A.AUTHOR_ID = B.AUTHOR_ID
 WHERE A.CATEGORY = '경제'
 ORDER BY A.PUBLISHED_DATE ASC


-- Levevl 4 특정 기간동안 대여 가능한 자동차들의 대여비용 구하기 (난이도 상)
/*
    문제 :
    자동차 종류가 '세단' 또는 'SUV' 인 자동차 중 2022년 11월 1일부터 2022년 11월 30일까지 대여 가능하고
    30일간의 대여 금액이 50만원 이상 200만원 미만인 자동차
    정렬 결과는 대여 FEE 금액을 기준으로 내림차순 정렬, 자동차 종류를 기준으로 오름차순 정렬,자동차 ID를 기준으로 내림차순

    조건 :
    할인된 가격 : 판매가 * (1-(할인율/100))
    대여 가능한 자동차 ID 찾기 : 대여 가능하지 않은 자동차를 걸러낸다.
    대여가 안되는 차는 ?
        - 11월 1일부터 30일까지 대여 해야함.
        - 대여 종료일이 11월 1일 이상이면 못빌림
        - 대여 시작일이 11월 30일 이전 대상 또한 포함.
    레퍼런스 중 CAR_ID가 동일한 차, 즉 한대의 차가 여러 히스토리를 가지므로 가장 최근 이력봐야한다고 했음.
    MAX() 시도 했으나, 어차피 여러 히스토리를 갖는 차 중에 날짜 범위를 토대로 CAR_ID 제외한다.
    날짜를 비교해서 자동으로 가장 최근 이력을 보게끔 되어 있음.
*/
SELECT A.CAR_ID,
       A.CAR_TYPE,
       ROUND(A.DAILY_FEE*30*(1-(DISCOUNT_RATE/100))) AS FEE
  FROM CAR_RENTAL_COMPANY_CAR A
  JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN C
    ON A.CAR_TYPE = C.CAR_TYPE
   AND C.DURATION_TYPE = '30일 이상'
 WHERE A.CAR_TYPE IN ('세단','SUV')
   AND A.CAR_ID NOT IN (SELECT B.CAR_ID
                          FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY B
                         WHERE B.END_DATE >= '2022-11-01' AND B.START_DATE <= '2022-11-30')
   AND A.DAILY_FEE*30*(1-(C.DISCOUNT_RATE/100)) >= 500000 AND A.DAILY_FEE*30*(1-(C.DISCOUNT_RATE/100)) < 2000000
 ORDER BY A.DAILY_FEE*30*(1-(C.DISCOUNT_RATE/100)) DESC, A.CAR_TYPE ASC, A.CAR_ID DESC

-- Level 3 없어진 기록 찾기
-- 입양을 간 기록은 있는데, 보호소에 들어온 기록이 없는 동물의 ID와 이름을 ID 순으로 조회하는 SQL문을 작성해주세요.
-- ANIMAL_OUTS 기록 있음, ANIMAL_INS 기록 없음
SELECT A.ANIMAL_ID, A.NAME
  FROM ANIMAL_OUTS A
  LEFT JOIN ANIMAL_INS B
         ON A.ANIMAL_ID = B.ANIMAL_ID
 WHERE B.ANIMAL_ID IS NULL
 ORDER BY ANIMAL_ID;

-- Level 3 있었는데요 없었습니다 (소요시간 5분)
-- 관리자의 실수로 일부 동물의 입양일이 잘못 입력되었습니다.
-- 보호 시작일보다 입양일이 더 빠른 동물의 아이디와 이름을 조회하는 SQL문을 작성해주세요. 이때 결과는 보호 시작일이 빠른 순으로 조회해야합니다.
SELECT A.ANIMAL_ID, A.NAME
  FROM ANIMAL_INS A
  JOIN ANIMAL_OUTS B
    ON A.ANIMAL_ID = B.ANIMAL_ID
 WHERE A.DATETIME > B.DATETIME
 ORDER BY A.DATETIME ASC;


-- Level 3 오랜 기간 보호한 동물 (소요시간 4분)
-- 아직 입양을 못 간 동물 중, 가장 오래 보호소에 있었던 동물 3마리의 이름과 보호 시작일을 조회하는 SQL문을 작성해주세요.
-- 이때 결과는 보호 시작일 순으로 조회해야 합니다.
SELECT A.NAME, A.DATETIME
  FROM ANIMAL_INS A
  LEFT JOIN ANIMAL_OUTS B
         ON A.ANIMAL_ID = B.ANIMAL_ID
 WHERE B.ANIMAL_ID IS NULL
 ORDER BY A.DATETIME ASC LIMIT 3;


-- Level 4 보호소에서 중성화한 동물 (소요시간 30분)
-- 보호소에서 중성화 수술을 거친 동물 정보를 알아보려 합니다.
-- 보호소에 들어올 당시에는 중성화1되지 않았지만,
-- 보호소를 나갈 당시에는 중성화된 동물의
-- 아이디와 생물 종, 이름을 조회하는 아이디 순으로 조회하는 SQL 문을 작성해주세요.

SELECT A.ANIMAL_ID, A.ANIMAL_TYPE, A.NAME
FROM ANIMAL_INS A
         JOIN ANIMAL_OUTS B
              ON A.ANIMAL_ID = B.ANIMAL_ID
WHERE A.SEX_UPON_INTAKE LIKE '%Intact%'
  AND (B.SEX_UPON_OUTCOME LIKE '%Spayed%' OR B.SEX_UPON_OUTCOME LIKE '%Neutered%') -- () 괄호 빼먹어서 계속 틀렸음.
ORDER BY ANIMAL_ID ASC;


SELECT A.ANIMAL_ID, A.ANIMAL_TYPE, A.NAME
FROM ANIMAL_INS A
         JOIN ANIMAL_OUTS B
              ON A.ANIMAL_ID = B.ANIMAL_ID
WHERE A.SEX_UPON_INTAKE LIKE '%Intact%'
  AND B.SEX_UPON_OUTCOME NOT LIKE '%Intact%';



-- Level 2 상품 별 오프라인 매출 구하기
-- 테이블에서 상품코드 별 매출액(판매가 * 판매량) 합계를 출력
-- 매출액을 기준으로 내림차순 정렬해주시고 매출액이 같다면 상품코드를 기준으로 오름차순 정렬
-- 문제랑 예시랑 확실하게 읽기.
-- (헷갈리는 부분) 상품 별로 중복되지 않는 8자리 상품코드 값을 가지며, 앞 2자리는 카테고리 코드를 의미합니다.
-- (헷갈리는 부분) 동일한 날짜, 상품 ID 조합에 대해서는 하나의 판매 데이터만 존재합니다.
SELECT A.PRODUCT_CODE, SUM(B.SALES_AMOUNT) * A.PRICE AS PRICE
  FROM PRODUCT A
  JOIN OFFLINE_SALE B
    ON A.PRODUCT_ID = B.PRODUCT_ID
 GROUP BY B.PRODUCT_ID
 ORDER BY PRICE DESC, PRODUCT_CODE ASC;

-- Level 5 상품을 구매한 회원 비율 구하기
/*
    년,월 별로 상품을 구매한 회원수와 상품을 구매한 회원비율을 구하는 문제

    2021년에 가입한 전체 회원들 중 상품을 구매한 회원수 >> 2021년에 가입한 회원을 USER_INFO ,ONLINE_SALE  조인하면 상품을 구매한 회원들의 목록이 되는 것.
    회원수를 구할 때 COUNT(USER_ID)로 하게 되면 중복 제거가 안되므로, COUNT(DISTINCT(A.USER_ID)) 해줘야한다.
    *  COUNT() 함수는 컬럼의 데이터 개수

    상품을 구매한 회원의 비율 >> (2021년에 가입한 회원 중 상품을 구매한 회원수 / 2021년에 가입한 전체 회원 수) 소수점 두번째자리에서 반올림
    2021년에 가입한 전체 회원 수 >> 2021년에 가입은 했지만 ONLINE_SALE에는 구매 이력이 없을 수도 있으니 USER_INFO에서 2021년에 가입한 회원 수를 구해야한다.

    소수점 두번째자리에서 반올림 하라는 의미는 첫번째 자리까지 보여주면 된다는 의미.
    * ROUND(숫자, 지정한 자릿수 + 1의 자릿수에서 반올림하고 난뒤의 소수점 자리 수 지정) >> ex) ROUND(123.4567, 1)는 123.5이다.

    SELECT *
      FROM USER_INFO A
      JOIN ONLINE_SALE B
        ON A.USER_ID = B.USER_ID
     WHERE DATE_FORMAT(A.JOINED, "%Y") = "2021"
     결과 >> 2021년에 가입한 회원들의 상품 구매 목록


    GROUP BY DATE_FORMAT(B.SALES_DATE, "%Y"), DATE_FORMAT(B.SALES_DATE, "%Y")로 년,월 별로 그룹핑을 한다.

*/

SELECT DATE_FORMAT(B.SALES_DATE, "%Y") AS YEAR
        , DATE_FORMAT(B.SALES_DATE, "%m") AS MONTH
        , COUNT(DISTINCT(A.USER_ID)) AS PUCHASED_USERS
        , ROUND(COUNT(DISTINCT(A.USER_ID)) / (SELECT COUNT(DISTINCT(USER_ID)) FROM USER_INFO WHERE DATE_FORMAT(JOINED, "%Y") = "2021" ),1) AS PUCHASED_RATIO
  FROM USER_INFO A
  JOIN ONLINE_SALE B
    ON A.USER_ID = B.USER_ID
 WHERE DATE_FORMAT(A.JOINED, "%Y") = "2021"
 GROUP BY YEAR, MONTH
 ORDER BY YEAR, MONTH ASC