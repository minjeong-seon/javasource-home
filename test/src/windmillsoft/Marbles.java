package windmillsoft;
/*
 * 
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Marbles {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		String[] inputArr = input.split(" ");
		int n = Integer.parseInt(inputArr[0]);
		int m = Integer.parseInt(inputArr[1]);
		int k = Integer.parseInt(inputArr[2]);
				
		Random random = new Random();
		for(int i = 0; i < k; i++) {
			// 0은 2를 이김, 1은 0을 이김, 2는 1을 이김
			int nChoice = random.nextInt(3);
			int mChoice = random.nextInt(3);
			while(n>=0 || m>=0) {				
				if((nChoice == 0 && mChoice ==2)||(nChoice == 1 && mChoice ==0)||(nChoice == 2 && mChoice ==1)) {
					n++;
				}else if(nChoice == mChoice) {
					
				}else {
					n--;
				}
			}
		}
		System.out.println("");
		br.close();
	}
}
