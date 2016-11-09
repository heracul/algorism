package algorism.db.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryTest {

	public static void main(String[] args) {
		DBConnection dbConn = new DBConnection();
		Connection conn = dbConn.getConnection();
		String query = "SELECT SYSTIMESTAMP as MS FROM DUAL";
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			psmt = conn.prepareStatement(query);
			rs = psmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("MS"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				psmt.close();
				dbConn.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
