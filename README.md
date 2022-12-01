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

3. API 테스트

- [API 테스트 링크](http://localhost:8080/swagger-ui/index.html)

- Root URL : http://localhost:8080

- 주식 조회
    - URL : `/stocks/{symbol}/{interval}/{range}`
        - e.g. `/stocks/005930.KS/1d/5d`
    - method : `GET`
    - 예시
        - response body
          ```json
          {
            "message": "",
            "body": {
              "timestamp": [
                1669334400,
                1669593600,
                1669680000,
                1669766400,
                1669876204
              ],
              "volume": [
                6677933,
                8589032,
                7014160,
                19768903,
                16476208
              ],
              "open": [
                61400,
                60500,
                59900,
                60400,
                63100
              ],
              "close": [
                61000,
                60100,
                60600,
                62200,
                62600
              ],
              "high": [
                61700,
                60500,
                60600,
                62200,
                63200
              ],
              "low": [
                60800,
                59800,
                59800,
                60200,
                62300
              ]
            }
          }
          ```

## 사용기술

- Kotlin
- Spring Boot
- Spring Data JPA
- Docker
- Mysql
- Openfeign
- Springdoc-openapi
