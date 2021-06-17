package study_management.service;

import java.util.List;
import study_management.data.Student;
import study_management.data.StudentData;

public class Study6_overView implements StudyManage{
	@Override
	public void manage() {		
		StringBuilder sb = new StringBuilder();	
		StudentData sData = StudentData.getInstance();
		List<Student> board = sData.study_getAll();
		
		int deposit_sum = 0;
		int fine_sum = 0;
		int balance_sum = 0;
		
		sb.append("\n=============================================================================================\n");
		sb.append("\t\t\t\t\t���͵� ����\t\t\t\t\t\n");
		sb.append("=============================================================================================\n");
		sb.append("ȸ����ȣ\tȸ���̸�\t������\t���Գ�¥\t���͵�¥\té������\t��������\t�߰�����\t1��������\t����\t�ܾ�\tŻ�𿩺�\n");
		sb.append("---------------------------------------------------------------------------------------------\n");
		
		for(Student stu : board) {
			//������, ����, �ܾ�
			int deposit = stu.getDeposit();
			int fine = stu.getFine();
			int balance = stu.getBalance();	
			
			sb.append(stu.getStuId());
			sb.append("\t");
			sb.append(stu.getName());
			sb.append("\t");
			sb.append(deposit);
			sb.append("\t");
			sb.append(stu.getJoinDate());
			sb.append("\t");
			sb.append(stu.getStudyDate());
			sb.append("\t");
			sb.append(stu.getSummarizeChapter());
			sb.append("\t");
			sb.append(stu.getTask());
			sb.append("\t");
			sb.append(stu.getAttendanceMid());
			sb.append("\t");
			sb.append(stu.getAttendanceWeekly());
			sb.append("\t");
			sb.append(fine);
			sb.append("\t");
			sb.append(balance);
			sb.append("\t");
			
			//Ż���� ȸ���� ���� Ż��ǥ�ð� �߰���
			String nonActice = "";
			if(stu.getActive() == "n") {
				nonActice = "Ż��";
			}
			
			sb.append(nonActice);
			sb.append("\n");		
			
			deposit_sum += deposit;
			fine_sum += fine;
			balance_sum += balance;
		}		
		sb.append("---------------------------------------------------------------------------------------------");
		sb.append("\n\t\t\t");
		sb.append("�� ������ "+ deposit_sum);
		sb.append("\t");
		sb.append("�� ���� "+ fine_sum);
		sb.append("\t");
		sb.append("�� �ܾ� "+ balance_sum);
		sb.append("\n");
		sb.append("=============================================================================================\n");
		
		System.out.println(sb.toString());
		sb.setLength(0);	
	}
}
