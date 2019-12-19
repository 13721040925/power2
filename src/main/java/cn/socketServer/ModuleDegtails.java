package cn.socketServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.pojo.Address;
import cn.service.AddressService;
import cn.util.Changedegital;
import cn.util.CommondName;

public class ModuleDegtails implements Runnable {
	private static ApplicationContext app = new ClassPathXmlApplicationContext("spring-config.xml");
	private DataOutputStream out;
	private DataInputStream in;
	private Socket socket;
	private String msg;
	private static AddressService addressService;

	static {
		addressService = app.getBean("addressService", AddressService.class);
	}

	public ModuleDegtails(Socket socket) {
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
			byte[] bt = CommondName.getXyModel();
			if (bt != null) {
				out.write(bt);// 输出信息
				out.flush();
			}
			byte[] bt1 = new byte[1024];
			while (in != null) {
				try {
					while (in.available() != 0) {
						in.read(bt1);
					}

				} catch (SocketTimeoutException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					String ip = socket.getRemoteSocketAddress().toString().split(":")[0].substring(1);
					if (addressService.getAddressByIp(ip) == null) {
						Address add = new Address();
						add.setIp(ip);
						add.setCooperate_name(ip);
						add.setStates(1);
						if (addressService.addAddress(add) > 0) {
							System.out.println(ip + "位置添加成功！");
						}
					} else {
						String cooperate_name = addressService.getAddressByIp(ip).getCooperate_name();
						Address add = new Address();
						add.setIp(ip);
						add.setCooperate_name(cooperate_name);
						add.setStates(1);
						if (addressService.updateAddress(add) > 0) {
							System.out.println("修改状态成功");
						}
						socket.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
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
				in.close();
				out.close();
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
