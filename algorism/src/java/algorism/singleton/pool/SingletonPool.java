package algorism.singleton.pool;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SingletonPool {

	private static final int MAX_POOL_SIZE = 10;
	private int CURRENT_POOL_SIZE = 0;
//	public List<Connection> connectionPool = new ArrayList<Connection>();
	public Queue<Connection> connectionPool = new ConcurrentLinkedQueue<Connection>();
	public Connection getConnection() throws PoolSizeoverException {
		Connection conn = null;
		synchronized (connectionPool) {
			if(0 < connectionPool.size()) {
				conn = connectionPool.poll();
			} else {
				conn = new Connection();
				connectionPool.add(conn);
				CURRENT_POOL_SIZE++;
			}
		}
		return conn;
	}
	
	public int getConnectionPoolSize() {
		return connectionPool.size();
	}
	public void releaseConnection(Connection conn) {
		if(connectionPool.size()< MAX_POOL_SIZE && CURRENT_POOL_SIZE < MAX_POOL_SIZE) {
			connectionPool.add(conn);
		} else {
			conn.close();
		}
	}
	
	
	
	
	public static void main(String[] args) throws PoolSizeoverException {
		Thread t1 = new Thread(new GetConnectionObject("Thread-01"));
		Thread t2 = new Thread(new GetConnectionObject("Thread-02"));
		Thread t3 = new Thread(new GetConnectionObject("Thread-03"));
		Thread t4 = new Thread(new GetConnectionObject("Thread-04"));
		Thread t5 = new Thread(new GetConnectionObject("Thread-05"));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}
class PoolSizeoverException extends Exception {
	public PoolSizeoverException(String msg) {
		super(msg);
	}
}

class Connection {
	private String url;
	private String driverName;
	private String id;
	private String password;
	public void close() {
		
	}
}

class GetConnectionObject implements Runnable {
	final SingletonPool pool = new SingletonPool();
	Connection conn = null;
	String threadId = "";
	int i=0;
	
	public GetConnectionObject(String id) {
		this.threadId = id;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(3000);
			while(i < 200) {
				conn = pool.getConnection();
				i++;
				System.out.println(threadId+" : "+pool.getConnectionPoolSize());
			}
		} catch (PoolSizeoverException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}