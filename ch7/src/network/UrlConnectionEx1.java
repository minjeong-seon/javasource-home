package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/*
 * URLConnection 클래스: 어플리케이션과 URL 간의 통신 연결을 나타내는 클래스
 * 
 * 네트워크 기반 ==> 소켓 프로그래민(TCP/UDP)
 */

public class UrlConnectionEx1 {
	public static void main(String[] args) {
		
		BufferedReader input = null;
		String line = "";
		
			try {
				URL url = new URL("https://www.naver.com");
				//url.openStream(): 연결된 url에서 데이터를 읽어 InputStream형태로 리턴
				//InputStramReader() : InputStream -> Reader 변환
				
				//BufferedReader(fileInputSteam)
				//BufferedInputStream(FileInputStream)
				
//				▼url.openStream() 대신에 URLConnection 사용하기▼
//				URLConnection con = url.openConnection();
//				con.getInputStream();
				
				input = new BufferedReader(new InputStreamReader(url.openStream()));		//오른쪽부터 해석
				URLConnection urlConnection = url.openConnection();
				
				while((line = input.readLine())!=null) {
					System.out.println(line);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			
			
	}
}
