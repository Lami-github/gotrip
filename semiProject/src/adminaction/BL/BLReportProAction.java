package adminaction.BL;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blacklist.BlacklistDBBean;
import blacklist.BlacklistDataBean;
import controller.CommandAction;




//�Էµ� ��ó��
public class BLReportProAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8"); // �ѱ� ���ڵ�
		String report = request.getParameter("report");
		
		String writer=request.getParameter("writer");
		int bl_num = Integer.parseInt(request.getParameter("num"));
		BlacklistDBBean dbPro = BlacklistDBBean.getInstance(); //DBó��
		dbPro.updateMember(bl_num, writer, report);

		return "/JY/BL/BLReportPro.jsp";
	} 

}
