package com.park.nov11.menu;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuDAO {

	@Autowired
	private SqlSession ss;
	
	public void getMenu(HttpServletRequest req) {
		List<Menu> menus = ss.getMapper(MenuMapper.class).getMenu();
		//req.attribute에 마무리 
		req.setAttribute("menus",menus);
		
		//req.session.attribute 
		//cookie 총 3가지가 있다. 이 3가지다 그 사이트 내에섬나 사용가능.
		
		//DB에 있는 데이터를 외부에서 쓰게 해주려면?
		//AJAX 서버를 만드ㅡㄹ어야 한다.
		
	}
	
	public Menus getMenuXML() {
		List<Menu> menus = ss.getMapper(MenuMapper.class).getMenu();
		
		return new Menus(menus);
	}
	
}
