package beverage_order_kiosk_ver2.kiosk.command;

import beverage_order_kiosk_ver2.kiosk.data.beverageInfo.BeverageInfo;
import java.util.Map;
import java.util.Scanner;

public class CommandFunctions {
    public boolean isNumber(String request){
        boolean isNum = false;
        try{
            Integer.parseInt(request);
            isNum = true;
        } catch (NumberFormatException ignored){ }
        return isNum;
    }

    //반복문 돌면서 취소여부 물어보기
    public boolean askOrderCancel(Scanner scan){
        System.out.println("\n주문을 취소하시겠습니까? (y/n): ");
        boolean wantToCancel = false;
        int count = 0;
        while( count<3 ){
            count++;
            System.out.print("입력 : ");
            String cancelAnswer = scan.next().trim().toLowerCase();

            if(!isYesOrNo(cancelAnswer)){
                System.out.println("y 혹은 n을 입력바랍니다");
                continue;
            }
            if(cancelAnswer.equals("y")){
                wantToCancel = true;
            }
            break;
        }
        return wantToCancel;
    }

    //y 혹은 n 입력 확인
    public boolean isYesOrNo(String request) {
        return request.equals("y") || request.equals("n");
    }

    //적절한 숫자 입력여부 확인
    public boolean checkInputRange(String input, int index){
        boolean inputCheck = false;
        if(isNumber(input)){
            int num = Integer.parseInt(input);
            //숫자가 범위에 해당하는지 확인
            if(0<num && num<index+1) {
                inputCheck = true;
            }
        }
        return inputCheck;
    }

    //단위변환
    public void check_beverageChoose(String input, int index){
        System.out.println("주문자가 선택한 정보 출력");
        System.out.println(input+ "을 선택하였습니다");
        int num = Integer.parseInt(input);
        String str = new UnitChange().toString_kind(num);
        System.out.printf("%s\n", str);
    }

    //주문메뉴 출력
    public void printMenu() {
        Map<String, Integer> menuMap = new BeverageInfo().getBeverageMap_kind();
        BeverageInfo.KIND[] beverages = BeverageInfo.KIND.values();

        String line     = "-------------------------";
        System.out.println(line);
        System.out.println("메뉴");

        String beverKind;
        int price;
        for(int i = 0; i< beverages.length; i++){
            beverKind = beverages[i].toString();
            price = menuMap.get(beverKind);
            System.out.printf(" %d. %s\t%d원\n", i+1, beverKind, price);
        }
        System.out.println(line);
    }


    //결제 정상여부 반환
    private boolean calculate(){
        return false;
    }
}
