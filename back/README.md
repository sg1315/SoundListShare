# 백엔드 (Spring Boot)

## 프로젝트 구조
- Spring Boot 기반 REST API 서버
- JWT를 활용한 인증/인가 구현
- JPA를 활용한 객체지향적인 엔티티 설계 및 데이터베이스 연동 구현

## 주요 라이브러리
- Spring Boot
- Spring Security
- Spring Data JPA
- Spring WebSocket
- Gradle
- JWT (JSON Web Token)
- AWS S3
- MySQL

## 실행 방법

```bash
cd back
./gradlew bootRun
```

## API 명세

| 메서드 | 엔드포인트              | 설명       |
| ------ |--------------------|----------|
| GET | /api/user/checkId  | 아이디 중복 체크 |
| POST | /api/user/createUser | 사용자 생성   |



## 환경 변수
- `application.yml`에서 DB 및 JWT 시크릿 키 설정
- AWS S3 버킷 및 자격 증명 정보 설정 (이미지 업로드 등에서 사용)
- 문자 인증을 위한 Solapi API 키 설정
- 공공 API를 통한 공휴일 정보 연동을 위한 인증키 설정
- 파일 업로드 및 서버 인코딩 관련 설정 포함 (UTF-8, 최대 파일 용량 등)
