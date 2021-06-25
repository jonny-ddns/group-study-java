# STUDY MANAGEMENT PROGRAM
##### ====================================================================================
code language : java

created by : jonny-ddns

created : Jun.11, 2021

updated : Jun.17, 2021

usage : study management
##### ====================================================================================

### flow of execution

	StudyManage_start.java - main() �޼ҵ� ����
	--> Study_application.java - appStart()�޼ҵ� ����
	--> Scanner�� ���� �Է°� �ޱ�
		���� Ȥ�� 0~7�� ��� ���� �Է½� ��� �޽��� ���
	--> StudyManage.java �� ������ Ŭ���� ȣ��
	--> (while ���� ������� �ʴ���) �Է°� ��� �ޱ�
	--> ���α׷� ����� 7�� �Է�
	--> ���α׷� ����

##### ====================================================================================

#### package description

	application	: application ����� �ʿ��� ���Ϲ���
	data 		: Student �� StudentList ������ �����Ǵ� ���
	service 	: application������ ��û�� �޾� ����Ǵ� ��ɵ� ����
	
##### ====================================================================================

#### StudyManage_start.java
	main method ��ġ. Study_application Ŭ���� ȣ��

#### Study_application.java
	���͵���� ��ȣ�� �Է¹޴� Ŭ����
	StudyManage �������̽��� ������ Ŭ������ ȣ���Ͽ� ����� ����ǰ� ��

#### App_button.java
	java Enum
	Study_application ����� �־��� �Է°��� �Էµǵ��� ���� 

#### Student.java
	-ȸ�� ������ ���� ����
	-ȸ������ : 
		ȸ����ȣ
		�̸�
		������
		���Գ�¥
		���͵�¥
		é������
		��������
		�߰�����
		����������
		����
		�ܾ�
		Ȱ������

#### StudentData.java
	o ȸ�� ������ List ���·� ����
	List�� �̱��� �������� ����
	
	o �ֿ� �޼ҵ�
	study_isMember()
		������ ��ϵ� ������� Ȯ��

	study_getMember()
		ȸ����ȣ�� �޾� ȸ�������� ��������

	study_newStudent()
		���͵� �ű԰���

 	study_isInserted()
		���͵� ������ �Է��ߴ��� Ȯ��

	study_insertInfo()
		���͵� �����Է��ϱ�

	study_editInfo()
		���͵� ���������ϱ�

	study_quit()
		���͵� Ż���ϱ�

	study_getAll()
		���͵� ���� ��� ��������

#### StudyManage.java
	manage() �޼ҵ带 ���� interface 
	StudyManage Ŭ���� ������ manage() �޼ҵ带 �����ϵ��� ����

#### Study0_menu.java
	StudyManage.java ������ Ŭ����
	�޴��� �ֿܼ� ����ϴ� ���

#### Study1_join.java
	StudyManage.java ������ Ŭ����
	���͵� ����ó���� �ϴ� ���

#### Study2_insertInfo.java
	StudyManage.java ������ Ŭ����
	���͵� ������ �Է��� �� �ִ� ���

#### Study3_editInfo.java
	StudyManage.java ������ Ŭ����
	���͵� ������ ������ �� �ִ� ���

#### Study4_quit.java
	StudyManage.java ������ Ŭ����
	���͵� Ż��ó���� �� �� �ִ� ���

#### Study5_fineStatus.java
	StudyManage.java ������ Ŭ����
	���͵� Ż������ �ʾ����� ������ 0���̻��� ȸ���� ���ݻ����� �����ִ� ���

#### Study6_overView.java
	StudyManage.java ������ Ŭ����
	���͵� Ż�� ȸ���� �����Ͽ� ���͵� ��ü ��Ȳ�� �����ִ� ���
