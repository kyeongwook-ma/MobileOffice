MobileOffice
============

ExoBrain 프로젝트

# 통신 기법 : OSGi HTTP Rest

1. 타겟 플랫폼 설정

Eclipse 역시 OSGi플랫폼 위에 구동되므로 새로운 타겟 플랫폼을 생성하여 기존의 IDE에 변경이
없는 개발 환경을 만들어야 합니다.

<img src=http://eclipsesource.com/blogs/wp-content/uploads/2014/02/001-target.png>
Eclipse 의 상단 메뉴 중 Preference - Plugin Development 에서 Target Platform에서
새로운 타겟 플랫폼을 추가합니다.

<img src=http://eclipsesource.com/blogs/wp-content/uploads/2014/02/002-create-target.png>
여타 다른 번들들은 필요하지 않으므로 Nothing 으로 플랫폼을 생성합니다.

<img src=http://eclipsesource.com/blogs/wp-content/uploads/2014/02/003-add-software-site.png>
개발시 필요한 OSGi - HTTP REST 를 지원하는 라이브러리를 추가합니다.





