package beverage_order_kiosk_ver2.kiosk.command;

public class Functions {
    //인자값이 숫자인지 확인하기
    public boolean isNumber(String inputNumber){
        boolean isNum = false;
        try{
            Integer.parseInt(inputNumber);
            isNum = true;
        } catch (NumberFormatException ignored){ }
        return isNum;
    }

    //입력값이 y||n 인지 확인
    public boolean isYesOrNo(String request) {
        return request.equals("y") || request.equals("n");
    }
}
