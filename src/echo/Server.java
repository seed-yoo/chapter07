package echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {

		// 서버소켓생성
		ServerSocket serverSocket = new ServerSocket();

		// 바인딩
		serverSocket.bind(new InetSocketAddress("192.168.0.59", 10002));	// ("본인 컴퓨터 IP주소", port 번호 지정)

		// 서버시작
		System.out.println("<서버시작>");
		System.out.println("==================================");
		
		// 반복
		while (true) {
			System.out.println("[연결을 기다리고 있습니다.]");
			
			// 클라이언트가 접속을 하면 accept()가 실행됨
			Socket socket = serverSocket.accept();
			
			// 출장	thread.start();
			Thread thread = new ServerThread(socket);
			thread.start();
		}
		
		/*
		System.out.println("=========================================");
		System.out.println("<서버 종료>");
		
		
		// 닫기
		socket.close();
		serverSocket.close();
		*/
	}
}
