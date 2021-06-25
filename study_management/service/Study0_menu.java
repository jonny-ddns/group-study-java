package study_management.service;

public class Study0_menu implements StudyManage {
	@Override
	public void manage() {	
		StringBuilder sb = new StringBuilder();		
		sb.append("\n==================="+ "\n");
		sb.append("메뉴(0)"+ "\n");
		sb.append("  1. 스터디 가입\n");
		sb.append("  2. 정보 입력\n");
		sb.append("  3. 정보 수정\n");
		sb.append("  4. 스터디 탈퇴\n");
		sb.append("  5. 벌금 현황\n");
		sb.append("  6. 스터디 관리내용\n");
		sb.append("  7. 서비스 종료\n");		
		sb.append("===================\n");
		System.out.print(sb.toString());
		sb.setLength(0);		
	}
}
