package lang;

import java.util.Arrays;
import java.util.Iterator;

//**주어진 문자열에서 내가 원하는 문자/문자열 찾기**

public class StringEx2 {
	public static void main(String[] args) {
		//String 생성자
		
		//new String(char value[])
		char c[]= {'H','e','l','l','o'};
		String str1=new String(c);
		System.out.println(str1);
		
		String str2="Hello";
		
		//charAt(int index): char 
		//	--> charAt 호출 시 int 매개변수를 넣어서 호출하고 결과값은 char로 받는다
		//length() : 문자열 길이
				System.out.println("length():문자열 길이 "+str1.length());
		//	-->(int index)안에는 배열의 변수명.length 값을 넣음
		System.out.println(str1.charAt(0));
		System.out.println(str1.charAt(str1.length()-1));
		
		
		
		
		String str3 = "자바 프로그래밍";
		
		
		//str3 문자열에 '프'라는 문자가 포함되어 있는지 확인
		int counter=0;
		for (int i = 0; i < str3.length(); i++) {
			if(str3.charAt(i)=='프') {
				counter++;
			}
		}System.out.println(counter>0?"있음":"");
		System.out.println("'프' 횟수: "+counter);
		
		
		
		//indexOf(int ch): 주어진 문자 ch가 문자열에 들어있는지 확인하고 위치를 리턴(못 찾으면 -1 리턴)
		System.out.println("indexOf(int ch):"+str2.indexOf('o'));
		//indexOf(String str): 문자열 str가 문자열에 있는지 확인 하고 str의 첫번째 문자 위치를 리턴
		System.out.println("indexOf(String str): "+str2.indexOf("llo"));
		//indexOf(int ch, int fromInedex): fromIndex에 넣은 정수로 시작 위치 지정
		System.out.println("indexOf(int ch, int fromInedex): "+str2.indexOf('e', 2));
		System.out.println("indexOf(int ch, int fromInedex): "+str2.indexOf('e', 0));
		//lastIndexOf(int ch): 오른쪽 끝부터 주어진 ch를 찾아 위치 리턴
		System.out.println("lastIndexOf(int ch):"+str2.lastIndexOf('o'));
		
		//str3 문자열에 '프'가 들어있는지 확인(indexOf만 사용)
		System.out.println("str3 문자열에서 '프'가 있는 위치: "+str3.indexOf('프')+"번째 자리");
		System.out.println(str3.indexOf('프')>-1?"있음":""); //있나 없나만 확인
		
		//substring(): 지정한 범위에 해당하는 문자열 얻기
		String ssn="880515-1222012";
		//substring(int beginIndex): int 입력값부터 끝까지
		String result=ssn.substring(3);
		System.out.println(result);
		//substring(int beginIndex, endIndex): int begin~end-1까지 범위 문자열 추출(end는 포함하지 않음)
		System.out.println("substring(int beginIndex, endIndex): "+ssn.substring(3, 9));
	
		
		//concat(String str): +와 같은 역할
		String result2=str2.concat(": 안녕하세요");
		System.out.println(result2);
		System.out.println("concat(String str):"+str3.concat("java programming"));
		
		//startsWith(String prefix): 문자열이 prefix로 시작하면 true 아니면 false로 출력
		String str4 = "java.lang.Object";
		boolean result3=str4.startsWith("lang");
		System.out.println(result3);
		System.out.println("startsWith(String prefix): "+str4.startsWith("java"));
		//startsWith(String prefix, toffset): toffset을 시작위치로 prefix 값으로 시작하는지 출력
		System.out.println("startsWith(String prefix, toffset): "+str4.startsWith("lang", 5));
		
		//endWith(String suffix): suffix로 끝나는지 여부
		System.out.println(str4.endsWith("ect"));
		
		//contains(charSequence s): charSequence(문자열의 부모), 지정된 문자열에 s가 포함되어 있는지 여부 
		System.out.println("contains : "+str2.contains("Hello"));
		
		//replace(old charSequence, new charSequence): 원본 문자열 > 변경 문자열로 대체(String으로 리턴)
		String str5="자바는 객체지향 언어입니다. 자바는 풍부한 API를 제공합니다.";
		System.out.println(str5.replace("자바는", "이것은"));
		System.out.println(str5);  //->String은 변경 불가능한(immutable) 클래스라 원본이 변경되지 않음
		//원본 문자열을 변경하려면 새로운 문자열로 리턴값을 다시 담아줘야 한다.
		str5=str5.replace("자바는", "이것은");
		System.out.println(str5);
		//replaceFirst(String regex, String replacement): 첫번째 regex만 replacement로 대체
		System.out.println(str5.replaceFirst("이것은", "자바는"));
		//replaceAll(String regex, String replacement): 문자열의 모든 regex를 replacement로 대체
		System.out.println(str5.replaceAll("이것은", "자바는"));
	
		//trim(): 문자열의 좌우 공백을 제거한 String 값으로 리턴(중간 공백은 제거x)
		String str6 = "   Hello World   ";
		System.out.println(str6.length());  //공백 포함 17자 길이
		System.out.println(str6.equals("Hello World"));  //str6의 공백이 없음
		System.out.println("trim(): "+str6.trim());
	
		//static ==> 클래스명.메소드명 / 클래스명.상수로 호출
		//static String valueOf() : 지정된 값을 문자열로 변환하여 리턴
		System.out.println(String.valueOf('s'));
		System.out.println(String.valueOf(true));
		System.out.println(String.valueOf(700));
		System.out.println(String.valueOf(c));
	
		//static String valueOf()를 쓰지 않고 a를 문자열로 변경
		int a = 100;
		String str7 = a+"";
		
		//toLowerCase(): 모든 문자열을 소문자로 리턴 | toUpperCase(): 모든 문자열을 대문자로 리턴
		System.out.println(str2.toLowerCase());
		System.out.println(str2.toUpperCase());
	
		//split(String regex): regex/특정 문자를 기준으로 문자열을 나누어 배열에 저장 후 리턴(아래 for문 출력 참고)
		String animals = "dog,cat,bear";
		//regex; regular expression(정규표현식) : 특정한 규칙을 가진 문자열의 집합
		String[] zooArr = animals.split(",");
	
		System.out.println(zooArr.length); //zooArr[index] = 3개
		String zoo1 = zooArr[0];  //dog
		String zoo2 = zooArr[1];  //cat
		String zoo3 = zooArr[2];  //bear

		System.out.println("split 바로 출력: "+zooArr);  //toString이 오버라이딩 되지 않아 주소값이 출력됨
		System.out.println(zoo1+" "+zoo2+" "+zoo3); //toString이 오버라이딩 되지 않아 주소값이 출력됨
		
		//[원하는대로 출력] For문으로 배열 값 출력하기(toString override 없이)
		for (int i = 0; i < zooArr.length; i++) {
			System.out.println(zooArr[i]);}  //dog\n cat\n bear\n
		
		//[주로 확인용] Arrays.toString 배열 값 출력하기(toString override 없이)  
		System.out.println(Arrays.toString(zooArr));  //[dog, cat, bear]
		
		//split(String regex, int limit): regex/특정문자 기준으로 문자열을 나누되, limit만큼만 index제한
		zooArr = animals.split(",", 2);
		System.out.println(Arrays.toString(zooArr));  //[dog, cat,bear]
		for (int i = 0; i < zooArr.length; i++) {
			System.out.println(zooArr[i]); //dog\n cat,bear
		}
		
		//compareTo(String anotherString): 문자열/정수 비교(사전순서) | 크다/이전(1), 같다(0), 작다/이후(-1)
		System.out.println("aaa".compareTo("aaa"));
		System.out.println("aaa".compareTo("bbb"));
		System.out.println("bbb".compareTo("aaa"));
		//compareTo(String anotherString): 비교 불가한 지점 문자열의 비교, 포함 관계의 비교, 비교 불가한 시점에서의 차이값
		System.out.println("aaa>AAA 비교: "+"aaa".compareTo("AAA")); //32(97과 65의 차이)
		System.out.println("aaa>a 비교: "+"aaa".compareTo("a"));  //2(a는 aaa에 포함된 경우 문자열 길이의 차이 값 리턴)
		System.out.println("bbb>bcde 비교: "+"bbb".compareTo("bcde"));  //-1
		
		//join(CharSequence delimiter, CharSequence... elements): split()의 반대 개념. 특정 문자열로 결합.
		zooArr=animals.split(",");
		System.out.println(Arrays.toString(zooArr));
		String str8=String.join("-", zooArr);
		System.out.println("join(): "+str8);		
		
		
		
	}

}
