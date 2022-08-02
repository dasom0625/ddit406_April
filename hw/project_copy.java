public static void main(String[] args) {
	/*
	 * 발표일 10/27(수) 오후 => ppt 만들기(15분~20분)
	 * 발표순서 : 조 소개 > 주제 소개 > 주제 선정 배경 > 메뉴 구조 > 시연 > 프로젝트 후기
	 * 발표인원 : 발표자 1명, ppt 및 시연 도우미 1명
	 * 
	 * 웹 개발시 파트분배
	 * Controller : 화면 이동 - 어느 화면으로 이동할 것인가(메뉴구성)
	 * Service : 화면 기능 - 서비스라는 클래스에 실제 기능이 다 들어감
                             (여기서는 데이터베이스에 직접 접근하지 않음)
	 * Dao(data access object) : 쿼리 작성 
     - 화면에 기능을 만들면 데이터 조회,수정,등록을 해야하는 경우 발생, 그때 사용
	 * 중복될 수 있기 때문에 service와 dao를 나눔
	 * ex. 사용자의 정보를 조회하는 경우가 기능을 사용할 때 여러 번 있음.
	 */
	
	//회원가입, 로그인해서 게시판이용
	new Controller().start();
}

public static Map<String, Object> loginUser = null;

private UserService userService = UserService.getInstance();
private BoardService boardService = BoardService.getInstance();

private void start() {
	//어떤 화면으로 이동할 것인가 메서드를 호출
	int view = View.HOME; //처음 프로그램을 시작하면 HOME부터 시작하기 때문
	while(true) {//프로그램에 화면이 많아지면 case문이 늘어남
		switch(view) {//메서드는 여기에서 호출, 모든 메서드는 인트타입(여기에서만 화면을 이동해야함)
		case View.HOME : view = home(); break; 
                //홈화면으로 이동하는 메서드를 호출해서 그 화면으로 이동
		case View.LOGIN : view = userService.login(); break;
		case View.JOIN : view = userService.join(); break;
		case View.BOARD_LIST: boardService.boardList(); break;
		case View.BOARD_READ:  break;
		case View.BOARD_INSERT: boardService.insert(); break;
		}
	}
}

//리턴타입 : 다음으로 이동할 화면을 리턴한다.
private int home() {//다음 화면이 뭔지(어디로 이동할 것인지) 리턴할 것
	System.out.println("1.로그인 2.회원가입 0.프로그램 종료>");
	int input = ScanUtil.nextInt();
	switch(input) {
	case 1://로그인화면 리턴
		return View.LOGIN;//여기에는 메서드를 직접호출하지 않고 리턴만 해줌 
                                    - 여기서 직접 호출하면 화면이동이 꼬임
	case 2://회원가입화면 리턴
		return View.JOIN;//여기에는 메서드를 직접호출하지 않고 리턴만 해줌
	case 0:
		System.out.println("프로그램이 종료되었습니다.");
		System.exit(0);
	}
	return View.HOME;//위의 숫자 외에 다른 숫자를 입력했을 경우
}


/////////////////////////////////////////////////////////////////////////////////////

public interface View {

