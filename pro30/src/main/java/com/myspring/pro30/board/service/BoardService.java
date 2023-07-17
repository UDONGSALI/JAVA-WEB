package com.myspring.pro30.board.service;

import java.util.List;
import java.util.Map;

import com.myspring.pro30.board.vo.ArticleVO;

public interface BoardService {

	List<ArticleVO> listArticles() throws Exception;

	int addNewArticle(Map articleMap) throws Exception;

}