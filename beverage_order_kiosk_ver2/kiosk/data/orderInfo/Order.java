package beverage_order_kiosk_ver2.kiosk.data.orderInfo;

public class Order {
    private int beverKind;		//����
    private int beverTemper;	//���� �µ�
    private int beverShot;		//���� ��
    private int beverSize;		//���� ũ��
    private int beverWhere;		//���� �������
    private int beverCount;     //�ֹ�����

    public int getBeverKind() {
        return beverKind;
    }
    public Order setBeverKind(int beverKind) {
        this.beverKind = beverKind;
        return this;
    }

    public int getBeverTemper() {
        return beverTemper;
    }
    public Order setBeverTemper(int beverTemper) {
        this.beverTemper = beverTemper;
        return this;
    }

    public int getBeverShot() {
        return beverShot;
    }
    public Order setBeverShot(int beverShot) {
        this.beverShot = beverShot;
        return this;
    }

    public int getBeverSize() {
        return beverSize;
    }
    public Order setBeverSize(int beverSize) {
        this.beverSize = beverSize;
        return this;
    }

    public int getBeverWhere() {
        return beverWhere;
    }
    public Order setBeverWhere(int beverWhere) {
        this.beverWhere = beverWhere;
        return this;
    }

    public int getBeverCount() {
        return beverCount;
    }

    public Order setBeverCount(int beverCount) {
        this.beverCount = beverCount;
        return this;
    }
}
