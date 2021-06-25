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
		
		System.out.println("\n<<��������>>");					
		System.out.print("[���Ե� ȸ������ Ȯ���մϴ�]\n-ȸ����ȣ �Է� : ");
		
		stuId = scan.next();
		stuId = stuId.trim();
		isMember = sData.study_isMember(stuId);
		
		if(!isMember) {
			System.out.println("[ȸ���� �ƴմϴ�]");
		} else {
			System.out.print("-���͵� ��¥ �Է� : ");
			studyDate = scan.next();
			
			yesOrNo = false;
			while(!yesOrNo) {
				System.out.print("-é�� ���� ����[y/n] : ");
				summarizeChapter = scan.next();
				if(sData.isYesOrNo(summarizeChapter)){
					yesOrNo = true;
				} else {
					enter_yesOrNo();
				}
			}
			
			yesOrNo = false;
			while(!yesOrNo) {
				System.out.print("-���� ���࿩�� �Է�[y/n] : ");
				task = scan.next();
				if(sData.isYesOrNo(task)){
					yesOrNo = true;
				} else {
					enter_yesOrNo();
				}
			}
			
			yesOrNo = false;
			while(!yesOrNo) {
				System.out.print("-�߰����� ��������[y/n] : ");
				attendanceMid = scan.next();
				if(sData.isYesOrNo(attendanceMid)){
					yesOrNo = true;
				} else {
					enter_yesOrNo();
				}
			}
			
			yesOrNo = false;
			while(!yesOrNo) {
				System.out.print("-1�������� ��������[y/n] : ");
				attendanceWeekly = scan.next();
				if(sData.isYesOrNo(attendanceWeekly)){
					yesOrNo = true;
				} else {
					enter_yesOrNo();
				}
			}
			
			System.out.print("\n-������ �����Ͻðڽ��ϱ�[y/n] : ");
			if(scan.next().trim().toLowerCase().equals("y")){
				sData.study_editInfo(stuId, studyDate, summarizeChapter, task, attendanceMid, attendanceWeekly);
			} else {
				System.out.println("[���͵� ���������� ����մϴ�]");
			}
		}
	}
	
	void enter_yesOrNo() {
		System.out.println("[y Ȥ�� n�� �Է¹ٶ��ϴ�]");
	}
}
