package windmillsoft;

/*
 * 사용자로부터 현재시간과 버스5대의 시간표 입력받기
 * -입력 형태 --> HH:mm(버스시간의 경우 공백으로 구분)
 * 익일 탑승도 고려하여 탑승 대기 시간이 가장 짧은 버스 시간표를 출력
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.*;
import java.util.Arrays;

public class Bus {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 현재 시간 입력받기
		String current = br.readLine();
		// String -> LocalTime 으로 변환
		LocalTime currentTime = LocalTime.parse(current);

		// 버스 도착 시간 입력받기
		String bus = br.readLine();
		// 공백 제거하여 배열로 저장
		String[] busStr = bus.split(" ");
		// String[] -> LocalTime[] 으로 변환
		LocalTime[] busTimeArr = Arrays.stream(busStr).map(x -> LocalTime.parse(x)).toArray(LocalTime[]::new);

		// LocalTime[] 요소를 계산하여 long[]으로 저장하기 위해 long[] 배열 생성
		// 대기시간 배열의 길이는 버스시간 배열 길이와 동일함
		long[] waitingMinutes = new long[busTimeArr.length];

		// 대기시간 배열에 현재시간-버스도착시간 차이를 분 단위로 담기
		// Duration : 시간 간격, 두 시간 간 차이 계산(LocalDateTime, LocalTime 등의 타입을 계산)
		for (int i = 0; i < busTimeArr.length; i++) {
			waitingMinutes[i] = Duration.between(currentTime, busTimeArr[i]).toMinutes();

			// 현재 시간보다 이른 시간인 경우 다음 날로 가정하고 24시간을 더함
			if (waitingMinutes[i] < 0) {
				waitingMinutes[i] += 24 * 60;
			}
		}
		
		 // 음수와 양수를 모두 고려하여 가장 작은 대기 시간을 찾아 반환
		// getAsLong() : long 타입 값이 있으면 반환, 없으면 NoSuchElementException 발생
        long shortestWaitingTime = Arrays.stream(waitingMinutes).min().getAsLong();
        System.out.println("가장 적은 대기 시간은 " + shortestWaitingTime + "분 입니다.");

		br.close();
	}
}
