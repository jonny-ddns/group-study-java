package study_management.service;

import java.util.Scanner;
import study_management.data.Student;
import study_management.data.StudentData;

/*
 * @SuppressWarnings("resource")
 * Scanner 를 종료하지 않아서 resource leak 발생함
 * .close() 호출시 사용한 스트림을 닫아 main메서드에서 재사용이 불가능하다
 * Study_application - switch문에서 {}블록을 도입하여 객체를 닫아줌
 */
public class Study1_join implements StudyManage {
	@Override
	public void manage() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		StudentData sData = StudentData.getInstance();
		
		System.out.println("\n<<스터디 가입>>");
		System.out.print("가입된 회원번호 확인 : ");
		String stuId = scan.next().trim();

		boolean isMember = sData.study_isMember(stuId);
		
		if(isMember) {
			//회원번호, 이름, 보증금, 가입날짜
			Student student = new Student();
			student = sData.study_getMember(stuId);
			System.out.println("-회원번호 : "+ student.getStuId());
			System.out.println("-회원이름 : "+ student.getName());
			System.out.println("-보증금 : "+ student.getDeposit());
			System.out.println("-가입날짜 : "+ student.getJoinDate());
		}
		else if(!isMember) {
			System.out.print("\n[회원이 아닙니다]\n회원 등록하기[y/n] : ");
			
			String answer = scan.next();
			
			if(!answer.trim().toLowerCase().equals("y")) {
				System.out.println("\n[회원 등록 취소]");
			} else {				
				boolean isStuId_unique = false;
				while(!isStuId_unique) {
					System.out.print("\n-회원번호 입력 : ");
					stuId = scan.next().trim();

					if(sData.study_isMember(stuId)) {
						System.out.println("[이미 등록된 회원번호입니다]");
					} else {
						isStuId_unique = true;
					}
				}
				
				System.out.print("-이름 입력 : ");
				scan.nextLine();
				String name = scan.nextLine().trim();				
	
				boolean isDepositOk = false;
				int deposit = 0;
				
				while(!isDepositOk) {					
					try {
						System.out.print("-보증금 입력 : ");
						deposit = Integer.parseInt(scan.nextLine().trim());	
						if(deposit < 10000) {
							System.out.println("[보증금은 최소 10000원입니다]");
						} else {
							isDepositOk = true;
						}
					} catch (Exception e) {
						System.out.println("[숫자를 입력바랍니다]");
					}
				}
				System.out.print("-가입날짜 입력 : ");
				String joinDate = scan.next().trim();
				
				sData.study_newStudent(stuId, name, deposit, joinDate);
			}
		}
	}
}
