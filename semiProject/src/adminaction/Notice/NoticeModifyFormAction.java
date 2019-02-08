package adminaction.Notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.NoticeDataBean;
import notice.NoticeDBBean;
import controller.CommandAction;

public class NoticeModifyFormAction implements CommandAction {
	//글 수정 폼
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		NoticeDBBean dbPro = NoticeDBBean.getInstance();
		NoticeDataBean article = dbPro.updateGetArticle(num);
		
		//해당 뷰에서 사용할 속성
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("num", num);
		request.setAttribute("article", article);
		request.setAttribute("modify", 1);
		
		return "/JY/Notice/NoticeWriteForm.jsp"; //해당 뷰
	}
}
