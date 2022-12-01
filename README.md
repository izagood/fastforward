# 패스트포워드 백엔드 과제

## 테스트 방법

1. DB 실행

- docker 를 사용하여 테스트 DB(mysql)를 만들었습니다.

- DB 실행방법
    1. docker desktop 을 실행
    2. 터미널 실행
    3. 프로젝트 root 경로에서 `docker compose up -d --build` 명령어를 입력하시면 됩니다.

- DB 접속 정보
    - url : jdbc:mysql://localhost:3306/fastforward
    - user: stock
    - password : s1234

2. 프로젝트 실행

- DB 실행 후 로컬 프로젝트 실행(StockApplication.kt)

## 사용기술

- Kotlin
- Spring Boot
- Spring Data JPA
- Docker
- Mysql
- Openfeign
