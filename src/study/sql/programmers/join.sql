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