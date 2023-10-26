package windmeal;

/*
 * 삼각형의 넓이 구하기
 * 결과값은 소숫점 둘째 자리에서 반올림하여 첫째 자리까지만 나타내기
 */

import java.io.*;

public class triangle {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 삼각형의 밑변과 높이를 공백을 사이에 두고 입력받기
		String input = br.readLine();
		// 공백 제거하여 배열에 담기
		String[] numArr = input.split(" ");
		
		// String -> int 로 변환하여 변수에 저장
		int base = Integer.parseInt(numArr[0]);
		int height = Integer.parseInt(numArr[1]);
		
		double area = base*height*0.5;
		// 삼각형의 넓이 area를 둘째 자리에서 반올림 후 첫째 자리까지 표현
		double roundArea = Math.round(area*10.0)/10.0;

		System.out.println("삼각형의 넓이: "+roundArea);
	}
}
