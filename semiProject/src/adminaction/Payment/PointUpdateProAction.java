package adminaction.Payment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import point.PointDBBean;
import point.PointDataBean;
import controller.CommandAction;

public class PointUpdateProAction implements CommandAction {// 회원인증 처리

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("utf-8");// 한글 인코딩

		String num = request.getParameter("num");
		String id = request.getParameter("id");
		String point = request.getParameter("point");
		String type = request.getParameter("type");
		String date = request.getParameter("date");
		String check = request.getParameter("check");

		PointDBBean dbPro = PointDBBean.getInstance();// DB처리
		PointDataBean member = new PointDataBean();
		if (check.equals("insert")) {
			member.setId(id);
			member.setUpdate_point(Integer.parseInt(point));
			member.setType(type);
			member.setUpdate_date(date);
		} else
			member.setNum(Integer.parseInt(num));

		dbPro.UpdatePoint(member, check);
		// 해당 뷰에서 사용할 속성

		return "/JY/Payment/PointUpdatePro.jsp";// 해당 뷰
	}
}