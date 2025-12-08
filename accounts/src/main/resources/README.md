



## jvm 사용해서 환경 적용하기

```java
--spring.profiles.active=prod --build.version=1.1

```

- intellij 는 active profile 에 prod 

### Program arguments

-  --build.version=1.0

### jvm

```java
-Dspring.profiles.active=prod -Dbuild.version=1.2
```


## 환경 변수로 실행하기
### ENVIRONMENT VARIABLES
```java
spring.profiles.active=prod;build.version=1.2
```
### 대문자 버전
```java
SPRING_PROFILES_ACTIVE=prod;BUILD_VERSION=1.2
```