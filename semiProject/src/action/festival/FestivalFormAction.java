package action.festival;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import festival.FestivalDBBean;

public class FestivalFormAction implements CommandAction { //회원인증 폼 처리

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String pageNum = request.getParameter("pageNum"); // 페이지 번호
		
		if(pageNum == null) {
			pageNum ="1";
		}
		int pageSize = 8;// 한 페이지의 글의 개수
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage-1)*pageSize +1; // 한페이지의 시작글 번호
		int endRow = currentPage* pageSize;
		int count =0;
		int number=0;
		
		List articleList1 = null;
		List articleList2 = null;
		FestivalDBBean dbPro = FestivalDBBean.getInstance(); // DB연동
		count = dbPro.getArticleCount(); // 전체글의수
		
		if(count > 0 ) {
			articleList1 = dbPro.getArticles(startRow, endRow);
			//현재페이지에 해당하는 글 목록
		}else {
			articleList1 = Collections.EMPTY_LIST;
		}
		
		number = count-(currentPage-1)*pageSize; // 글목록에 표시할 글번호
		
		//해당 뷰에서 사용할 속성
		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
		request.setAttribute("articleList", articleList1);
		
		return "/JY/Festival/MainFestivalForm.jsp";//해당 
	}

}
