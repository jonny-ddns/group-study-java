package study_management.service;

import java.util.Scanner;
import study_management.data.Student;
import study_management.data.StudentData;

/*
 * @SuppressWarnings("resource")
 * Scanner �� �������� �ʾƼ� resource leak �߻���
 * .close() ȣ��� ����� ��Ʈ���� �ݾ� main�޼��忡�� ������ �Ұ����ϴ�
 * Study_application - switch������ {}����� �����Ͽ� ��ü�� �ݾ���
 */
public class Study1_join implements StudyManage {
	@Override
	public void manage() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		StudentData sData = StudentData.getInstance();
		
		System.out.println("\n<<���͵� ����>>");
		System.out.print("���Ե� ȸ����ȣ Ȯ�� : ");
		String stuId = scan.next().trim();

		boolean isMember = sData.study_isMember(stuId);
		
		if(isMember) {
			//ȸ����ȣ, �̸�, ������, ���Գ�¥
			Student student = new Student();
			student = sData.study_getMember(stuId);
			System.out.println("-ȸ����ȣ : "+ student.getStuId());
			System.out.println("-ȸ���̸� : "+ student.getName());
			System.out.println("-������ : "+ student.getDeposit());
			System.out.println("-���Գ�¥ : "+ student.getJoinDate());
		}
		else if(!isMember) {
			System.out.print("\n[ȸ���� �ƴմϴ�]\nȸ�� ����ϱ�[y/n] : ");
			
			String answer = scan.next();
			
			if(!answer.trim().toLowerCase().equals("y")) {
				System.out.println("\n[ȸ�� ��� ���]");
			} else {				
				boolean isStuId_unique = false;
				while(!isStuId_unique) {
					System.out.print("\n-ȸ����ȣ �Է� : ");
					stuId = scan.next().trim();

					if(sData.study_isMember(stuId)) {
						System.out.println("[�̹� ��ϵ� ȸ����ȣ�Դϴ�]");
					} else {
						isStuId_unique = true;
					}
				}
				
				System.out.print("-�̸� �Է� : ");
				scan.nextLine();
				String name = scan.nextLine().trim();				
	
				boolean isDepositOk = false;
				int deposit = 0;
				
				while(!isDepositOk) {					
					try {
						System.out.print("-������ �Է� : ");
						deposit = Integer.parseInt(scan.nextLine().trim());	
						if(deposit < 10000) {
							System.out.println("[�������� �ּ� 10000���Դϴ�]");
						} else {
							isDepositOk = true;
						}
					} catch (Exception e) {
						System.out.println("[���ڸ� �Է¹ٶ��ϴ�]");
					}
				}
				System.out.print("-���Գ�¥ �Է� : ");
				String joinDate = scan.next().trim();
				
				sData.study_newStudent(stuId, name, deposit, joinDate);
			}
		}
	}
}
