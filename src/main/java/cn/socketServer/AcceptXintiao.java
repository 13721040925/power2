package cn.socketServer;

import java.io.DataInputStream;
import java.net.Socket;

import cn.util.Changedegital;

public class AcceptXintiao implements Runnable {
	private DataInputStream in;
	private Socket socket;
	private String msg;

	public String getMsg() {
		return msg;
	}

	@Override
	public void run() {
		try {
			in = new DataInputStream(socket.getInputStream());
			byte[] bt1 = new byte[1024];
			while (in != null) {
				while (in.available() != 0) {
					in.read(bt1);
				}
				msg = Changedegital.bytesToString(bt1);
				if (msg.length() <= 0) {
					continue;
				}
				if (msg.charAt(0) != '~') {
					if (msg.charAt(0) != '#') {

					}
					System.out.println("心跳：" + msg);

				}
				System.out.println(msg);
				msg = null;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
