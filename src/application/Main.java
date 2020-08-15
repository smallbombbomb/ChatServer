package application;

import java.net.ServerSocket;
import java.util.Vector;
import java.util.concurrent.ExecutorService;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static ExecutorService threadPool;
	public static Vector<Client> clients = new Vector<Client>();
	
	ServerSocket serverSocket;
	
	// 서버를 구동시켜 클라이언트의 연걸을 기다리는 메소드
	public void startServer(String IP, int port){
		
	}
	
	// 서버 작동 중지 메소드
	public void stopServer() {
		
	}
	
	// UI 생성하고 실질적 프로그램 작동 메소드
	@Override
	public void start(Stage primaryState){
		
	}
	
	// 프로그램의 진입점
	public static void main(String[] args) {
		launch(args);
	}

}
