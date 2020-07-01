# Description

*  Security 적용상태에서  profile에 따른 선별적 security filter 적용
	( ex : 상용에서는 특정 url이 404로 동작하나 , 개발에서는 url에 정상적으로 access )
* 특정 url을 환경 ( 상용 , 개발 , 로컬 )에 따라 다르게 동작하도록 정의할때 사용
  
# 동작

* Spring security 적용상태
* Security pattern에 "/main/**" 적용
* "/main/test" url로 요청이 들어올때 profile이 "local" 일 경우에는 error.html 로 redirect
* "/main/test" url로 요청이 들어올때 profile이 "service"일 경우에는 로그인 --> test.html view페이지 반환
