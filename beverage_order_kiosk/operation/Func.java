package beverage_order_kiosk.operation;

public class Func {
    //�Է°��� �������� Ȯ���ϱ�
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
