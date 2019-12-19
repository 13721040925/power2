package cn.controller;

import java.net.Socket;
import java.util.Arrays;
import java.util.Map.Entry;
import java.util.Queue;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.entty.Consumer;
import cn.entty.Resolution;
import cn.service.CooperateService;
import cn.service.GroupService;
import cn.service.WarnlogService;
import cn.socketServer.GetRemotState;
import cn.socketServer.RemoteControl;
import cn.socketServer.ServerMain;
import cn.util.Translate;
@Controller
@RequestMapping("/pow") 
public class MyController {

	@Resource
	private CooperateService cooperateService;
	@Resource
	private GroupService groupService;
	@Resource
	private WarnlogService warnlogService;

	private static ServerMain serverMain;

	static {
		serverMain = new ServerMain();
	}


	/**
	 * 发送遥控命令
	 * 
	 * @param ip
	 * @param group
	 * @param type
	 * @param datai
	 * @return
	 */
	@RequestMapping(value = "/remote1", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String remote1(String ip, String group, String type, String datai) {
		try {
			System.out.println("ip=" + ip + ",group=" + group + ",type=" + type + ",datai=" + datai);
			Socket so = null;
			for (Entry<String, Socket> entry : serverMain.getChannels().entrySet()) {
				if (entry.getKey().equals(ip)) {
					System.out.println(">>>>>>>>>>>>>>>");
					so = entry.getValue();
					break;
				}
			}
			if (so != null) {
				System.out.println(so);
				synchronized (this) {
					RemoteControl remoteControl = new RemoteControl(so, group, type, datai);
					Thread th = new Thread(remoteControl);
					th.start();
					th.join();
					String msg = null;

					while ((msg = remoteControl.getMsg()) != null) {
						System.out.println(msg);
						break;
					}
					System.out.println(">>>>>>>>>>>遥控响应msg=" + msg);
					if (msg.trim().substring(7, 9).equals("00")) {// ~200147000000FDB2
						String[] commond_groups = { "01", "02", "03", "04", "05", "06", "07" };
						String[] reses = new String[commond_groups.length];
						Thread th1 = null;
						String msg1 = null;
						for (int i = 0; i < commond_groups.length; i++) {
							GetRemotState getRemotState = new GetRemotState(so, commond_groups[i]);
							th1 = new Thread(getRemotState);
							th1.start();
							th1.join();
							while ((msg1 = getRemotState.getMsg()) != null) {
								System.out.println(msg1);
								reses[i] = msg1;
								break;
							}
						}
						System.out.println(Arrays.toString(reses));
						if (Translate.tranRemoteState(ip, reses)) {
							return JSON.toJSONString("设置成功,刷新成功");
						}
						return JSON.toJSONString("设置成功,刷新失败");
					}
				}

			} else {
				JSON.toJSONString(ip + "未连接服务器");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(ip + "已经与服务器断开");
		}
		return JSON.toJSONString("设置失败");
	}

	@RequestMapping(value = "/upgrade", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String upgrade(String ip) {
		try {
			Socket so = null;
			for (Entry<String, Socket> entry : serverMain.getChannels().entrySet()) {
				if (entry.getKey().equals(ip)) {
					so = entry.getValue();
					break;
				}
			}
			if (so != null) {
				synchronized (this) {
					Queue<byte[]> resolution = Resolution.Resolution();

					Thread consumer = new Consumer(resolution, so);
					consumer.start();
				}
			} else {
				JSON.toJSONString(ip + "未连接服务器");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(ip + "已经与服务器断开");
		}
		return JSON.toJSONString("升级失败");
	}

}
