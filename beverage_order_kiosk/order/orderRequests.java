package beverage_order_kiosk.order;

public class orderRequests {
    private String beverKind;
    private String beverIceHot;
    private String beverShot;
    private String beverSize;
    private String beverTakeout;

    public String getBeverKind() {
        return beverKind;
    }
    public orderRequests setBeverKind(String beverKind) {
        this.beverKind = beverKind;
        return this;
    }

    public String getBeverIceHot() {
        return beverIceHot;
    }
    public orderRequests setBever_iceHot(String beverIceHot) {
        this.beverIceHot = beverIceHot;
        return this;
    }

    public String getBeverShot() {
        return beverShot;
    }
    public orderRequests setBeverShot(String beverShot) {
        this.beverShot = beverShot;
        return this;
    }

    public String getBeversize() {
        return beverSize;
    }
    public orderRequests setBeverSize(String beverSize) {
        this.beverSize = beverSize;
        return this;
    }

    public String getBeverTakeout() {
        return beverTakeout;
    }
    public orderRequests setBeverTakeout(String beverTakeout) {
        this.beverTakeout = beverTakeout;
        return this;
    }
}
