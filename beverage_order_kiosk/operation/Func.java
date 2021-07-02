package beverage_order_kiosk.operation;

public class Func {
    //입력값이 숫자인지 확인하기
    static boolean isNumber(String request){
        boolean isNum = false;
        try{
        	Integer.parseInt(request);
            isNum = true;
        } catch (NumberFormatException nfe){
            nfe.getMessage();
        } catch (Exception e){
            e.getMessage();
        }
        return isNum;
    }
}
