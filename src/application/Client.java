package application;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Iterator;

// 1명이 클라이언트 통신가능 클래스
public class Client {

	Socket socket;

	public Client(Socket socket) {
		this.socket = socket;
		receive();
	}

	// 반복적으로 클라이언트에 메시지 받는 메소드
	public void receive() {
		Runnable thread = new Runnable() {
			@Override
			public void run() {
				try {
					while (true) {
						InputStream in = socket.getInputStream();
						byte[] buffer = new byte[512];

						int length = in.read(buffer);
						if (length == -1)
							throw new IOException();
						System.out.println("[메시지 수신 성공]" + socket.getRemoteSocketAddress() + ": "
								+ Thread.currentThread().getName());
						String message = new String(buffer, 0, length, "UTF-8");
						for (Client client : Main.clients) {
							client.send(message);
						}
					}
				} catch (Exception e) {
					try {
						System.out.println("[메시지 수신 오류]" + socket.getRemoteSocketAddress() + ": "
								+ Thread.currentThread().getName());
						Main.clients.remove(Client.this);
						socket.close();
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				}
			}
		};
		Main.threadPool.submit(thread);
	}

	// 해당 클라이언트에 메시지 전송하는 메소드
	public void send(String message) {

	}

}
