# product-order-service-tdd

이중석 - 스프링부트 상품-주문 API 개발로 알아보는 TDD

2023년 7월 31일.

하루만에 완강하기 도전 !

[인프런 강의](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8-%EC%8B%A4%EC%A0%84-%EC%83%81%ED%92%88%EC%A3%BC%EB%AC%B8-tdd)

[이중석님 유튜브](https://www.youtube.com/@ejoongseok)

[해당 강의 실습 github](https://github.com/ejoongseok/product-order-service)

### POJO 상품 등록 기능 구현하기

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
