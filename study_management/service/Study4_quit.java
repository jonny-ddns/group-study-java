package study_management.service;

import java.util.Scanner;
import study_management.data.StudentData;

public class Study4_quit implements StudyManage {
	@Override
	public void manage() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		StudentData sData = StudentData.getInstance();
		
		String stuId;
		
		System.out.println("\n<<스터디 탈퇴>>");					
		System.out.print("-회원번호 입력 : ");
		stuId = scan.next();
		stuId = stuId.trim();
		
		if(!sData.study_isMember(stuId)) {
			System.out.println("[해당 회원을 찾을 수 없습니다]");
		} else {
			System.out.print("스터디 탈퇴처리 하시겠습니까[y/n] : ");				
			
			String answer = scan.next();
			if(answer.trim().toLowerCase().equals("y")) {
				sData.study_quit(stuId);
			}
		}		
	}
}
