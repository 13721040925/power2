package cn.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 工具类
 * 
 * @author Lenovo
 *
 */
public class Commons {
	private static char[] ch = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', //
			'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', //
			'r', 's', 't', 'u', 'v', 'w', 'y', 'z', //
			'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', //
			'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', //
			'R', 'S', 'T', 'U', 'V', 'W', 'Y', 'Z', 'X', 'x', //
			'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '_' };

	static {
		for (int i = 0; i < 529;) {
			// User u = new User();
			// u.setUserName(generateRandomNameOrPassWord());
			// u.setPassWord(generateRandomNameOrPassWord());
			// Map<Integer, Date> map =
			// changeIdentityToBirthAndAge(generateRandomIndentityNo());
			// Set<Integer> set = map.keySet();
			// Iterator<Integer> it = set.iterator();
			// Integer key = it.next();
			// u.setAge(key);
			// u.setBirthday(map.get(key));
			// list.add(u);
			i++;
		}
	}

	// 产生随机的用户名
	public static String generateRandomNameOrPassWord() {
		StringBuffer sb = new StringBuffer();
		sb.append(ch[(int) (Math.random() * 52)]);// 首字母
		int num = (int) (Math.random() * (11 - 5 + 1)) + 5;// [5,11]
		for (int i = 0; i < num; i++) {
			sb.append(ch[(int) (Math.random() * 63)]);// 首字母之外的值
		}
		return sb.toString();
	}

	// 产生随机的电话号码
	public static String generateRandomTelNum() {
		StringBuffer sb = new StringBuffer("1");
		sb.append((int) (Math.random() * 7) + 3);// [3-9]
		for (int i = 0; i < 9; i++) {
			sb.append((int) (Math.random() * 10));
		}
		return sb.toString();
	}

	// 产生随机的积分
	public static String generateRandomScore() {
		StringBuffer sb = new StringBuffer();
		sb.append((int) (Math.random() * 9000) + 1000);
		return sb.toString();
	}

	// 产生随机的会员卡号
	public static String generateRandomCardNo() {
		StringBuffer sb = new StringBuffer("t");
		for (int i = 0; i < 10; i++) {
			sb.append((int) (Math.random() * 10));
		}
		return sb.toString();
	}

	// 产生随机的性别
	public static String generateRandomGender() {
		if ((int) (Math.random() * 10) > 5) {
			return "女";
		}
		return "男";
	}

	// 产生随机的邮箱
	public static String generateRandomEamil() {
		StringBuffer sb = new StringBuffer();
		sb.append(ch[(int) (Math.random() * 52)]);// 首字符是字母
		for (int i = 0; i < 6; i++) {
			sb.append(ch[(int) (Math.random() * 63)]);
		}
		sb.append("@");
		for (int i = 0; i < 6; i++) {
			sb.append(ch[(int) (Math.random() * 62)]);
		}
		String[] st = { ".com.cn", ".com", ".cn" };
		sb.append(st[(int) (Math.random() * 3)]);
		return sb.toString();
	}

	// 1、判断用户名是否符合要求的方法
	public static boolean isSuitableUserNameOrPassword(String userName) {
		// userName:用户名，6-12位，字母开头，非空，唯一
		// passWord：密码，6-12位，字母开头，非空，
		String regex = "^[A-Za-z]\\w{5,11}$";
		// ^:表示正则表达式的开始
		// [A-Za-z]:大小写字母中的任意一个
		// \\w:大小写字母,0-9数字，下划线中的任意一个[a-zA-Z0-9_]
		// {5,11}:前面的组织单元出现5-11次
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(userName);
		return matcher.matches();
	}

	// 2、判断移动号码是否符合要求的方法
	public static boolean isSuitableTelNum(String telNum) {
		// telNum:移动电话号码，11位，唯一，非空
		String regex = "^1[3456789]\\d{9}$";
		// ^:开头
		// 1:数字1
		// [3456789]:3-9任意一个
		// \\d:0-9任意一个
		// {9}:出现9次
		// $:结尾
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(telNum);
		return matcher.matches();
	}

	// 3、判断会员卡号是否符合要求的方法
	public static boolean isSuitableCardNo(String cardNo) {
		// cardNo:会员卡号，11位，单字母开头，其余数字，唯一，非空
		String regex = "^[A-Za-z]\\d{10}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(cardNo);
		return matcher.matches();
	}

	// 4、判断身份证号是否符合要求的方法
	public static boolean isSuitableIdentityNo(String identityNo) {
		String regex = "^[1-7]\\d{5}(19|20)\\d{2}((0[1-9])|10|11|12)(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
		// 身份证验证规则：41000119910101123X
		// 1、六位数字地址码，八位数字出生日期码，三位数字顺序码和一位校验码，可以用字母表示如为ABCDEFYYYYMMDDXXXR
		// ^:表示开头
		// [1-9]:表示1-9之间任意整数，4
		// \\d{5}:表示0-9之间任意数字出现5位，10001
		// (18|19|20):表示现在的年份只能选18、19、20开头，19
		// \\d{2}:表示年份，91
		// ((0[1-9])|(10|11|12)):表示月份，如果不满十位添加0，01
		// (([0-2][1-9])|10|20|30|31):表示月中的日，不满十位前面加0，01
		// \\d{3}:3位数字顺序码，123
		// [0-9Xx]:0-9整数Xx中的任意一个校验码，X
		// $:表示结尾
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(identityNo);
		return matcher.matches() && isSuitableDate(identityNo);
	}

