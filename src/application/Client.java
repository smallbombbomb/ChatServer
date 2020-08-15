package application;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Iterator;

// 1���� Ŭ���̾�Ʈ ��Ű��� Ŭ����
public class Client {

	Socket socket;

	public Client(Socket socket) {
		this.socket = socket;
		receive();
	}

	// �ݺ������� Ŭ���̾�Ʈ�� �޽��� �޴� �޼ҵ�
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
						System.out.println("[�޽��� ���� ����]" + socket.getRemoteSocketAddress() + ": "
								+ Thread.currentThread().getName());
						String message = new String(buffer, 0, length, "UTF-8");
						for (Client client : Main.clients) {
							client.send(message);
						}
					}
				} catch (Exception e) {
					try {
						System.out.println("[�޽��� ���� ����]" + socket.getRemoteSocketAddress() + ": "
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

	// �ش� Ŭ���̾�Ʈ�� �޽��� �����ϴ� �޼ҵ�
	public void send(String message) {

	}

}
