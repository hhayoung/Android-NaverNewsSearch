# Android-NaverNewsSearch

### 프로젝트 개요
네이버 뉴스 검색 오픈 API를 이용한 뉴스 리스트를 구현한 애플리케이션   
해당 키워드로 검색한 뉴스가 최신순대로 20개 보여진다.   
각 뉴스를 클릭하면 해당 뉴스의 원문 기사 페이지로 넘어간다.   

### 개발환경
Android Studio, 안드로이드용 폰

### 개발기간
210308 ~ 210312 (5일)   
프로젝트를 시작하기 전에 기본적인 안드로이드 강의를 들었고,
본격적으로 시작한 날짜부터 기록했다.

### 개발과정
1 - 네이버 뉴스 검색 API가 잘 가져와지는지 테스트   
2 - RecyclerView를 이용해 가져온 뉴스 데이터 나타내기   
3 - API 호출을 위한 라이브러리인 Retrofit을 사용해서 네이버 뉴스 값 나타내기   
4 - Retrofit을 이용해 뉴스 검색 API를 호출해서 RecyclerView에 나타내기   
5 - UI 꾸미기   

### 어려웠던 점
Recyclerview위젯을 사용할 때의 필요한 클래스들과 데이터를 보여주는 코드의 위치가    
메인이 아닌 어댑터 클래스에 있어야 하고 그런 동작과정을 이해하는데 시간이 걸렸다.   
그리고 Retrofit 라이브러리를 사용하는 방법을 익혔지만,
recyclerview 코드와 retrofit 코드를 합칠 때에 시행착오가 많았다.   
사라지는 코드와 생성해야 하는 코드가 처음에는 너무 헷갈렸지만 잘 합쳐서 원하는 결과를 만들었다.   
사용하기 편하고 보기 좋은 UI를 꾸미는게 어려웠다.   

### 느꼈던 점
오랜만에 하는 안드로이드 프로젝트라서 기본을 익히는데 시간이 걸렸지만,   
네이버 검색 API를 사용해서 실제 데이터를 가져오다보니 실시간으로 값이 바뀌고
테스트를 하면서 몇 초전의 뉴스를 빠르게 확인하는 게 재밌었다.   
여러가지를 합쳤을 때의 동작과정에 대해 이해할 수 있었던 프로젝트이다.   

