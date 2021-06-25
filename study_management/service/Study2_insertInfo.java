package study_management.service;

import java.util.Scanner;
import study_management.data.StudentData;

public class Study2_insertInfo implements StudyManage{
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
		
		System.out.println("\n<<정보입력>>");
		System.out.print("-회원번호 입력 : ");
		stuId = scan.next();
		stuId = stuId.trim();
		
		isMember = sData.study_isMember(stuId);
		if(!isMember) {
			System.out.println("[회원이 아닙니다]");
		}
		else {
			if(sData.study_isInserted(stuId)) {
				System.out.println("[스터디정보를 이미 입력하였습니다]");
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
					System.out.print("-중간점검 참석여부 [y/n] : ");
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
				sData.study_insertInfo(stuId, studyDate, summarizeChapter, task, attendanceMid, attendanceWeekly);
			}
		}		
	}
	
	void enter_yesOrNo() {
		System.out.println("[y 혹은 n을 입력바랍니다]");
	}
}
