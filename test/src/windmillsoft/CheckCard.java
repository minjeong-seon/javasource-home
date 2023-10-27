package windmillsoft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * 예약결제 기능이 탑재된 체크카드의 잔액 출력하기
 * 사용자 입력: 계좌잔액 n, 거래건수 m (공백으로 구분)
 * 사용자 입력: deposit(입금), pay(즉시결제), reservation(예약결제) -->공백으로 구분+줄바꿈으로 입력
 * 	ㄴ> pay는 잔액부족 시 결제 실패
 * 	ㄴ> reservation은 잔액부족 시 대기목록 업데이트
 */

public class CheckCard {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 잔액, 거래건수 입력받기
		String input = br.readLine();
		String[] check = input.split(" ");
		// 각각 분리
		int balance = Integer.parseInt(check[0]);
		int number = Integer.parseInt(check[1]);

		// 거래 종류, 거래 금액 담을 변수 선언
		String detail;
		int amount;

		// 예약결제 항목 대기 목록 리스트 생성
		List<Integer> waitingList = new ArrayList<>();

		// 거래건수만큼 사용자로부터 거래내용 입력받기
		for (int i = 0; i < number; i++) {
			String input2 = br.readLine();
			String[] parts = input2.split(" ");

			detail = parts[0];
			amount = Integer.parseInt(parts[1]);

			// 거래 내용(detail)별 거래 처리
			switch (detail) {
			// 입금 시 처리: 잔액 증가, 대기목록 있는 경우 잔액에 따라 결제 진행
			case "deposit":
				balance += amount;
				System.out.println("입금 후 잔액: " + balance);
				while (!waitingList.isEmpty()) {
					if (balance >= waitingList.get(0)) {
						balance -= waitingList.get(0);
						waitingList.remove(0);
						System.out.println("대기목록 결제 후 잔액: " + balance);
					} else {
						System.out.println("남은 대기 목록: " + waitingList);
						break;
					}
				}
				break;
			// 즉시결제 시 처리: 잔액 되면 잔액에서 차감, 부족하면 amount 0으로 처리
			case "pay":
				if (balance >= amount) {
					balance -= amount;
					System.out.println("즉시 결제 후 잔액: " + balance);
				} else {
					amount = 0;
					System.out.println("결제 실패(잔액부족): " + balance);
				}
				break;
			// 예약결제 시 처리: 잔액 되면 잔액에서 차감, 부족하면 대기목록에 업데이트
			case "reservation":
				if (balance >= amount) {
					balance -= amount;
					System.out.println("예약 결제 후 잔액: " + balance);
				} else {
					waitingList.add(amount);
					System.out.println("대기목록에 추가됨 " + waitingList);
				}
				// 대기목록이 존재하면 대기목록부터 잔액 상황에 따라 처리(결제 후 해당 대기 목록 비우기)
				while (!waitingList.isEmpty()) {
					if (balance >= waitingList.get(0)) {
						balance -= waitingList.get(0);
						waitingList.remove(0);
						System.out.println("대기목록 결제 후 잔액: " + balance);
					} else {
						System.out.println("남은 대기 목록: " + waitingList);
						break;
					}
				}
			default:
				break;
			}
		}
		System.out.println(balance);
		br.close();
	}
}