    //화면 정의
    int HOME = 0;
    int LOGIN = 1;
    int JOIN = 2;
    int BOARD_LIST = 3;
    int BOARD_READ = 4;
    int BOARD_INSERT = 5;

}
public class UserService {

//싱글톤 패턴
private UserService() {}
private static UserService instance;
public static UserService getInstance() {
	if(instance == null) {
		instance = new UserService();
	}
	return instance;
}

private UserDao userDao = UserDao.getInstance();

//회원가입
public int join() {//다른패키지에서 사용 - public
	System.out.println("================== 회원가입 ==================");
	System.out.println("아이디>");//아이디 중복확인
	String userId = ScanUtil.nextLine();
	System.out.println("비밀번호>");//비밀번호 두 번 입력
	String password = ScanUtil.nextLine();
	System.out.println("이름>");
	String userName = ScanUtil.nextLine();
	//아이디 중복 확인 생략
	//비밀번호 확인 생략
	//유효성 검사(정규표현식) 생략
	
	Map<String, Object> param = new HashMap<>();
	param.put("USER_ID", userId);
	param.put("PASSWORD", password);
	param.put("USER_NAME", userName);
	
	int result = userDao.isertUser(param);
	
	if(0 < result) {
		System.out.println("회원가입 성공");
	}else {
		System.out.println("회원가입 실패");
	}
	return View.HOME;
}


//로그인
public int login() {
	System.out.println("=============== 로그인 ===============");
	System.out.println("아이디>");
	String userId = ScanUtil.nextLine();
	System.out.println("비밀번호>");
	String password = ScanUtil.nextLine();
	
	Map<String, Object> user = userDao.selectUser(userId, password);
        //쿼리조회 -> selectOne메서드 사용
	
	if(user == null) {
		System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
	}else {
		System.out.println("로그인 성공");
                //유저를 기억 = 어딘가에 로그인한 사람의 정보를 저장하는 것
		Controller.loginUser = user;
		return View.BOARD_LIST;
	}
	
	return View.LOGIN;//다시 로그인 화면으로 돌아감
}

/////////////////////////////////////////////////////////////////////////////////////public class UserDao {

//싱글톤 패턴
private UserDao() {}
private static UserDao instance;
public static UserDao getInstance() {
	if(instance == null) {
		instance = new UserDao();
	}
	return instance;
}

private JDBCUtil jdbc = JDBCUtil.getInstance();

public int isertUser(Map<String, Object> param) {//업데이트시 몇 개의 행이 영향을 받았는지
	String sql = "INSERT INTO TB_JDBC_USER VALUES (?, ?, ?)";
	
	List<Object> p = new ArrayList<>();
	p.add(param.get("USER_ID"));
	p.add(param.get("PASSWORD"));
	p.add(param.get("USER_NAME"));
	
	return jdbc.update(sql, p);
}

public Map<String, Object> selectUser(String userId, String password) {
	String sql = "SELECT USER_ID, PASSWORD, USER_NAME"
			+ "     FROM TB_JDBC_USER"
			+ "	   WHERE USER_ID = ?"
			+ "      AND PASSWORD = ?";
	
	List<Object> param= new ArrayList<>();
	param.add(userId);
	param.add(password);
	
	return jdbc.selectOne(sql, param);
}

//////////////////////////////////////////////////////////////////
public class UserService {

//싱글톤 패턴
private UserService() {}
private static UserService instance;
public static UserService getInstance() {
	if(instance == null) {
		instance = new UserService();
	}
	return instance;
}

private UserDao userDao = UserDao.getInstance();

//회원가입
public int join() {//다른패키지에서 사용 - public
	System.out.println("================== 회원가입 ==================");
	System.out.println("아이디>");//아이디 중복확인
	String userId = ScanUtil.nextLine();
	System.out.println("비밀번호>");//비밀번호 두 번 입력
	String password = ScanUtil.nextLine();
	System.out.println("이름>");
	String userName = ScanUtil.nextLine();
	//아이디 중복 확인 생략
	//비밀번호 확인 생략
	//유효성 검사(정규표현식) 생략
	
	Map<String, Object> param = new HashMap<>();
	param.put("USER_ID", userId);
	param.put("PASSWORD", password);
	param.put("USER_NAME", userName);
	
	int result = userDao.isertUser(param);
	
	if(0 < result) {
		System.out.println("회원가입 성공");
	}else {
		System.out.println("회원가입 실패");
	}
	return View.HOME;
}


//로그인
public int login() {
	System.out.println("=============== 로그인 ===============");
	System.out.println("아이디>");
	String userId = ScanUtil.nextLine();
	System.out.println("비밀번호>");
	String password = ScanUtil.nextLine();
	
	Map<String, Object> user = userDao.selectUser(userId, password);
        //쿼리조회 -> selectOne메서드 사용
	
	if(user == null) {
		System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
	}else {
		System.out.println("로그인 성공");
                //유저를 기억 = 어딘가에 로그인한 사람의 정보를 저장하는 것
		Controller.loginUser = user;
		return View.BOARD_LIST;
	}
	
	return View.LOGIN;//다시 로그인 화면으로 돌아감
}

//////////////////////////////////////////////////////////////////////////////////////
public class UserDao {

//싱글톤 패턴
private UserDao() {}
private static UserDao instance;
public static UserDao getInstance() {
	if(instance == null) {
		instance = new UserDao();
	}
	return instance;
}

private JDBCUtil jdbc = JDBCUtil.getInstance();

public int isertUser(Map<String, Object> param) {//업데이트시 몇 개의 행이 영향을 받았는지
	String sql = "INSERT INTO TB_JDBC_USER VALUES (?, ?, ?)";
	
	List<Object> p = new ArrayList<>();
	p.add(param.get("USER_ID"));
	p.add(param.get("PASSWORD"));
	p.add(param.get("USER_NAME"));
	
	return jdbc.update(sql, p);
}

public Map<String, Object> selectUser(String userId, String password) {
	String sql = "SELECT USER_ID, PASSWORD, USER_NAME"
			+ "     FROM TB_JDBC_USER"
			+ "	   WHERE USER_ID = ?"
			+ "      AND PASSWORD = ?";
	
	List<Object> param= new ArrayList<>();
	param.add(userId);
	param.add(password);
	
	return jdbc.selectOne(sql, param);
}
}

/////////////////////////////////////////////////////////////////////////////////////////
public class BoardService {

//싱글톤 패턴
private BoardService() {}
private static BoardService instance;
public static BoardService getInstance() {
	if(instance == null) {
		instance = new BoardService();
	}
	return instance;
}

private BoardDao boardDao = BoardDao.getInstance();

private JDBCUtil jdbc = JDBCUtil.getInstance();


//게시판 목록
public int boardList() {//다른 패키지에서 호출하려고 public
	List<Map<String,Object>> boardList = boardDao.selectBoardList();
	
	System.out.println("====================================");
	System.out.println("번호\t제목\t작성자\t작성일");
	for(Map<String, Object> board : boardList){
		System.out.println("------------------------------------");
		System.out.println(board.get("BOARD_NO")
				+ "\t" + board.get("TITLE")
				+ "\t" + board.get("USER_NAME") 
				+ "\t" + board.get("REG_DATE"));
	}
	System.out.println("====================================");
	System.out.println("1.조회 2.등록 0.로그아웃>");
	int input = ScanUtil.nextInt();
	
	switch(input){
	case 1://조회
		return View.BOARD_READ;
	case 2://등록
		return View.BOARD_INSERT;
	case 0:
		Controller.loginUser = null;//저장했던 사용자 정보를 없애는 게 로그아웃
		return View.HOME;
	}
	return View.BOARD_LIST;
}
}

///////////////////////////////////////////////////////////////////////////////////////
public class BoardDao {

//싱글톤 패턴
private BoardDao() {}
private static BoardDao instance;
public static BoardDao getInstance() {
	if(instance == null) {
		instance = new BoardDao();
	}
	return instance;
}	

private JDBCUtil jdbc = JDBCUtil.getInstance();

public List<Map<String, Object>> selectBoardList(){
	String sql = "SELECT A.BOARD_NO, A.TITLE, A.CONTENT, B.USER_NAME, A.REG_DATE"
			+ "		FROM TB_JDBC_BOARD A"
			+ "		LEFT OUTER JOIN TB_JDBC_USER B ON A.USER_ID = B.USER_ID"
			+ "	   ORDER BY A.BOARD_NO DESC";
	return jdbc.selectList(sql);
	
}

public int insert() {
	System.out.print("제목>");
	String title = ScanUtil.nextLine();
	System.out.print("내용>");
	String content = ScanUtil.nextLine();
	String userid = (String)Controller.loginUser.get("USER_ID");
	//작성자 = 로그인 된 userid
	
	String sql = "INSERT INTO TB_JDBC_BOARD"
			+ "   VALUES ("
			+ "          (SELECT NVL(MAX(BOARD_NO), 0) + 1 FROM TB_JDBC_BOARD"
			+ "			, ?"
			+ "			, ?"
			+ "			, ?"
			+ "		    , SYSDATE)";
	ArrayList<Object> param = new ArrayList<>();
	param.add(title);
	param.add(content);
	param.add(userid);
	
	if(0 < jdbc.update(sql, param)){
		System.out.println("게시글이 등록되었습니다.");
	}else {
		System.out.println("게시글 등록에 실패하였습니다.");
	}
	
	return 0;
			
}

public int read() {
	System.out.println("조회할 게시물 번호>");
	int boardNo = ScanUtil.nextInt();
	
	String sql = "SELECT A.BOARD_NO"
			+ "			,A.TITLE"
			+ "			,A.CONTENT"
			+ "			,B.USER_NAME"
			+ "			,TO_CHAR(A.REG_DATE, 'MM/DD') AS REG_DATE"
			+ "		FROM TB_JDBC_BOARD A"
			+ "		LEFT OUTER JOIN TB_JDBC_USER B ON A.USER_ID=B.USER_ID"
			+ "    WHERE BOARD_NO = ?";
	
	return 0;
}	
}
