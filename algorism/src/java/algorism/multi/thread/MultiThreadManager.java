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
		mt1 = new Thread(new MultiThread("Thread-1"));
		mt2 = new Thread(new MultiThread("Thread-2"));
		mt3 = new Thread(new MultiThread("Thread-3"));
	}

	public void start() {
		
		mt2.start();
		mt3.start();mt1.start();
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

	private void withdraw(String threadId, Map<String, Double> accountMap) {
		Double accountCash = 0D;
		if(accountMap != null) {
			synchronized(accountMap) {
				accountCash = accountMap.get("cash");
				if(accountCash > 0 ) {
					accountMap.put("cash", accountCash-1000);
					System.out.println(threadId+"가 "+accountCash+"에서 1000원을 출금하여 잔액이 "+(accountCash-1000)+"남았습니다.");
				}
			}
		}
	}

	class MultiThread implements Runnable {
		private String threadId;
		public MultiThread(String threadId) {
			this.threadId = threadId;
		}
		public String getId() {
			return threadId;
		}
		
		@Override
		public void run() {
			try {
//				synchronized (accountMap) {
					while(accountMap.get("cash") > 0 ) {
						Thread.sleep(200);
						withdraw(threadId,accountMap);
					}
//				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
