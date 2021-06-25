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
		
		System.out.println("\n<<���͵� Ż��>>");					
		System.out.print("-ȸ����ȣ �Է� : ");
		stuId = scan.next();
		stuId = stuId.trim();
		
		if(!sData.study_isMember(stuId)) {
			System.out.println("[�ش� ȸ���� ã�� �� �����ϴ�]");
		} else {
			System.out.print("���͵� Ż��ó�� �Ͻðڽ��ϱ�[y/n] : ");				
			
			String answer = scan.next();
			if(answer.trim().toLowerCase().equals("y")) {
				sData.study_quit(stuId);
			}
		}		
	}
}
