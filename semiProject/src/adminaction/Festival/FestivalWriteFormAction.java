package adminaction.Festival;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import festival.FestivalDBBean;
import festival.FestivalDataBean;

public class FestivalWriteFormAction implements CommandAction { //회원인증 폼 처리

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub


		request.setAttribute("modify", 0);
		
		return "/JY/Festival/FestivalWriteForm.jsp";//해당 
	}

}
