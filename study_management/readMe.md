# STUDY MANAGEMENT PROGRAM
##### ====================================================================================
code language : java

created by : jonny-ddns

created : Jun.11, 2021

updated : Jun.12, 2021

usage : study management
##### ====================================================================================

### flow of execution

	StudyManage_start.java - main() 메소드 실행
	--> Study_application.java - appStart()메소드 실행
	--> Scanner를 통해 입력값 받기
		문자 혹은 0~7을 벗어난 숫자 입력시 경고 메시지 출력
	--> StudyManage.java 를 구현한 클래스 호출
	--> (while 문이 종료되지 않는한) 입력값 계속 받기
	--> 프로그램 종료시 7을 입력
	--> 프로그램 종료

##### ====================================================================================

#### package description

	application	: application 실행시 필요한 파일묶음
	data 		: Student 정보가 보관되는 장소
	service 	: 요청을 전달받아 실행되는 기능들 묶음
	
##### ====================================================================================

#### StudyManage_start.java
	main method 위치. Study_application 클래스 호출

#### Study_application.java
	스터디관리 번호를 입력받는 클래스
	StudyManage 인터페이스를 구현한 클래스를 호출하여 기능이 실행되게 함

#### App_button.java
	java Enum
	Study_application 실행시 주어진 입력값만 입력되도록 설정 

#### Student.java
	-회원 정보를 담은 파일
	-회원정보 : 
		회원번호
		이름
		보증금
		가입날짜
		스터디날짜
		챕터정리
		과제수행
		중간점검
		일주일점검
		벌금
		잔액
		활동여부

#### StudentData.java
	o 회원 정보를 List 형태로 보관
	List는 싱글톤 패턴으로 구현
	
	o 주요 메소드
	study_isMember()
		기존에 등록된 멤버인지 확인

	study_getMember()
		회원번호를 받아 회원정보를 가져오기

	study_newStudent()
		스터디 신규가입

 	study_isInserted()
		스터디 정보를 입력했는지 확인

	study_insertInfo()
		스터디 정보입력하기

	study_editInfo()
		스터디 정보수정하기

	study_quit()
		스터디 탈퇴하기

	study_getAll()
		스터디 정보 모두 가져오기

#### StudyManage.java
	manage() 메소드를 갖는 interface 
	StudyManage 클래스 구현시 manage() 메소드를 실행하도록 설정

#### Study0_menu.java
	StudyManage.java 구현한 클래스
	메뉴를 콘솔에 출력하는 기능

#### Study1_join.java
	StudyManage.java 구현한 클래스
	스터디 가입처리를 하는 기능

#### Study2_insertInfo.java
	StudyManage.java 구현한 클래스
	스터디 정보를 입력할 수 있는 기능

#### Study3_editInfo.java
	StudyManage.java 구현한 클래스
	스터디 정보를 수정할 수 있는 기능

#### Study4_quit.java
	StudyManage.java 구현한 클래스
	스터디 탈퇴처리를 할 수 있는 기능

#### Study5_fineStatus.java
	StudyManage.java 구현한 클래스
	스터디를 탈퇴하지 않았으며 벌금이 0원이상인 회원의 벌금상태을 보여주는 기능

#### Study6_overView.java
	StudyManage.java 구현한 클래스
	스터디 탈퇴 회원을 포함하여 스터디 전체 현황을 보여주는 기능
