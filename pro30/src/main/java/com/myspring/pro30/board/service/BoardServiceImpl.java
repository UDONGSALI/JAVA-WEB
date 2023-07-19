package com.myspring.pro30.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.pro30.board.dao.BoardDAO;
import com.myspring.pro30.board.vo.ArticleVO;
import com.myspring.pro30.board.vo.ImageVO;

@Service("boardService")
@Transactional(propagation = Propagation.REQUIRED)
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDAO boardDAO;

//	@Override
//	public List<ArticleVO> listArticles() throws Exception {
//		List<ArticleVO> articlesList = boardDAO.selectAllArticlesList();
//		System.out.println("아티클 리스트" + articlesList);
//		return articlesList;
//	}

	@Override
	public Map listArticles(Map<String, Integer> pagingMap) throws Exception {
		Map articlesMap = new HashMap();
		
		List<ArticleVO> articlesList = boardDAO.selectAllArticlesList(pagingMap);
		int totArticles = boardDAO.selectTotArticles();
		
		articlesMap.put("articlesList", articlesList);
		articlesMap.put("totArticles", totArticles);
		
		return articlesMap;
	}

	@Override
	public int addReplyMap (Map articleMap) throws Exception {
		int articleNO = boardDAO.insertNewArticle(articleMap);
		articleMap.put("articleNO", articleNO);
		boardDAO.insertNewImage(articleMap);
		return articleNO;		
	}

	
	// 단일 이미지 추가하기
//	@Override
//	public int addNewArticle(Map articleMap) throws Exception {
//		return boardDAO.insertNewArticle(articleMap);
//	}
	
	@Override
	public int addNewArticle(Map articleMap) throws Exception {
		int articleNO = boardDAO.insertNewArticle(articleMap);
		articleMap.put("articleNO", articleNO);
		boardDAO.insertNewImage(articleMap);
		return articleNO;
	}

//	@Override
//	public ArticleVO viewArticle(int articleNO) throws Exception {
//		ArticleVO articleVO = boardDAO.selectArticle(articleNO);
//		return articleVO;
//	}

	@Override
	public void modArticle(Map articleMap) throws Exception {
		boardDAO.updateArticle(articleMap);
	}

	@Override
	public void removeArticle(int articleNO) throws Exception {
		boardDAO.deleteArticle(articleNO);
	}

	@Override
	public Map viewArticle(int articleNO) throws Exception{
		Map articleMap = new HashMap();
		ArticleVO articleVO = boardDAO.selectArticle(articleNO);
		List<ImageVO> imageFileList = boardDAO.selectImageFileList(articleNO) ;
		articleMap.put("article", articleVO);
		articleMap.put("imageFileList", imageFileList);
		return articleMap;		
	}
	
}
