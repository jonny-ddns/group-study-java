package beverage_order_kiosk_ver2.kiosk.command.member_operation;

import java.util.Scanner;

//회원인지 확인하기
public class MemberOperation_orderWay implements MemberOperation {
    @Override
    public boolean execute(Scanner scan) {
        System.out.println("Operation_orderWay");
        boolean isMember = false;
        boolean inputcheck = false;
        String inputNumber;

        System.out.println("1. 회원으로 주문");
        System.out.println("2. 비회원으로 주문");
        System.out.print("\n입력: ");

        while(!inputcheck){
            inputNumber = scan.next().trim();

            //입력한 번호 검증하기
            if(!isNumber(inputNumber)){
                System.out.println("숫자를 입력해주세요");
                continue;
            } if(!(inputNumber.equals("1") || inputNumber.equals("2"))){
                System.out.println("1 혹은 2를 입력하세요");
                continue;
            }

            if(Integer.parseInt(inputNumber) == 1){
                isMember = true;
            }
        }
        System.out.println("Operation_orderWay end");
        return isMember;
    }

    //인자값이 숫자인지 확인하기
    private boolean isNumber(String inputNumber){
        boolean isNum = false;
        try{
            Integer.parseInt(inputNumber);
            isNum = true;
        } catch (NumberFormatException nfe){ }
        return isNum;
    }
}
