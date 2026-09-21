SELECT FACTORY_ID, FACTORY_NAME, ADDRESS
FROM FOOD_FACTORY
WHERE ADDRESS LIKE '강원%'  # '%강원%'으로 검색해야 정확하지 않을까?
ORDER BY FACTORY_ID ASC;


# 일반적으로 데이터베이스를 구조화시켜 컬럼을 분리시키기 때문에 '강원%' 등으로 검색할 수 있다.
# 비정형 데이터의 예외 처리를 위해서 '%강원%'을 사용해야 하지만 풀 테이블 스캔이 발생해 속도가 느리다.
