package windmillsoft;

/*
 * 케이크 먹기
 * N개의 조각, 방금 먹은 조각으로부터 K번째 조각을 최종 2조각이 남을 때까지 먹는다.
 * 남은 2조각은 몇 번째 조각인가? 
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Cake {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		String[] inputArr = input.split(" ");
		int n = Integer.parseInt(inputArr[0]);
		int k = Integer.parseInt(inputArr[1]);

//		LinkedList<Integer> cake = new LinkedList<>(); 도 가능함
		// LinkedList : 삽입, 삭제에 효율이 더 높음(소요시간 짧음)
		// ArrayList : 그 외에는 다 이게 낫다.
		
		// 케이크 조각 담을 리스트 생성
		List<Integer> cake = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			cake.add(i);
		}
				
		// 1번부터 먹어야 함(일단 먹고 시작)
		int currentIndex = 0;
		cake.remove(currentIndex);
		
		// 남은 케이크 조각이 2개가 되기 전까지 반복
		while(cake.size() > 2) {
			// 그냥 currentIndex + k 를 나누면 실제 먹는 인덱스보다 1이 많아지므로 -1
			// 다음에 먹을 후보 인덱스의 번호가 조각 범위를 벗어나지 않도록 나머지로 취합
			currentIndex = (currentIndex + k -1)%cake.size();
			// 케이크 먹을 때마다 리스트에서 해당 조각 삭제
			cake.remove(currentIndex);
		}
		System.out.println(cake);
		
		br.close();
	}
}
