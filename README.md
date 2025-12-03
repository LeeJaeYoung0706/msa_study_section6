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
