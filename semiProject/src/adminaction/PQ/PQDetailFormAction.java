package adminaction.PQ;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import personalquestion.PersonalquestionDBBean;
import personalquestion.PersonalquestionDataBean;
import controller.CommandAction;


public class PQDetailFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		int pq_num = Integer.parseInt(request.getParameter("pq_num")); //해당글번호
		String pageNum = request.getParameter("pageNum"); //해당 페이지번호
		
		PersonalquestionDBBean dbPro = PersonalquestionDBBean.getInstance(); // 디비처리
		PersonalquestionDataBean article = dbPro.getArticle(pq_num); // 해당 글번호에 대한 해당 레코드
		
		//해당 뷰에서 사용할 속성
		request.setAttribute("pq_num", pq_num);
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("article", article);
		
		return "/JY/PQ/PQDetailForm.jsp";
	}

}
