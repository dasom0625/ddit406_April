package j_collection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import e_oop.ScanUtil;

public class Board {
	// --------------------------------------------------//
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "pc11";
	String password = "java";

	Connection con = null; // 자바와 오라클 연결
	PreparedStatement ps = null; // 쿼리 작성
	ResultSet rs = null; // 결과를 넣는 주머니
	// --------------------------------------------------//

	// HashMap 먼저 만들기
	HashMap<String, Object> row = new HashMap<String, Object>();
	// ArrayboardTable 만들기
	ArrayList<HashMap<String, Object>> boardTable = new ArrayList<HashMap<String, Object>>();

	public static void main(String[] args) {

		Board board = new Board();
		board.start();
	}

	//목록
	void start() {
		int number = 1;

		while (true) {
			System.out.println("===================================");
			System.out.println("No.\t제목\t작성자\t작성일");
			System.out.println("-----------------------------------");
			for (int i = boardTable.size() - 1; i >= 0; i--) {// 거꾸로 출력
				System.out.print(boardTable.get(i).get("번호"));
				System.out.print("\t" + boardTable.get(i).get("제목"));
				System.out.print("\t" + boardTable.get(i).get("작성자"));
				System.out.print("\t" + boardTable.get(i).get("작성일"));
				System.out.println();
				System.out.println("-----------------------------------");
			}

			System.out.print("1.조회\t2.등록\t0.종료");
			int input = ScanUtil.nextInt();

			switch (input) {
			case 1: // 조회
				System.out.println("조회할 게시물 번호>");
				int input1 = ScanUtil.nextInt();

				read(input1);

				break;
			case 2: // 등록
				insertrow(number);
				number++;
				boardTable.add(row);
				System.out.println("작성하신 게시글이 등록되었습니다.");
				break;
			case 0: // 종료
				System.out.println("게시판을 종료합니다.");
				System.exit(0);
				break;
			}
		}
	}

	//조회 후 수정,삭제,목록
	void seeDetail(int inputNo) {

		while (true) {
			System.out.println("1.수정\t2.삭제\t3.목록");
			int input = ScanUtil.nextInt();
			switch (input) {
			case 1: // 수정
				updaterow(inputNo);
				break;
			case 2: // 삭제
				removerow(inputNo);

			case 3: // 목록
				return;
			}
		}

	}

	//조회
	void read(int inputNo) {// 글 번호랑 인덱스랑 연관짓지 말기.
		for (int i = 0; i < boardTable.size(); i++) {
			if ((int) boardTable.get(i).get("번호") == inputNo) {

				System.out.println("제목 : " + boardTable.get(i).get("제목"));
				System.out.println("내용 : " + boardTable.get(i).get("내용"));
				System.out.println("작성자 : " + boardTable.get(i).get("작성자"));
				System.out.println("작성일 : " + boardTable.get(i).get("작성일"));
				seeDetail(inputNo);
				return;
			}
		}
		System.out.println("게시글이 존재하지 않습니다.");
	}

	//등록
	void insertrow(int number) {

		row = new HashMap<String, Object>();
		row.put("번호", number);
		System.out.print("제목 : ");
		String title = ScanUtil.nextLine();
		row.put("제목", title);
		System.out.print("내용 : ");
		String content = ScanUtil.nextLine();
		row.put("내용", content);
		System.out.print("작성자 : ");
		String name = ScanUtil.nextLine();
		row.put("작성자", name);
		row.put("작성일", new Date());

	}

	//수정
	//수정하고자 하는번호와 boardTable에 저장되어있는 인덱스번호와 일치하는지확인
	void updaterow(int inputNo) {
		for (int i = 0; i < boardTable.size(); i++) {
			if ((int) boardTable.get(i).get("번호") == inputNo) {

				System.out.println("글을 수정합니다.");
				System.out.print("제목 : ");
				String title = ScanUtil.nextLine();
				boardTable.get(i).put("제목", title);
				System.out.print("내용 : ");
				String content = ScanUtil.nextLine();
				boardTable.get(i).put("내용", content);
			}
		}
	}

	//삭제
	//삭제하고자 하는 번호와 boardTable에 저장되어 있는인덱스 번호와 일치하는지 확인
	void removerow(int inputNo) {
		System.out.println("글을 삭제합니다.");
		for (int i = 0; i < boardTable.size(); i++) {
			if ((int) boardTable.get(i).get("번호") == inputNo) {
				boardTable.remove(i);

			}
		}
	}
}
