package action.Notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import notice.NoticeDataBean;
import notice.NoticeDBBean;

public class NoticeDetailFormAction implements CommandAction{
	//글 내용 처리
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int num = Integer.parseInt(request.getParameter("num")); //해달 글번호
		String pageNum = request.getParameter("pageNum"); //해당페이지 번호
		
		NoticeDBBean dbPro = NoticeDBBean.getInstance(); //DB처리
		NoticeDataBean article = dbPro.getArticle(num); //해당 글 번호에 대한 해당 레코드
		
		//해당 뷰에서 사용할 속성
		request.setAttribute("num", new Integer(num));
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("article", article);
		
		return "/JY/Notice/MainNoticeDetailForm.jsp"; //해당 뷰
	}
}
