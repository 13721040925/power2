package cn.entty;

public class Upgrade {

	//启动升级命令
	private byte[] Startu = { (byte) 0x7E, (byte) 0x32, (byte) 0x30, (byte) 0x30, (byte) 0x31, (byte) 0x34, (byte) 0x37,(byte)0x38,(byte)0x32,
			(byte) 0x45, (byte) 0x30, (byte) 0x30, (byte) 0x32, 
			(byte) 0x30, (byte) 0x31, 
			(byte) 0x46, (byte) 0x44,(byte) 0x33, (byte) 0x30,
			(byte) 0x0D };
	
	//取消升级命令
	private byte[] Undou = { (byte) 0x7E, (byte) 0x32, (byte) 0x30, (byte) 0x30, (byte) 0x31, (byte) 0x34, (byte) 0x37,(byte)0x38,(byte)0x32,
			(byte) 0x45, (byte) 0x30, (byte) 0x30, (byte) 0x32, 
			(byte) 0x30, (byte) 0x30, 
			(byte) 0x46, (byte) 0x44,(byte) 0x33, (byte) 0x31,
			(byte) 0x0D };

	//启动命令的响应
	//放电,拒绝升级
	private byte[] StartResponse1 = { (byte) 0x7E, (byte) 0x32, (byte) 0x30, (byte) 0x30, (byte) 0x31, (byte) 0x34, (byte) 0x37,(byte)0x30,(byte)0x30,
			(byte) 0x45, (byte) 0x30, (byte) 0x30, (byte) 0x32, 
			(byte) 0x30, (byte) 0x31, 
			(byte) 0x46, (byte) 0x44,(byte) 0x34, (byte) 0x41,
			(byte) 0x0D };
	
	//取消升级
	private byte[] StartResponse2 = { (byte) 0x7E, (byte) 0x32, (byte) 0x30, (byte) 0x30, (byte) 0x31, (byte) 0x34, (byte) 0x37,(byte)0x30,(byte)0x30,
			(byte) 0x45, (byte) 0x30, (byte) 0x30, (byte) 0x32, 
			(byte) 0x30, (byte) 0x31, 
			(byte) 0x46, (byte) 0x38,(byte) 0x33, (byte) 0x33,
			(byte) 0x0D };
	
	//接收升级
	private byte[] StartResponse3 = { (byte) 0x7E, (byte) 0x32, (byte) 0x30, (byte) 0x30, (byte) 0x31, (byte) 0x34, (byte) 0x37,(byte)0x30,(byte)0x30,
			(byte) 0x45, (byte) 0x30, (byte) 0x30, (byte) 0x32, 
			(byte) 0x46, (byte) 0x46, 
			(byte) 0x46, (byte) 0x38,(byte) 0x30, (byte) 0x46,
			(byte) 0x0D };
	
	
	//设置升级包信息命令信息
	private byte[] setUpgrade = {(byte)0x7E, (byte)0x32, (byte)0x30, (byte)0x30, (byte)0x31, (byte)0x34, (byte)0x37, (byte)0x38, (byte)0x33, (byte)0x42,
			(byte)0x30, (byte)0x31, (byte)0x34, (byte)0x30, (byte)0x33, (byte)0x30, (byte)0x41, (byte)0x31, (byte)0x34, (byte)0x31, (byte)0x33, (byte)0x30,
			(byte)0x31, (byte)0x31, (byte)0x37, (byte)0x30, (byte)0x30, (byte)0x30, (byte)0x33, (byte)0x35, (byte)0x32, (byte)0x39, (byte)0x34, (byte)0x46,
			(byte)0x39, (byte)0x39, (byte)0x33, (byte)0x0D
	};
	

	public byte[] getSetUpgrade() {
		return setUpgrade;
	}



	public byte[] getStartu() {
		return Startu;
	}

	

	public byte[] getUndou() {
		return Undou;
	}

	

	public byte[] getStartResponse1() {
		return StartResponse1;
	}

	

	public byte[] getStartResponse2() {
		return StartResponse2;
	}

	

	public byte[] getStartResponse3() {
		return StartResponse3;
	}

	//1.设置升级信息响应信息
		public String SetUpgradeResponse(String message) {
			//去掉所有空格
			message = message.replaceAll("\\s*", "");
			System.out.println(message);
			String str = message.substring(7,9);
			
			String mes = null;
			
				
				switch(str) {
				case "00":
					mes = "正常";
					break;
				case "01":
					mes = "VER错";
					break;
				case "02":
					mes = "CHKSUM错";
					break;
				case "03":
					mes = "LCHKSUM错";
					break;
				case "04":
					mes = "CID2无效";
					break;
				case "05":
					mes = "命令格式错";
					break;
				case "06":
					mes = "无效数据";
					break;
				case "07":
					mes = "无数据";
					break;
				case "E1":
					mes = "无数据";
					break;
				case "E2":
					mes = "命令执行失败";
					break;
				case "E3":
					mes = "设备故障";
					break;
				case "E4":
					mes = "无效权限";
					break;
				case "E5":
					mes = "无效权限";
					break;
				
				}
				return mes;
			
			
		}
	
	
	//启动升级命令响应信息
	public String Abalysis(String message) {
		//去掉所有空格
		message = message.replaceAll("\\s*", "");
		String str = message.substring(7,9);
		String str1 = message.substring(13,15);
		String mes = null;
		if("00".equals(str)) {
			switch(str1) {
			case "01":
				mes = "正在放电，拒绝升级";
				break;
			case "02":
				mes = "电池压差过大，拒绝升级";
				break;
			case "03":
				mes = "充电电流过大，拒绝升级";
				break;
			case "04":
				mes = "充电电流过大，拒绝升级";
				break;
			case "05":
				mes = "充电电流过大，拒绝升级";
				break;
			case "80":
				mes = "充电电流过大，拒绝升级";
				break;
			case "FF":
				mes = "接收升级";
				break;
			
			}
			return mes;
		}else {
			switch(str) {
			case "01":
				mes = "VER错";
				break;
			case "02":
				mes = "CHKSUM错";
				break;
			case "03":
				mes = "LCHKSUM错";
				break;
			case "04":
				mes = "CID2无效";
				break;
			case "05":
				mes = "命令格式错";
				break;
			case "06":
				mes = "无效数据";
				break;
			case "07":
				mes = "无数据";
				break;
			case "E1":
				mes = "无数据";
				break;
			case "E2":
				mes = "命令执行失败";
				break;
			case "E3":
				mes = "设备故障";
				break;
			case "E4":
				mes = "无效权限";
				break;
			case "E5":
				mes = "无效权限";
				break;
			
			}
			return mes;
		}
		
	}
	
}
