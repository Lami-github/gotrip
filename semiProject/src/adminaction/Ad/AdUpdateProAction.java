package adminaction.Ad;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ad.AdDBBean;
import ad.AdDataBean;
import controller.CommandAction;

public class AdUpdateProAction implements CommandAction {// ȸ������ ó��

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("utf-8");// �ѱ� ���ڵ�

		String ad_id = request.getParameter("ad_id");
		String ad_loc = request.getParameter("ad_loc");
		String ad_sdate = request.getParameter("ad_sdate");
		String ad_edate = request.getParameter("ad_edate");
		String ad_company = request.getParameter("ad_company");
		String ad_price = request.getParameter("ad_price");
		String check = request.getParameter("check");

		AdDBBean dbPro = AdDBBean.getInstance();// DBó��
		AdDataBean member = new AdDataBean();
		if (check.equals("insert")) {
			member.setAd_loc(ad_loc);
			member.setAd_sdate(ad_sdate);
			member.setAd_edate(ad_edate);
			member.setAd_company(ad_company);
			member.setAd_price(ad_price);
		} else
			member.setAd_id(Integer.parseInt(ad_id));

		dbPro.UpdateAd(member, check);
		// �ش� �信�� ����� �Ӽ�

		return "/JY/Ad/AdUpdatePro.jsp";// �ش� ��
	}
}