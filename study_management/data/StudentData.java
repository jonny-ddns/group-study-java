package study_management.data;

import java.util.ArrayList;
import java.util.List;

public class StudentData {
	
	//외부에서 직접 변경할 수 없도록 싱글톤 패턴 사용
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
				studentList에 접근하는 메소드
	---------------------------------------------*/
	//기존에 등록된 멤버인지 확인
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
	
	//stuId를 받아 리스트에서 Student 값을 가져오기
	public Student study_getMember(String stuId) {
		Student student = null;
		for(int i=0; i<studentList.size(); i++) {			
			if(studentList.get(i).getStuId().equals(stuId)) {
				student = studentList.get(i);
			}
		}
		return student;
	}
	
	//새로운 멤버를 리스트에 등록
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
		
		System.out.println("[스터디 신규등록 완료]");	
	}
	
	//스터디 정보입력 전에 기존에 등록된 내용이 있는지 확인하기
	public boolean study_isInserted(String stuId) {
		boolean inserted = false;
		for(Student student : studentList) {
			if(student.getStuId().equals(stuId) && student.getStudyDate() != "-"){
				inserted = true;
			}
		}
		return inserted;
	}
	
	//스터디 정보입력
	//회원번호, 스터디날짜, 챕터정리, 과제수행, 중간점검, 일주일점검
	public void study_insertInfo(String stuId, String studyDate,String summarizeChapter,
			String task, String attendanceMid, String attendanceWeekly) {		
		
		Student student = null;		
		
		for(int i=0; i<studentList.size(); i++) {
			student = studentList.get(i);
			if(student.getStuId().equals(stuId)) {
				int deposit = student.getDeposit();
				int count = 0;

				//챕터정리, 과제수행, 중간점검, 일주일점검 4가지 항목 중 실시되지 않았을때 보증금을 차감하는 코드
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
					   .setBalance(deposit - 2500*count);			//차감된 보증금을 잔액에 반영하기
			}
		}
		System.out.println("[스터디 정보입력 완료]");
	}
	
	//스터디 정보 수정
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
		System.out.println("[스터디 정보수정 완료]");
	}
	
	//스터디 탈퇴. stuId를 받아 active 항목값을 'n'으로 변경하기
	public void study_quit(String stuId) {	
		for(Student stu : studentList) {
			if(stu.getStuId().equals(stuId)) {
				stu.setActive("n");
			}
		}
		System.out.println("[스터디 탈퇴처리 완료]");
	}
	
	//전체 회원 데이터 가져오기 -멤버현황
	public List<Student> study_getAll() {
		List<Student> board = studentList;
		return board;
	}

	/*----------------------------------------*/
	//입력된 값의 소문자가 y, n인지 확인하는 코드
	public boolean isYesOrNo(String check) {
		boolean isProper = false; 
		check = check.trim().toLowerCase();
		if(check.equals("y") || check.equals("n")) {
			isProper = true; 
		}
		return isProper;
	}
}
