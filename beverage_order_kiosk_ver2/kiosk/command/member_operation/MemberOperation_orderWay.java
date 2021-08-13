package beverage_order_kiosk_ver2.kiosk.command.member_operation;

import java.util.Scanner;

//주문방식 결정하기 - 회원/비회원
public class MemberOperation_orderWay implements MemberOperation {
    @Override
    public int execute(Scanner scan) {
        int stepParameter = 2;

        System.out.println("Operation_orderWay");
        boolean isOk = false;
        String scanInput;

        System.out.println("1. 회원으로 주문");
        System.out.println("2. 비회원으로 주문");


        int count = 0;
        while(!isOk){
            //횟수 제한
            count++;
            if( count>5 ){
                System.out.println("다시 시도해주시기 바랍니다");
                stepParameter = 3;
                break;
            }

            System.out.print("\n입력: ");
            scanInput = scan.next().trim();

            //입력한 번호 검증하기
            MemberFunction f = new MemberFunction();
            if(!f.isNumber(scanInput)){
                System.out.println("숫자를 입력해주세요");
                continue;
            } if(!(scanInput.equals("1") || scanInput.equals("2"))){
                System.out.println("1 혹은 2를 입력하세요");
                continue;
            }
            //회원주문시 리턴 1
            //비회원주문시 리턴 2
            if(Integer.parseInt(scanInput) == 1){
                stepParameter = 1;
            }
            isOk = true;
        }
        System.out.println("Operation_orderWay end");
        return stepParameter;
    }


}
