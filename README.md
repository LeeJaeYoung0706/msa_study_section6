# msa_study_section6


## Docker Basic

### docker build

docker build . -t leejaeyoung4466/loans:s4

docker images
docker inspect leejaeyoung4466/loans:s5

docker run -p 8081:8080 leejaeyoung4466/accounts:s5

docker run -d -p 8081:8080 leejaeyoung4466/accounts:s5  BACK GROUND

docker ps 상태확인

 mvn spring-boot:build-image 빌드팩으로 빌드하기

```
<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<excludes>
						<exclude>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
						</exclude>
					</excludes>
					<image>
						<name>leejaeyoung4466/${project.artifactId}:s6</name>
					</image>
				</configuration>
			</plugin>
		</plugins>
	</build>
```

### docker Hub 올리기

docker login -u leejaeyoung4466

-> docker hub 홈페이지에서 generate token 발급 받아 password 처리

docker image push docker.io/jaesoon/accounts:s5 

-> 해당 jaesoon 이름과 내 로그인 아이디가 일치하지 않을경우 authorization 오류

docker build . -t leejaeyoung4466/accounts:s5

docker image push docker.io/leejaeyoung4466/accounts:s5

docker pull leejaeyoung4466/accounts:s5

docker run -d -p 8081:8080 leejaeyoung4466/accounts:s5


### docker Compose 로 여러개 서비스 돌리기

```
services:
  accounts:
    image: "leejaeyoung4466/accounts:s5"
    container_name: accounts-ms # 컨테이너 랜덤 이름 부여 방지
    ports: # port 맵핑 다중 포트 맵핑 가능.
      - "8080:8080"
    deploy: # 배포
      resources:
        limits:
          memory: 700m # 최대 메모리
    networks:
      - sidle
  loans:
    image: "leejaeyoung4466/loans:s5"
    container_name: loans-ms # 컨테이너 랜덤 이름 부여 방지
    ports: # port 맵핑 다중 포트 맵핑 가능.
      - "8090:8090"
    deploy: # 배포
      resources:
        limits:
          memory: 700m # 최대 메모리
    networks:
      - sidle
  cards:
    image: "leejaeyoung4466/cards:s5"
    container_name: cards-ms # 컨테이너 랜덤 이름 부여 방지
    ports: # port 맵핑 다중 포트 맵핑 가능.
      - "9000:9000"
    deploy: # 배포
      resources:
        limits:
          memory: 700m # 최대 메모리
    networks:
      - sidle
networks: # 루트 요소 서비스간의 네트워킹 정의
  sidle:
    driver: "bridge" # 기본적으로 타입 지정하지 않는다면 이 타입으로 지정


```
