package beverage_order_kiosk_ver2.kiosk.command.member_operation;

import beverage_order_kiosk_ver2.kiosk.memberInfo.MemberCollection;
import java.util.Scanner;

public class MemberOperation_signIn implements MemberOperation {

    @Override
    public boolean execute(Scanner scan) {
        System.out.println("Operation_signIn");
        boolean goToNext = false;
        //회원 정보 가져오기
        MemberCollection memberCollection = MemberCollection.getInstance();
        memberCollection.checkMemberInList(name, phone);

        System.out.println("아이디를 입력하세요");
        System.out.println("-회원가입하려면 'q' 입력");
        System.out.println("-가입취소하려면 'c' 입력");
        System.out.println("\n입력 : ");

        String request = scan.next().trim().toLowerCase();
        //가입하기
        if(request.equals('q')) {


        }
        //취소하기
        if(request.equals('c')){


        }


        //아이디가 일치하는지 확인하기



        System.out.println("Operation_signIn");
        return goToNext;
    }
}