package cn.socketServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import cn.util.Changedegital;
import cn.util.CommondName;

public class DoWarn implements Runnable {
	private DataOutputStream out;
	private DataInputStream in;
	private Socket socket;
	private String msg;

	public DoWarn(Socket socket) {
		this.socket = socket;
	}

	public String getMsg() {
		return msg;
	}

	@Override
	public void run() {
		try {
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			byte[] bt = CommondName.getWarn();
			if (bt != null) {
				out.write(bt);// 输出信息
				out.flush();
			}
			byte[] bt1 = new byte[1024];
			while (in != null) {
				in.read(bt1);
				msg = Changedegital.bytesToString(bt1);
				if (msg.length() <= 0) {
					continue;
				}
				if (msg.charAt(0) != '~') {
					if (msg.charAt(0) != '#') {

					}
					System.out.println("心跳：" + msg);
					continue;
				}
				break;
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}

}
