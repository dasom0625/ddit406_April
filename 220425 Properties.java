/*
 * Properties객체는 Map보다 축소된 기능의 객체라고 할 수 있다.
 * 
 * Map의 경우, key값과 value값에 모든 형태의 객체를 사용할 수 있지만
 * Properties객체는 key값과 value값에 String형태만 사용이 가능하다.
 * 
 * Map은 put(),get()메서드를 이용해서 데이터를 입출력하지만,
 * Properties는 setProperty(),getProperty()메서드를 이용하여 데이터를 입출력한다. 
 * 		- setProperty(key,value);	=>put역할(넣는역할)
 * 		- getProperty(key); =>get역할 (출력역할)
 * 
 * Properties객체는 데이터를 파일(file)로 입출력 할 수 있다.
*/

package kr.or.ddit.basic;

import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) {
		
		//1. Properties객체 생성
		Properties prop = new Properties();
		
		//2. 데이터 추가
		prop.setProperty("name", "이다솜");
		prop.setProperty("age1", 30+"");	//숫자를 문자형으로 형변환 해주는 방법 1
		prop.setProperty("age2", String.valueOf(30));	//숫자를 문자형으로 형변환 해주는 방법 2
		prop.setProperty("tel", "010-1234-5678");
		prop.setProperty("addr", "경기도");
		
		//3. 데이터 읽기
		String name = prop.getProperty("name");
		String age1 = prop.getProperty("age1");
		String age2 = prop.getProperty("age2");
		String tel  = prop.getProperty("tel");
		String addr = prop.getProperty("addr");
		
		System.out.println("이름      : " + name);
		System.out.println("나이1  : " + age1);
		System.out.println("나이2  : " + age2);
		System.out.println("전화번호 : " + tel);
		System.out.println("주소      : " + addr);
		
	}
  
  ======================================================================================================
  출력값 )
  이름      : 이다솜
나이1  : 30
나이2  : 30
전화번호 : 010-1234-5678
주소      : 경기도
