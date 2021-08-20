# BEVERAGE ORDER KIOSK
### Authors
    Jul.3, 2021 : 장원준(Jang, wonjun)
### Change Logs   
	Jul.4, 2021 : added comments.
	Jul.9, 2021 : 
		1) modified not to ask about temperature, shot when taking order except coffee.
		2) modified not to add count when order canceled			
		3) setup to use only one scanner object.
### Bugs
    영수증 출력 부분이 매끄럽지 않아 수정필요
### Project Description
    o usage : making order using kiosk
    o code language : java
### Prerequisites
    JRE or JDK8 (or higher version is recommended)
### Flow of Execution
	kioskStart.java - 프로그램 실행
	-> 음료 메뉴 출력.
    -> 선택하기
        음료 종류
        음료 온도(ice, hot)
        음료 샷(shot)
        음료 크기(size)
        음료 섭취장소(where)
    -> 적절한 값이 입력되어야 다음단계로 진행가능
        요청사항은 List 형태로 저장됨
        취소("c") 요청시 주문내역 삭제되고 다시 처음부터 주문해야함
        추가주문 희망시 음료메뉴 출력. 음료종류부터 다시 받을 수 있음
    -> 요청사항 선택 끝나면 주문확인내용 출력
    -> 주문확인이 끝나면 영수증 출력
    -> 프로그램 종료
### Package Description
    menu_enum       : 음료 종류, 가격, 요청사항 등 정보가 담긴 장소
    operation       : 주문요청사항을 입력받는 역할
    customerOrder   : 주문요청사항을 보관하는 장소
    receipt         : 영수증을 제작하는 역할
### File Description
#### KioskStart.java
	main method 실행. KioskOrder 클래스 생성
#### KioskOrder.java
    o 역할
    -주문요청사항을 받기위한 클래스들을 호출
    -주문취소여부, 주문확인결과에 따른 흐름제어
    -영수증 제작 클래스 호출

    o start() 메서드
    주문받고(receiveOrder) 영수증을 출력(CreateReceipt)하는 메서드 호출

    o receiveOrder() 메서드
    주문요청사항을 받는 역할
    operation 구현객체들을 호출
#### Orders.java
    Value Object
    주문요청사항을 저장하는 객체
#### OrderCollection.java
    Orders 를 객체로 하는 List 생성 및 보관

    o add_orderInfo() 메서드
    주문내역을 List에 추가

    o reset_orderInfo() 메서드
    주문취소시 resetData() 메서드 호출하여 List를 null로 변경
#### Operation
    인터페이스
    주문요청을 받는역할
#### Operation0_kind.java
    Operation 구현객체
    음료종류 요청사항을 입력받아 Orders 에 반영
#### Operation1_temper.java
    Operation 구현객체
    음료 온도 요청사항을 입력받아 Orders 에 반영
#### Operation2_shot.java
    Operation 구현객체
    음료 샷 요청사항을 입력받아 Orders 에 반영
#### Operation3_size.java
    Operation 구현객체
    음료크기 요청사항을 입력받아 Orders 에 반영
#### Operation4_where.java
    Operation 구현객체
    음료섭취장소 요청사항을 입력받아 Orders 에 반영
#### Operation5_orderMore.java
    Operation 구현객체
	추가주문 여부를 입력받는 역할
#### Operation5_orderCheck.java
    Operation 구현객체
	주문확인 결과를 입력받는 역할
#### CreateReceipt.java
    영수증 frame 생성 및 출력하는 역할
#### ReceiptOrder.java
    영수증에 들어갈 주문요청 및 금액을 생성하는 역할
#### UnitChange.java
    menu_enum 패키지의 enum 및 주문요청 정보(int)를 적절히 변환하는 역할

### Thanks