package beverage_order_kiosk_ver2.kiosk.command.member_operation;

public class MemberFunction {
    //���ڰ��� �������� Ȯ���ϱ�
    public boolean isNumber(String inputNumber){
        boolean isNum = false;
        try{
            Integer.parseInt(inputNumber);
            isNum = true;
        } catch (NumberFormatException nfe){ }
        return isNum;
    }
}
