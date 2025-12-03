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

실행

```jsx
docker compose up -d -- 실행
```

종료

```jsx
docker compose down  -- 종료 및 삭제
종료만 하려면 stop
```


### Docker Command

- docker images
    - docker 이미지 리스트

- docker image inspect [imageid]
    - image 상세 정보

- docker image rm  [imageid]
    - image 삭제

- docker build . -t [imageName[
    - 이미지 생성

- docker run -p [hostPort:ContainerPort] [imageName]
    - HostPort 와 ContainerPort를 지정한 상태로 이미지 실

- docker ps
    - 실행중인 container list

- docker ps -a
    - 중지 및 실행중인 container list

- docker container start edaf7f7eb443 44a18fe1b2de a08ec1b6d6d7
    - docker container start 함수 id를 space 로 포함하여 여러개 실행 가능

- docker container pause edaf7f7eb443 44a18fe1b2de a08ec1b6d6d7
    - 메모리는 그대로 유지
    - 파일시스템 상태도 그대로 유지
    - 네트워크 소켓 연결 자체는 살아있지만 데이터 송수신 불가
    - 프로세스는 kill 되지 않고, 그냥 멈춘 상태
    
    1) 컨테이너 프로세스가 CPU를 과하게 잡아먹을 때
    
    잠시 멈춰놨다가 상태 점검할 때.
    
    2) 컨테이너 상태를 유지해야 하지만, 동작은 멈춰야 할 때
    
    디버깅 / 백업 / 점검 시 유용.
    
    3) 스냅샷 느낌으로 일시정지
    
    Stop 은 프로세스 종료라 메모리 날아가지만, Pause 는 메모리 그대로 남아있음.
    
- docker unpause <container_id>
    - 다시 활성화

- docker container stop <container_id>
    - 5~10초가량의 시간 뒤 정상 종료
    - docker stop -t 3 app_container t를 통해 시간 조정가능
    
- docker container kill <container_id>
    - 즉시종료

- docker container logs edaf7f7eb443
    - 콘테이너의 로그

- docker container restart <container_id>
    - 재실행
