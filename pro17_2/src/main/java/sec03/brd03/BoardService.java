package sec03.brd03;


import java.util.List;

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
}

