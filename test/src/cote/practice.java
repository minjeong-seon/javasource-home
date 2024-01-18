package cote;
//문자열 배열의 오름차순, 내림차순 정렬
//구구단 출력
import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class practice {
public static void main(String[] args) {
//	//	배열의 오름차순 내림차순 정렬(대문자를 기준으로)
//	String[] animals = {"Dog", "cat", "Rabbit", "tiger", "bear", "Hamster"};
//
//	//요소를 대문자로 변경하여 새로운 배열에 저장
//	for (int i = 0; i < animals.length; i++) {
//		animals[i] =  animals[i].toUpperCase();
//	}
//	
//	//오름차순 정렬
////	Arrays.sort(upperAnimals);	
//	
//	//내림차순 정렬
//	
//	//방법1) collator(문자열 비교) 사용
////	Collator collator = Collator.getInstance(Locale.ENGLISH);
////	Arrays.sort(animals, collator.reversed());
//	
//	//방법2) Collections.reverseOrder() 사용: 역순으로 비교하는 Comparator(객체 정렬 관련 인터페이스)를 반환
//	Arrays.sort(animals, Collections.reverseOrder());
//	
//	//배열 출력
//	for (int i = 0; i < animals.length; i++) {
//		System.out.println(animals[i]);
//	}
//	
//	
//	
//	//구구단(세로로 출력하기)
//	for (int i = 1; i < 10; i++) {
//		for (int j = 1; j < 10; j++) {
//			System.out.printf("%d x %d = %-2d  ", j, i, j * i);
//		}
//		System.out.println();
//	}
//	
//	
	//문자열 char 마다 n횟수만큼 반복하기
//	int n = 3;
//	String str = "star";
//	char[] strArr = str.toCharArray();
//	StringBuilder repeatStr = new StringBuilder();
//	for (char c : strArr) {
//		for (int i = 0; i < n; i++) {
//			repeatStr.append(c);
//		}
//	}
//	System.out.println(repeatStr.toString().toCharArray());
//	
//	
//	//특정 문자 제거하기
//	String str = "AbcdeF";
//	String letter = "e";
//
//	if (str.contains(letter)) {
//		str = str.replace(letter, "");
//	}
//	
//	System.out.println(str);
	
	System.out.println(5/2);
	
	}
}
