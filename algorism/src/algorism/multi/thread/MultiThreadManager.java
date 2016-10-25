package algorism.multi.thread;

import java.util.HashMap;
import java.util.Map;

public class MultiThreadManager {
	private Thread mt1;
	private Thread mt2;
	private Thread mt3;
	private Map<String, Double> accountMap = new HashMap<String, Double>();
	public MultiThreadManager(Map<String, Double> accountMap) {
		this.accountMap = accountMap;
	}
	public void init() {
		mt1 = new Thread(new MultiThread1());
		mt2 = new Thread(new MultiThread2());
		mt3 = new Thread(new MultiThread3());
	}

	public void start() {
		mt1.start();
		mt2.start();
		mt3.start();
	}
	
	public Thread getMt1() {
		return mt1;
	}

	public Thread getMt2() {
		return mt2;
	}

	public Thread getMt3() {
		return mt3;
	}

	private synchronized void withdraw(String threadId, Map<String, Double> accountMap) {
		Double accountCash = 0D;
		if(accountMap != null) {
			accountCash = accountMap.get("cash");
//			if(accountCash > 0 ) {
				accountMap.put("cash", accountCash-10000);
				System.out.println(threadId+"가 "+accountCash+"에서 10000원을 출금하여 잔액이 "+(accountCash-10000)+"남았습니다.");
//			}
		}
	}

	class MultiThread1 implements Runnable {
		String threadId = "Thread-1";
		public String getId() {
			return threadId;
		}
		
		@Override
		public void run() {
			try {
				synchronized (this) {
					while(accountMap.get("cash") > 0 ) {
						withdraw(threadId,accountMap);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	class MultiThread2 implements Runnable {
		String threadId = "Thread-2";
		public String getId() {
			return threadId;
		}
		@Override
		public void run() {
			try {
				synchronized (this) {
					while(accountMap.get("cash") > 0 ) {
						withdraw(threadId,accountMap);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	class MultiThread3 implements Runnable {
		String threadId = "Thread-3";
		public String getId() {
			return threadId;
		}
		@Override
		public void run() {
			try {
				synchronized (this) {
					while(accountMap.get("cash") > 0 ) {
						withdraw(threadId,accountMap);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
