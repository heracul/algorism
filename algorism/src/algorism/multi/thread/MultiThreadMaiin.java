package algorism.multi.thread;

import algorism.multi.thread.MultiThreadManager.MultiThread1;
import algorism.multi.thread.MultiThreadManager.MultiThread3;

public class MultiThreadMaiin {

	public static void main(String[] args) throws InterruptedException {
		MultiThreadManager mtm = new MultiThreadManager();
		mtm.init();
		mtm.getMt1().start();
		mtm.getMt3().start();
		
//		Thread.sleep(2000);
		System.out.println("Thread1에 대한 join수행");
		System.out.println(mtm.getMt1().getName());
		MultiThread1.sleep(10000);;
		MultiThread3.sleep(10000);
		mtm.getMt1().interrupt();
	}

}
