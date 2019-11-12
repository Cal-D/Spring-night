package com.park.nov11;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.park.nov11.menu.MenuDAO;
import com.park.nov11.menu.Menus;

@Controller
public class HomeController {

	@Autowired
	private MenuDAO mDAO;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		mDAO.getMenu(req);
		return "index";
	}
	
	@RequestMapping(value = "/menu.get", method = RequestMethod.GET,
			produces = "application/xml; charset=utf-8")
	public @ResponseBody Menus menuGet(HttpServletRequest req) {
		mDAO.getMenu(req);
		return mDAO.getMenuXML();
	}

}
