package cn.entty;

import java.util.LinkedList;
import java.util.Queue;

public class QueueClass {
	
	private QueueClass() {}
	
	 private static final QueueClass QueueClass = new QueueClass();  
	 
	 //静态工厂方法   
	 public static QueueClass getQueueClass() {  
	       return QueueClass;  
	 } 
	private static final Queue<byte[]> queue = new LinkedList<byte[]>();

	public Queue<byte[]> getQueue() {
		return queue;
	}
	
	
	
	/*public Queue getQueue() {
		return queue = new LinkedList<byte[]>();
		
	}*/
	
	
}



