package study_management.application;

import java.util.Scanner;
import study_management.service.StudyManage;
import study_management.service.Study0_menu;
import study_management.service.Study1_join;
import study_management.service.Study2_insertInfo;
import study_management.service.Study3_editInfo;
import study_management.service.Study4_quit;
import study_management.service.Study5_fineStatus;
import study_management.service.Study6_overView;

public class Study_application {
	protected Study_application() {
		System.out.println("STUDY MANAGEMENT START!");
		
		StudyManage studymanage = new Study0_menu();
		studymanage.manage();

		appStart();
	}
	
	private void appStart() {
		boolean programRun	= true;		//flag 변수
		Scanner scan		= new Scanner(System.in);

		while(programRun) {					
			please_enterService();			
			
			//입력된 값이 0~7에 속하는 숫자인지 확인하는 코드
			//입력 오류시 경고메시지 출력되고 다시 반복
			int num = 8;
			try {
				num = Integer.parseInt(scan.next());
				if(num<0 || 7<num) {
					num = 8;
				}
			} catch (Exception e) { }				
			
			/*-----------------------------------------------------*/
			//Java - Enum을 사용하여 열거된 값만 switch 인자값으로 할당되도록 설정
			switch (App_button.values()[num]) {
			case MENU:			//메뉴 출력
			{
				StudyManage studymanage = new Study0_menu();
				studymanage.manage();
			}					
				break;
				
			case JOIN:			//스터디 가입					
			{
					StudyManage studymanage = new Study1_join();
					studymanage.manage();
			}
				break;
				
			case INSERT_INFO: 	//정보 입력
			{
					StudyManage studymanage = new Study2_insertInfo();
					studymanage.manage();
			}
				break;
				
			case EDIT_INFO:		//정보 수정
			{
					StudyManage studymanage = new Study3_editInfo();
					studymanage.manage();
			}				
				break;
			
			case QUIT:			//스터디 탈퇴
			{
				StudyManage studymanage = new Study4_quit();
				studymanage.manage();
			}				
				break;
			
			case FINE_STATUS:	//벌금 현황
			{
				StudyManage studymanage = new Study5_fineStatus();
				studymanage.manage();
			}
				break;

			case OVER_VIEW:		//스터디 괸리
			{
				StudyManage studymanage = new Study6_overView();
				studymanage.manage();
			}
				break;	
				
			case PROGRAM_FINISH: //프로그램 종료
				System.out.println("STUDY MANAGEMENT FINISH!");
				programRun = false;
				System.exit(0);		
				break;
				
			case ERROR:	//에러 잡는코드
				System.out.println("[0부터 7사이의 숫자를 입력해주세요]");
			}			
		}
		scan.close();
	}
			
	private void please_enterService() {
		System.out.print("\n서비스 입력>>");
	}
}