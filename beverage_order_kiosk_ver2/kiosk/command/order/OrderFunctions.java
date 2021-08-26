package beverage_order_kiosk_ver2.kiosk.command.order_command;

import beverage_order_kiosk_ver2.kiosk.command.UnitChange;
import beverage_order_kiosk_ver2.kiosk.data.beverageInfo.BeverageInfo;
import java.util.Map;
import java.util.Scanner;

public class OrderFunctions {
    public boolean isNumber(String request){
        boolean isNum = false;
        try{
            Integer.parseInt(request);
            isNum = true;
        } catch (NumberFormatException ignored){ }
        return isNum;
    }

    //�ݺ��� ���鼭 ��ҿ��� �����
    public boolean askOrderCancel(Scanner scan){
        System.out.println("\n�ֹ��� ����Ͻðڽ��ϱ�? (y/n): ");
        boolean wantToCancel = false;
        int count = 0;
        while( count<3 ){
            count++;
            System.out.print("�Է� : ");
            String cancelAnswer = scan.next().trim().toLowerCase();

            if(!isYesOrNo(cancelAnswer)){
                System.out.println("y Ȥ�� n�� �Է¹ٶ��ϴ�");
                continue;
            }
            if(cancelAnswer.equals("y")){
                wantToCancel = true;
            }
            break;
        }
        return wantToCancel;
    }

    //y Ȥ�� n �Է� Ȯ��
    public boolean isYesOrNo(String request) {
        return request.equals("y") || request.equals("n");
    }

    //������ ���� �Է¿��� Ȯ��
    public boolean checkInputRange(String input, int index){
        boolean inputCheck = false;
        if(isNumber(input)){
            int num = Integer.parseInt(input);
            //���ڰ� ������ �ش��ϴ��� Ȯ��
            if(0<num && num<index+1) {
                inputCheck = true;
            }
        }
        return inputCheck;
    }

    //������ȯ
    public void check_beverageChoose(String input, int index){
        System.out.println("�ֹ��ڰ� ������ ���� ���");
        System.out.println(input+ "�� �����Ͽ����ϴ�");
        int num = Integer.parseInt(input);
        String str = new UnitChange().toString_kind(num);
        System.out.printf("%s\n", str);
    }

    //�޴� ���
    public void printMenu() {
        Map<String, Integer> menuMap = new BeverageInfo().getBeverageMap();
        BeverageInfo.KIND[] beverages = BeverageInfo.KIND.values();

        String line     = "-------------------------";
        System.out.println(line);
        System.out.println("�޴�");

        String beverKind;
        int price;
        for(int i = 0; i< beverages.length; i++){
            beverKind = beverages[i].toString();
            price = menuMap.get(beverKind);
            System.out.printf(" %d. %s\t%d��\n", i+1, beverKind, price);
        }
        System.out.println(line);
    }
}
