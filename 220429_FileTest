//[ File객체 만들기 연습 ]
//1. new File(string 파일 또는 경로)
//		=>디렉토리와 디렉토리 사이 또는 디렉토리와 파일명 사이의 구분 문자는 '\'를 사용하거나 '/'를 사용할 수 있다.
//		
//2. new File(File parent, String child)=>'parent'는 폴더고, parent폴더 안에있는'child'는 파일이다.
//3. new File(String parent,String child)=> 여기선 parent도 String으로 지정할수있다.
package kr.or.ddit.basic.file;

import java.io.File;

public class FileTest01 {

	public static void main(String[] args) {
		
		//1. 
		File file1 = new File("d:/D_Other/test.txt");//구분문자를 '/'로 했을 때
		File file2 = new File("d:\\D_Other\\test.txt"); //구분문자를 '\'로 했을 때
		
		System.out.println("파일1 명 : "+file1.getName());
		System.out.println("파일2 명 : "+file2.getName());
//		=>출력 값 : 파일1 명 : test.txt
//			   	   파일2 명 : test.txt
		System.out.println("디렉토리인가 ? > "+file2.isDirectory());
		System.out.println("파일인가? > "+file2.isFile());
//		=>출력 값 : 디렉토리인가 ? > false
//				   파일인가? > true
		System.out.println();
		
		
		
		File file3 = new File("d:/D_Other");//폴더정보만 들어있음
		System.out.println("파일 3 명 : "+file3.getName());
//		=>출력 값 : 파일 3 명 : D_Other

		System.out.println("디렉토리인가 ? > "+file3.isDirectory());
		System.out.println("파일인가? > "+file3.isFile());
//		출력 값 : 디렉토리인가 ? > true
//			       파일인가? > false

//////////////////////////////////////////////////////////////////////////
		//2.
		System.out.println("==========================================");
		File file4 = new File(file3, "test.txt");
		System.out.println("파일 4 명 : "+file4.getName());
		System.out.println("디렉토리인가 ? > "+file4.isDirectory());
		System.out.println("파일인가? > "+file4.isFile());
//		=>출력값 : 파일 4 명 : test.txt
//				디렉토리인가 ? > false
//				파일인가? > true
	
//////////////////////////////////////////////////////////////////////////
		//3.
		File file5 = new File("d:/D_Other", "test.txt");
		System.out.println("파일 5 명 : "+file5.getName());
		System.out.println("디렉토리인가 ? > "+file5.isDirectory());
		System.out.println("파일인가? > "+file5.isFile());
//		=>출력값 : 파일 5 명 : test.txt
//				디렉토리인가 ? > false
//				파일인가? > true
	}

}
