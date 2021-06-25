package study_management.service;

import java.util.Scanner;
import study_management.data.StudentData;

public class Study3_editInfo implements StudyManage {
	@Override
	public void manage() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		StudentData sData = StudentData.getInstance();
		
		String stuId = "";
		String studyDate = "";	
		String summarizeChapter = "";
		String task = "";
		String attendanceMid = "";
		String attendanceWeekly = "";
		
		boolean isMember;
		boolean yesOrNo;		
		
		System.out.println("\n<<정보수정>>");					
		System.out.print("[가입된 회원인지 확인합니다]\n-회원번호 입력 : ");
		
		stuId = scan.next();
		stuId = stuId.trim();
		isMember = sData.study_isMember(stuId);
		
		if(!isMember) {
			System.out.println("[회원이 아닙니다]");
		} else {
			System.out.print("-스터디 날짜 입력 : ");
			studyDate = scan.next();
			
			yesOrNo = false;
			while(!yesOrNo) {
				System.out.print("-챕터 정리 여부[y/n] : ");
				summarizeChapter = scan.next();
				if(sData.isYesOrNo(summarizeChapter)){
					yesOrNo = true;
				} else {
					enter_yesOrNo();
				}
			}
			
			yesOrNo = false;
			while(!yesOrNo) {
				System.out.print("-과제 수행여부 입력[y/n] : ");
				task = scan.next();
				if(sData.isYesOrNo(task)){
					yesOrNo = true;
				} else {
					enter_yesOrNo();
				}
			}
			
			yesOrNo = false;
			while(!yesOrNo) {
				System.out.print("-중간점검 참석여부[y/n] : ");
				attendanceMid = scan.next();
				if(sData.isYesOrNo(attendanceMid)){
					yesOrNo = true;
				} else {
					enter_yesOrNo();
				}
			}
			
			yesOrNo = false;
			while(!yesOrNo) {
				System.out.print("-1주일점검 참석여부[y/n] : ");
				attendanceWeekly = scan.next();
				if(sData.isYesOrNo(attendanceWeekly)){
					yesOrNo = true;
				} else {
					enter_yesOrNo();
				}
			}
			
			System.out.print("\n-정말로 수정하시겠습니까[y/n] : ");
			if(scan.next().trim().toLowerCase().equals("y")){
				sData.study_editInfo(stuId, studyDate, summarizeChapter, task, attendanceMid, attendanceWeekly);
			} else {
				System.out.println("[스터디 정보수정을 취소합니다]");
			}
		}
	}
	
	void enter_yesOrNo() {
		System.out.println("[y 혹은 n을 입력바랍니다]");
	}
}
