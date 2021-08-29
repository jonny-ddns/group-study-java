package beverage_order_kiosk_ver2.kiosk.command;

import beverage_order_kiosk_ver2.kiosk.data.beverageInfo.OrderPriceMap;
import beverage_order_kiosk_ver2.kiosk.data.beverageInfo.enums.KIND;
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

    //주문메뉴 출력
    public void printMenu() {
        Map<String, Integer> beverageMapKind = new OrderPriceMap().getBeverageMapKind();
        KIND[] beverages = KIND.values();

        String line     = "-------------------------";
        System.out.println(line);
        System.out.println("메뉴");

        String beverKind;
        int price;
        for(int i = 0; i< beverages.length; i++){
            beverKind = beverages[i].toString();
            price = beverageMapKind.get(beverKind);
            System.out.printf(" %d. %s\t%d원\n", i+1, beverKind, price);
        }
        System.out.println(line);
    }

    //결제 정상여부 반환
    public boolean calculate(){
        return false;
    }

    public void paymentGuide(String way){
        System.out.println(way+ "결제를 선택하였습니다");
        System.out.println(way+" 넣어주세요");
    }

    public String getMonenyFromCustomer(Scanner scan){
        System.out.print("금액 : ");
        return scan.next().trim();
    }

    //잔액계산. 결제실패시 -1 리턴
    public int calculateBalance(int price, int receivedMoney){
        if(price <= receivedMoney){
            return receivedMoney - price;
        } else {
            return -1;
        }
    }
}