	// 产生随机的身份证号
	public static String generateRandomIndentityNo() {
		StringBuffer sb = new StringBuffer();
		// [1-7]
		sb.append((int) (Math.random() * 7) + 1);// [1-7]
		// \\d{5}
		for (int i = 0; i < 5; i++) {
			sb.append((int) (Math.random() * 10));// \\d{5}
		}
		// (19|20)\\d{2}((0[1-9])
		int year = (int) (Math.random() * (2018 - 1900 + 1)) + 1900;
		sb.append(year);
		// (0[1-9])|10|11|12)
		int month = (int) (Math.random() * 12) + 1;
		if (month < 10) {
			sb.append("0" + month);
		} else {
			sb.append(month);
		}
		// (([0-2][1-9])|10|20|30|31)
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
				|| month == 10 || month == 12) {
			int day = (int) (Math.random() * 31) + 1;
			if (day < 10) {
				sb.append("0" + day);
			} else {
				sb.append(day);
			}
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			int day = (int) (Math.random() * 30) + 1;
			if (day < 10) {
				sb.append("0" + day);
			} else {
				sb.append(day);
			}
		} else {
			if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
				int day = (int) (Math.random() * 29) + 1;
				if (day < 10) {
					sb.append("0" + day);
				} else {
					sb.append(day);
				}
			} else {
				int day = (int) (Math.random() * 28) + 1;
				if (day < 10) {
					sb.append("0" + day);
				} else {
					sb.append(day);
				}
			}
		}
		// \\d{3}
		for (int i = 0; i < 3; i++) {
			sb.append((int) (Math.random() * 10));// \\d{3}
		}
		// [0-9Xx]
		int index = (int) (Math.random() * (61 - 50 + 1)) + 50;// [50-61]
		sb.append(ch[index]);
		return sb.toString();
	}

	// 5、把生分证号转化成生日和年龄
	public static Map<Integer, Date> changeIdentityToBirthAndAge(
			String identityNo) {
		Map<Integer, Date> map = new HashMap<Integer, Date>();
		if (identityNo == null) {
			return map;
		}
		// System.out.println(identityNo);
		String st = identityNo.substring(6, 14);// 1990-01-01
		// System.out.println(st);
		StringBuffer sb = new StringBuffer(st);
		sb.insert(4, "-");
		sb.insert(7, "-");
		st = sb.toString();// 1990-01-01
		// 日期格式化对象
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date bt = ft.parse(st);
			// System.out.println("bt=" + bt);
			// 获得日历类的对象
			Calendar cl = Calendar.getInstance();
			// 设置指定的日期
			cl.setTime(bt);
			// 获得指定日期的年
			int year = cl.get(Calendar.YEAR);
			// System.out.println(year);
			// 当前的年
			int now = Calendar.getInstance().get(Calendar.YEAR);
			// 年龄
			int age = 0;
			if (now == year) {
				age = 1;
			} else {
				age = now - year;
			}
			// System.out.println("age=" + age);
			map.put(age, bt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return map;
	}

	// 6、验证email是否合法
	public static boolean isSuitableEmail(String email) {
		// tom@126.com
		String regex = "^[A-Za-z]+\\w*@[a-zA-Z0-9]+\\.((com\\.cn)|com|cn)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	// 7、判断身份证闰年和大小月是否在符合范围
	public static boolean isSuitableDate(String date) {
		try {
			String st = date.substring(6, 10);
			String st1 = date.substring(10, 12);
			String st2 = date.substring(12, 14);
			int year = Integer.parseInt(st);
			int month = Integer.parseInt(st1);
			int day = Integer.parseInt(st2);
			// 当前的年
			int now = Calendar.getInstance().get(Calendar.YEAR);
			// 小月
			if (month == 4 || month == 6 || month == 9 || month == 11) {
				if (day > 30) {
					System.out.println(year + "小月只有30天");
					return false;
				}
			} else if (month == 2) {// 2月
				// 闰年
				if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
					if (day > 29) {
						System.out.println(year + "2月只有29天");
						return false;
					}
				} else {
					// 不是闰年
					if (day > 28) {
						System.out.println(year + "2月只有28天");
						return false;
					}
				}
			}
			// 如果输入的年份超过当前年，判定不符合要求[1900-2018]
			if (year > now) {
				System.out.println(year + "年还没到");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	// 将首字符大写
	public static String upperCase(String str) {
		// 先将字符串转换为字符数组
		char[] ch = str.toCharArray();
		// 将数组的第一个元素 即字符串首字母，进行ASCII 码前移，ASCII 中大写字母从65开始，小写字母从97开始，所以这里减去32。
		if (ch[0] >= 'a' && ch[0] <= 'z') {
			ch[0] = (char) (ch[0] - 32);
		}
		return new String(ch);
	}


	// 获得随机的文件名称
	public static String getFileName(String name) {
		return MD5Util.enconding(UUID.randomUUID().toString()).substring(0, 10)
				+ name;
	}

	// 把字符串首字母转化成大写
	public static String upperCaseFirstChar(String str) {
		try {
			return (str.charAt(0) + "").toUpperCase() + str.substring(1);
		} catch (Exception e) {
			return null;
		}
	}

	// 是否是图片
	public static boolean isPicture(String fileName) {
		String suffix = null;// 后缀tom.png
		if (fileName != null && !fileName.equals("")) {
			int index = fileName.lastIndexOf(".");
			suffix = fileName.substring(index + 1);// png
		}
		// 把"jpg", "bmp", "jpeg", "png", "gif"放到list中
		List<String> list = Arrays.asList("jpg", "bmp", "jpeg", "png", "gif");
		for (String string : list) {
			if (string.equalsIgnoreCase(suffix)) {
				return true;
			}
		}
		return false;
	}

}
