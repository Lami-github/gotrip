package adminaction.BL;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blacklist.BlacklistDBBean;
import blacklist.BlacklistDataBean;
import controller.CommandAction;




//입력된 글처리
public class BLReportProAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8"); // 한글 인코딩
		String report = request.getParameter("report");
		
		String writer=request.getParameter("writer");
		int bl_num = Integer.parseInt(request.getParameter("num"));
		BlacklistDBBean dbPro = BlacklistDBBean.getInstance(); //DB처리
		dbPro.updateMember(bl_num, writer, report);

		return "/JY/BL/BLReportPro.jsp";
	} 

}
