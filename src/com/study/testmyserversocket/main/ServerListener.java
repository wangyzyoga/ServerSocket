package com.study.testmyserversocket.main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ServerListener extends Thread {

	@Override
	public void run() {

		try {
			ServerSocket serverSocket = new ServerSocket(11188);
			while (true) {
				Socket socket = serverSocket.accept();
				JOptionPane.showMessageDialog(null, "有客戶端連接到了本機的11188端口");
				ChatSocket cs = new ChatSocket(socket);
				cs.start();
				ChatManager.getChatManager().add(cs);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
