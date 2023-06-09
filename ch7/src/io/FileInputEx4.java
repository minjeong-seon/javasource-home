package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/*
 * 보조 스트림 <-스트림 기능 보완
 * 
 * 텍스트+이미지+동영상
 * FileInputStream + BufferedInputStream: 버퍼를 이용한 입력 성능 향상
 * FileOutputStream + BufferedOutputStream: 버퍼를 이용한 출력 성능 향상
 * 
 * 텍스트
 * FileReader + BufferedReader : 버퍼를 이용한 입력 성능 향상
 * FileWriter + BufferedWriter : 버퍼를 이용한 출력 성능 향상
 * 
 */
public class FileInputEx4 {
	public static void main(String[] args) {
		//buffer에 값을 저장한 후 FileOutputStream을 이용해서 실제 파일에 저장
		try (FileOutputStream fos = new FileOutputStream("c:\\temp\\output2.txt");
				BufferedOutputStream bos = new BufferedOutputStream(fos)){
			
			for (int i = '1'; i <= '9'; i++) {
				bos.write(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
