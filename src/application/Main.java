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
	
	// ������ �������� Ŭ���̾�Ʈ�� ������ ��ٸ��� �޼ҵ�
	public void startServer(String IP, int port){
		
	}
	
	// ���� �۵� ���� �޼ҵ�
	public void stopServer() {
		
	}
	
	// UI �����ϰ� ������ ���α׷� �۵� �޼ҵ�
	@Override
	public void start(Stage primaryState){
		
	}
	
	// ���α׷��� ������
	public static void main(String[] args) {
		launch(args);
	}

}
