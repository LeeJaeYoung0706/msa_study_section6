

### docker Hub 올리기

docker login -u leejaeyoung4466

-> docker hub 홈페이지에서 generate token 발급 받아 password 처리

docker image push docker.io/jaesoon/accounts:s5 

-> 해당 jaesoon 이름과 내 로그인 아이디가 일치하지 않을경우 authorization 오류

docker build . -t leejaeyoung4466/accounts:s5

docker image push docker.io/leejaeyoung4466/accounts:s5
