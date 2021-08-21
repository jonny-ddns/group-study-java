package beverage_order_kiosk_ver2.kiosk.command;

public class CommandFunctions {
    //���ڰ��� �������� Ȯ���ϱ�
    public boolean isNumber(String inputNumber){
        boolean isNum = false;
        try{
            Integer.parseInt(inputNumber);
            isNum = true;
        } catch (NumberFormatException ignored){ }
        return isNum;
    }

    //�Է°��� y||n ���� Ȯ��
    public boolean isYesOrNo(String request) {
        return request.equals("y") || request.equals("n");
    }
}
