package cn.entty;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class FileInput {
	
	public static byte[] FileInput() throws Exception {
		final int max = 4096;
		BufferedInputStream fis =null;
		File file = new File("D:\\a.txt");
		
        long fileSize = file.length();  
        
        byte[] b = new byte[(int) fileSize];  

		try {
			fis = new BufferedInputStream(new FileInputStream(file));
			
			
		/*	while((fis.read(b)!=-1)) {
				System.out.println(new String(b));
			}*/
			
			
			fis.read(b);
		}finally {
			
		}
		
		
		return b;
		
		
	}
	
	/*File file = new File("E:\\a.txt");  
	
    long fileSize = file.length(); 
	//读取一个文本的字符流
	BufferedReader in = new BufferedReader(new FileReader(file));
	String line = null;
	//定义一个空字符串来接受读到的字符串
	String str="";
	//循环把读取到的字符赋给str
	while((line = in.readLine())!=null)
	{
	str+=line;
	}*/

	//System.out.println("str="+str);
	
	/*//拆分数组,另写一个方法
	byte[] newByte = new byte[max+5];
	
	System.arraycopy(b, 0, newByte, 3, 4096);
	
	System.out.println(Arrays.toString(newByte));
	
	newByte[0] = 55;
	newByte[1] = 10;
	newByte[2] = 00;
	 byte[] bt = { (byte) 0x7E, (byte) 0x32, (byte) 0x30, (byte) 0x30, (byte) 0x31, (byte) 0x34};
	 int sum = 0 ;
	for (int i=0;i< bt.length;i++) {
		sum += bt[i];
		System.out.println("sum = " + sum);
	}
	
	newByte[4100] = (byte) 0xAA;//AA显示成了-86，越界了
	System.out.println(Arrays.toString(newByte));*/
}
