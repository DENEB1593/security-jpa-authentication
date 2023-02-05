## JPA 기반 인증 구현

### [환경]
* springboot 3.0
* jdk 17
* h2 database

### [구현내용]
* WebSecurityConfigureAdapter 방식이 아닌 @Bean 방식을 이용하여 구현한다.
* lombok 라이브러리는 미사용한다.
* User 모델과 UserDetails 구현체는 별도로 분리한다.
* 간단한 HomeController를 생성하여 ROLE 별 접근 테스트를 진행한다.

### [이력]
* 01/28: Jakarta EE 10, UUID 기본키활용 가능하여 수정 <br>
* 02/05: README 수정, Security 단위테스트 추가 <br>
 
[참고]
* [단위테스트 참고사이트](https://github.com/eugenp/tutorials/tree/master/spring-boot-modules/spring-boot-security/src/main/java/com/baeldung/integrationtesting)
* Jakarata 관련 참고 사항
>Jakarta EE 10 is first new feature release in five years after Java EE was moved to the Eclipse Foundation in September 2017.<br>
Jakarta EE 8 = same as Java EE 8 with javax package and Java 8 baseline <br>
Jakarta EE 9 = same as Java EE 8 with jakarta package and Java 8 baseline <br>
Jakarta EE 9.1 = same as Java EE 8 with jakarta package Java 8 baseline and Java 11 support <br>
Jakarta EE 10 = First Major release with Java 11 baseline and Java 17 support <br>