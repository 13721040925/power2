package cn.socketServer;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.pojo.Address;
import cn.service.AddressService;
import cn.util.Changedegital;
import cn.util.Translate;

public class ServerMain {
	// 线程池50--固定
	private static ApplicationContext app = new ClassPathXmlApplicationContext("spring-config.xml");
	private static ExecutorService threadPool = Executors.newFixedThreadPool(50);
	private static ServerSocket server;
	private static Map<String, Socket> channels = new HashMap<String, Socket>();
	private static int port;
	private static AddressService addressService;

	static {
		try {
			addressService = app.getBean("addressService", AddressService.class);
			InputStream is = ServerMain.class.getResourceAsStream("/info.properties");
			Properties properties = new Properties();
			properties.load(is);
			port = Integer.parseInt(properties.getProperty("port"));
			System.out.println("port=" + port);
			is.close();
			server = new ServerSocket(port);
			System.out.println("服务器启动！");

			Accept ac = new Accept();
			Thread th1 = new Thread(ac);
			th1.start();
			Moli moli = new Moli();
			Thread th2 = new Thread(moli);
			th2.start();
			// HeartJump heartJump = new HeartJump();
			// Thread th3 = new Thread(acceptXintiao);
			// th3.start();
			// th3.join();
			// String msg1 = null;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Map<String, Socket> getChannels() {
		return channels;
	}

	public static boolean sendWarnCommond(String ip) {
		boolean flag = false;
		try {
			Socket so = null;
			for (Entry<String, Socket> entry : getChannels().entrySet()) {
				if (entry.getKey().equals(ip)) {
					System.out.println(">>>>>>>>>>>>>>>");
					so = entry.getValue();
					break;
				}
			}
			if (so != null) {
				System.out.println(so);
				DoWarn doWarn = new DoWarn(so);
				Thread th = new Thread(doWarn);
				th.start();
				th.join();
				String msg = null;
				while ((msg = doWarn.getMsg()) != null) {
					System.out.println(msg);
					flag = Translate.tranWarn(msg.trim(), ip);
					break;
				}
			} else {
				System.out.println(ip + "未连接服务器");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(ip + "已经与服务器断开");
		}
		return flag;
	}

	static class Moli implements Runnable {

		@Override
		public void run() {
			try {
				while (true) {
					Thread.currentThread().sleep(1000 * 30);
					synchronized (this) {
					System.out.println(">>>>>>>>>>>>>Moli");
					Socket so = null;
						String imei = null;
					for (Entry<String, Socket> entry : getChannels().entrySet()) {
							imei = entry.getKey();
							System.out.println(imei);
							so = entry.getValue();
							System.out.println(so);

							ModuleDegtails moduleDegtails = new ModuleDegtails(so);
							Thread th = new Thread(moduleDegtails);
							th.start();
							th.join();
							String msg = null;
							while ((msg = moduleDegtails.getMsg()) != null) {
								System.out.println(msg);
								break;
							}

							if (msg != null) {

								String flag = Translate.transLog(imei, msg.trim(), entry.getKey(), so);
								System.out.println(flag);
								if (flag.equals("11") || flag.equals("01")) {
									sendWarnCommond(entry.getKey());
								}
								String key = entry.getKey();
								if (addressService.getAddressByIp(key) == null) {
									Address add = new Address();
									add.setIp(key);
									add.setCooperate_name(key);
									add.setStates(0);
									if (addressService.addAddress(add) > 0) {
										System.out.println(key + "位置添加成功！");
									}
								} else {
									String cooperate_name = addressService.getAddressByIp(key).getCooperate_name();
									Address add = new Address();
									add.setIp(key);
									add.setCooperate_name(cooperate_name);
									add.setStates(0);
									if (addressService.updateAddress(add) > 0) {
										System.out.println("修改状态成功");
									}
								}
							} else {
								String key = entry.getKey();
								entry.getValue().close();
								channels.remove(key);
								System.out.println(key + "已断开连接");
								if (addressService.getAddressByIp(key) == null) {
									Address add = new Address();
									add.setIp(key);
									add.setCooperate_name(key);
									add.setStates(1);
									if (addressService.addAddress(add) > 0) {
										System.out.println(key + "位置添加成功！");
									}
								} else {
									String cooperate_name = addressService.getAddressByIp(key).getCooperate_name();
									Address add = new Address();
									add.setIp(key);
									add.setCooperate_name(cooperate_name);
									add.setStates(1);
									if (addressService.updateAddress(add) > 0) {
										System.out.println("修改状态成功");
									}

								}
							}
						}

					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	static class Accept implements Runnable {
		@Override
		public void run() {
			System.out.println(server);
			try {
				Socket socket = null;
				// 实时监听接收客户端连过来的所有socket
				while ((socket = server.accept()) != null) {
					// socket = server.accept();
					RunnableImple run = new RunnableImple(socket);
					threadPool.execute(run);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 接受Socket对象，处理该对象
	static class RunnableImple implements Runnable {
		public Socket socket;

		public RunnableImple(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			// 将获取的socket对象交给线程池
			SocketAddress address = socket.getRemoteSocketAddress();
			System.out.println(address);
			String ip = address.toString().split(":")[0].substring(1);
			// channels.put(ip, socket);
			HeartJump heartJump = new HeartJump(socket);
			Thread th3 = new Thread(heartJump);
			th3.start();

			// if (addressService.getAddressByIp(ip) == null) {
			// Address add = new Address();
			// add.setIp(ip);
			// add.setCooperate_name(ip);
			// add.setStates(0);
			// if (addressService.addAddress(add) > 0) {
			// System.out.println(ip + "位置添加成功！");
			// }
			// } else {
			// Address add = new Address();
			// add.setIp(ip);
			// add.setStates(0);
			// if (addressService.updateAddress(add) > 0) {
			// System.out.println("修改状态成功");
			// }
			// }
		}
	}

	static class HeartJump implements Runnable {
		private DataInputStream is;
		private Socket sck;
		private String imei;

		public HeartJump(Socket sck) {
			this.sck = sck;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				is = new DataInputStream(sck.getInputStream());
				byte[] bt1 = new byte[1024];
				while (is != null) {
					while (is.available() != 0) {
						is.read(bt1);
					}
					imei = Changedegital.bytesToString(bt1);
					if (imei.length() <= 0) {
						continue;
					}
					// 心跳的标识：#
					if (imei.charAt(0) == '#') {
						imei = imei.substring(1);
						channels.put(imei, sck);
					}

				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}

