package adminaction.PQ;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import personalquestion.PersonalquestionDBBean;
import personalquestion.PersonalquestionDataBean;
import controller.CommandAction;

public class PQWriteFormAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		int pq_num=0, ref=1, re_step=0,re_level=0;
		
		try {
			if(request.getParameter("pq_num") !=null) {
				pq_num = Integer.parseInt(request.getParameter("pq_num"));
				ref = Integer.parseInt(request.getParameter("ref"));
				re_step = 1;
				re_level = 1;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		request.setAttribute("pq_num", new Integer(pq_num));
		request.setAttribute("ref", new Integer(ref));
		request.setAttribute("re_step", new Integer(re_step));
		request.setAttribute("re_level", new Integer(re_level));
		request.setAttribute("serach", request.getParameter("serach"));
		
		
		
		return "/JY/PQ/PQWriteForm.jsp";
	} // 글입력 폼 처리
	

}
