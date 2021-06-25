package study_management.data;

public class Student {	
	private String stuId;				//회원번호
	private String name;				//이름
	private int deposit;				//보증금
	private String joinDate;			//가입날짜
	private String studyDate;			//스터디날짜
	private String summarizeChapter;	//챕터정리
	private String task;				//과제수행
	private String attendanceMid;		//중간점검
	private String attendanceWeekly;	//일주일점검
	private int fine;					//벌금
	private int balance;				//잔액
	private String active;				//활동여부
	
	public String getStuId() {
		return stuId;
	}
	public Student setStuId(String stuId) {
		this.stuId = stuId;
		return this;
	}
	public String getName() {
		return name;
	}
	public Student setName(String name) {
		this.name = name;
		return this;
	}
	public int getDeposit() {
		return deposit;
	}
	public Student setDeposit(int deposit) {
		this.deposit = deposit;
		return this;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public Student setJoinDate(String joinDate) {
		this.joinDate = joinDate;
		return this;
	}
	public String getStudyDate() {
		return studyDate;
	}
	public Student setStudyDate(String studyDate) {
		this.studyDate = studyDate;
		return this;
	}
	public String getSummarizeChapter() {
		return summarizeChapter;
	}
	public Student setSummarizeChapter(String summarizeChapter) {
		this.summarizeChapter = summarizeChapter;
		return this;
	}
	public String getTask() {
		return task;
	}
	public Student setTask(String task) {
		this.task = task;
		return this;
	}
	public String getAttendanceMid() {
		return attendanceMid;
	}
	public Student setAttendanceMid(String attendanceMid) {
		this.attendanceMid = attendanceMid;
		return this;
	}
	public String getAttendanceWeekly() {
		return attendanceWeekly;
	}
	public Student setAttendanceWeekly(String attendanceWeekly) {
		this.attendanceWeekly = attendanceWeekly;
		return this;
	}
	public int getFine() {
		return fine;
	}
	public Student setFine(int fine) {
		this.fine = fine;
		return this;
	}
	public int getBalance() {
		return balance;
	}
	public Student setBalance(int balance) {
		this.balance = balance;
		return this;
	}
	public String getActive() {
		return active;
	}
	public Student setActive(String active) {
		this.active = active;
		return this;
	}
}
