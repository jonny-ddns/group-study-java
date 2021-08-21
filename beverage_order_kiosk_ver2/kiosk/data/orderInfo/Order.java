package beverage_order_kiosk_ver2.kiosk.data.orderInfo;

public class Order {
    private int beverKind;		//종류
    private int beverTemper;	//음료 온도
    private int beverShot;		//음료 샷
    private int beverSize;		//음료 크기
    private int beverWhere;		//음료 섭취장소
    private int beverCount;     //주문개수

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
