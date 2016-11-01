package com.seil.auth.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class AuthDAO {

	@Autowired
	private SqlMapClient sqlMapClient;
	
	public List<Map<String, String>> selectAllTables() throws SQLException {
		List<Map<String, String>> tableList = sqlMapClient.queryForList("com.seil.auth.showtable");
		return tableList;
	}
}
