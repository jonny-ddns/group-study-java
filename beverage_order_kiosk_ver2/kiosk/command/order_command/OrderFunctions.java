package beverage_order_kiosk_ver2.kiosk.command.order_command;

public class OrderFunctions {
    public boolean isNumber(String request){
        boolean isNum = false;
        try{
            Integer.parseInt(request);
            isNum = true;
        } catch (NumberFormatException ignored){ }
        return isNum;
    }

    public boolean isYesOrNo(String request) {
        return request.equals("y") || request.equals("n");
    }
}
