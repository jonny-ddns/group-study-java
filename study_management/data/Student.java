package study_management.data;

public class Student {	
	private String stuId;				//ȸ����ȣ
	private String name;				//�̸�
	private int deposit;				//������
	private String joinDate;			//���Գ�¥
	private String studyDate;			//���͵�¥
	private String summarizeChapter;	//é������
	private String task;				//��������
	private String attendanceMid;		//�߰�����
	private String attendanceWeekly;	//����������
	private int fine;					//����
	private int balance;				//�ܾ�
	private String active;				//Ȱ������
	
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
