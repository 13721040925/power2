package cn.entty;

import java.net.Socket;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import cn.socketServer.SendUpgrade;

/**
 * 消费者
 */
public class Consumer extends Thread{
	    private static final Lock lock = new ReentrantLock();//重入锁
	    private static final Condition fullCondition = lock.newCondition();     //队列满的条件
	    private static final Condition emptyCondition = lock.newCondition();        //队列空的条件
	private Socket socket;
	    //获取队列
	    QueueClass queueClass = QueueClass.getQueueClass();
		Queue<byte[]> queue = queueClass.getQueue();
		
		
	   /* String name;
	    int maxSize;*/

	public Consumer(Queue<byte[]> queue, Socket socket) {
	       
	        this.queue = queue;
		this.socket = socket;
	    }

	    @Override
	    public void run(){
	        while(true){
	            //获得锁
	            lock.lock();

	            if(queue.isEmpty()){
	                try {
	                    System.out.println("队列为空");
	                    //条件不满足，消费阻塞
	                    emptyCondition.await();
	                } catch (Exception ex) {
	                    ex.printStackTrace();
	                }
	            }
	            
			// BufferedOutputStream fos =null;
			synchronized (this) {
				Thread th = null;
				String msg = null;
				while (!queue.isEmpty()) {
					byte[] b = queue.poll();
					SendUpgrade sendUpgrade = new SendUpgrade(socket, b);
					th = new Thread(sendUpgrade);
					th.start();
					try {
						th.join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					while ((msg = sendUpgrade.getMsg()) != null) {
						System.out.println(msg);
						break;
					}
				}
	            }

			System.out.println("升级完毕！");
			// try {
			// fos.flush();
			// fos.close();
			// } catch (IOException e1) {
			// // TODO Auto-generated catch block
			// e1.printStackTrace();
			// }
				
        		
				
	           /* byte[] x = queue.poll();
	            System.out.println("");*/

	            //唤醒其他所有生产者、消费者
	           // fullCondition.signalAll();
	           // emptyCondition.signalAll();

	            //释放锁
	            lock.unlock();

	            try {
	                Thread.sleep(new Random().nextInt(1000));
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	
}
   