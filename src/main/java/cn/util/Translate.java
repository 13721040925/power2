package cn.util;

import java.net.Socket;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.pojo.Address;
import cn.pojo.Cooperate;
import cn.pojo.Group;
import cn.pojo.Individual;
import cn.pojo.RemoteState;
import cn.pojo.Warnlog;
import cn.service.AddressService;
import cn.service.CooperateService;
import cn.service.GroupService;
import cn.service.IndividualService;
import cn.service.RemoteStateService;
import cn.service.WarnlogService;
import cn.socketServer.GetVersion;

public class Translate {
	private static ApplicationContext app = new ClassPathXmlApplicationContext("spring-config.xml");
	private static CooperateService cooperateService;
	private static GroupService groupService;
	private static IndividualService individualService;
	private static WarnlogService warnlogService;
	private static RemoteStateService remoteStateService;
	private static AddressService addressService;

	static {
		cooperateService = app.getBean("cooperateService", CooperateService.class);
		groupService = app.getBean("groupService", GroupService.class);
		individualService = app.getBean("individualService", IndividualService.class);
		warnlogService = app.getBean("warnlogService", WarnlogService.class);
		remoteStateService = app.getBean("remoteStateService", RemoteStateService.class);
		addressService = app.getBean("addressService", AddressService.class);
	}

	public static String tranVer(String msg) {
		// ~20014700400C 0235 14130117 FB3F
		if (panduan(msg.trim().substring(7, 9))) {
			String m = msg.trim().substring(13, 15);
			String n = msg.trim().substring(15, 17);
			m = m.charAt(0) == '0' ? m.substring(1) : m;
			Integer o = Integer.parseInt(n, 16);
			n = o.toString().length() == 2 ? o.toString() : "0" + o.toString();
			String version = m + "." + n;
			System.out.println(version);
			return version;
		}
		return null;
	}
	public static boolean tranRemoteState(String ip, String[] msgs) {
		boolean flag = true;
		for (String msg : msgs) {
			if (!msg.trim().substring(7, 9).equals("00")) {
				flag = false;
				break;
			}
		}
		if (flag) {
			String cooperate_name = cooperateService.getCooperateByIp(ip).getCooperate_name();
			int group1xianliu = Integer.parseInt(msgs[0].trim().substring(14, 15));
			int group1inpower = Integer.parseInt(msgs[0].trim().substring(16, 17));
			int group1outpower = Integer.parseInt(msgs[0].trim().substring(18, 19));
			int group1inorder = Integer.parseInt(msgs[0].trim().substring(20, 21));
			int group1outorder = Integer.parseInt(msgs[0].trim().substring(22, 23));

			int group2xianliu = Integer.parseInt(msgs[1].trim().substring(14, 15));
			int group2inpower = Integer.parseInt(msgs[1].trim().substring(16, 17));
			int group2outpower = Integer.parseInt(msgs[1].trim().substring(18, 19));
			int group2inorder = Integer.parseInt(msgs[1].trim().substring(20, 21));
			int group2outorder = Integer.parseInt(msgs[1].trim().substring(22, 23));

			int group3xianliu = Integer.parseInt(msgs[2].trim().substring(14, 15));
			int group3inpower = Integer.parseInt(msgs[2].trim().substring(16, 17));
			int group3outpower = Integer.parseInt(msgs[2].trim().substring(18, 19));
			int group3inorder = Integer.parseInt(msgs[2].trim().substring(20, 21));
			int group3outorder = Integer.parseInt(msgs[2].trim().substring(22, 23));

			int group4xianliu = Integer.parseInt(msgs[3].trim().substring(14, 15));
			int group4inpower = Integer.parseInt(msgs[3].trim().substring(16, 17));
			int group4outpower = Integer.parseInt(msgs[3].trim().substring(18, 19));
			int group4inorder = Integer.parseInt(msgs[3].trim().substring(20, 21));
			int group4outorder = Integer.parseInt(msgs[3].trim().substring(22, 23));

			int group5xianliu = Integer.parseInt(msgs[4].trim().substring(14, 15));
			int group5inpower = Integer.parseInt(msgs[4].trim().substring(16, 17));
			int group5outpower = Integer.parseInt(msgs[4].trim().substring(18, 19));
			int group5inorder = Integer.parseInt(msgs[4].trim().substring(20, 21));
			int group5outorder = Integer.parseInt(msgs[4].trim().substring(22, 23));

			int group6xianliu = Integer.parseInt(msgs[5].trim().substring(14, 15));
			int group6inpower = Integer.parseInt(msgs[5].trim().substring(16, 17));
			int group6outpower = Integer.parseInt(msgs[5].trim().substring(18, 19));
			int group6inorder = Integer.parseInt(msgs[5].trim().substring(20, 21));
			int group6outorder = Integer.parseInt(msgs[5].trim().substring(22, 23));

			int inoutmodel = Integer.parseInt(msgs[6].trim().substring(14, 15));

			RemoteState remoteState = new RemoteState();
			remoteState.setCooperate_ip(ip);
			remoteState.setCooperate_name(cooperate_name);

			remoteState.setGroup1inorder(group1inorder);
			remoteState.setGroup1inpower(group1inpower);
			remoteState.setGroup1outorder(group1outorder);
			remoteState.setGroup1outpower(group1outpower);
			remoteState.setGroup1xianliu(group1xianliu);

			remoteState.setGroup2inorder(group2inorder);
			remoteState.setGroup2inpower(group2inpower);
			remoteState.setGroup2outorder(group2outorder);
			remoteState.setGroup2outpower(group2outpower);
			remoteState.setGroup2xianliu(group2xianliu);

			remoteState.setGroup3inorder(group3inorder);
			remoteState.setGroup3inpower(group3inpower);
			remoteState.setGroup3outorder(group3outorder);
			remoteState.setGroup3outpower(group3outpower);
			remoteState.setGroup3xianliu(group3xianliu);

			remoteState.setGroup4inorder(group4inorder);
			remoteState.setGroup4inpower(group4inpower);
			remoteState.setGroup4outorder(group4outorder);
			remoteState.setGroup4outpower(group4outpower);
			remoteState.setGroup4xianliu(group4xianliu);

			remoteState.setGroup5inorder(group5inorder);
			remoteState.setGroup5inpower(group5inpower);
			remoteState.setGroup5outorder(group5outorder);
			remoteState.setGroup5outpower(group5outpower);
			remoteState.setGroup5xianliu(group5xianliu);

			remoteState.setGroup6inorder(group6inorder);
			remoteState.setGroup6inpower(group6inpower);
			remoteState.setGroup6outorder(group6outorder);
			remoteState.setGroup6outpower(group6outpower);
			remoteState.setGroup6xianliu(group6xianliu);

			remoteState.setInoutmodel(inoutmodel);

			if (remoteStateService.checkRemoteState(ip) != null) {
				if (remoteStateService.updateRemoteState(remoteState) > 0) {
					return true;
				}
			} else {
				if (remoteStateService.addRemoteState(remoteState) > 0) {
					return true;
				}
			}
		}
		return false;
	}

