package cn.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class LocationUtil {
	public static void getposition(String loca) {
		String lng = loca.substring(0, loca.indexOf(","));
		String lat = loca.substring(loca.indexOf(",") + 1);
		String location = lat + "," + lng;
		BufferedReader in = null;
		URL tirc = null;
		try {
			tirc = new URL("http://api.map.baidu.com/geocoder/v2/?ak=0xdI6Lq0agqBHUtthykRldY7gMTM378p&location="
					+ location + "&output=json&pois=0");
			System.out.println(tirc);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			URLConnection connection = tirc.openConnection();
			connection.setDoOutput(true);
			in = new BufferedReader(new InputStreamReader(tirc.openStream(), "UTF-8"));
			String res;
			StringBuilder sb = new StringBuilder("");
			while ((res = in.readLine()) != null) {
				sb.append(res.trim());
			}
			String str = sb.toString();
			System.out.println(str);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
