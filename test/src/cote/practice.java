package cote;
//문자열 배열의 오름차순, 내림차순 정렬
//구구단 출력
import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
	
	
	//프로그래머스 진료순서 정하기
	//값이 큰 요소부터 차례로 1,2,3... 순위를 매겨 배열로 다시 출력
	int[] emergency = {3, 76, 24};

//	// 원래 배열 인덱스(위치)로 순위 매기기
//    int[] ranks = IntStream.range(0, emergency.length)
//            .boxed()
//            .sorted((i, j) -> Integer.compare(emergency[j], emergency[i]))
//            .mapToInt(i -> i + 1)
//            .toArray();
//
//    System.out.println("순위 매기기: " + Arrays.toString(ranks));
//
//    // 배열 요소의 원래 위치 유지
//    int[] result = IntStream.range(0, emergency.length)
//            .boxed()
//            .sorted((i, j) -> Integer.compare(ranks[i], ranks[j]))
//            .mapToInt(i -> i+1)
//            .toArray();

	//희표좌ver. 초간단 코드
	int[] answer = Arrays.stream(emergency)
				.map(i -> Arrays.stream(emergency)
										.boxed()	//각 요소를 Integer로 boxing
										.sorted(Comparator.reverseOrder())	//내림차순 정렬
										.collect(Collectors.toList())	//리스트로 수집
										.indexOf(i)+1)	//현재 요소의 인덱스에 1을 더하기
										.toArray();
										
		//*indexOf() : 주어진 괄호 안의 요소가 리스트/배열에서 처음으로 나타내는 인덱스를 찾아줌
	System.out.println(Arrays.toString(answer));
	
	
	
	
	
	
	
	
	
	
	}
}