	public static String transLog(String imei, String res, String ip, Socket socket) {
		String logtime = DateUtil.convertUtilDateToString(new Date());
		String state = "0";
		String DATA_FALG = "";
		String VER = res.substring(1, 3);
		String ADR = res.substring(3, 5);
		String CRD1 = res.substring(5, 7);
		String RTN = res.substring(7, 9);
		if (panduan(RTN)) {
			String LENGTH = res.substring(9, 13);
			String LENID = res.substring(10, 13);
			int INFO_Len = Integer.parseInt(LENID, 16) / 2;
			DATA_FALG = res.substring(13, 15);
			switch (DATA_FALG) {
			case "00": {
				System.out.println("无未读取的开关量变化,无未读取的告警量变化");
				break;
			}
			case "11": {
				System.out.println("有未读取的开关量变化,有未读取的告警量变化");
				state = "1";
				break;
			}
			case "01": {
				System.out.println("无未读取的开关量变化,有未读取的告警量变化");
				state = "1";
				break;
			}
			case "10": {
				System.out.println("有未读取的开关量变化,无未读取的告警量变化");
				break;
			}
			}

			String str = "";
			int n = 0;
			str = res.substring(15, 19);
			n = Integer.parseInt(str, 16);
			double group1V = n / 100;
			str = res.substring(19, 23);
			n = Integer.parseInt(Changedegital.hexToNumber(str, 1.0).toString());
			double group1A = n / 10;
			str = res.substring(23, 27);
			n = Integer.parseInt(str, 16);
			int group1AH = n;

			str = res.substring(27, 31);
			n = Integer.parseInt(str, 16);
			double group2V = n / 100;
			str = res.substring(31, 35);
			n = Integer.parseInt(Changedegital.hexToNumber(str, 1.0).toString());
			double group2A = n / 10;
			str = res.substring(35, 39);
			n = Integer.parseInt(str, 16);
			int group2AH = n;

			str = res.substring(39, 43);
			n = Integer.parseInt(str, 16);
			double group3V = n / 100;
			str = res.substring(43, 47);
			n = Integer.parseInt(Changedegital.hexToNumber(str, 1.0).toString());
			double group3A = n / 10;
			str = res.substring(47, 51);
			n = Integer.parseInt(str, 16);
			int group3AH = n;

			str = res.substring(51, 55);
			n = Integer.parseInt(str, 16);
			double group4V = n / 100;
			str = res.substring(55, 59);
			n = Integer.parseInt(Changedegital.hexToNumber(str, 1.0).toString());
			double group4A = n / 10;
			str = res.substring(59, 63);
			n = Integer.parseInt(str, 16);
			int group4AH = n;

			str = res.substring(63, 67);
			n = Integer.parseInt(str, 16);
			double group5V = n / 100;
			str = res.substring(67, 71);
			n = Integer.parseInt(Changedegital.hexToNumber(str, 1.0).toString());
			double group5A = n / 10;
			str = res.substring(71, 75);
			n = Integer.parseInt(str, 16);
			int group5AH = n;

			str = res.substring(75, 79);
			n = Integer.parseInt(str, 16);
			double group6V = n / 100;
			str = res.substring(79, 83);
			n = Integer.parseInt(Changedegital.hexToNumber(str, 1.0).toString());
			double group6A = n / 10;
			str = res.substring(83, 87);
			n = Integer.parseInt(str, 16);
			int group6AH = n;

			str = res.substring(87, 91);
			n = Integer.parseInt(str, 16);
			double fdtime = n / 10;// 放电倒计时
			str = res.substring(91, 95);
			n = Integer.parseInt(str, 16);
			int totaltime = n;// 放电总时长
			str = res.substring(95, 97);
			n = Integer.parseInt(str, 16);
			int onlioncount = n;// 电池组在线数量

			str = res.substring(97, 99);
			n = Integer.parseInt(str, 16);
			int group1m = n;// 电池组1的单体个数m1
			double[] group1mV = new double[group1m];
			int start = 99;
			for (int i = 0; i < group1m; i++) {
				str = res.substring(start, start + 4);
				n = Integer.parseInt(str, 16);
				double v = n / 1000;
				group1mV[i] = v;
				start += 4;
			}

			str = res.substring(start, start + 2);
			n = Integer.parseInt(str, 16);
			int group2m = n;// 电池组2的单体个数m2
			double[] group2mV = new double[group2m];
			start += 2;
			for (int i = 0; i < group2m; i++) {
				str = res.substring(start, start + 4);
				n = Integer.parseInt(str, 16);
				double v = n / 1000;
				group2mV[i] = v;
				start += 4;
			}

			str = res.substring(start, start + 2);
			n = Integer.parseInt(str, 16);
			int group3m = n;// 电池组3的单体个数m3
			double[] group3mV = new double[group3m];
			start += 2;
			for (int i = 0; i < group3m; i++) {
				str = res.substring(start, start + 4);
				n = Integer.parseInt(str, 16);
				double v = n / 1000;
				group3mV[i] = v;
				start += 4;
			}

			str = res.substring(start, start + 2);
			n = Integer.parseInt(str, 16);
			int group4m = n;// 电池组4的单体个数m4
			double[] group4mV = new double[group4m];
			start += 2;
			for (int i = 0; i < group4m; i++) {
				str = res.substring(start, start + 4);
				n = Integer.parseInt(str, 16);
				double v = n / 1000;
				group4mV[i] = v;
				start += 4;
			}

			str = res.substring(start, start + 2);
			n = Integer.parseInt(str, 16);
			int group5m = n;// 电池组5的单体个数m5
			double[] group5mV = new double[group5m];
			start += 2;
			for (int i = 0; i < group5m; i++) {
				str = res.substring(start, start + 4);
				n = Integer.parseInt(str, 16);
				double v = n / 1000;
				group5mV[i] = v;
				start += 4;
			}

			str = res.substring(start, start + 2);
			n = Integer.parseInt(str, 16);
			int group6m = n;// 电池组6的单体个数m6
			double[] group6mV = new double[group6m];
			start += 2;
			for (int i = 0; i < group6m; i++) {
				str = res.substring(start, start + 4);
				n = Integer.parseInt(str, 16);
				double v = n / 1000;
				group6mV[i] = v;
				start += 4;
			} // 电池组6 END

			str = res.substring(start, start + 2);
			n = Integer.parseInt(str, 16);
			int group1n = n;// 电池组1（或单体）温度数n1
			double[] group1nTem = new double[group1n];
			start += 2;
			for (int i = 0; i < group1n; i++) {
				str = res.substring(start, start + 4);
				n = Integer.parseInt(Changedegital.hexToNumber(str, 1.0).toString());
				double v = n;
				group1nTem[i] = v;
				start += 4;
			}

			str = res.substring(start, start + 2);
			n = Integer.parseInt(str, 16);
			int group2n = n;// 电池组2（或单体）温度数n2
			double[] group2nTem = new double[group2n];
			start += 2;
			for (int i = 0; i < group2n; i++) {
				str = res.substring(start, start + 4);
				n = Integer.parseInt(Changedegital.hexToNumber(str, 1.0).toString());
				double v = n;
				group2nTem[i] = v;
				start += 4;
			}

			str = res.substring(start, start + 2);
			n = Integer.parseInt(str, 16);
			int group3n = n;// 电池组3（或单体）温度数n3
			double[] group3nTem = new double[group3n];
			start += 2;
			for (int i = 0; i < group3n; i++) {
				str = res.substring(start, start + 4);
				n = Integer.parseInt(Changedegital.hexToNumber(str, 1.0).toString());
				double v = n;
				group3nTem[i] = v;
				start += 4;
			}

			str = res.substring(start, start + 2);
			n = Integer.parseInt(str, 16);
			int group4n = n;// 电池组4（或单体）温度数n4
			double[] group4nTem = new double[group4n];
			start += 2;
			for (int i = 0; i < group4n; i++) {
				str = res.substring(start, start + 4);
				n = Integer.parseInt(Changedegital.hexToNumber(str, 1.0).toString());
				double v = n;
				group4nTem[i] = v;
				start += 4;
			}

			str = res.substring(start, start + 2);
			n = Integer.parseInt(str, 16);
			int group5n = n;// 电池组5（或单体）温度数n5
			double[] group5nTem = new double[group5n];
			start += 2;
			for (int i = 0; i < group5n; i++) {
				str = res.substring(start, start + 4);
				n = Integer.parseInt(Changedegital.hexToNumber(str, 1.0).toString());
				double v = n;
				group5nTem[i] = v;
				start += 4;
			}

			str = res.substring(start, start + 2);
			n = Integer.parseInt(str, 16);
			int group6n = n;// 电池组6（或单体）温度数n6
			double[] group6nTem = new double[group6n];
			start += 2;
			for (int i = 0; i < group6n; i++) {
				str = res.substring(start, start + 4);
				n = Integer.parseInt(Changedegital.hexToNumber(str, 1.0).toString());
				double v = n;
				group6nTem[i] = v;
				start += 4;
			}

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			int group1DOD = n;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			int group2DOD = n;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			int group3DOD = n;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			int group4DOD = n;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			int group5DOD = n;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			int group6DOD = n;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			double group1MiddleV = n / 100;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			double group2MiddleV = n / 100;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			double group3MiddleV = n / 100;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			double group4MiddleV = n / 100;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			double group5MiddleV = n / 100;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			double group6MiddleV = n / 100;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			int group1SurplusTime = n;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			int group2SurplusTime = n;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			int group3SurplusTime = n;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			int group4SurplusTime = n;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			int group5SurplusTime = n;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			int group6SurplusTime = n;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			int group1TotalTime = n;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			int group2TotalTime = n;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			int group3TotalTime = n;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			int group4TotalTime = n;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			int group5TotalTime = n;
			start += 4;

			str = res.substring(start, start + 4);
			n = Integer.parseInt(str, 16);
			int group6TotalTime = n;
			start += 4;

			String CHKSUM = res.substring(start, start + 4);

			String version = null;
			try {
				GetVersion getVersion = new GetVersion(socket);
				Thread ths = new Thread(getVersion);
				ths.start();
				ths.join();
				String verMsg = null;
				while ((verMsg = getVersion.getMsg()) != null) {
					System.out.println("verMsg=" + verMsg);
					break;
				}
				if (verMsg != null) {
					version = tranVer(verMsg);
				}
				version = version == null ? "" : version;
				System.out.println("version=" + version);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Cooperate cooperate = addCooperate(fdtime, totaltime, onlioncount, ip, state, logtime, version);
			List<Cooperate> cooperates = cooperateService.getCooperateByName(cooperate);
			cooperate = cooperates.get(cooperates.size() - 1);
			String cooperate_name = cooperate.getCooperate_name();
			Long cooperate_id = cooperate.getId();

			int batter_type1 = group1m > 0 ? 1 : 0;
			Group group1 = addGroup(cooperate_id, cooperate_name, batter_type1, group1V, group1A, group1AH, group1m,
					group1n, group1DOD, group1MiddleV, group1SurplusTime, group1TotalTime, 1);
			List<Group> group1s = groupService.getGroupByName(group1);
			group1 = group1s.get(group1s.size() - 1);
			Long group1_id = group1.getId();
			String group1_name = group1.getGroup_name();
			if (addIndividual(group1_id, group1_name, group1mV, group1nTem, group1m, group1n)) {
				System.out.println("group1单体添加成功！");
			}

			int batter_type2 = group2m > 0 ? 1 : 0;
			Group group2 = addGroup(cooperate_id, cooperate_name, batter_type2, group2V, group2A, group2AH, group2m,
					group2n, group2DOD, group2MiddleV, group2SurplusTime, group2TotalTime, 2);
			List<Group> group2s = groupService.getGroupByName(group2);
			group2 = group2s.get(group2s.size() - 1);
			Long group2_id = group2.getId();
			String group2_name = group2.getGroup_name();
			if (addIndividual(group2_id, group2_name, group2mV, group2nTem, group1m, group1n)) {
				System.out.println("group2单体添加成功！");
			}

			int batter_type3 = group3m > 0 ? 1 : 0;
			Group group3 = addGroup(cooperate_id, cooperate_name, batter_type3, group3V, group3A, group3AH, group3m,
					group3n, group3DOD, group3MiddleV, group3SurplusTime, group3TotalTime, 3);
			List<Group> group3s = groupService.getGroupByName(group3);
			group3 = group3s.get(group3s.size() - 1);
			Long group3_id = group3.getId();
			String group3_name = group3.getGroup_name();
			if (addIndividual(group3_id, group3_name, group3mV, group3nTem, group1m, group1n)) {
				System.out.println("group3单体添加成功！");
			}

			int batter_type4 = group4m > 0 ? 1 : 0;
			Group group4 = addGroup(cooperate_id, cooperate_name, batter_type4, group4V, group4A, group4AH, group4m,
					group4n, group4DOD, group4MiddleV, group4SurplusTime, group4TotalTime, 4);
			List<Group> group4s = groupService.getGroupByName(group4);
			group4 = group4s.get(group4s.size() - 1);
			Long group4_id = group4.getId();
			String group4_name = group4.getGroup_name();
			if (addIndividual(group4_id, group4_name, group4mV, group4nTem, group1m, group1n)) {
				System.out.println("group4单体添加成功！");
			}

			int batter_type5 = group5m > 0 ? 1 : 0;
			Group group5 = addGroup(cooperate_id, cooperate_name, batter_type5, group5V, group5A, group5AH, group5m,
					group5n, group5DOD, group5MiddleV, group5SurplusTime, group5TotalTime, 5);
			List<Group> group5s = groupService.getGroupByName(group5);
			group5 = group5s.get(group5s.size() - 1);
			Long group5_id = group5.getId();
			String group5_name = group5.getGroup_name();
			if (addIndividual(group5_id, group5_name, group5mV, group5nTem, group1m, group1n)) {
				System.out.println("group5单体添加成功！");
			}

			int batter_type6 = group6m > 0 ? 1 : 0;
			Group group6 = addGroup(cooperate_id, cooperate_name, batter_type6, group6V, group6A, group6AH, group6m,
					group6n, group6DOD, group6MiddleV, group6SurplusTime, group6TotalTime, 6);
			List<Group> group6s = groupService.getGroupByName(group6);
			group6 = group6s.get(group6s.size() - 1);
			Long group6_id = group6.getId();
			String group6_name = group6.getGroup_name();
			if (addIndividual(group6_id, group6_name, group6mV, group6nTem, group1m, group1n)) {
				System.out.println("group6单体添加成功！");
			}
			// TODO
			if (addressService.getAddressByIp(ip) == null) {
				Address address = new Address();
				address.setIp(ip);
				address.setCooperate_name(cooperate_name);
				address.setStates(0);
				if (addressService.addAddress(address) > 0) {
					System.out.println(ip + "位置添加成功！");
				}
			}
		}
		return DATA_FALG;

	}

	public static Cooperate addCooperate(double fdtime, int totaltime, int onlioncount, String ip, String state,
			String logtime, String version) {
		Cooperate cooperate = new Cooperate();
		cooperate.setIp(ip);
		cooperate.setState(state);
		cooperate.setLogtime(logtime);
		cooperate.setFdtime(fdtime);
		cooperate.setTotaltime(totaltime);
		cooperate.setOnlioncount(onlioncount);
		cooperate.setVersion(version);
		Address address = addressService.getAddressByIp(ip);
		String cooperate_name = "";
		if (address != null) {
			if (address.getCooperate_name() != null && !address.getCooperate_name().equals("")) {
				cooperate_name = address.getCooperate_name();
			} else {
				cooperate_name = ip;
			}
		} else {
			cooperate_name = ip;
		}

		cooperate.setCooperate_name(cooperate_name);
		if (cooperateService.addCooperate(cooperate) > 0) {
			System.out.println("cooperate添加成功！");
		}
		return cooperate;

	}

	public static Group addGroup(Long cooperate_id, String cooperate_name, int batter_type, Double group_v,
			Double group_a,
			Integer group_ah, Integer indi_m, Integer indi_n, Integer dod, Double middle_v, Integer surplus_time,
			Integer group_total_time, int n) {
		Group group=new Group();
		group.setCooperate_id(cooperate_id);
		group.setCooperate_name(cooperate_name);
		group.setBatter_type(batter_type);
		group.setGroup_v(group_v);
		group.setGroup_a(group_a);
		group.setGroup_ah(group_ah);
		group.setIndi_m(indi_m);
		group.setIndi_n(indi_n);
		group.setDod(dod);
		group.setMiddle_v(middle_v);
		group.setSurplus_time(surplus_time);
		group.setGroup_total_time(group_total_time);
		String group_name = cooperate_name + "_group" + n;
		group.setGroup_name(group_name);
		group.setGroup_num(n);
		if (groupService.addGroup(group) > 0) {
			System.out.println("group" + n + "添加成功！");
		}
		return group;

	}

	public static boolean addIndividual(Long group_id, String group_name, double[] groupmV, double[] groupnTem,
			int groupm, int groupn) {
		int n = (groupn == 0) ? 0 : (groupm / groupn);
		// int m=group1m%group1n;
		boolean flag = true;
		int j = 0;
		for (int i = 0; i < groupmV.length; i++) {
			Individual individual = new Individual();
			Double indi_v = groupmV[i];
			if (groupn == 0) {
				individual.setIndi_tem(0.0);
			} else {
				if (groupmV.length > 0) {
					Double indi_tem = (j > groupmV.length - 1) ? groupnTem[groupmV.length - 1] : groupnTem[j];
					individual.setIndi_tem(indi_tem);
				} else {
					individual.setIndi_tem(0.0);
				}
			}

			individual.setGroup_id(group_id);
			individual.setGroup_name(group_name);
			individual.setIndi_v(indi_v);

			individual.setIndi_num(i + 1);
			if (individualService.addIndividual(individual) <= 0) {
				flag = false;
			}
			if (groupn != 0) {
				if ((i + 1) % n == 0) {
					j++;
				}
			}

		}
		return flag;

	}

	public static boolean tranWarn(String res, String ip) {
		String warntime=DateUtil.convertUtilDateToString(new Date());
		String VER = res.substring(1, 3);
		String ADR = res.substring(3, 5);
		String CRD1 = res.substring(5, 7);
		String RTN = res.substring(7, 9);
		if (panduan(RTN)) {
			Address address = addressService.getAddressByIp(ip);
			String cooperate_name = "";

			if (address.getCooperate_name() != null && !address.getCooperate_name().equals("")) {
				cooperate_name = address.getCooperate_name();
			} else {
				cooperate_name = ip;
			}
			int address_cooperate_id = address.getId();
			String LENGTH = res.substring(9, 13);
			String LENID = res.substring(10, 13);
			int INFO_Len = Integer.parseInt(LENID, 16) / 2;
			String DATA_FALG = res.substring(13, 15);
			String str = "";
			str = res.substring(15, 17);
			String group1Pro = Changedegital.buwei(Changedegital.conver2HexStr(Changedegital.conver16HexToByte(str)),
					8);
			str = res.substring(17, 19);
			String group1Warn = Changedegital.buwei(Changedegital.conver2HexStr(Changedegital.conver16HexToByte(str)),
					8);
			str = res.substring(19, 21);
			String group1Other = Changedegital.buwei(Changedegital.conver2HexStr(Changedegital.conver16HexToByte(str)),
					8);
			// TODO
				int group_id = 1;
				int type = 1;
			if (group1Pro.charAt(0) == '1') {
				long child_warn_id = 1;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group1Pro.charAt(2) == '1') {
				long child_warn_id = 2;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group1Pro.charAt(3) == '1') {
				long child_warn_id = 3;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group1Pro.charAt(4) == '1') {
				long child_warn_id = 4;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group1Pro.charAt(5) == '1') {
				long child_warn_id = 5;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group1Pro.charAt(6) == '1') {
				long child_warn_id = 6;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group1Pro.charAt(7) == '1') {
				long child_warn_id = 7;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			type = 2;
			if (group1Warn.charAt(0) == '1') {
				long child_warn_id = 1;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group1Warn.charAt(1) == '1') {
				long child_warn_id = 2;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group1Warn.charAt(2) == '1') {
				long child_warn_id = 3;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group1Warn.charAt(3) == '1') {
				long child_warn_id = 4;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group1Warn.charAt(4) == '1') {
				long child_warn_id = 5;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group1Warn.charAt(5) == '1') {
				long child_warn_id = 6;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group1Warn.charAt(6) == '1') {
				long child_warn_id = 7;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group1Warn.charAt(7) == '1') {
				long child_warn_id = 8;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			type = 3;
			if (group1Other.charAt(3) == '1') {
				long child_warn_id = 1;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group1Other.charAt(4) == '1') {
				long child_warn_id = 2;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group1Other.charAt(5) == '1') {
				long child_warn_id = 3;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
				}
			if (group1Other.charAt(6) == '1') {
				long child_warn_id = 4;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
				}
			if (group1Other.charAt(7) == '1') {
				long child_warn_id = 5;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
				}


			str = res.substring(21, 23);
			String group2Pro = Changedegital.buwei(Changedegital.conver2HexStr(Changedegital.conver16HexToByte(str)),
					8);
			str = res.substring(23, 25);
			String group2Warn = Changedegital.buwei(Changedegital.conver2HexStr(Changedegital.conver16HexToByte(str)),
					8);
			str = res.substring(25, 27);
			String group2Other = Changedegital.buwei(Changedegital.conver2HexStr(Changedegital.conver16HexToByte(str)),
					8);
			group_id = 2;
			type = 1;
			if (group2Pro.charAt(0) == '1') {
				long child_warn_id = 1;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group2Pro.charAt(2) == '1') {
				long child_warn_id = 2;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group2Pro.charAt(3) == '1') {
				long child_warn_id = 3;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group2Pro.charAt(4) == '1') {
				long child_warn_id = 4;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group2Pro.charAt(5) == '1') {
				long child_warn_id = 5;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group2Pro.charAt(6) == '1') {
				long child_warn_id = 6;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group2Pro.charAt(7) == '1') {
				long child_warn_id = 7;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			type = 2;
			if (group2Warn.charAt(0) == '1') {
				long child_warn_id = 1;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group2Warn.charAt(1) == '1') {
				long child_warn_id = 2;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group2Warn.charAt(2) == '1') {
				long child_warn_id = 3;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group2Warn.charAt(3) == '1') {
				long child_warn_id = 4;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group2Warn.charAt(4) == '1') {
				long child_warn_id = 5;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group2Warn.charAt(5) == '1') {
				long child_warn_id = 6;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group2Warn.charAt(6) == '1') {
				long child_warn_id = 7;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group2Warn.charAt(7) == '1') {
				long child_warn_id = 8;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			type = 3;
			if (group2Other.charAt(3) == '1') {
				long child_warn_id = 1;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group2Other.charAt(4) == '1') {
				long child_warn_id = 2;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group2Other.charAt(5) == '1') {
				long child_warn_id = 3;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group2Other.charAt(6) == '1') {
				long child_warn_id = 4;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group2Other.charAt(7) == '1') {
				long child_warn_id = 5;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}

			str = res.substring(27, 29);
			String group3Pro = Changedegital.buwei(Changedegital.conver2HexStr(Changedegital.conver16HexToByte(str)),
					8);
			str = res.substring(29, 31);
			String group3Warn = Changedegital.buwei(Changedegital.conver2HexStr(Changedegital.conver16HexToByte(str)),
					8);
			str = res.substring(31, 33);
			String group3Other = Changedegital.buwei(Changedegital.conver2HexStr(Changedegital.conver16HexToByte(str)),
					8);
			group_id = 3;
			type = 1;
			if (group3Pro.charAt(0) == '1') {
				long child_warn_id = 1;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group3Pro.charAt(2) == '1') {
				long child_warn_id = 2;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group3Pro.charAt(3) == '1') {
				long child_warn_id = 3;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group3Pro.charAt(4) == '1') {
				long child_warn_id = 4;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group3Pro.charAt(5) == '1') {
				long child_warn_id = 5;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group3Pro.charAt(6) == '1') {
				long child_warn_id = 6;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group3Pro.charAt(7) == '1') {
				long child_warn_id = 7;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			type = 2;
			if (group3Warn.charAt(0) == '1') {
				long child_warn_id = 1;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group3Warn.charAt(1) == '1') {
				long child_warn_id = 2;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group3Warn.charAt(2) == '1') {
				long child_warn_id = 3;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group3Warn.charAt(3) == '1') {
				long child_warn_id = 4;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group3Warn.charAt(4) == '1') {
				long child_warn_id = 5;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group3Warn.charAt(5) == '1') {
				long child_warn_id = 6;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group3Warn.charAt(6) == '1') {
				long child_warn_id = 7;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group3Warn.charAt(7) == '1') {
				long child_warn_id = 8;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			type = 3;
			if (group3Other.charAt(3) == '1') {
				long child_warn_id = 1;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group3Other.charAt(4) == '1') {
				long child_warn_id = 2;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group3Other.charAt(5) == '1') {
				long child_warn_id = 3;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group3Other.charAt(6) == '1') {
				long child_warn_id = 4;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group3Other.charAt(7) == '1') {
				long child_warn_id = 5;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}

			str = res.substring(33, 35);
			String group4Pro = Changedegital.buwei(Changedegital.conver2HexStr(Changedegital.conver16HexToByte(str)),
					8);
			str = res.substring(35, 37);
			String group4Warn = Changedegital.buwei(Changedegital.conver2HexStr(Changedegital.conver16HexToByte(str)),
					8);
			str = res.substring(37, 39);
			String group4Other = Changedegital.buwei(Changedegital.conver2HexStr(Changedegital.conver16HexToByte(str)),
					8);
			group_id = 4;
			type = 1;
			if (group4Pro.charAt(0) == '1') {
				long child_warn_id = 1;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group4Pro.charAt(2) == '1') {
				long child_warn_id = 2;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group4Pro.charAt(3) == '1') {
				long child_warn_id = 3;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group4Pro.charAt(4) == '1') {
				long child_warn_id = 4;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group4Pro.charAt(5) == '1') {
				long child_warn_id = 5;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group4Pro.charAt(6) == '1') {
				long child_warn_id = 6;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group4Pro.charAt(7) == '1') {
				long child_warn_id = 7;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			type = 2;
			if (group4Warn.charAt(0) == '1') {
				long child_warn_id = 1;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group4Warn.charAt(1) == '1') {
				long child_warn_id = 2;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group4Warn.charAt(2) == '1') {
				long child_warn_id = 3;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group4Warn.charAt(3) == '1') {
				long child_warn_id = 4;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group4Warn.charAt(4) == '1') {
				long child_warn_id = 5;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group4Warn.charAt(5) == '1') {
				long child_warn_id = 6;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group4Warn.charAt(6) == '1') {
				long child_warn_id = 7;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group4Warn.charAt(7) == '1') {
				long child_warn_id = 8;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			type = 3;
			if (group4Other.charAt(3) == '1') {
				long child_warn_id = 1;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group4Other.charAt(4) == '1') {
				long child_warn_id = 2;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group4Other.charAt(5) == '1') {
				long child_warn_id = 3;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group4Other.charAt(6) == '1') {
				long child_warn_id = 4;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group4Other.charAt(7) == '1') {
				long child_warn_id = 5;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}

			str = res.substring(39, 41);
			String group5Pro = Changedegital.buwei(Changedegital.conver2HexStr(Changedegital.conver16HexToByte(str)),
					8);
			str = res.substring(41, 43);
			String group5Warn = Changedegital.buwei(Changedegital.conver2HexStr(Changedegital.conver16HexToByte(str)),
					8);
			str = res.substring(43, 45);
			String group5Other = Changedegital.buwei(Changedegital.conver2HexStr(Changedegital.conver16HexToByte(str)),
					8);
			group_id = 5;
			type = 1;
			if (group5Pro.charAt(0) == '1') {
				long child_warn_id = 1;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group5Pro.charAt(2) == '1') {
				long child_warn_id = 2;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group5Pro.charAt(3) == '1') {
				long child_warn_id = 3;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group5Pro.charAt(4) == '1') {
				long child_warn_id = 4;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group5Pro.charAt(5) == '1') {
				long child_warn_id = 5;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group5Pro.charAt(6) == '1') {
				long child_warn_id = 6;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group5Pro.charAt(7) == '1') {
				long child_warn_id = 7;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			type = 2;
			if (group5Warn.charAt(0) == '1') {
				long child_warn_id = 1;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group5Warn.charAt(1) == '1') {
				long child_warn_id = 2;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group5Warn.charAt(2) == '1') {
				long child_warn_id = 3;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group5Warn.charAt(3) == '1') {
				long child_warn_id = 4;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group5Warn.charAt(4) == '1') {
				long child_warn_id = 5;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group5Warn.charAt(5) == '1') {
				long child_warn_id = 6;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group5Warn.charAt(6) == '1') {
				long child_warn_id = 7;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group5Warn.charAt(7) == '1') {
				long child_warn_id = 8;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			type = 3;
			if (group5Other.charAt(3) == '1') {
				long child_warn_id = 1;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group5Other.charAt(4) == '1') {
				long child_warn_id = 2;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group5Other.charAt(5) == '1') {
				long child_warn_id = 3;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group5Other.charAt(6) == '1') {
				long child_warn_id = 4;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group5Other.charAt(7) == '1') {
				long child_warn_id = 5;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}

			str = res.substring(45, 47);
			String group6Pro = Changedegital.buwei(Changedegital.conver2HexStr(Changedegital.conver16HexToByte(str)),
					8);
			str = res.substring(47, 49);
			String group6Warn = Changedegital.buwei(Changedegital.conver2HexStr(Changedegital.conver16HexToByte(str)),
					8);
			str = res.substring(49, 51);
			String group6Other = Changedegital.buwei(Changedegital.conver2HexStr(Changedegital.conver16HexToByte(str)),
					8);
			group_id = 6;
			type = 1;
			if (group6Pro.charAt(0) == '1') {
				long child_warn_id = 1;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group6Pro.charAt(2) == '1') {
				long child_warn_id = 2;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group6Pro.charAt(3) == '1') {
				long child_warn_id = 3;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group6Pro.charAt(4) == '1') {
				long child_warn_id = 4;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group6Pro.charAt(5) == '1') {
				long child_warn_id = 5;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group6Pro.charAt(6) == '1') {
				long child_warn_id = 6;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group6Pro.charAt(7) == '1') {
				long child_warn_id = 7;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			type = 2;
			if (group6Warn.charAt(0) == '1') {
				long child_warn_id = 1;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group6Warn.charAt(1) == '1') {
				long child_warn_id = 2;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group6Warn.charAt(2) == '1') {
				long child_warn_id = 3;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group6Warn.charAt(3) == '1') {
				long child_warn_id = 4;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group6Warn.charAt(4) == '1') {
				long child_warn_id = 5;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group6Warn.charAt(5) == '1') {
				long child_warn_id = 6;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group6Warn.charAt(6) == '1') {
				long child_warn_id = 7;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group6Warn.charAt(7) == '1') {
				long child_warn_id = 8;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			type = 3;
			if (group6Other.charAt(3) == '1') {
				long child_warn_id = 1;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group6Other.charAt(4) == '1') {
				long child_warn_id = 2;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group6Other.charAt(5) == '1') {
				long child_warn_id = 3;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group6Other.charAt(6) == '1') {
				long child_warn_id = 4;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}
			if (group6Other.charAt(7) == '1') {
				long child_warn_id = 5;
				boolean f = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, group_id, type,
						child_warn_id);
				if (!f) {
					System.out.println("添加失败！");
				}
			}

			str = res.substring(51, 53);
			int n = (byte) Integer.parseInt(str, 16);
			double glqtemp = n;
			long temp_child_warn_id = (long) (glqtemp * 100);
			int temp_type = 4;
			int temp_group_id = (int) (glqtemp * 100);
			boolean tempf = addWarnLog(warntime, ip, address_cooperate_id, cooperate_name, temp_group_id, temp_type,
					temp_child_warn_id);
			if (!tempf) {
				System.out.println("管理器温度添加失败");
				return false;
			}
			return true;
		}
		return false;
	}

	public static boolean addWarnLog(String warntime, String ip, int address_cooperate_id, String cooperate_name,
			int group_id, int type, long child_warn_id) {
		Warnlog warnlog = new Warnlog();
		warnlog.setWarntime(warntime);
		warnlog.setIp(ip);
		warnlog.setAddress_cooperate_id(address_cooperate_id);
		warnlog.setCooperate_name(cooperate_name);
		warnlog.setGroup_id(group_id);
		warnlog.setType(type);
		warnlog.setChild_warn_id(child_warn_id);
		if (warnlogService.addWarnLog(warnlog) > 0) {
			System.out.println("WarnLog add success!");
			return true;
		}
		return false;
	}

	public static boolean panduan(String RTN) {
		switch (RTN) {
		case "00": {
			System.out.println("正常");
			return true;
		}
		case "01": {
			System.out.println("VER错");
			break;
		}
		case "02": {
			System.out.println("CHKSUM错");
			break;
		}
		case "03": {
			System.out.println("LCHKSUM错");
			break;
		}
		case "04": {
			System.out.println("CID2无效");
			break;
		}
		case "05": {
			System.out.println("命令格式错");
			break;
		}
		case "06": {
			System.out.println("无效数据");
			break;
		}
		case "07": {
			System.out.println("无数据");
			break;
		}
		case "E1": {
			System.out.println("CID1无效");
			break;
		}
		case "E2": {
			System.out.println("命令执行失败");
			break;
		}
		case "E3": {
			System.out.println("设备故障");
			break;
		}
		case "E4": {
			System.out.println("无效权限");
			break;
		}
		case "E5": {
			System.out.println("设备写保护");
			break;
		}
		case "FF": {
			System.out.println("不用返回响应包");
			break;
		}
		default: {
			System.out.println("其他错误");
			break;
		}
		}
		return false;

	}
}
