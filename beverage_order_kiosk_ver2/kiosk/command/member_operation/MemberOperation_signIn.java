package beverage_order_kiosk_ver2.kiosk.command.member_operation;

import beverage_order_kiosk_ver2.kiosk.memberInfo.Member;
import beverage_order_kiosk_ver2.kiosk.memberInfo.MemberCollection;
import java.util.Scanner;

//회원 로그인 처리하기
/*
#리턴
0 취소
1 로그인
2 가입
 */
public class MemberOperation_signIn implements MemberOperation {
    @Override
    public int execute(Scanner scan) {
        System.out.println("Operation_signIn");
        int stepParameter = 0;
        
        System.out.println("회원여부를 확인합니다");
        System.out.println("휴대폰 번호 8자리를 입력하세요");
        System.out.println("-회원가입하려면 'q' 입력");
        System.out.println("-가입취소하려면 'c' 입력");

        int count = 0;
        boolean isOk = false;
        while(!isOk){
            //횟수 제한
            count++;
            if( count>3 ){
                System.out.println("처음부터 다시 시도해주시기 바랍니다");
                stepParameter = 3;
                break;
            }

            System.out.print("\n입력 : ");
            String scanInput = scan.next().trim().toLowerCase();

            //회원가입 처리
            if(scanInput.equals("q")) {
                System.out.println("\n회원가입하시겠습니까 [y/n]");
                String inputSignup = scan.next().trim().toLowerCase();

                System.out.println("y 혹은 n 인지 확인하기");

                if(inputSignup.equals("y")){
                    System.out.println("회원가입 처리진행시켯");
                    stepParameter = 2;
                }
                break;
            }
            //취소 처리
            else if(scanInput.equals("c")){
                System.out.println("\n취소시켯");
                stepParameter = 3;
                break;
            }
            
            //리스트의 휴대전화 데이터와 비교하기
            //회원 정보 가져오기
            MemberCollection memberCollection = MemberCollection.getInstance();
            Member member = memberCollection.checkMemberInList(scanInput);

            //일치하는 회원정보가 없음
            if(member == null){
                System.out.println("일치하는 회원정보가 없습니다. 다시 입력해주세요");
//                continue;
            } else {
                System.out.printf("[%s]님 반갑습니다\n", member.getNick());
                
                isOk = true;
            }
        }
        System.out.println("Operation_signIn end");
        return stepParameter;
    }
}