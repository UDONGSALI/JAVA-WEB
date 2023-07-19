package com.myspring.pro30.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.pro30.board.vo.ArticleVO;

public interface BoardDAO {

	public List selectAllArticlesList(Map pagingMap) throws DataAccessException ;

	public int insertNewArticle(Map articleMap) throws DataAccessException;

	public ArticleVO selectArticle(int articleNO) throws DataAccessException;

	void updateArticle(Map articleMap) throws DataAccessException;

	void deleteArticle(int articleNO) throws DataAccessException;

	void insertNewImage(Map articleMap) throws DataAccessException;

	public List selectImageFileList(int articleNO) throws DataAccessException;

	public int selectTotArticles() throws DataAccessException;
}
