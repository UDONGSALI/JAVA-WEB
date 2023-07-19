package com.myspring.pro30.board.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.pro30.board.vo.ArticleVO;
import com.myspring.pro30.board.vo.ImageVO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List selectAllArticlesList(Map pagingMap) throws DataAccessException {
		int section = (Integer)pagingMap.get("section");
		System.out.println("dao" + section);
		int pageNum=(Integer)pagingMap.get("pageNum");
		System.out.println("dao" + pageNum); 
		List<ArticleVO> articlesList;
		articlesList = sqlSession.selectList("mapper.board.selectAllArticlesList", pagingMap);
		return articlesList;
	}

	@Override
	public int selectTotArticles() throws DataAccessException {
		int articleCount = sqlSession.selectOne("mapper.board.selectTotArticles");;
		System.out.println("dao 게시글 수 " + articleCount);
		return articleCount;
	}

	
	@Override
	public int insertNewArticle(Map articleMap) throws DataAccessException {
		int articleNO = selectNewArticleNO();
		articleMap.put("articleNO", articleNO);
		System.out.println(articleMap);
		sqlSession.insert("mapper.board.insertNewArticle", articleMap);
		return articleNO;
	}

	@Override
	public void insertNewImage(Map articleMap) throws DataAccessException {
		List<ImageVO> imageFileList = (ArrayList) articleMap.get("imageFileList");
		if(imageFileList == null) {
			
			};
		int articleNO = (Integer) articleMap.get("articleNO");
		int imageFileNO = selectNewArticleNO();
		if(imageFileList == null) {
			sqlSession.insert("mapper.board.insertNewImage", null);
		}
		else {
			for (ImageVO imageVO : imageFileList) {
				imageVO.setImageFileNO(++imageFileNO);
				imageVO.setArticleNO(articleNO);
			}
			sqlSession.insert("mapper.board.insertNewImage", imageFileList);
		} 
	}

	private int selectNewImageFileNO() throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectNewImageFileNO");
	}

	private int selectNewArticleNO() throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectNewArticleNO");
	}

	@Override
	public ArticleVO selectArticle(int articleNO) throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectArticle", articleNO);
	}

	@Override
	public void updateArticle(Map articleMap) throws DataAccessException {
		sqlSession.update("mapper.board.updateArticle", articleMap);
	}

	@Override
	public void deleteArticle(int articleNO) throws DataAccessException {
		sqlSession.delete("mapper.board.deleteArticle", articleNO);
	}
	
	@Override
	public List selectImageFileList(int articleNO) throws DataAccessException{
		List<ImageVO> imageFileList = sqlSession.selectList("mapper.board.selectImageFileList", articleNO);
		return imageFileList;
	}
	

}