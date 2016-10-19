package algorism.singleton.pool;

import java.util.ArrayList;
import java.util.List;

public class SingletonPool {

	public static int POOL_SIZE = 10;
	public List<Connection> connectionPool = new ArrayList<Connection>();
	
	public Connection getConnection() throws PoolSizeoverException {
		if(POOL_SIZE == connectionPool.size()) {
			throw new PoolSizeoverException("사이즈초과");
		}
		Connection conn = new Connection();
		connectionPool.add(conn);
		return conn;
	}
	
	public void releaseConnection(Connection conn) {
		connectionPool.remove(conn);
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
	}
	
	public static void main(String[] args) {
		
	}
}
