package com.koreait.nemorecipe.domain;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Recipe {

	private int recipe_id; //레시피번호
	private int member_id;  //유저
	
	
	private String type; //종류별
	private String situation; //상황별
	private String ingredient; //재료별별
	private String method; //방법별
	private String time; //조리시간
	private String level; //레벨
	private String serving; //인분
	
	private String recipe_img;//사진
	private String recipe_name; //레피시이름
	private String recipe_order; //조리순서
	private String recipe_ingredient; //재료
	
	MultipartFile photo;
	
	private Timestamp date; //등록시간
}
