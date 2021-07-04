# BEVERAGE ORDER KIOSK
    code language : java
    created by : jonny-ddns
    created : Jul.3, 2021
    updated : Jun.4, 2021
    usage : making order using kiosk
##### --------------------------------------------------------------------------------------
### flow of execution
	kioskStart.java - ���α׷� ����
	-> ���� �޴� ���.
    -> �����ϱ�
        ���� ����
        ���� �µ�(ice, hot)
        ���� ��(shot)
        ���� ũ��(size)
        ���� �������(where)
    -> ������ ���� �ԷµǾ�� �����ܰ�� ���డ��
        ��û������ List ���·� �����
        ���("c") ��û�� �ֹ����� ���� 
        �߰��ֹ� ����� ����޴� ���. ������������ �ٽ� ���� �� ����
    -> ��û���� ���� ������ �ֹ�Ȯ�γ��� ���
    -> �ֹ�Ȯ���� ������ ������ ���
    -> ���α׷� ����
##### --------------------------------------------------------------------------------------
### package description
    menu_enum       : ���� ����, ����, ��û���� �� ������ ��� ���
    operation       : �ֹ���û������ �Է¹޴� ����
    customerOrder   : �ֹ���û������ �����ϴ� ���
    receipt         : �������� �����ϴ� ����
##### --------------------------------------------------------------------------------------
### class description
#### KioskStart.java
	main method ����. KioskOrder Ŭ���� ����
#### KioskOrder.java
    o ����
    -�ֹ���û������ �ޱ����� Ŭ�������� ȣ��
    -�ֹ���ҿ���, �ֹ�Ȯ�ΰ���� ���� �帧����
    -������ ���� Ŭ���� ȣ��

    o start() �޼���
    �ֹ��ް�(receiveOrder) �������� ���(CreateReceipt)�ϴ� �޼��� ȣ��

    o receiveOrder() �޼���
    �ֹ���û������ �޴� ����
    operation ������ü���� ȣ��
#### Orders.java
    Value Object
    �ֹ���û������ �����ϴ� ��ü
#### OrderCollection.java
    Orders �� ��ü�� �ϴ� List ���� �� ����

    o add_orderInfo() �޼���
    �ֹ������� List�� �߰�

    o reset_orderInfo() �޼���
    �ֹ���ҽ� resetData() �޼��� ȣ���Ͽ� List�� null�� ����
#### Operation
    �������̽�
    �ֹ���û�� �޴¿���
#### Operation0_kind.java
    Operation ������ü
    �������� ��û������ �Է¹޾� Orders �� �ݿ�
#### Operation1_temper.java
    Operation ������ü
    ���� �µ� ��û������ �Է¹޾� Orders �� �ݿ�
#### Operation2_shot.java
    Operation ������ü
    ���� �� ��û������ �Է¹޾� Orders �� �ݿ�
#### Operation3_size.java
    Operation ������ü
    ����ũ�� ��û������ �Է¹޾� Orders �� �ݿ�
#### Operation4_where.java
    Operation ������ü
    ���ἷ����� ��û������ �Է¹޾� Orders �� �ݿ�
#### Operation5_orderMore.java
    Operation ������ü
	�߰��ֹ� ���θ� �Է¹޴� ����
#### Operation5_orderCheck.java
    Operation ������ü
	�ֹ�Ȯ�� ����� �Է¹޴� ����
#### CreateReceipt.java
    ������ frame ���� �� ����ϴ� ����
#### ReceiptOrder.java
    �������� �� �ֹ���û �� �ݾ��� �����ϴ� ����
#### UnitChange.java
    menu_enum ��Ű���� enum �� �ֹ���û ����(int)�� ������ ��ȯ�ϴ� ����