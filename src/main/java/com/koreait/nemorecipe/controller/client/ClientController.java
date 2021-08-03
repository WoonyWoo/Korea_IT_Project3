package com.koreait.nemorecipe.controller.client;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.nemorecipe.domain.Member;
import com.koreait.nemorecipe.exception.MemberExistException;
import com.koreait.nemorecipe.model.service.member.MemberService;

@Controller
public class ClientController {
	
	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
	
	@Autowired
	private MemberService memberService;
	
	//메인화면 요청처리
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String mainForm(HttpServletRequest request) {
		return "client/main";
	}
	
	//글 목록 요청처리
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(HttpServletRequest request) {
		return "client/list";
	}
	
	//글작성화면 요청처리
	@RequestMapping(value="/regist", method=RequestMethod.GET)
	public String registForm(HttpServletRequest request) {
		return "client/regist";
	}
	
	//랭킹 화면 요청처리
	@RequestMapping(value="/ranking", method=RequestMethod.GET)
	public String rankingForm(HttpServletRequest request) {
		return "client/ranking";
	}
	
	//회원가입 폼 요청처리
	@RequestMapping(value="/signin", method=RequestMethod.GET)
	public String signin(HttpServletRequest request) {
		return "client/signin";
	}
	
	//로그인 폼 요청처리
	@RequestMapping(value="/loginform", method=RequestMethod.GET)
	public String loginform(HttpServletRequest request) {
		return "client/loginform";
	}
	
	//로그인 요청처리
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Member member, HttpServletRequest request) {
		logger.info("아이디는 {} ",member.getUser_id());
		logger.info("비밀번호는 {} ",member.getUser_pass());
		
		//3단계: 일 시키기
		Member obj = memberService.login(member);
		logger.info("닉네임은 {} ",obj.getUser_nickname());
		
		//4단계: 결과 저장
		HttpSession session = request.getSession();
		session.setAttribute("member", obj); //request가 아닌 session에 저장함
		
		return "redirect:/client/main";
	}
	
	//로그아웃 요청처리
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		
		//3단계: 일 시키기
		
		//4단계: 결과 저장
		HttpSession session = request.getSession();
		session.setAttribute("member", null); //request가 아닌 session에 저장함
		
		return "redirect:/client/main";
	}
	
	
	
}
