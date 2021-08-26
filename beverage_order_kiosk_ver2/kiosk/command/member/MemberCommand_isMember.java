package beverage_order_kiosk_ver2.kiosk.command.member_command;

import beverage_order_kiosk_ver2.kiosk.command.CommandFunctions;

import java.util.Scanner;

//주문방식 결정하기 - 회원/비회원
/*
#리턴
0 취소
1 회원
2 비회원
 */
public class MemberCommand_isMember implements MemberCommand {
    CommandFunctions commandFunctions;

    @Override
    public int execute(Scanner scan) {
        String scanInput;
        int stepParameter = 2;
        int count = 0;
        boolean isOk = false;

        printWelcomeMent();

        while(!isOk){
            //횟수 제한
            count++;
            if( count>3 ){
                System.out.println("처음부터 다시 시도해주시기 바랍니다");
                stepParameter = 3;
                break;
            }

            System.out.print("\n입력: ");
            scanInput = scan.next().trim();

            //입력한 번호 검증하기
            commandFunctions = new CommandFunctions();
            if(!commandFunctions.isNumber(scanInput)){
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
        return stepParameter;
    }

    private void printWelcomeMent(){
        System.out.println("안녕하세요. 음료주문 키오스크입니다\n주문방식을 선택해주세요\n");
        System.out.println("1. 회원으로 주문");
        System.out.println("2. 비회원으로 주문");
    }
}
