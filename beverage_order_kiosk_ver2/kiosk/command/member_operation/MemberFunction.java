package beverage_order_kiosk_ver2.kiosk.command.member_operation;

public class MemberFunction {
    //인자값이 숫자인지 확인하기
    public boolean isNumber(String inputNumber){
        boolean isNum = false;
        try{
            Integer.parseInt(inputNumber);
            isNum = true;
        } catch (NumberFormatException nfe){ }
        return isNum;
    }
}
