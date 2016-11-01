package com.seil.auth.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seil.auth.dao.AuthDAO;

@Service("authService")
public class AuthService {

	@Autowired
	private AuthDAO authDAO;
	
	public List<Map<String, String>> getAllTables() throws SQLException {
		return authDAO.selectAllTables();
	}
}
