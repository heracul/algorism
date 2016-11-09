package algorism.db.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private String url;
	private String user;
	private String passwd;
	public DBConnection() {
		try {
			init();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void init() throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		this.url = "jdbc:oracle:thin:@localhost:1521:XE";
		this.user = "hr";
		this.passwd = "hr";
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, passwd);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void close(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
