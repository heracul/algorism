package com.seil.auth.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.seil.auth.service.AuthService;

@Controller
public class AuthController {

	@Autowired
	private AuthService authService;
	
	@RequestMapping("/allTables.do")
	public ModelAndView searchTableList() {
		List<Map<String, String>> tableList = null;
		ModelAndView mav = new ModelAndView("/jsp/showAllTables");
		try {
			tableList = authService.getAllTables();
			mav.addObject("tableList", mav);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mav;
		
	}
}
