package com.koreait.nemorecipe.controller.client;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.nemorecipe.domain.Member;

@Controller
public class ClientController {
	
	//메인화면 요청처리
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String mainForm() {
		return "client/main";
	}
	
	//로그인 폼 요청처리
	@RequestMapping(value="/loginform", method=RequestMethod.GET)
	public String loginform() {
		return "client/loginform";
	}
	
	//로그인 요청처리
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Member member, HttpSession session) {
		//3단계: 일 시키기
		return null;
	}
	
}
