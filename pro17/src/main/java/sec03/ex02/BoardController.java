package sec03.ex02;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sec02.ex02.MemberVO;

public class BoardController extends HttpServlet {
	private static String ARTICLE_IMAGE_REPO = "C:\\board\\article_image";
	BoardService boardService;
	ArticleVO articleVO = new ArticleVO();

	public void init(ServletConfig  config) throws ServletException {
		boardService = new BoardService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		doHandle(request, response);
	}


	private void doHandle(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		String nextPage = "";
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String action = request.getPathInfo();
		System.out.println("action:" + action);
		try {
			List<ArticleVO> articlesList = new ArrayList<ArticleVO>();
			if (action == null) {
				articlesList = boardService.listArticles();
				request.setAttribute("articlesList", articlesList);
				nextPage = "/board02/listArticles.jsp";
			} else if (action.equals("/listArticles.do")) {
				articlesList = boardService.listArticles();
				request.setAttribute("articlesList", articlesList);
				nextPage = "/board02/listArticles.jsp";
			} else if (action.equals("/articleForm.do")) {
				nextPage = "/board02/articleForm.jsp";
			} else if (action.equals("/addArticle.do")) {
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				articleVO.setParentNO(0);
				articleVO.setId("hong");
				articleVO.setTitle(title);
				articleVO.setContent(content);
				articleVO.setImageFileName("noting");
				boardService.addArticle(articleVO);
				nextPage = "/board/listArticles.do";				
			}else {
				nextPage = "/board02/listArticles.jsp";
			}	
			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
			dispatch.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	private Map<String, String> upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Map<String, String> articleMap = new HashMap<String, String>();
//		String encoding = "utf-8";
//		File currentDirPath = new File(ARTICLE_IMAGE_REPO);
//		DiskFileItemFactory factory = new DiskFileItemFactory();
//		factory.setRepository(currentDirPath);
//		factory.setSizeThreshold(1024 * 1024);
//		ServletFileUpload upload = new ServletFileUpload(factory);
//
//		try {
//			List items = upload.parseRequest(request);
//			for (int i = 0; i < items.size(); i++) {
//				FileItem fileItem = (FileItem) items.get(i);
//				if (fileItem.isFormField()) {
//					System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));
//					articleMap.put(fileItem.getFieldName(), fileItem.getString(encoding));
//				} else {
//					System.out.println("파라미터명:" + fileItem.getFieldName());
//					//System.out.println("파일명:" + fileItem.getName());
//					System.out.println("파일크기:" + fileItem.getSize() + "bytes");
//					//articleMap.put(fileItem.getFieldName(), fileItem.getName());
//					if (fileItem.getSize() > 0) {
//						int idx = fileItem.getName().lastIndexOf("\\");
//						if (idx == -1) {
//							idx = fileItem.getName().lastIndexOf("/");
//						}
//
//						String fileName = fileItem.getName().substring(idx + 1);
//						System.out.println("파일명:" + fileName);
//						articleMap.put(fileItem.getFieldName(), fileName);  //익스플로러에서 업로드 파일의 경로 
//                                                                                                                                   //제거 후 map에 파일명 저장
//						File uploadFile = new File(currentDirPath + "\\" + fileName);
//						fileItem.write(uploadFile);
//
//					} // end if
//				} // end if
//			} // end for
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return articleMap;
//	}
}



