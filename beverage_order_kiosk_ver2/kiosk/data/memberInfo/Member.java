package beverage_order_kiosk_ver2.kiosk.data.memberInfo;

public class Member {
    private String phone;
    private String birthday;
    private String nick;
    private int point;

    public String getPhone() {
        return phone;
    }
    public Member setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getBirthday() {
        return birthday;
    }
    public Member setBirthday(String birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getNick() {
        return nick;
    }
    public Member setNick(String nick) {
        this.nick = nick;
        return this;
    }

    public int getPoint() {
        return point;
    }
    public Member setPoint(int point) {
        this.point = point;
        return this;
    }
}
