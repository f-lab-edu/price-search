### Pricesearch

#### 개요
- Chrome Extension 기반 가격 비교 장바구니
- 장바구니에 물건을 넣으면, 최저가를 찾아 알려준다!

#### Tech Stack
- Spring Boot(Embedded Tomcat), Spring Data JPA + MySQL, Testcontainers
- Nginx
- Ubuntu 21.04
- Pinpoint
- Elasticsearch + Kibana(Access Logging)

#### User Story
- 사용자는 가격비교하고자 하는 상품의 url을 본인의 장바구니에 담아 해당하는 상품의 쇼핑몰별 상품정보와 결제가능 url 정보를 받아볼수 있다.
- 사용자는 본인이 담은 상품의 목록을 조회할 수 있다.
- 사용자는 본인의 장바구니에서 담아뒀던 상품을 제거할 수 있다.
- 사용자는 장바구니에 담긴 상품결제링크를 통해 해당하는 가격의 쇼핑몰 결제페이지에 접근할 수 있다.
- 사용자는 장바구니에 담긴 상품의 최저가격이 업데이트 되면 알림을 받을 수 있다.
- 사용자는 본인의 장바구니에 담긴 상품(들)을 선택해 다른 사용자에게 공유할 수 있다.