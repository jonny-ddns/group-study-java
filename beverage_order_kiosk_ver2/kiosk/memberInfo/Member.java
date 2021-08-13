package beverage_order_kiosk_ver2.kiosk.memberInfo;

public class Member {
    private String name;
    private String nick;
    private String birthday;
    private String phone;

    public String getName() {
        return name;
    }
    public Member setName(String name) {
        this.name = name;
        return this;
    }

    public String getNick() {
        return nick;
    }
    public Member setNick(String nick) {
        this.nick = nick;
        return this;
    }

    public String getBirthday() {
        return birthday;
    }
    public Member setBirthday(String birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getPhone() {
        return phone;
    }
    public Member setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
