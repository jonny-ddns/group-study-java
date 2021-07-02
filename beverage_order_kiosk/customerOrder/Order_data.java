package beverage_order_kiosk.customerOrder;

public class Order_data {
    private int beverKind;
    private int beverTemper;
    private int beverShot;
    private int beverSize;
    private int beverWhere;

    public int getBeverKind() {
        return beverKind;
    }
    public Order_data setBeverKind(int beverKind) {
        this.beverKind = beverKind;
        return this;
    }

    public int getBeverTemper() {
        return beverTemper;
    }
    public Order_data setBeverTemper(int beverTemper) {
        this.beverTemper = beverTemper;
        return this;
    }

    public int getBeverShot() {
        return beverShot;
    }
    public Order_data setBeverShot(int beverShot) {
        this.beverShot = beverShot;
        return this;
    }

    public int getBeverSize() {
        return beverSize;
    }
    public Order_data setBeverSize(int beverSize) {
        this.beverSize = beverSize;
        return this;
    }

    public int getBeverWhere() {
        return beverWhere;
    }
    public Order_data setBeverWhere(int beverWhere) {
        this.beverWhere = beverWhere;
        return this;
    }
}
