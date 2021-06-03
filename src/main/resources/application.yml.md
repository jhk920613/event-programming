## mariadb를 사용할 경우
```yaml
spring:
  datasource:
    driverClassName: org.mariadb.jdbc.Driver
    url: jdbc:mariadb://localhost:3306/account
    username: account
    password: account
  jpa:
    hibernate:
      ddl-auto: update
```

## h2를 사용할 경우
```yaml
spring:
  application:
    name: account
  h2:
    console:
      enabled: true
      path: /h2
  datasource:
    url: jdbc:h2:mem:account
    driverClassName: org.h2.Driver
    username: sa
    password:
```
