package beverage_order_kiosk.customerOrder;

public class Order_data {
    private String beverKind;
    private String beverIceHot;
    private String beverShot;
    private String beverSize;
    private String beverWhere;

    public String getBeverKind() {
        return beverKind;
    }
    public Order_data setBeverKind(String beverKind) {
        this.beverKind = beverKind;
        return this;
    }

    public String getBeverIceHot() {
        return beverIceHot;
    }
    public Order_data setBever_iceHot(String beverIceHot) {
        this.beverIceHot = beverIceHot;
        return this;
    }

    public String getBeverShot() {
        return beverShot;
    }
    public Order_data setBeverShot(String beverShot) {
        this.beverShot = beverShot;
        return this;
    }

    public String getBeversize() {
        return beverSize;
    }
    public Order_data setBeverSize(String beverSize) {
        this.beverSize = beverSize;
        return this;
    }

    public String getBeverWhere() {
        return beverWhere;
    }
    public Order_data setBeverWhere(String beverWhere) {
        this.beverWhere = beverWhere;
        return this;
    }
}
