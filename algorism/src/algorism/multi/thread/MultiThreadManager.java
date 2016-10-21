package algorism.multi.thread;

public class MultiThreadManager {
	private MultiThread1 mt1;
	private MultiThread2 mt2;
	private MultiThread3 mt3;
	
	public void init() {
		mt1 = new MultiThread1();
		mt2 = new MultiThread2();
		mt3 = new MultiThread3();
	}

	public MultiThread1 getMt1() {
		return mt1;
	}

	public MultiThread2 getMt2() {
		return mt2;
	}

	public MultiThread3 getMt3() {
		return mt3;
	}


	class MultiThread1 extends Thread {
		long threadId = 1L;
		public long getId() {
			return threadId;
		}
		public MultiThread1() {
		}
		@Override
		public void run() {
			for(int i=0; i<50; i++ ) {
				System.out.println("multiThread"+threadId+" : "+i*1+" ");
//				try {
//					Thread.sleep(500);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
			}
			
		}
		
	}
	
	class MultiThread2 implements Runnable {
		String threadId = "multiThread2";
		public String getId() {
			return threadId;
		}
		@Override
		public void run() {
			for(int i=0; i<50; i++ ) {
				System.out.println(threadId+" : "+i*2+" ");
//				try {
//					Thread.sleep(500);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
			}
		}
		
	}
	
	class MultiThread3 extends Thread {
		long threadId = 3L;
		public long getId() {
			return threadId;
		}
		public MultiThread3() {
		}
		@Override
		public void run() {
			for(int i=0; i<50; i++ ) {
				System.out.println("multiThread"+threadId+" : "+i*3+" ");
//				try {
//					Thread.sleep(500);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
			}
			
		}
		
	}
}
