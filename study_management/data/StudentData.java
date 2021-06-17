package study_management.data;

import java.util.ArrayList;
import java.util.List;

public class StudentData {
	
	//�ܺο��� ���� ������ �� ������ �̱��� ���� ���
	private static StudentData studentData;
	private static List<Student> studentList = new ArrayList<>();
	
	private StudentData() {
	}
	
	public static StudentData getInstance() {
		if(studentData == null) {
			studentData = new StudentData();
		}
		return studentData;
	}
	
	public static List<Student> getStudentList(){
		if(studentList == null) {
			studentList = new ArrayList<Student>();
		}
		return studentList;
	}	
	
	
	/*---------------------------------------------
				studentList�� �����ϴ� �޼ҵ�
	---------------------------------------------*/
	//������ ��ϵ� ������� Ȯ��
	public boolean study_isMember(String stuId) {
		boolean isMember = false;		
		for(Student st : studentList) {
			if(st.getStuId().equals(stuId)) {
				isMember = true;
				break;	
			}
		}
		return isMember;
	}
	
	//stuId�� �޾� ����Ʈ���� Student ���� ��������
	public Student study_getMember(String stuId) {
		Student student = null;
		for(int i=0; i<studentList.size(); i++) {			
			if(studentList.get(i).getStuId().equals(stuId)) {
				student = studentList.get(i);
			}
		}
		return student;
	}
	
	//���ο� ����� ����Ʈ�� ���
	public void study_newStudent(String stuId, String name, int deposit, String joinDate) {
		Student student = new Student();
		student.setStuId(stuId)
			   .setName(name)
			   .setDeposit(deposit)
			   .setJoinDate(joinDate)
			   .setStudyDate("-")
			   .setSummarizeChapter("")
			   .setTask("")
			   .setAttendanceMid("")
			   .setAttendanceWeekly("")
			   .setFine(0)
			   .setBalance(deposit)
			   .setActive("y");
		studentList.add(student);
		
		System.out.println("[���͵� �űԵ�� �Ϸ�]");	
	}
	
	//���͵� �����Է� ���� ������ ��ϵ� ������ �ִ��� Ȯ���ϱ�
	public boolean study_isInserted(String stuId) {
		boolean inserted = false;
		for(Student student : studentList) {
			if(student.getStuId().equals(stuId) && student.getStudyDate() != "-"){
				inserted = true;
			}
		}
		return inserted;
	}
	
	//���͵� �����Է�
	//ȸ����ȣ, ���͵�¥, é������, ��������, �߰�����, ����������
	public void study_insertInfo(String stuId, String studyDate,String summarizeChapter,
			String task, String attendanceMid, String attendanceWeekly) {		
		
		Student student = null;		
		
		for(int i=0; i<studentList.size(); i++) {
			student = studentList.get(i);
			if(student.getStuId().equals(stuId)) {
				int deposit = student.getDeposit();
				int count = 0;

				//é������, ��������, �߰�����, ���������� 4���� �׸� �� �ǽõ��� �ʾ����� �������� �����ϴ� �ڵ�
				if(summarizeChapter.trim().toLowerCase().equals("n"))	count++;
				if(task.trim().toLowerCase().equals("n"))				count++;
				if(attendanceMid.trim().toLowerCase().equals("n"))		count++;
				if(attendanceWeekly.trim().toLowerCase().equals("n"))	count++;

				student.setStudyDate(studyDate)
					   .setSummarizeChapter(summarizeChapter)
					   .setTask(task)
					   .setAttendanceMid(attendanceMid)
					   .setAttendanceWeekly(attendanceWeekly)
					   .setFine(2500*count)
					   .setBalance(deposit - 2500*count);			//������ �������� �ܾ׿� �ݿ��ϱ�
			}
		}
		System.out.println("[���͵� �����Է� �Ϸ�]");
	}
	
	//���͵� ���� ����
	public void study_editInfo(String stuId, String studyDate, String summarizeChapter, String task,
			String attendanceMid, String attendanceWeekly) {
		Student student = null;	
		
		for(int i=0; i<studentList.size(); i++) {
			student = studentList.get(i);
			if(student.getStuId().equals(stuId)) {
				int deposit = student.getDeposit();
				int count = 0;
				
				if(summarizeChapter.trim().toLowerCase().equals("n"))	count++;
				if(task.trim().toLowerCase().equals("n"))				count++;
				if(attendanceMid.trim().toLowerCase().equals("n"))		count++;
				if(attendanceWeekly.trim().toLowerCase().equals("n"))	count++;
				
				student.setStudyDate(studyDate.trim().toLowerCase())
					   .setSummarizeChapter(summarizeChapter.trim().toLowerCase())
					   .setTask(task.trim().toLowerCase())
					   .setAttendanceMid(attendanceMid.trim().toLowerCase())
					   .setAttendanceWeekly(attendanceWeekly.trim().toLowerCase())
					   .setFine(2500*count)
					   .setBalance(deposit - 2500*count);
				studentList.set(i, student);	
			}
		}
		System.out.println("[���͵� �������� �Ϸ�]");
	}
	
	//���͵� Ż��. stuId�� �޾� active �׸��� 'n'���� �����ϱ�
	public void study_quit(String stuId) {	
		for(Student stu : studentList) {
			if(stu.getStuId().equals(stuId)) {
				stu.setActive("n");
			}
		}
		System.out.println("[���͵� Ż��ó�� �Ϸ�]");
	}
	
	//��ü ȸ�� ������ �������� -�����Ȳ
	public List<Student> study_getAll() {
		List<Student> board = studentList;
		return board;
	}

	/*----------------------------------------*/
	//�Էµ� ���� �ҹ��ڰ� y, n���� Ȯ���ϴ� �ڵ�
	public boolean isYesOrNo(String check) {
		boolean isProper = false; 
		check = check.trim().toLowerCase();
		if(check.equals("y") || check.equals("n")) {
			isProper = true; 
		}
		return isProper;
	}
}
