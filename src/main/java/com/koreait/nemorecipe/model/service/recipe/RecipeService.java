package com.koreait.nemorecipe.model.service.recipe;

import java.util.List;

import com.koreait.nemorecipe.domain.Member;
import com.koreait.nemorecipe.domain.Recipe;

public interface RecipeService {

	public List selectAll(); //목록가져오기
	public void regist(Recipe recipe); 
	public Recipe select(int recipe_id);
	public void update(Recipe recipe); //회원가입
	public void delete(int recipe_id);
	public List selectAllLike(); //좋아요순
	public List selectAllHit(); //조회수순
	public void addHit(int recipe_id); //조회수 증가
}
