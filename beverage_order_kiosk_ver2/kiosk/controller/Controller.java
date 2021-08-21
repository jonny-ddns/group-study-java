package beverage_order_kiosk_ver2.kiosk.controller;

import java.util.Scanner;

public interface Controller {
    public Controller getInstance();
    public int control(Scanner scan);
}
