-- Level 2 가격이 제일 비싼 식품의 정보 출력하기
SELECT PRODUCT_ID, PRODUCT_NAME, PRODUCT_CD, CATEGORY, PRICE
  FROM FOOD_PRODUCT
 WHERE PRICE = (SELECT MAX(PRICE) AS PRICE FROM FOOD_PRODUCT)

