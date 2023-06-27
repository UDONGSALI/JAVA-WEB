package test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import org.apache.tomcat.util.http.fileupload.FileUploadException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/loading.do")
public class Upload_Download extends HttpServlet {

	// 순서대로
	// 인코딩 방식, 파일 위치, 파일 최대 크기 설정
	private static final String CHARSET = "UTF-8";
	private static final String ATTACHES_DIR = "D:\\file_repo";
	private static final int LIMIT_SIZE_BYTES = 1024 * 1024;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		dohandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		dohandle(request, response);
	}

	// 업로드 & 다운로드 구현
	private void dohandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, FileUploadException {

		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding(CHARSET);
		PrintWriter out = response.getWriter();
		String contentType = request.getContentType();

		try {
			if (contentType != null && contentType.toLowerCase().startsWith("multipart/")) {
				// getParts()를 통해 Body에 넘어온 데이터들을 각각의 Part로 쪼개어 리턴
				// 오류 발생시 추가 작업을 위한 선행작업
				Collection<Part> parts = null;
				parts = request.getParts();
				
// 원본 코드
//				Collection<Part> parts = request.getParts();

				for (Part part : parts) {
					System.out.printf("파라미터 명 : %s, contentType :  %s,  size : %d bytes \n", part.getName(),
							part.getContentType(), part.getSize());

					if (part.getHeader("Content-Disposition").contains("filename=")) {
						String fileName = extractFileName(part.getHeader("Content-Disposition"));

						if (part.getSize() > 0) {
							System.out.printf("업로드 파일 명 : %s  \n", fileName);
							part.write(ATTACHES_DIR + File.separator + fileName);
							part.delete();
						}
					} else {
						String formValue = request.getParameter(part.getName());
						System.out.printf("name : %s, value : %s  \n", part.getName(), formValue);
					}
				}
				out.println("<h1>업로드 완료</h1>");
			} else {
				out.println("<h1>enctype이 multipart/form-data가  아님</h1>");
			}
		} catch (IllegalStateException e) {
			// 업로드 크기 제한을 넘겼을 경우의 처리
		}
	}

	// Part에 있는 content-Disposition 속성값을 partHeader 변수로 받아 파일명 추출
	// String의 여러 메서드를 이용하여 추출
	private String extractFileName(String partHeader) {
		for (String cd : partHeader.split(";")) {
			if (cd.trim().startsWith("filename")) {
				String fileName = cd.substring(cd.indexOf("=") + 1).trim().replace("\"", "");
				int index = fileName.lastIndexOf(File.separator);
				return fileName.substring(index + 1);
			}
		}
		return null;
	}

}
