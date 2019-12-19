package cn.entty;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Queue;

public class Resolution{
	

	    public static Queue<byte[]> Resolution() throws Exception {
	    	final int max = 4096;
		File file = new File("D:\\a.txt");
			
		    long fileSize = file.length();  
		    System.out.println("文件长度"+fileSize);
		    int length = (int) (fileSize % 4096);
		    int line = (int) (fileSize / max);
		    System.out.println("4096的个数"+line);
		    
		    //获取队列
		    QueueClass queueClass = QueueClass.getQueueClass();
			Queue<byte[]> queue = queueClass.getQueue();
		
			BufferedInputStream fis =null;
			
			//读取文件
	        byte[] b = new byte[(int) fileSize];  

			try {
				fis = new BufferedInputStream(new FileInputStream(file));
				
				
			/*	while((fis.read(b)!=-1)) {
					System.out.println(new String(b));
				}*/
				
				
				fis.read(b);
			}finally {
				fis.close();
			}
	  	   
	  	    
	  		
	  		
	  		if(line == 0 || line == 1) {
	  			byte[] newByte1 = new byte[(int) (fileSize+6)];
	  			System.arraycopy(b, 0, newByte1, 3, (int) fileSize);
	  			
	  			newByte1[0] = 55;
		  		newByte1[1] = 10;
		  		newByte1[2] = 00;
		  		int sum = ChkSum(newByte1);
		  		
		  		
		  		String high = High(sum);
		  		byte[] h = hexStringToByteArray(high);
		  		
		  		
		  		String inf = Infraversion(sum);
  				byte[] i = hexStringToByteArray(inf);
  				
		  		
		  		newByte1[newByte1.length - 3] = h[0];
		  		newByte1[newByte1.length - 2] = i[0];
		  	    newByte1[newByte1.length - 1] = (byte) 0xAA;//AA显示成了-86，越界了
	  			
		  	    queue.offer(newByte1);
		  	   
		  	    
	  			
	  		}else if(line > 1){
	  			for(int j = 0;j<line;j++) {
	  				byte[] newByte1 = new byte[max+6];
		  			System.arraycopy(b, j*4096, newByte1, 3, max);
		  			
		  			newByte1[0] = 55;
			  		newByte1[1] = 10;
			  		newByte1[2] = 00;
			  		int sum = ChkSum(newByte1);
			  		
			  		
			  		String high = High(sum);
			  		byte[] h = hexStringToByteArray(high);
			  		
			  		
			  		String inf = Infraversion(sum);
	  				byte[] i = hexStringToByteArray(inf);
			  		
			  		
			  		newByte1[newByte1.length - 3] = h[0];
			  		newByte1[newByte1.length - 2] = i[0];
			  	    newByte1[newByte1.length - 1] = (byte) 0xAA;//AA显示成了-86，越界了
		  			
			  	    queue.offer(newByte1);
	  				
	  				
	  			}
	  			
	  			//不足4096的数组
	  			byte[] newByte = new byte[length+6];
	  			System.arraycopy(b, (int) (fileSize - length), newByte, 3, length);
	  			System.out.println((int) (fileSize - length));
	  			System.out.println("length:"+length);
	  			
	  			System.out.println("长度司"+intToHex(length));
	  			
	  			newByte[0] = 55;
	  			
	  			String high = High(length);	
	  			if(high.length() == 2  && !high.contains("A") && !high.contains("B") && !high.contains("C") 
	  					&& !high.contains("D") && !high.contains("E") && !high.contains("F")) {
	  				
	  				
	  				newByte[1] = Integer.valueOf(high).byteValue();
	  				
	  			}else {
	  				byte[] h = hexStringToByteArray(high);
			  		System.out.println(Arrays.toString(h));
			  		newByte[1] = h[0];
	  			}
	  			
		  		
		  		
		  		String inf = Infraversion(length);
		  		if(inf.length() == 2  && !inf.contains("A") && !inf.contains("B") && !inf.contains("C") 
	  					&& !inf.contains("D") && !inf.contains("E") && !inf.contains("F")) {
	  				
	  				
	  				newByte[2] = Integer.valueOf(inf).byteValue();
	  				
	  			}else {
	  				byte[] i = hexStringToByteArray(inf);
	  				System.out.println(Arrays.toString(i));
			  		newByte[2] = i[0];
	  			}
		  		
		  		
  			
		  		
		  		int sum = ChkSum(newByte);
		  		
		  		String high1 = High(sum);
		  		byte[] h1 = hexStringToByteArray(high1);
		  		System.out.println(Arrays.toString(h1));
		  		
		  		String inf1 = Infraversion(sum);
  				byte[] i1 = hexStringToByteArray(inf1);
  				System.out.println(Arrays.toString(i1));
		  		
		  		newByte[newByte.length - 3] = h1[0];
		  		newByte[newByte.length - 2] = i1[0];
		  	    newByte[newByte.length - 1] = (byte) 0xAA;//AA显示成了-86，越界了
	  			
		  	    queue.offer(newByte);
		  	  
  				
	  		}
			return queue;
			
			
			
			
	  		
	  		
	  		
	  		
	  		
	    }
	    
	  
	   //计算chksum
		public static int ChkSum(byte[] b) {
			int sum = 0;
			for(int i = 0; i<b.length; i++) {
				sum += b[i];
				
			}
			return sum % 65536;
			
		}

		//计算高八位
		public static String High(int sum) {
			int High = sum >> 8;
			String h = intToHex(High);
			System.out.println("high:"+h);
			return h;
		}
	
		//计算低八位
		public static String Infraversion(int sum) {
			int infraversion = sum & 0xff;
			String inf = intToHex(infraversion);
			System.out.println("infraversion:"+inf);
			return inf;
		}
		
		//十进制转十六进制
		private static String intToHex(int n) {
	        StringBuffer s = new StringBuffer();
	        String a;
	        char []b = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	        while(n != 0){
	            s = s.append(b[n%16]);
	            n = n/16;            
	        }
	        a = s.reverse().toString();
	        return a;
	    }
		
		//十六进制字符串转字节数组
	    public static byte[] hexStringToByteArray(String hexString) {
	        
	        if(hexString.length() %2 != 0) {
	        	hexString = "0" + hexString;
	        	
	        }
	        int length = hexString.length();
	        byte[] buffer = new byte[length / 2];

	        for (int i = 0; i < length; i += 2) {
	            buffer[i / 2] = (byte) ((toByte(hexString.charAt(i)) << 4) | toByte(hexString.charAt(i + 1)));
	        }

	        return buffer;
	    }
	 
	    private static int toByte(char c) {
	        if (c >= '0' && c <= '9') return (c - '0');
	        if (c >= 'A' && c <= 'F') return (c - 'A' + 10);
	        if (c >= 'a' && c <= 'f') return (c - 'a' + 10);

	        throw new RuntimeException("Invalid hex char '" + c + "'");
	    }

		

		
}
