# product-order-service-tdd

이중석 - 스프링부트 상품-주문 API 개발로 알아보는 TDD

2023년 7월 31일.

~~하루만에 완강하기 도전 !~~

어림도 없지. 생각보다 어려워서 천천히 봐야겠다..

[인프런 강의](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8-%EC%8B%A4%EC%A0%84-%EC%83%81%ED%92%88%EC%A3%BC%EB%AC%B8-tdd)

[이중석님 유튜브](https://www.youtube.com/@ejoongseok)

[해당 강의 실습 github](https://github.com/ejoongseok/product-order-service)

## POJO 상품 등록 기능 구현하기

- 변수 추출: Command + Option + V

- TODO: request DTO 를 record로 사용하셨는데, java 17 record 알아보기.

- UnsupportedOperationException -> 이 예외를 통해 테스트를 빠르게 실패하게 만든다. (단축키 쓰시는 것 같은데, ide 설정해서 쓰시는 듯)

- TODO: port adaptor 네이밍을 사용하신다. 그냥 일반적으로 내가 사용하던 Interface - 구현체 관계와 다른 것 일까? 이것도 한 번 알아보자.
오. 인프런 답변이 있군.

> 이번 강의에서 사용된 port와 adapter는 헥사고날 아키텍처, 포트 & 어댑터 등으로 불리고 있는 구조에서 말하는 아웃바운드 포트, 아웃바운드 어댑터라고 이해하시면 될거같습니다.
>
> 아웃바운드 포트를 이용해 애플리케이션 코어를 외부(DB, API, 등...)와 분리하여,
>
> 애플리케이션 코어를 쉽게 테스트 하고, 외부의 변경으로 부터 코어를 보호하려는 의도로 사용했습니다.

- 음. 하나의 테스트 파일에 Inner class 로 모두 작성 후에, public 클래스로 빼내시는군.

  - inner class 클래스 추출: F6

- 테스트에서도 적극적으로 매서드 분리를 하시는건가.

마무리: 하루만에 끝내려고 했는데, 엄청난 강의 속도 + 노하우들이 숨어 있어서 11분짜리 듣는데에 30분이 넘게 걸렸다.

다른 사람이 코드 한 줄 한 줄 치는 것을 처음 보는 것 같은데, 이 분이 어떤 방식으로 생각하고 코드를 짜고 계시는지 볼 수 있어서 너무 좋은 것 같다. 이 흐름을 따라가는 것만 해도 굉장히 좋은 공부인 것 같다.

[강의 QnA 구경하기]

POJO로 개발한 후 스프링으로 전환하고 마지막에 JPA로 전환하는 이유
- 설계 및 개발 과정에서의 효율성과 유연성 때문
- POJO로 개발한 후 스프링과 JPA로 전환하는 접근 방식은 객체지향적인 설계 원칙을 준수하면서도 개발 시간을 줄이고 유연한 코드 작성이 가능한 방법
  - JPA를 처음부터 사용하게 되면, 데이터 중심의 설계가 나오기 쉽습니다. 이로 인해 객체지향적인 설계 원칙이 무시되거나 희생될 수 있습니다.
  - JPA를 처음부터 사용하면, 초기 개발 시간이 상대적으로 더 많이 소요됩니다. 반면에 POJO로 먼저 개발하면, 기능 구현에 집중하여 빠르게 개발.

## API 테스트로 전환하기

- ApiTest 라는 random port를 생성하는 클래스를 만들고 상속받아서 사용하신다.
- TODO: 랜덤 포트를 사용하지 않으면 어떤 일이 생길까?
- 로직 매서드 추출: Command + Option + M
- TODO: 테스트에서 요청과 응답 매서드 반환을 var 타입으로 받는다. 왜 그런걸까?
- TODO: RestAssured 에 대해서 알아보자.
  - RestAssured 의 문제점 중 하나는, 데이터가 캐싱되어서 격리가 잘 안된다.
  - [우아한 ATDD' 영상 참고](https://www.youtube.com/watch?v=ITVpmjM4mUE&ab_channel=%EC%9A%B0%EC%95%84%ED%95%9C%ED%85%8C%ED%81%AC)
  - DatabaseCleanup 객체의 주석 확인.
- TODO: InitializingBean 가 어떤 클래스인지 알아보기

## 상품 조회 API 개발
- 리팩토링 메뉴 전체 조회: Control + T
  - 클래스 빼내는 곳에 사용
- 첫번째에는 POJO 클래스로 처음부터 개발을 했는데, 상품 조회는 간단하니까 그냥 처음부터 spring boot test 로 진행.
  - 그때그때 더 빠른 방법을 선택하면 된다고 한다. -> 와 이거 언제 익숙해져서 TDD가 빨라지는걸까

