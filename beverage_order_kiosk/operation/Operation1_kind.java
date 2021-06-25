package beverage_order_kiosk.operation;

public class Operation1_kind implements Operation {
    @Override
    public void execute(String request) {
        System.out.println("ÀÔ·Â°ª : "+ request);
    }
}
