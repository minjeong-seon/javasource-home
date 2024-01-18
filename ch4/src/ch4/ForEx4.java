package ch4;

import java.util.Iterator;
import java.util.Scanner;

//중첩 For
//		-For 문 안에 For 문 포함
public class ForEx4 {
	public static void main(String[] args) {
		for (int i = 1; i < 6; i++) {
			System.out.println("**********");
		}
		
		System.out.println();
		
		
//		for (@1번 ; @2번--@10번 ; @9번) {
//			for (@3번 ; @4번 ; @6번) {
//				System.out.print(@5번--@7번);
//			}
//			System.out.println(@8번);
//		}	
		// 1) 바깥 For 실행 int i=1;
		// 2) i<6;  --몇 번 반복할지
		// 3) 안쪽 For 실행 int j=0;
		// 4) j<10;
		// 5) System.out.print("*");
		// 6) j++   j=1
		// 7) System.out.print("*");
		// 8) 6~8) 반복
		// 10) j가 10이 되는 순간 안쪽 For 종료(terminate)
		// 11) System.out.println();
		// 12) 바깥 For 실행 i++  i=2
		// 13) i<6 조건 비교
		// 14) 안쪽 For 10번 수행
		// 15) 계속 반복되다가 i가 6이 되는 순간 For 완전 종료됨
		for (int i = 1; i < 6; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print("*");
			}
			System.out.println();
		}	
		
		System.out.println();
		//별로 피라미드 쌓기
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j <=i; j++) {  //j <=i; : 별을 몇 개씩 늘어놓을지
				System.out.print("하나");
			}System.out.println();
		}
		
		
		System.out.println();
		// 문1) 4x+5y=60의 모든 해 구하기
		//		단, x, y는 10이하의 자연수
		// 		4*1+5*1=60 ...4*1+5*2=60 ...4*1+5*3=60 ...
		for (int i = 1; i <= 10; i++) {   //For문의 i와 j를 각각의 미지수로 설정: i(x)=10보다 작은 자연수
			for (int j = 1; j <= 10; j++) {  //j(y)=10보다 작은 자연수로 설정
				//60이 나오는 x,y 출력
				if (4*i+5*j==60) {   //방정식을 풀어서 조건문 설정
					System.out.printf("(%d, %d)\n",i,j);   //조건에 맞는 값이 도출되도록 출력
				}
			}
		}
		
		System.out.println();
//		//break: 자신이 포함된 가장 가까운 반복문을 벗어나게 됨(주로 if문과 같이 사용됨)
//		for (int i = 0; i < 10; i++) {   //0-9 사이의 수가 1씩 증가
//			System.out.println(i);
//			if (i==5) break;   //i=5일 때 반복문 terminate
//		}
		
		System.out.println();
		//continue:
		//반복문 내에서만 사용
		//반복이 진행되는 도중에 continue문을 만나면 반복문의 끝으로 이동하여 다음 반복문으로 넘어감
		
		for (int i = 0; i <= 10; i++) {
			if (i%3==0) continue;
			System.out.println(i);	   //if조건에 속하는 대상만 제외하고 반복함
			
		}
		
		
		
	}

}
