package study_management.service;

import java.util.List;
import study_management.data.Student;
import study_management.data.StudentData;

public class Study5_fineStatus implements StudyManage{
	@Override
	public void manage() {
		StringBuilder sb = new StringBuilder();	
		StudentData sData = StudentData.getInstance();
		List<Student> board = sData.study_getAll();
		
		int sum = 0;
		int count = 0;
		
		sb.append("\n=============================\n");
		sb.append("\t���� ��Ȳ\n");
		sb.append("ȸ����ȣ");
		sb.append("\t");
		sb.append("ȸ���̸�");
		sb.append("\t");
		sb.append("���͵�¥");
		sb.append("\t");
		sb.append("����");
		sb.append("\n");
		//��ȣ, �̸�, ���͵�¥, ����
		sb.append("-----------------------------\n");
		for(Student stu : board) {
			if(stu.getFine() > 0 && stu.getActive() == "y") {
				sb.append(stu.getStuId());
				sb.append("\t");
				sb.append(stu.getName());
				sb.append("\t");
				sb.append(stu.getStudyDate());
				sb.append("\t");
				sb.append(stu.getFine());
				sb.append("\t");
				sb.append("\n");		
				
				count ++;
				sum += stu.getFine();
			}
		}
		sb.append("=============================\n");		
		sb.append("\t");
		sb.append("���ο� "+ count);
		sb.append("\t");
		sb.append("�ѹ��� "+ sum);
		
		System.out.println(sb.toString());
		sb.setLength(0);	
	}
}
