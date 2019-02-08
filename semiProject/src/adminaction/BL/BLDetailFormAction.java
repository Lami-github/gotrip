package adminaction.BL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blacklist.BlacklistDBBean;
import blacklist.BlacklistDataBean;
import controller.CommandAction;




public class BLDetailFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(request.getParameter("num")); //해당글번호
		String pageNum = request.getParameter("pageNum"); //해당 페이지번호
		
		BlacklistDBBean dbPro = BlacklistDBBean.getInstance(); // 디비처리
		BlacklistDataBean member = dbPro.getMember(num); // 해당 글번호에 대한 해당 레코드
		
		//해당 뷰에서 사용할 속성
		request.setAttribute("num", new Integer(num));
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("member", member);
		
		return "/JY/BL/BLDetailForm.jsp";
	}

}
