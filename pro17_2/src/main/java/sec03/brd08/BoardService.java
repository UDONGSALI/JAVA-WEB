package sec03.brd08;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardService {
	BoardDAO boardDAO;
	public BoardService() {
		boardDAO = new BoardDAO();
	}

	public List<ArticleVO> listArticles() {
		List<ArticleVO> articlesList = boardDAO.selectAllArticles();
		System.out.println("모든 리스트 보기");
		return articlesList;
	}
	
	public int addArticle(ArticleVO article){
		return boardDAO.insertNewArticle(article);		
	}	
	public ArticleVO viewArticle(int articleNO) {
		ArticleVO article = null;
		article = boardDAO.selectArticle(articleNO);
		return article;
	}
	public void modArticle(ArticleVO article) {
		boardDAO.updateArticle(article);
	}
	public List removeArticle(int articleNO) {
		List<Integer> articleNOList = boardDAO.selectRemovedArticles(articleNO);
		boardDAO.deleteArticle(articleNO);
		return articleNOList;
	}
	public int addReply(ArticleVO article) {
		return boardDAO.insertNewArticle(article);
	}
	
	public Map listArticles(Map<String, Integer> pagingMap) {  // 
		Map articlesMap = new HashMap();
		List<ArticleVO> articlesList = boardDAO.selectAllArticles(pagingMap); // 
		int totArticles = boardDAO.selectTotArticles();
		articlesMap.put("articlesList", articlesList);  // 해당 글 자료
//		articlesMap.put("totArticles", totArticles);    // 총 글갯수
		articlesMap.put("totArticles", 170);  // 글 갯수를 170개로 하여 테스트해봄
		return articlesMap;
	}

	

}

